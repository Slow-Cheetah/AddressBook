package com.example.addressbook;

import android.app.Person;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText nameET;
    private EditText surnameET;
    private EditText addressET;
    private EditText phoneET;
    private Button saveBTN;
    private ListView listLV;

    private List<BookPerson> book = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        unitUI();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, book);
        listLV.setAdapter(adapter);

        saveBTN.setOnClickListener(v -> {
            BookPerson person = new BookPerson(nameET.getText().toString(), surnameET.getText().toString(),
                    addressET.getText().toString(), phoneET.getText().toString());
            book.add(person);
            adapter.notifyDataSetChanged();
            nameET.getText().clear();
            surnameET.getText().clear();
            addressET.getText().clear();
            phoneET.getText().clear();
            Toast.makeText(this, "Пользователь сохранен", Toast.LENGTH_SHORT).show();
        });
        listLV.setOnItemClickListener((parent, view, position, id) -> {
            int index = (int) id;
            BookPerson intentPerson = book.get(index);
            Intent intent = new Intent(this, ItemActivity.class);
            intent.putExtra(BookPerson.class.getSimpleName(), intentPerson);
            startActivity(intent);
        });


    }

    private void unitUI() {
        nameET = findViewById(R.id.nameET);
        surnameET = findViewById(R.id.surnameET);
        addressET = findViewById(R.id.addressET);
        phoneET = findViewById(R.id.phoneET);

        saveBTN = findViewById(R.id.saveBTN);

        listLV = findViewById(R.id.listLV);
    }
}