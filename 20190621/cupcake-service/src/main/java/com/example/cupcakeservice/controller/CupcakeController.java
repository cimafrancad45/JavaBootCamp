package com.example.cupcakeservice.controller;

import com.example.cupcakeservice.model.Cupcake;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Random;


@RestController
public class CupcakeController {

    @RequestMapping(value = "/cupcakes/", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)

    public Cupcake createCupcake(@RequestBody @Valid Cupcake cupcake){
        Random rnd = new Random();

        cupcake.setId(rnd.nextInt(9999));

        return cupcake;

    }


}
