package com.trilogyed.tasker.controller;

import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/tasks/")
public class TaskerController {

    @Autowired
    TaskerServiceLayer service;

    public TaskerController(TaskerServiceLayer service) {
        this.service = service;
    }


    @GetMapping(value = "/{id}")
    public TaskViewModel getTask(@PathVariable int id) {
        try {
            return service.fetchTask(id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    @DeleteMapping(value = "/{id}")
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }
}
