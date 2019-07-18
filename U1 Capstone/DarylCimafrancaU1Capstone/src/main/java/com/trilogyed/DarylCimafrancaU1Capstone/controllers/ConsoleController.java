package com.trilogyed.DarylCimafrancaU1Capstone.controllers;

import com.trilogyed.DarylCimafrancaU1Capstone.exception.NotFoundException;
import com.trilogyed.DarylCimafrancaU1Capstone.service.GameStoreServiceLayer;
import com.trilogyed.DarylCimafrancaU1Capstone.viewmodel.ConsoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/console")
public class ConsoleController {

    @Autowired
    GameStoreServiceLayer gameStoreServiceLayer;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConsoleViewModel addConsole(@RequestBody @Valid ConsoleViewModel console){
        return gameStoreServiceLayer.saveConsole(console);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ConsoleViewModel getConsole(@PathVariable("id") int id) {
        ConsoleViewModel consoleViewModel = gameStoreServiceLayer.getConsoleById(id);
        if (consoleViewModel == null)
            throw new NotFoundException("Console could not be found under id" + id);
        return consoleViewModel;
    }

    @GetMapping("/{manufacturer}")
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getConsolesByManufacturer(@PathVariable("manufacturer") String manufacturer) {
        List<ConsoleViewModel> cvmList = gameStoreServiceLayer.getConsolesByManufacturer(manufacturer);
        if (cvmList.size() == 0)
            throw new NotFoundException("Console could not be found under that manufacturer name");
        return cvmList;
    }


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable("id") int id){
        gameStoreServiceLayer.deleteConsole(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@PathVariable("id") int id, @RequestBody @Valid ConsoleViewModel consoleViewModel) {
        if (consoleViewModel.getConsoleId() == 0)
            consoleViewModel.setConsoleId(id);
        if (id != consoleViewModel.getConsoleId()){
            throw new IllegalArgumentException("Console IDs must match");
        }


        gameStoreServiceLayer.updateConsole(consoleViewModel);
    }
}
