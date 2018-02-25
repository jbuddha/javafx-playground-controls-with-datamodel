package com.pluralsight.javafx.playground;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener;
import org.junit.Test;

public class ObservableTests {
    @Test
    public void simpleTest() {
        ObservableList<String> list = FXCollections.observableArrayList();

        list.add("First");
        list.add("Second");
        System.out.println(list);
    }

    @Test
    public void listeningTest() {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addListener((ListChangeListener<? super String>) change -> {
            System.out.println("Change: " + change.toString());
        });
        list.addListener((InvalidationListener) invalidationChange -> {
            System.out.println("Invalidation: " + invalidationChange.toString());
        });
        list.add("First");
        list.set(0, list.get(0));
        list.add("Second");

        System.out.println(list);
    }

    @Test
    public void setTests() {
        ObservableSet<String> set = FXCollections.observableSet();
        set.addListener(this::onChange);
        set.addListener((SetChangeListener<? super String>) System.out::println);
        set.addListener((InvalidationListener) System.out::println);
        set.add("Item1");
        set.add("Item2");
        set.add("Item1");
    }

    @Test
    public void mapTests() {
        ObservableMap<String, String> set = FXCollections.observableHashMap();
        set.addListener(this::onChange);
        set.addListener((MapChangeListener<? super String, ? super String>) System.out::println);
        set.addListener((InvalidationListener) System.out::println);
        set.put("Item1","1");
        set.put("Item2", "1");
        set.put("Item1", "1");
    }

    private void onChange(Observable observable) {
        System.out.println("method ref: " + observable);
    }
}
