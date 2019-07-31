package com.trilogyed.tasker.service;


import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class TaskerServiceLayerTest {

    @Autowired
    TaskerDao taskerDao;
    TaskerServiceLayer service;

    @Before
    public void setUp() throws Exception{

        setUpTaskerDaoMock();

        service = new TaskerServiceLayer(taskerDao);

    }

    private void setUpTaskerDaoMock(){
        taskerDao = mock(TaskerDaoJdbcTemplateImpl.class);

        Task task = new Task();
        task.setId(3);
        task.setDescription("Finish summative");
        task.setCreateDate(LocalDate.parse("2019-07-24"));
        task.setDueDate(LocalDate.parse("2019-07-29"));
        task.setCategory("Project");

        Task task1 = new Task();
        task1.setDescription("Finish summative");
        task1.setCreateDate(LocalDate.parse("2019-07-24"));
        task1.setDueDate(LocalDate.parse("2019-07-29"));
        task1.setCategory("Project");

        List<Task> taskList = new ArrayList<>();
        taskList.add(task);

        doReturn(task).when(taskerDao).createTask(task1);
        doReturn(task).when(taskerDao).getTask(3);
        doReturn(taskList).when(taskerDao).getAllTasks();



    }


    @Test
    public void addGetTask(){

        Task task = new Task();
        task.setDescription("Finish summative");
        task.setCreateDate(LocalDate.parse("2019-07-24"));
        task.setDueDate(LocalDate.parse("2019-07-29"));
        task.setCategory("Project");

        task = taskerDao.createTask(task);

        Task task1 = taskerDao.getTask(task.getId());

        assertEquals(task, task1);

    }


    @Test
    public void getAllTasks(){
        List<Task> taskList = new ArrayList<>();
        Task task = new Task();

        task.setDescription("Finish summative");
        task.setCreateDate(LocalDate.parse("2019-07-24"));
        task.setDueDate(LocalDate.parse("2019-07-29"));
        task.setCategory("Project");


        taskList.add(task);

        taskerDao.createTask(task);

        List<Task> fromService = taskerDao.getAllTasks();

        assertEquals(taskList.size(), fromService.size());
    }

}
