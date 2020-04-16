package com.mas.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestDemo {

    public static void main(String[] args) {

        List<String> collectString = Stream.of("hello", "world", "helloWorld")
                .collect(ArrayList<String>::new, ArrayList<String>::add, ArrayList<String>::addAll);
        collectString.forEach(System.out::println);

        Stream.of("hello", "world", "helloWorld").map(String::toUpperCase).forEach(System.out::println);

        HashSet<Object> collect = Stream.of("hello", "world", "helloWorld").map(String::toUpperCase).collect(HashSet::new, HashSet::add, HashSet::addAll);
        System.out.println(collect.toString());

        Stream.of(Arrays.asList(1), Arrays.asList(2, 3)).flatMap(Collection::stream).map(Math::sqrt).forEach(System.out::println);

        List<Object> collect1 = Stream.of(Arrays.asList(1), Arrays.asList(2, 3)).flatMap(Collection::stream).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        System.out.println(collect1.toString());

        Stream.iterate(1, a -> a + 2).limit(6)
                .filter(integer -> integer > 2).mapToInt(integer -> integer * 2).skip(2).limit(2).reduce((a, b) -> a + b).ifPresent(System.out::println);

        Stream.iterate(1, a -> a + 2).limit(6)
                .filter(integer -> integer > 2).mapToInt(integer -> integer * 2).skip(2).limit(2).min().ifPresent(System.out::println);

        // this is error --> IntStream.iterate(0, i->(i+1)%2).distinct().limit(6).forEach(System.out::println);
        IntStream.iterate(0, i -> (i + 1) % 2).limit(6).distinct().forEach(System.out::println);


    }

}
