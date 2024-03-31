package com.codewithjas.supplier;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Demo {

    public static void main(String[] args) {
        Supplier<String> supplier = () ->  "User is learning Supplier";

        System.out.println(supplier.get());

        Supplier<String> supplier1 = ()-> "Here is the new Date: " + new Date();

        System.out.println(supplier1.get());
    }

}
