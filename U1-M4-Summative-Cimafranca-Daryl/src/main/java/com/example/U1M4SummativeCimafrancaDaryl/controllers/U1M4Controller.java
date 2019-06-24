package com.example.U1M4SummativeCimafrancaDaryl.controllers;

import com.example.U1M4SummativeCimafrancaDaryl.models.Quotes;
import com.example.U1M4SummativeCimafrancaDaryl.models.Words;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class U1M4Controller {
    @RequestMapping(value = "/quote/", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quotes getQuote(){
        //Initializing in-memory data storage for the quotes
        Quotes quote1 = new Quotes();
        Quotes quote2 = new Quotes();
        Quotes quote3 = new Quotes();
        Quotes quote4 = new Quotes();
        Quotes quote5 = new Quotes();
        Quotes quote6 = new Quotes();
        Quotes quote7 = new Quotes();
        Quotes quote8 = new Quotes();
        Quotes quote9 = new Quotes();
        Quotes quote10 = new Quotes();

        Random random = new Random();
        int randomNum = random.nextInt(10);

        List<Quotes> quotesList = new ArrayList<>();

        quote1.setQuote("If there's a fork in the road, take it.");
        quote1.setAuthor("Yogi Berra");

        quote2.setQuote("You must be shapeless, formless, like water. " +
                "When you pour water in a cup, it becomes the cup. " +
                "When you pour water in a bottle, it becomes the bottle. " +
                "When you pour water in a teapot, it becomes the teapot. " +
                "Water can drip and it can crash. " +
                "Become like water my friend.");
        quote2.setAuthor("Bruce Lee");

        quote3.setQuote("What strength! But don't forget that there are many of you all over the world!");
        quote3.setAuthor("Everyone you beat in Street Fighter I");

        quote4.setQuote("Go home and be a family man.");
        quote4.setAuthor("Guile");

        quote5.setQuote("These aren't the droids you're looking for");
        quote5.setAuthor("Obi-Wan Kenobi");

        quote6.setQuote("You must defeat my Shoryuken to stand a chance.");
        quote6.setAuthor("Ryu");

        quote7.setQuote("NNOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO!");
        quote7.setAuthor("Darth Vader");

        quote8.setQuote("I did not hit her! It's not true! This is bull$%&#! I did not hit her! I did not!... Oh hi, Mark.");
        quote8.setAuthor("Tommy Wiseau");

        quote9.setQuote("WHAT AM I FIGHTING FOOOOOORRRRRRRR!?");
        quote9.setAuthor("Zero");

        quote10.setQuote("What is a man!? A miserable little pile of secrets!");
        quote10.setAuthor("Dracula");

        quotesList.add(quote1);
        quotesList.add(quote2);
        quotesList.add(quote3);
        quotesList.add(quote4);
        quotesList.add(quote5);
        quotesList.add(quote6);
        quotesList.add(quote7);
        quotesList.add(quote8);
        quotesList.add(quote9);
        quotesList.add(quote10);

        return quotesList.get(randomNum);
    }

    @RequestMapping(value = "/word/", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Words getWord() {
        //initializing in-memory words
        Words word1 = new Words();
        Words word2 = new Words();
        Words word3 = new Words();
        Words word4 = new Words();
        Words word5 = new Words();
        Words word6 = new Words();
        Words word7 = new Words();
        Words word8 = new Words();
        Words word9 = new Words();
        Words word10 = new Words();

        Random random = new Random();



        List<Words> wordList = new ArrayList<>();

        word1.setWord("Relinquish");
        word1.setDefinition("To let go/To give up.");

        word2.setWord("Sanguine");
        word2.setDefinition("Consisting or related to blood.");

        word3.setWord("Mettle");
        word3.setDefinition("Vigor and strength.");

        word4.setWord("Corpulent");
        word4.setDefinition("Having a large body.");

        word5.setWord("Epitome");
        word5.setDefinition("A typical or ideal example.");

        word6.setWord("Robust");
        word6.setDefinition("Having or exhibiting strength or vigorous health.");

        word7.setWord("Pilfer");
        word7.setDefinition("To steal.");

        word8.setWord("Moist");
        word8.setDefinition("Slightly or moderately wet.");

        word9.setWord("Crevice");
        word9.setDefinition("A narrow opening resulting from a split or a crack.");

        word10.setWord("Luminous");
        word10.setDefinition("Emitting or reflecting usually steady light.");

        wordList.add(word1);
        wordList.add(word2);
        wordList.add(word3);
        wordList.add(word4);
        wordList.add(word5);
        wordList.add(word6);
        wordList.add(word7);
        wordList.add(word8);
        wordList.add(word9);
        wordList.add(word10);

        Words randomWordDef1 = wordList.get(random.nextInt(10));
        Words randomWordDef2 = wordList.get(random.nextInt(10));

        String randomWord = randomWordDef1.getWord();
        String randomDef = randomWordDef2.getDefinition();

        Words randomWordDef = new Words();
        randomWordDef.setWord(randomWord);
        randomWordDef.setDefinition(randomDef);

        return randomWordDef;
    }
}
