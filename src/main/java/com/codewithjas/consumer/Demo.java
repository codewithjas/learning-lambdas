package com.codewithjas.consumer;

import com.codewithjas.function.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Demo {

    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println(s + " is learning Consumer");
        consumer.accept("user");

        Consumer<String> consumer1 = s -> System.out.println(s + "is learning lambdas");

        consumer.andThen(consumer1).accept("codewithjas");

        Consumer<String> consumer2 = consumer.andThen(consumer1);
        consumer2.accept("newuser");
    }

}
