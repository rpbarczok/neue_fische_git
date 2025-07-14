package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> num = new ArrayList<Integer>(Arrays.asList(3, 9, 4, 12, 845, 3124, 45, 2341, 390, 873, 203));

        List<Integer> numEven = num.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(numEven);
        System.out.println();

        List<Integer> numDouble = num.stream()
                .map(x -> x * 2)
                .collect(Collectors.toList());
        System.out.println(numDouble);
        System.out.println();

        List<Integer> numSort = num.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(numSort);
        System.out.println();

        int sum = num.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(sum);
        System.out.println();

        num.forEach(System.out::println);

    // Das ist ein test comment
        // noch ein test comment
//  mal wieder ein neuer test comment
        // jetzt reichts aber mal mit den neuen commits

        System.out.println("--------------------------------------");
        // Bonus-Aufgabe Studenten

        Files.lines(Path.of("students.csv"))
                .filter(x -> !x.isEmpty())
                .filter(x -> !x.isBlank())
                .map(x -> x.split(","))
                .filter(x -> x.length == 4)
                .filter(x -> isInteger(x[0]))
                .filter(x -> isInteger(x[3]))
                .map(x -> new Student(Integer.parseInt(x[0]), x[1], x[2], Integer.parseInt(x[3])))
                .distinct()
                .forEach(System.out::println);

    }

    public static boolean isInteger(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
