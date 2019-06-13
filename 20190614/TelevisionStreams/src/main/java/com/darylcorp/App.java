package com.darylcorp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Television> televisions;

            televisions = mapper.readValue(new File("televisions.json"), new TypeReference<List<Television>>() {
            });


            System.out.println("\nTelevisions with screens larger than 60 inches\n");
            televisions.stream()
                    .filter(tv -> tv.getScreenSize() > 60)
                    .forEach(tv -> {
                        System.out.println("===========");
                        System.out.println("Brand: " + tv.getBrand());
                        System.out.println("Model: " + tv.getModel());
                        System.out.println("Screen Size: " + tv.getScreenSize());
                    });

            Map<String, List<Television>> brandMap =
                    televisions.stream()
                            .collect(Collectors.groupingBy(tv -> tv.getBrand()));

            System.out.println("\n----------Mapped Brands----------\n");
            Set<String> keys = brandMap.keySet();
            for (String keyVal : keys) {
                System.out.println(keyVal);
            }

            System.out.println("\n-----------Screen Size Average------------\n");


            double screenAvg =
                    televisions.stream()
                        .mapToInt(tv ->tv.getScreenSize())
                        .average()
                        .getAsDouble();

            System.out.println("The average of the screen sizes is: " + screenAvg + ".");

            System.out.println("\n------------Largest Screen-----------\n");

            int largestScreen =
                    televisions.stream()
                    .mapToInt(tv -> tv.getScreenSize())
                    .max()
                    .getAsInt();

            System.out.println("The largest screen size is: " + largestScreen + ".");

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
    }
}
