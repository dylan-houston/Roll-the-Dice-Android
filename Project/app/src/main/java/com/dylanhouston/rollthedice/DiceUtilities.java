package com.dylanhouston.rollthedice;

public abstract class DiceUtilities {

    private static final int[] numericalDiceImages = {
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.six
    };

    private static final int[] alphabeticalDiceImages = {

    };

    public static int getRandomNumericalDiceImage() {
        return getRandomElement(numericalDiceImages);
    }

    public static int getRandomAlphabeticalDiceImage() {
        // TODO: add some way of removing elements, maybe make a list
        return getRandomElement(alphabeticalDiceImages);
    }

    private static int getRandomElement(int[] array) {
        int randomIndex = (int) (Math.random() * ((array.length)+1));
        return array[randomIndex];
    }

}
