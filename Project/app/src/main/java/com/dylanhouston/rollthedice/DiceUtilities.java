package com.dylanhouston.rollthedice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class DiceUtilities {

    private static final List<Integer> numericalDiceImages = Arrays.asList(
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.six
    );

    /**
     * Gets a random numerical dice image for a six sided dice.
     * @return the {@code int} image reference
     */
    public static int getRandomNumericalDiceImage() {
        return getRandomElement(numericalDiceImages);
    }

    /**
     * Gets a random alphabetical dice image for an alphabetical dice.
     * @param includedLetters the {@code Map} of letter preferences
     * @return the {@code int} image reference
     */
    public static int getRandomAlphabeticalDiceImage(
                Map<LetterPreferences, Boolean> includedLetters
            ) {

        return getRandomElement(getIncludedAlphabeticalDiceImages(includedLetters));
    }

    private static List<Integer> getIncludedAlphabeticalDiceImages(
            Map<LetterPreferences, Boolean> includedLetters
    ) {

        List<Integer> images = new ArrayList<>();

        if (includedLetters.get(LetterPreferences.a_included)) images.add(R.drawable.a);
        if (includedLetters.get(LetterPreferences.b_included)) images.add(R.drawable.b);
        if (includedLetters.get(LetterPreferences.c_included)) images.add(R.drawable.c);
        if (includedLetters.get(LetterPreferences.d_included)) images.add(R.drawable.d);
        if (includedLetters.get(LetterPreferences.e_included)) images.add(R.drawable.e);
        if (includedLetters.get(LetterPreferences.f_included)) images.add(R.drawable.f);
        if (includedLetters.get(LetterPreferences.g_included)) images.add(R.drawable.g);
        if (includedLetters.get(LetterPreferences.h_included)) images.add(R.drawable.h);
        if (includedLetters.get(LetterPreferences.i_included)) images.add(R.drawable.i);
        if (includedLetters.get(LetterPreferences.j_included)) images.add(R.drawable.j);
        if (includedLetters.get(LetterPreferences.k_included)) images.add(R.drawable.k);
        if (includedLetters.get(LetterPreferences.l_included)) images.add(R.drawable.l);
        if (includedLetters.get(LetterPreferences.m_included)) images.add(R.drawable.m);
        if (includedLetters.get(LetterPreferences.n_included)) images.add(R.drawable.n);
        if (includedLetters.get(LetterPreferences.o_included)) images.add(R.drawable.o);
        if (includedLetters.get(LetterPreferences.p_included)) images.add(R.drawable.p);
        if (includedLetters.get(LetterPreferences.q_included)) images.add(R.drawable.q);
        if (includedLetters.get(LetterPreferences.r_included)) images.add(R.drawable.r);
        if (includedLetters.get(LetterPreferences.s_included)) images.add(R.drawable.s);
        if (includedLetters.get(LetterPreferences.t_included)) images.add(R.drawable.t);
        if (includedLetters.get(LetterPreferences.u_included)) images.add(R.drawable.u);
        if (includedLetters.get(LetterPreferences.v_included)) images.add(R.drawable.v);
        if (includedLetters.get(LetterPreferences.w_included)) images.add(R.drawable.w);
        if (includedLetters.get(LetterPreferences.x_included)) images.add(R.drawable.x);
        if (includedLetters.get(LetterPreferences.y_included)) images.add(R.drawable.y);
        if (includedLetters.get(LetterPreferences.z_included)) images.add(R.drawable.z);

        return images;
    }

    private static int getRandomElement(List<Integer> list) {
        int randomIndex = (int) (Math.random() * (list.size() - 1));
        return list.get(randomIndex);
    }

}
