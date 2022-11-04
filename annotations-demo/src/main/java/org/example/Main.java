package org.example;

import org.example.initializers.ObjectCreator;
import org.example.model.Person;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {

        var person = ObjectCreator.create(Person.class);

        System.out.println("Hello world!");
    }
}