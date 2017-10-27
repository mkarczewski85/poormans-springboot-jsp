package com.sda.spring.controller;

import com.sda.spring.facade.TaskFacade;
import com.sda.spring.facade.TaskGenerator;
import com.sda.spring.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TaskController {

    @Autowired
    TaskFacade taskFacade;

    @Autowired
    private TaskGenerator taskGenerator;

    @RequestMapping("/hello")
    public ModelAndView getHelloWorld(ModelAndView modelAndView) {
        modelAndView.setViewName("hello");
        return modelAndView;
    }

    @RequestMapping("/new")
    public ModelAndView newTaskForm(ModelAndView modelAndView) {
        modelAndView.addObject("task", new Task());
        modelAndView.setViewName("taskForm");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addNewTask(@Valid @ModelAttribute("task") Task task, ModelAndView modelAndView) {
        taskFacade.save(task);
        return prepareTaskList(modelAndView);
    }

    @RequestMapping("/delete")
    public ModelAndView deleteTask(@RequestParam("id") String id, ModelAndView modelAndView) {
        Long taskId = Long.parseLong(id);
        taskFacade.deleteTaskById(taskId);
        return prepareTaskList(modelAndView);
    }

    @RequestMapping("/edit")
    public ModelAndView editTask(@RequestParam("id") String id, ModelAndView modelAndView) {
        Long taskId = Long.parseLong(id);
        Task task = taskFacade.findTaskById(taskId);
        modelAndView.addObject("task", task);
        modelAndView.setViewName("taskForm");
        return modelAndView;
    }


    @RequestMapping("/generateData")
    @ResponseBody
    public String generateData() {
        List<Task> tasks = taskGenerator.generateTasks();
        for (Task t : tasks) {
            taskFacade.save(t);
        }
        return "Data generated";
    }

    @RequestMapping("/tasks")
    public ModelAndView getTasks(ModelAndView modelAndView) {
        return prepareTaskList(modelAndView);
    }

    private ModelAndView prepareTaskList(ModelAndView modelAndView) {
        modelAndView.addObject("tasks", taskFacade.findAll());
        modelAndView.setViewName("list");
        return modelAndView;
    }

}
