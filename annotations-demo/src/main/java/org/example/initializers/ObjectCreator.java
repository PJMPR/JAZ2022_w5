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

    public static <T> T create(Class<T> clazz) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        T instance = null;
        if(!hasCreatableAnnotation(clazz))
            return instance;
        instance = getNewInstance(clazz);
        useInitializationMethod(clazz, instance);
        setFieldDefaultValues(instance);
        return instance;
    }

    static boolean hasCreatableAnnotation(Class<?> clazz){
        return clazz.isAnnotationPresent(Creatable.class);
    }

    private static <T> T getNewInstance(Class<T> clazz) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        var constructor = getConstructor(clazz);
        if(constructor==null)
            return null;
        var instance = (T)constructor.newInstance();
        return instance;
    }
    static Constructor<?> getConstructor(Class<?> clazz){
        var constructors = Arrays.stream(clazz.getConstructors()).toList();
        Constructor<?> constructor;
        var constructorsCount = constructors.size();
        if(constructorsCount>1)
            constructor = getDefaultConstructor(constructors);
        constructor = constructors.stream().filter(c->c.getParameterCount()==0).findFirst().orElse(null);
        return constructor;
    }

    private static Constructor<?> getDefaultConstructor(List<Constructor<?>> constructors) {
        return constructors.stream()
                .filter(c -> c.isAnnotationPresent(DefaultConstructor.class))
                .findFirst()
                .orElse(null);
    }

    private static <T> void useInitializationMethod(Class<T> clazz, T instance) throws IllegalAccessException, InvocationTargetException {
        var initializationMethod = getInitMethod(clazz);
        if(initializationMethod!=null){
            initializationMethod.invoke(instance);
        }
    }

    static Method getInitMethod(Class<?> clazz){
        var methods = Arrays.stream(clazz.getDeclaredMethods()).toList();
        return methods.stream()
                .filter(m->m.isAnnotationPresent(InitializationMethod.class))
                .findFirst()
                .orElse(null);
    }

    static <T> void setFieldDefaultValues(T instance){
        var fields = Arrays.stream(instance.getClass().getDeclaredFields());
        fields.filter(f -> f.isAnnotationPresent(FieldValue.class))
                .collect(Collectors.toMap(field -> field, field -> field.getAnnotation(FieldValue.class)))
                .forEach((field, fieldValue) -> setValues(instance, fieldValue, field));
    }

    private static <T> void setValues(T instance, FieldValue fieldValue, Field field) {
        var fieldType = field.getType();
        field.setAccessible(true);
        try {
                if(fieldType.equals(int.class))
                    field.setInt(instance, fieldValue.intValue());
                if(fieldType.equals(String.class))
                    field.set(instance, fieldValue.stringValue());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
    }

}
