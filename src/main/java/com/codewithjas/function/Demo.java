package com.codewithjas.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Demo {

//Function: abstract method is apply() - takes one argument of any type. Returns one values of any type.

    public static void main(String[] args) {

//        Function<String, Integer> f1 = str -> str.length();
//        Lambda can be replaced with method reference as written in line 13
        Function<String, Integer> f1 = String::length;
        System.out.println(f1.apply("test"));

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("one", 45000));
        employees.add(new Employee("two", 55000));
        employees.add(new Employee("three", 49000));
        employees.add(new Employee("four", 58000));

        Function<Employee, Integer> empFunction = (emp) -> {
            if (emp.salary >= 50000)
                return emp.salary * 10 / 100;
            else
                return emp.salary * 5 / 100;
        };

        for (Employee e: employees){
            System.out.println(empFunction.apply(e));
        }

        System.out.println("Using Function with Stream API");
        employees.stream().flatMapToInt(e -> IntStream.of(empFunction.apply(e))).forEach(System.out::println);


        System.out.println("Returning List from Function interface.");
        Function<List<Employee>, List<Integer>> empFunction1 = (emp)-> {
            Predicate<Employee> predicate = e->e.salary>=50000;
            List<Integer> ints = new ArrayList<>();
            for (Employee e : emp)
                if (predicate.test(e))
                    ints.add(e.salary * 10 / 100);
                else
                    ints.add(e.salary * 5 / 100);
            return ints;
        };

        empFunction1.apply(employees).forEach(System.out::println);

//        Function chaining - andThen & compose
//        andThen() - value gets passed to all the functions in the chain from left to right.
//        compose() - reverse of andThen() - execution from right to left

        Function<Integer, Integer> function1 = param->param*2;
        Function<Integer, Integer> function2 = param->param*param*param;

        System.out.println("Example of andThen");
        System.out.println(function1.andThen(function2).apply(2));

        System.out.println("Example of compose");
        System.out.println(function1.compose(function2).apply(2));

    }
}