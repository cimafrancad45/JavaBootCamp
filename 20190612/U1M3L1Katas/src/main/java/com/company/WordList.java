package com.company;

import java.util.ArrayList;
import java.util.List;

public class WordList {

    public static void main(String[] args) {

        String[] wordList = {"byte", "case", "catch", "class", "const", "continue", "do", "double", "else", "extends"};

        for(String element : wordList) {
            System.out.println(element);
        }


        //REFACTORED CODE

        System.out.println("\n----------------------------------  Refactored Code ----------------------------------------\n");


        List<String> newWordList = new ArrayList<String>();

        for (String value : wordList){
            newWordList.add(value);
        }

        for (String value : newWordList) {
            System.out.println(value);
        }
    }

}
