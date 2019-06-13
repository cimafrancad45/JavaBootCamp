package com.company;

public class Application {

    public static void main(String[] args) {

        int petIndex = Pets.choosePet();

        String chosenPet = Pets.retrievePet(petIndex);

        Pets.readPetsFromFile();

        Pets.writePetToFile(chosenPet);

    }
}
