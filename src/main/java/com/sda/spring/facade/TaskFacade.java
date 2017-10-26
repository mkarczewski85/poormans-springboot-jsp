package com.sda.spring.facade;

import com.sda.spring.model.Task;
import com.sda.spring.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskFacade {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public void save(Task task){
        if (task.getDateCreated() == null){
            task.setDateCreated(new Date());
        }
        taskRepository.save(task);
    }

    public Task findTaskById(Long id){
        return taskRepository.findOne(id);
    }

    public void deleteTaskById(Long id){
        taskRepository.delete(id);
    }



}
