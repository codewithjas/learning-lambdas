package com.codewithjas;

import java.util.function.Predicate;

public class App {
    public static void main(String[] args) {

        MyInterface myInterface = ()-> System.out.println("lambda call");
        myInterface.sayHello();

    }
}
