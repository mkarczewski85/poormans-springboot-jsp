package com.sda.spring.facade;

import com.sda.spring.model.Task;
import com.sda.spring.repositories.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class TaskFacade {

    private static final Logger logger = LoggerFactory.getLogger(TaskFacade.class);

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public void save(Task task) {

        if (task.getDateCreated() == null) {
            logger.info("New task has been created");
            task.setDateCreated(LocalDateTime.now());
        } else {
            logger.info("Task with id {} and name {} edited successfully", task.getId(), task.getName());
        }

        try {
            taskRepository.save(task);
        } catch (Exception e) {
            logger.error("Saving task failed with error", e.getMessage());
        }

    }

    public Task findTaskById(Long id) {
        Task task = taskRepository.findOne(id);
        if (task == null) {
            logger.error("Tak with id {} doesn't exist", id);
            throw new IllegalStateException();
        }
        return task;
    }

    public void deleteTaskById(Long id) {
        taskRepository.delete(id);
        logger.info("Task of id: {} has been deleted!", id);
    }


}
