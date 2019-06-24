package com.example.motoinventoryDaryl.controller;

import com.example.motoinventoryDaryl.model.Motorcycle;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.NegativeOrZero;

import javax.validation.Valid;
import java.util.Random;

@RestController
public class MotoInventoryController {

    @RequestMapping(value = "/motorcycles", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Motorcycle createMotorcycle(@RequestBody @Valid Motorcycle motorcycle) {
        Random rnd = new Random();

        motorcycle.setId(rnd.nextInt(9999));

        return motorcycle;
    }
    
    @RequestMapping(value = "motorcycles/{bikeId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Motorcycle getMotorcycle(@PathVariable int bikeId) {

        Motorcycle bike = new Motorcycle();

        bike.setId(bikeId);
        bike.setVin("52343");
        bike.setColor("Black");
        bike.setMake("Garlond Ironworks");
        bike.setYear("1999");
        bike.setModel("SDS Fenrir");

        return bike;

    }

}
