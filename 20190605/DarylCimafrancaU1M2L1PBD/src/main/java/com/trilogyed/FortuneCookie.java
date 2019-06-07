package com.trilogyed;

import java.util.Random;

public class FortuneCookie {
    public static void main(String[] args) {


        Random random = new Random();
        int fortune = random.nextInt(6);

        String[] Fortunes = {
                "Don't listen to other forms of fortune telling, only listen to the fortune cookie",
                "Look up to the skies for inspiration",
                "Love is just around the corner.",
                "You cannot fail if you never give up.",
                "Never leave your umbrella at home. Always prepare for the worst.",
                "If you have nothing to do, take a walk and reflect on your successes.."};

        System.out.println(Fortunes[fortune]);

    }
}
