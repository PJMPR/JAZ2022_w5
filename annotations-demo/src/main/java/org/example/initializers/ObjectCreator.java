package org.example.initializers;

import org.example.initializers.annotations.Creatable;
import org.example.initializers.annotations.DefaultConstructor;
import org.example.initializers.annotations.FieldValue;
import org.example.initializers.annotations.InitializationMethod;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectCreator {

    /**
         W Javie, aby zadeklarować metodę generyczną, 
        należy określić typ generyczny w jej sygnaturze. 
        Typ generyczny zazwyczaj jest określony w nawiasach ostrokątnych < > 
        przed typem zwracanym metody. Parametr Typu powinien być użyty w parametrach metody, 
        aby móc określić ten typ przy wywołaniu metody tzn.
            Person person = ObjectCreator.create(Person.class);
            Car car = ObjectCreator.create(Car.class);
    */

    public static <T> T create(Class<T> clazz) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        
        T instance = null;
        /**
         * Jak sprawdzić czy adnotacja jest nad klasą
         */
        // if(!hasCreatableAnnotation(clazz))
        //     return instance;

        /**
         * 
         */
        //instance = getNewInstance(clazz);
        
        /**
         * 
         */
        // useInitializationMethod(clazz, instance);
        /**
         * 
         */
        // setFieldDefaultValues(instance);
        return instance;
    }

    /**
     * Metoda sprawdzająca czy klasa została oznaczona adnotacją
     */
    // static boolean hasCreatableAnnotation(Class<?> clazz){
    //     return clazz.isAnnotationPresent(Creatable.class);
    // }
    
    /**
     * metoda tworząca nowy obiekt
     */
    // private static <T> T getNewInstance(Class<T> clazz) throws InstantiationException, IllegalAccessException, InvocationTargetException {
    //     var constructor = getConstructor(clazz);
    //     if(constructor==null)
    //         return null;
    //     var instance = (T)constructor.newInstance();
    //     return instance;
    // }

    /**
     * Metoda która szuka konstruktora
     * -> jeśli jest więcej niż jeden konstruktor to bierzemy taki, 
     *    który jest oznaczony adnotacją @DefaultConstructor
     * -> jeśli takiego nie ma to bierzemy pierwszy który nie ma parametrów
     */
    static Constructor<?> getConstructor(Class<?> clazz){
        Constructor<?> constructor;
        // var constructors = Arrays.stream(clazz.getConstructors()).toList();
        // var constructorsCount = constructors.size();
        // if(constructorsCount>1)
        //     return getDefaultConstructor(constructors);
        // constructor = constructors.stream().filter(c->c.getParameterCount()==0).findFirst().orElse(null);
        return constructor;
    }

    /**
     * Sprawdzamy czy istnieje konstruktor oznacozny adnotacją @DefaultConstructor
     */
    // private static Constructor<?> getDefaultConstructor(List<Constructor<?>> constructors) {
    //     return constructors.stream()
    //             .filter(c -> /* !!! */ c.isAnnotationPresent(DefaultConstructor.class) && c.getParameterCount()==0)
    //             .findFirst()
    //             .orElse(null);
    // }

    /**
     * wywoływanie metody inicjującej obiekt
     */
    private static <T> void useInitializationMethod(Class<T> clazz, T instance) throws IllegalAccessException, InvocationTargetException {
        // var initializationMethod = getInitMethod(clazz);
        // if(initializationMethod!=null){
        //     initializationMethod.invoke(instance);
        // }
    }

    /**
     * Szukanie metody oznaczonej adnotacją @InitializationMethod
     */
    static Method getInitMethod(Class<?> clazz){
        // var methods = Arrays.stream(clazz.getDeclaredMethods()).toList();
        // return methods.stream()
        //         .filter(m-> /* !!! */ m.isAnnotationPresent(InitializationMethod.class))
        //         .findFirst()
        //         .orElse(null);
    }

    /**
     * Wykorzystanie adnotacji @FieldValue do ustawienia domyślnych wartości pól w klasie
     */
        private static <T> void setValues(T instance, FieldValue fieldValue, Field field) {
        // var fieldType = field.getType();
        // field.setAccessible(true);
        // try {
        //         if(fieldType.equals(int.class))
        //             field.setInt(instance, fieldValue.intValue());
        //         if(fieldType.equals(String.class))
        //             field.set(instance, fieldValue.stringValue());
        //     } catch (IllegalAccessException e) {
        //         throw new RuntimeException(e);
        //     }
    }

    static <T> void setFieldDefaultValues(T instance){
        // var fields = Arrays.stream(instance.getClass().getDeclaredFields());
        // fields.filter(f -> f.isAnnotationPresent(FieldValue.class))
        //         .collect(Collectors.toMap(field -> field, field -> /* !!! */ field.getAnnotation(FieldValue.class)))
        //         .forEach((field, fieldValue) -> setValues(instance, fieldValue, field));
    }



}
