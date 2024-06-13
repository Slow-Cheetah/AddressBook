package com.example.addressbook;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ItemActivity extends AppCompatActivity {

    BookPerson person;
    private TextView nameTV;
    private TextView surnameTV;
    private TextView addressTV;
    private TextView phoneTV;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_item);

        unitSecondUI();
        person = (BookPerson) getIntent().getExtras().getSerializable(BookPerson.class.getSimpleName());
        String name = person != null ? person.getName() : "";
        String surname = person != null ? person.getSurname() : "";
        String address = person != null ? person.getAddress() : "";
        String phone = person != null ? person.getPhone() : "";

        nameTV.setText(name);
        surnameTV.setText(surname);
        addressTV.setText(address);
        phoneTV.setText(phone);

    }

    private void unitSecondUI() {
        nameTV = findViewById(R.id.nameTV);
        surnameTV = findViewById(R.id.surnameTV);
        addressTV = findViewById(R.id.addressTV);
        phoneTV = findViewById(R.id.phoneTV);
    }
}