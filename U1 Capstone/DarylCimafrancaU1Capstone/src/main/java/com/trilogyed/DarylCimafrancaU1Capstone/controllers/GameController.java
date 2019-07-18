package com.trilogyed.DarylCimafrancaU1Capstone.controllers;

import com.trilogyed.DarylCimafrancaU1Capstone.exception.NotFoundException;
import com.trilogyed.DarylCimafrancaU1Capstone.service.GameStoreServiceLayer;
import com.trilogyed.DarylCimafrancaU1Capstone.viewmodel.ConsoleViewModel;
import com.trilogyed.DarylCimafrancaU1Capstone.viewmodel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/game")
public class GameController {
    @Autowired
    GameStoreServiceLayer gameStoreServiceLayer;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GameViewModel addGame(@RequestBody @Valid GameViewModel game) {
        return gameStoreServiceLayer.addGame(game);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ConsoleViewModel getGame(@PathVariable("id") int id) {
        ConsoleViewModel consoleViewModel = gameStoreServiceLayer.getConsoleById(id);
        if (consoleViewModel == null)
            throw new NotFoundException("Console could not be found under id" + id);
        return consoleViewModel;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable("id") int id) {
        gameStoreServiceLayer.deleteGame(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@PathVariable("id") int id, @RequestBody @Valid GameViewModel game) {
        if (game.getGameId() == 0)
            game.setGameId(id);
        if (id != game.getGameId()) {
            throw new IllegalArgumentException("Game IDs must match");
        }
    }
}