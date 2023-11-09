package org.example.initializers.annotations;

import org.example.model.Person;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
  W języku Java, gdy definiujemy adnotację, możemy używać następujących typów jako parametrów adnotacji:

    -> Wszystkie typy pierwotne (int, float, boolean, itd.).
    -> String.
    -> Class (lub dowolna odmiana typu Class<?>).
    -> Enumeracje (enum).
    -> Inne adnotacje.
    -> Tablice powyższych typów (na przykład int[], String[], Class[], enumy, inne adnotacje itp.).
 */

// @Retention(RetentionPolicy.RUNTIME)
// @Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface FieldValue {
    // String stringValue() default "";
    // int intValue() default 0;
}
