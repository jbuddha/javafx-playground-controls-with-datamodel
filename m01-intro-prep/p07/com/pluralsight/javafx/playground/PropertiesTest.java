package com.pluralsight.javafx.playground;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.junit.Test;

public class PropertiesTest {
    @Test
    public void simplePropertyTest() {
        IntegerProperty dependent = new SimpleIntegerProperty(10);

        //  System.out.println(dependent);

        dependent.addListener(invalidated -> {
            System.out.println(invalidated);
        });

        dependent.addListener((observable, oldValue, newValue) -> {
            System.out.println("new value: " + newValue);
        });

        dependent.setValue(15);
    }

    @Test
    public void binding() {
        IntegerProperty dependent = new SimpleIntegerProperty();

        dependent.addListener(invalidated -> {
            System.out.println(invalidated);
        });

        dependent.addListener((observable, oldValue, newValue) -> {
            System.out.println("new value: " + newValue);
        });

        IntegerProperty listenedProperty = new SimpleIntegerProperty(15);

        dependent.bind(listenedProperty);

        listenedProperty.setValue(10);

        System.out.println(dependent);
    }
}
