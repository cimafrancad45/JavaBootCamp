package com.trilogyed.DarylCimafrancaU1Capstone.dao;

import com.trilogyed.DarylCimafrancaU1Capstone.dto.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TShirtDaoTest {
    @Autowired
    ConsoleDao consoleDao;
    @Autowired
    GameDao gameDao;
    @Autowired
    TshirtDao tshirtDao;

    @Before
    public void initializeData(){
        List<Console> cList = consoleDao.getAllConsoles();
        for(Console c : cList){
            consoleDao.deleteConsole(c.getConsoleId());
        }

        List<Game> gList = gameDao.getAllGames();
        for (Game g : gList){
            gameDao.deleteGame(g.getGameId());
        }

        List<TShirt> tList = tshirtDao.getAllTShirts();
        for (TShirt t: tList){
            tshirtDao.deleteTShirt(t.gettShirtId());
        }

    }

    @Test
    public void addGetDeleteTShirt(){
        TShirt shirt = new TShirt();


    }

    @Test
    public void getAllTShirts() {
        List<TShirt> tList = new ArrayList<>();
        List<TShirt> tList2 = tshirtDao.getAllTShirts();

    }

    @Test
    public void updateTShirt(){

    }

    @Test
    public void getTShirtBySize(){

    }

    @Test
    public void getTShirtByColor(){

    }

}
