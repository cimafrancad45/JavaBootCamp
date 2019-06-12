package com.company;

import javax.sound.midi.Soundbank;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapFun {
    public static void main(String[] args) {
        Map<String, Integer> Cars = new HashMap<>();

        Cars.put("Toyota Camry", 2012);
        Cars.put("Chevy Camaro", 1969);
        Cars.put("Hyundai Genesis", 2015);
        Cars.put("Jeep Wrangler", 2003);
        Cars.put("Honda Civic", 2018);
        Cars.put("Toyota Supra", 1995);
        Cars.put("Pontiac GTO", 1964);

        Set<String> keys = Cars.keySet();

        for (String values : keys) {
            System.out.println(values + ": " + Cars.get(values));
        }

        Cars.put("Ford Explorer", 2012);
        Cars.put("Smart Fortwo",2013);

        System.out.println("\n--------------------");

        for (String values : keys) {
            System.out.println(values + ": " + Cars.get(values));
        }

        Cars.remove("Jeep Wrangler");

        System.out.println("\n--------------------");

        for (String values : keys) {
            System.out.println(values + ": " + Cars.get(values));
        }

    }
}
