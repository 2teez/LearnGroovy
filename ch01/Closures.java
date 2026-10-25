package com.practice.closures;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;

public class Closures {

    public static void main(String... args) {
        var list = new ArrayList<>(Arrays.asList(1, 2, 3));
        list.forEach(out::println);
    }
}
