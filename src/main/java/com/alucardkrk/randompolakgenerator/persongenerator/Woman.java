package com.alucardkrk.randompolakgenerator.persongenerator;

public class Woman extends Person {
    private String name;
    private String surname;
    private String city;
    private String street;




    public Woman(String name, String surname, String city, String street) {
        super(0);
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.street = street;

    }




    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }
}