package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardTestSuite {

    @Autowired
    private TaskList toDoList, inProgressList, doneList;

    @Test
    void testTaskAdd() {
        //Given
        //When
        toDoList.getTasks().add("first task to do");
        inProgressList.getTasks().add("task in progress");
        doneList.getTasks().add("task done");
        //Then
        System.out.println(toDoList.getTasks() + " " + inProgressList.getTasks() + " " + doneList.getTasks());


    }

}
