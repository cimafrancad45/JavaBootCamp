package com.trilogyed.tasker.controller;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import com.trilogyed.tasker.util.feign.AdServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RefreshScope
@RequestMapping(value = "/tasks")
public class TaskerController {

    @Autowired
    private final TaskerServiceLayer service;


    public TaskerController(TaskerServiceLayer service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskViewModel addTask(@RequestBody @Valid TaskViewModel task){
        return service.newTask(task);
    }


    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskViewModel getTask(@PathVariable int id) {
        try {
            return service.fetchTask(id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TaskViewModel> getAllTasks(){
        return service.fetchAllTasks();
    }

    @GetMapping(value = "/category/{category}")
    public List<TaskViewModel> getTaskByCategory(@PathVariable (value = "category") String category){
        return service.fetchTasksByCategory(category);
    }


    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTask(@PathVariable int id, TaskViewModel taskViewModel){
        service.updateTask(taskViewModel);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }
}
