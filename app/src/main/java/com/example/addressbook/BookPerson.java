package com.example.addressbook;

import java.io.Serializable;

public class BookPerson implements Serializable {
    private String name;
    private String surname;
    private String address;
    private String phone;

    public BookPerson(String name, String surname, String address, String phone) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return " " + name + " " +  surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
