package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerDaoTest {

    @Autowired
    TaskerDao taskerDao;

    @Before
    public void setUp(){
        List<Task> tList = taskerDao.getAllTasks();

        for (Task t : tList){
            taskerDao.deleteTask(t.getId());
        }

    }

    @Test
    public void getAddDeleteTask(){
        Task task = new Task();
        task.setDescription("Finish summative");
        task.setCreateDate(LocalDate.parse("2019-07-25"));
        task.setDueDate(LocalDate.parse("2019-07-29"));
        task.setCategory("Project");

        task = taskerDao.createTask(task);

        Task task1 = taskerDao.getTask(task.getId());

        assertEquals(task1, task1);

        taskerDao.deleteTask(task.getId());

        task1 = taskerDao.getTask(task.getId());

        assertNull(task1);




    }

    @Test
    public void getAllTasks(){
        Task task = new Task();
        task.setDescription("Finish summative");
        task.setCreateDate(LocalDate.of(2019, 07, 20));
        task.setDueDate(LocalDate.of(2019, 07, 25));
        task.setCategory("Project");

        taskerDao.createTask(task);

        Task task1 = new Task();
        task1.setDescription("Play video games");
        task1.setCreateDate(LocalDate.of(2019, 7, 20));
        task1.setDueDate(LocalDate.of(2019, 8, 19));
        task1.setCategory("Reward");

        taskerDao.createTask(task1);

        List<Task> taskList = taskerDao.getAllTasks();

        assertEquals(taskList.size(),2);

    }

    @Test
    public void updateTask(){

        Task task = new Task();
        task.setDescription("Finish summative");
        task.setCreateDate(LocalDate.of(2019, 07, 20));
        task.setDueDate(LocalDate.of(2019, 07, 25));
        task.setCategory("Project");

        task = taskerDao.createTask(task);

        task.setDescription("Play video games");
        task.setCreateDate(LocalDate.of(2019, 7, 20));
        task.setDueDate(LocalDate.of(2019, 8, 19));
        task.setCategory("Reward");

        taskerDao.updateTask(task);

        Task task1 = taskerDao.getTask(task.getId());

        assertEquals(task1, task);

    }

    @Test
    public void getTaskByCategory(){

        Task task = new Task();
        task.setDescription("Finish summative");
        task.setCreateDate(LocalDate.of(2019, 07, 20));
        task.setDueDate(LocalDate.of(2019, 07, 25));
        task.setCategory("Project");

        taskerDao.createTask(task);

        Task task1 = new Task();
        task1.setDescription("Play video games");
        task1.setCreateDate(LocalDate.of(2019, 7, 20));
        task1.setDueDate(LocalDate.of(2019, 8, 19));
        task1.setCategory("Reward");

        taskerDao.createTask(task1);

        Task task2 = new Task();
        task2.setDescription("Watch a movie");
        task2.setCreateDate(LocalDate.of(2019, 8, 20));
        task2.setDueDate(LocalDate.of(2019, 8, 21));
        task2.setCategory("Reward");

        taskerDao.createTask(task2);

        assertEquals(taskerDao.getTasksByCategory("Reward").size(), 2);


    }
}
