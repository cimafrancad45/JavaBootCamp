package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarLists {

    public static void main(String[] args) {

        Car camry = new Car("Toyota", "Camry");
        Car corolla = new Car("Toyota", "Corolla");
        Car highlander = new Car("Toyota", "Highlander");

        Car mustang = new Car("Ford", "Mustang");
        Car fusion = new Car("Ford", "Fusion");
        Car taurus = new Car("Ford", "Taurus");

        Car accord = new Car("Honda", "Accord");
        Car civic = new Car("Honda", "Civic");
        Car fit = new Car("Honda", "Fit");

        List<Car> toyotaList = new ArrayList<>();
        List<Car> fordList = new ArrayList<>();
        List<Car> hondaList = new ArrayList<>();


        toyotaList.add(camry);
        toyotaList.add(corolla);
        toyotaList.add(highlander);

        fordList.add(mustang);
        fordList.add(fusion);
        fordList.add(taurus);

        hondaList.add(accord);
        hondaList.add(civic);
        hondaList.add(fit);


    }
}
