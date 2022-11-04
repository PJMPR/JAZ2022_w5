package org.example.model;

import org.example.initializers.annotations.Creatable;
import org.example.initializers.annotations.DefaultConstructor;
import org.example.initializers.annotations.FieldValue;
import org.example.initializers.annotations.InitializationMethod;

@Creatable
public class Person {

    @FieldValue(intValue = 5)
    private int id;

    @FieldValue(stringValue = "jan")
    private String name;
    @FieldValue
    private String surname;

    @DefaultConstructor
    public Person(){}


    public Person(int id,@FieldValue(stringValue = "jan") String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    @InitializationMethod
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
