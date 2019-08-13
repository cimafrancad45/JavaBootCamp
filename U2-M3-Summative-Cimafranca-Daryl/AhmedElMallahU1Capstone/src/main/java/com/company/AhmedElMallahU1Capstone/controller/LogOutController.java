package com.company.AhmedElMallahU1Capstone.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/logout")
@RestController
public class LogOutController {

    @GetMapping
    public String logout(){
        return "Successfully logged out";
    }
}
