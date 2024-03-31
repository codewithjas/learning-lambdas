package com.codewithjas.predicates;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Demo {

//Predicate: abstract method is test() - takes one argument of any type. Returns boolean
//Predicates should be used  for condition checking

    public static void main(String[] args) {
        //integer example
        Predicate<Integer> pred = number -> (number<2);
        System.out.println(pred.test(10));

        //string example
        Predicate<String> stringPredicate = str -> str.length() > 10;
        System.out.println(stringPredicate.test("codewithjas"));
        System.out.println(stringPredicate.test("code"));

        //with multiple values
        String[] names = {"asd", "we", "uhh", "uaswewaddsdcybj"};
        Arrays.stream(names).filter(stringPredicate)
                .forEach(System.out::println);

        //Joining multiple predicates; each predicate has one lambda expression.
        //three methods available to join predicates - and, or, negate
        //and - all conditions should be true for the output to be true.
        //or - if any one of the condition is true - result is true.
        //negate  - negates the result of the predicate

        //p1 - checks if number is even
        //p2 - checks if number > 50

        Integer[] numbers = {5, 65, 435, 98, 23, 987, 12, 2};
        Predicate<Integer> p1 = arg->arg%2==0;
        Predicate<Integer> p2 = arg->arg>50;

        Arrays.stream(numbers).filter(p1).forEach(System.out::println);
        Arrays.stream(numbers).filter(p2).forEach(System.out::println);

        System.out.println("join operations");
        System.out.println("OR operations");
        Arrays.stream(numbers).filter(p1.or(p2)).forEach(System.out::println);

        System.out.println("AND operations");
        Arrays.stream(numbers).filter(p1.and(p2)).forEach(System.out::println);
        System.out.println("NEGATE operations");
        Arrays.stream(numbers).filter(p2.negate()).forEach(System.out::println);

    }

}
