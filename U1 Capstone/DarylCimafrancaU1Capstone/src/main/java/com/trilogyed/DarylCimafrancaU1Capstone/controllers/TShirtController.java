package com.trilogyed.DarylCimafrancaU1Capstone.controllers;

import com.trilogyed.DarylCimafrancaU1Capstone.exception.NotFoundException;
import com.trilogyed.DarylCimafrancaU1Capstone.service.GameStoreServiceLayer;
import com.trilogyed.DarylCimafrancaU1Capstone.viewmodel.TShirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/tshirt")
public class TShirtController {
    @Autowired
    GameStoreServiceLayer gameStoreServiceLayer;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TShirtViewModel addTShirt(@RequestBody @Valid TShirtViewModel shirt) {
        return gameStoreServiceLayer.addTShirt(shirt);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TShirtViewModel getTShirt(@PathVariable("id") int id) {
        TShirtViewModel tShirtViewModel = gameStoreServiceLayer.getTShirt(id);
        if (tShirtViewModel == null)
            throw new NotFoundException("Console could not be found under id" + id);
        return tShirtViewModel;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTShirt(@PathVariable("id") int id) {
        gameStoreServiceLayer.deleteTShirt(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTShirt(@PathVariable("id") int id, @RequestBody @Valid TShirtViewModel tShirtViewModel) {
        if (tShirtViewModel.getTShirtId() == 0)
            tShirtViewModel.settShirtId(id);
        if (id != tShirtViewModel.getTShirtId()) {
            throw new IllegalArgumentException("TShirt IDs must match");
        }
    }
}