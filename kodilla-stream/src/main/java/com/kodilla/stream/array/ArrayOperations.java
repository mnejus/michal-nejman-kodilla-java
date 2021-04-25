package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers) {
        IntStream.range(0, numbers.length)
                .forEach(System.out::printlngit);

        return IntStream.range(0, numbers.length)
                .average()
                .getAsDouble();
    }
}
