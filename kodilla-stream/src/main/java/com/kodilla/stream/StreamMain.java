package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.PoemDecorator;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.util.Locale;

public class StreamMain {

    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream");

        Processor processor = new Processor();
        //Executor codeToExecute = () -> System.out.println("Text!");
        processor.execute(() -> System.out.println("Text!"));

        System.out.println();
        System.out.println("Calculator - Lambda");
        System.out.println();

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambda: ");
        System.out.println();
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println();
        System.out.println("Calculating expressions with method references");
        System.out.println();
        expressionExecutor.executeExpression(3 , 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        System.out.println();
        System.out.println("Task 7.1");
        System.out.println();

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("Default Text", ((text) -> "ABC " + text + " ABC"));
        poemBeautifier.beautify("Default Text", ((text) -> text.toUpperCase()));
        poemBeautifier.beautify("Default Text", ((text) -> text.toLowerCase()));
        poemBeautifier.beautify("Default Text", ((text) -> text.replace('e', 'o')));

        System.out.println();
        System.out.println("Task 7.2 - Number generator");
        System.out.println();

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}
