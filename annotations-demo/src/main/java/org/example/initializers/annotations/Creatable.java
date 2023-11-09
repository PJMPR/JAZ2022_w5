package org.example.initializers.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


    /**
     *    RetentionPolicy określa, jak długo adnotacje zachowują ważność i są dostępne do użycia. 
     *    W Java istnieją trzy różne typy polityk zatrzymywania adnotacji, które określają ich zakres i żywotność: 
     *
     *  RetentionPolicy.SOURCE:
     *      Adnotacje z tym poziomem są dostępne tylko w kodzie źródłowym.
     *      Są one odrzucane przez kompilator w czasie kompilacji, co oznacza, że nie pojawiają się w skompilowanym pliku .class.
     *      Przykładem adnotacji, która jest zwykle używana tylko w czasie analizy źródeł, jest @Override. 
     *
     *  RetentionPolicy.CLASS:
     *      Adnotacje z tym poziomem są zapisywane w pliku .class podczas kompilacji, 
     *      ale nie są dostępne w czasie działania przez maszynę wirtualną Java (JVM).
     *      Jest to domyślna polityka zatrzymywania, jeśli nie określono innej.
     *      Adnotacje z tym poziomem zatrzymania mogą być używane przez narzędzia działające na plikach .class, 
     *      ale nie będą widoczne przez klasę Class w czasie działania programu.    
     *
     *  RetentionPolicy.RUNTIME:
     *      Adnotacje z tym poziomem są zachowywane w pliku .class i są dostępne w czasie działania, 
     *      co oznacza, że mogą być odczytywane refleksyjnie w czasie wykonywania programu.
     *      Adnotacje z takim poziomem zatrzymania są używane, gdy chcesz, 
     *      aby adnotacja była dostępna za pomocą refleksji w czasie działania aplikacji, 
     *      np. za pomocą metod getAnnotation, getAnnotations, getDeclaredAnnotation i getDeclaredAnnotations z klasy java.lang.Class.
     */

    /**
     *  @Target to adnotacja używana w Javie do określenia, w których miejscach inna adnotacja może być stosowana. 
     *  Innymi słowy, @Target określa "miejsce docelowe" adnotacji, czyli kontekst, w jakim dana adnotacja jest dozwolona. 
     *  Przykładami "miejsca docelowego" mogą być klasy, interfejsy, metody, pola itp.
     *  
     *  @Target przyjmuje jako wartość tablicę elementów wyliczeniowych ElementType, 
     *  które określają możliwe lokalizacje adnotacji. Poniżej znajduje się lista typów ElementType:
     *  
     *  TYPE: Adnotacja może być zastosowana do każdej deklaracji klasy, interfejsu (w tym interfejsu adnotacji), enumu lub adnotacji.
     *  FIELD: Adnotacja może być zastosowana do pola klasy, czyli deklaracji zmiennej członkowskiej.
     *  METHOD: Adnotacja może być zastosowana do metody w klasie lub interfejsie.
     *  PARAMETER: Adnotacja może być zastosowana do parametru metody.
     *  CONSTRUCTOR: Adnotacja może być zastosowana do konstruktora.
     *  LOCAL_VARIABLE: Adnotacja może być zastosowana do lokalnych zmiennych.
     *  ANNOTATION_TYPE: Adnotacja może być zastosowana do innej adnotacji.
     *  PACKAGE: Adnotacja może być zastosowana do deklaracji pakietu.
     *  TYPE_PARAMETER: Adnotacja może być zastosowana do parametru typu w deklaracji generycznej.
     *  TYPE_USE: Adnotacja może być zastosowana do każdego użycia typu (w deklaracjach typów, rzutowaniach, itp.).
     */

// @Retention(RetentionPolicy.RUNTIME)
// @Target(ElementType.TYPE)
public @interface Creatable {
}
