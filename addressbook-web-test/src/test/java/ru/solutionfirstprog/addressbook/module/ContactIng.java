package ru.solutionfirstprog.addressbook.module;

import java.util.Objects;

public class ContactIng {
    private int id;
    private final String company;
    private final String street;
    private final String email;
    private final String name;
    private final String middlename;
    private final String lastname;
    private String group;

    public ContactIng(String company, String street, String email, String name, String middlename, String lastname, String group) {
        this.id = Integer.MAX_VALUE;
        this.company = company;
        this.street = street;
        this.email = email;
        this.name = name;
        this.middlename = middlename;
        this.lastname = lastname;
        this.group = group;
    }
    public ContactIng(int id, String company, String street, String email, String name, String middlename, String lastname, String group) {
        this.id = id;
        this.company = company;
        this.street = street;
        this.email = email;
        this.name = name;
        this.middlename = middlename;
        this.lastname = lastname;
        this.group = group;
    }

    public String getCompany() {
        return company;
    }

    public String getStreet() {
        return street;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
            return name;
        }

        public String getMiddlename() {
            return middlename;
        }

        public String getLastname() {
            return lastname;
        }

    public String getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ContactIng{" +
                "lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactIng that = (ContactIng) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname);
    }
}
