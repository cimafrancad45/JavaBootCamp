package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskerServiceLayer{


    TaskerDao dao;

    @Autowired
    AdServiceClient client;

    public TaskerServiceLayer(AdServiceClient client){
        this.client = client;
    }


    @Autowired
    public TaskerServiceLayer(TaskerDao dao) {
        this.dao = dao;
    }

    public TaskViewModel fetchTask(int id) {

        Task task = dao.getTask(id);
        TaskViewModel tvm = new TaskViewModel();

        tvm.setId(task.getId());
        tvm.setDescription(task.getDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());
        tvm.setAdvertisement(client.getAd());

        return tvm;
    }

    public List<TaskViewModel> fetchAllTasks() {
        List<Task> taskList = dao.getAllTasks();
        TaskViewModel tvm = new TaskViewModel();
        List<TaskViewModel> tvmList = new ArrayList<>();

        for (Task t : taskList){
                tvm.setId(t.getId());
                tvm.setDescription(t.getDescription());
                tvm.setCreateDate(t.getCreateDate());
                tvm.setDueDate(t.getDueDate());
                tvm.setCategory(t.getCategory());
                tvm.setAdvertisement(client.getAd());
                tvmList.add(tvm);
        }

        return tvmList;
    }

    public List<TaskViewModel> fetchTasksByCategory(String category) {
        List<Task> taskList = dao.getTasksByCategory(category);
        TaskViewModel tvm = new TaskViewModel();
        List<TaskViewModel> tvmList = new ArrayList<>();

        for (Task t : taskList){
            tvm.setId(t.getId());
            tvm.setDescription(t.getDescription());
            tvm.setCreateDate(t.getCreateDate());
            tvm.setDueDate(t.getDueDate());
            tvm.setCategory(t.getCategory());
            tvmList.add(tvm);
        }
        return tvmList;
    }

    public TaskViewModel newTask(TaskViewModel taskViewModel) {
        Task task = new Task();

        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        task = dao.createTask(task);

        taskViewModel.setId(task.getId());
        taskViewModel.setAdvertisement(client.getAd());

        return taskViewModel;
    }

    public void deleteTask(int id) {
        dao.deleteTask(id);

    }

    public void updateTask(TaskViewModel taskViewModel) {
        Task task = new Task();
        task.setId(taskViewModel.getId());
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        dao.updateTask(task);
    }
}
