package org.example.model;

//@Creatable
public class Person {

    private int id;

    //@FieldValue(stringValue = "jan")
    private String name;
    private String surname;

    //@DefaultConstructor
    public Person(){}

    public Person(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    //@InitializationMethod
    public void initializePerson(){
        this.id = -1;
        this.name = "";
        this.surname= "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
