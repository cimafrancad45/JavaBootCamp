package com.company;

import java.util.*;

public class IterateAndPrint {

    public static void main(String[] args) {


        Map<String, String> baseballTeam = new HashMap<>();

        baseballTeam.put("Pitcher", "Mike Foltynewicz");
        baseballTeam.put("Catcher", "Brian McCann");
        baseballTeam.put("First Baseman", "Freddie Freeman");
        baseballTeam.put("Second Baseman", "Ozzie Albies");
        baseballTeam.put("Third Baseman", "Josh Donaldson");
        baseballTeam.put("Shortstop", "Dansby Swanson");
        baseballTeam.put("Left Fielder", "Ronald Acuna, Jr.");
        baseballTeam.put("Center Fielder", "Ender Inciarte");
        baseballTeam.put("Right Fielder", "Nick Markakis");

        Set<String> keys = baseballTeam.keySet();
             System.out.println("\n----Keys-----\n");

        for (String values : keys) {
            System.out.println(values);
        }

        System.out.println("\n------Values------\n");
        Collection<String> player = baseballTeam.values();
        for (String values : player) {
            System.out.println(values);
        }

        System.out.println("\n-------Map---------\n");


        for (String values : keys) {
            System.out.println(values + ": " + baseballTeam.get(values));
        }
    }
}