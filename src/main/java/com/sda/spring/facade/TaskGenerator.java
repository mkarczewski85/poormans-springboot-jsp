package com.sda.spring.facade;

import com.sda.spring.model.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskGenerator {

    public List<Task> generateTasks() {

        List<Task> tasks = new ArrayList<>();
        Task task1 = new Task();
        task1.setName("Task 1");
        task1.setComment("Task 1 comment");
        task1.setPriority(3);

        Task task2 = new Task();
        task2.setName("Task 2");
        task2.setComment("Task 2 comment");
        task2.setPriority(1);

        tasks.add(task1);
        tasks.add(task2);
        return tasks;
    }


}
