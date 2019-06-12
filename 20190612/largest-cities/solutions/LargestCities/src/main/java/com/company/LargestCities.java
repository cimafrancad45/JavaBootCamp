package com.company;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LargestCities {
    public static void main(String[] args) {
        /*
        Using the City Class constructor, we set up city objects for each city with the String name of the city as the key
        and have the set as the population.
        */
        City newYork = new City("New York", 8654321);
        City losAngeles = new City("Los Angeles", 4563218);
        City chicago = new City( "Chicago", 2716520);
        City denver = new City("Denver", 704621);
        City desMoines = new City("Des Moines", 217521);
        City atlanta = new City("Atlanta", 486213);

        //Creating a new map
        Map<String, City> cities = new HashMap<>();

        //putting the city values we created into the map
        cities.put("New York", newYork);
        cities.put("California", losAngeles);
        cities.put("Illinois", chicago);
        cities.put("Colorado", denver);
        cities.put("Iowa", desMoines);
        cities.put("Georgia", atlanta);

        Scanner scan = new Scanner(System.in);

        /*
        User puts in a population using the Scanner interface and with the logic below, we determine which cities have
        a population larger than the user's input.
         */

        System.out.print("Please enter a population (number): ");
        int popLimit = Integer.parseInt(scan.nextLine());

        System.out.println("Cities with a population larger than " + popLimit);

        Set<String> keys = cities.keySet();

        for(String key : keys) {
            if(cities.get(key).getPopulation() > popLimit) {
                System.out.println(key + " : " + cities.get(key).getName());
            }
        }
    }
}
