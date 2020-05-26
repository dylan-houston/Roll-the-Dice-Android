package com.dylanhouston.rollthedice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
     * @param userPreferenceManager the {@code UserPreferenceManager} object
     *                              containing preferences
     * @return the {@code int} image reference
     */
    public static int getRandomAlphabeticalDiceImage(
                UserPreferenceManager userPreferenceManager
            ) {

        return getRandomElement(getIncludedAlphabeticalDiceImages(userPreferenceManager));
    }

    private static List<Integer> getIncludedAlphabeticalDiceImages(
            UserPreferenceManager u
    ) {

        List<Integer> images = new ArrayList<>();

        if (u.isTrue(LetterPreferences.a_included)) images.add(R.drawable.a);
        if (u.isTrue(LetterPreferences.b_included)) images.add(R.drawable.b);
        if (u.isTrue(LetterPreferences.c_included)) images.add(R.drawable.c);
        if (u.isTrue(LetterPreferences.d_included)) images.add(R.drawable.d);
        if (u.isTrue(LetterPreferences.e_included)) images.add(R.drawable.e);
        if (u.isTrue(LetterPreferences.f_included)) images.add(R.drawable.f);
        if (u.isTrue(LetterPreferences.g_included)) images.add(R.drawable.g);
        if (u.isTrue(LetterPreferences.h_included)) images.add(R.drawable.h);
        if (u.isTrue(LetterPreferences.i_included)) images.add(R.drawable.i);
        if (u.isTrue(LetterPreferences.j_included)) images.add(R.drawable.j);
        if (u.isTrue(LetterPreferences.k_included)) images.add(R.drawable.k);
        if (u.isTrue(LetterPreferences.l_included)) images.add(R.drawable.l);
        if (u.isTrue(LetterPreferences.m_included)) images.add(R.drawable.m);
        if (u.isTrue(LetterPreferences.n_included)) images.add(R.drawable.n);
        if (u.isTrue(LetterPreferences.o_included)) images.add(R.drawable.o);
        if (u.isTrue(LetterPreferences.p_included)) images.add(R.drawable.p);
        if (u.isTrue(LetterPreferences.q_included)) images.add(R.drawable.q);
        if (u.isTrue(LetterPreferences.r_included)) images.add(R.drawable.r);
        if (u.isTrue(LetterPreferences.s_included)) images.add(R.drawable.s);
        if (u.isTrue(LetterPreferences.t_included)) images.add(R.drawable.t);
        if (u.isTrue(LetterPreferences.u_included)) images.add(R.drawable.u);
        if (u.isTrue(LetterPreferences.v_included)) images.add(R.drawable.v);
        if (u.isTrue(LetterPreferences.w_included)) images.add(R.drawable.w);
        if (u.isTrue(LetterPreferences.x_included)) images.add(R.drawable.x);
        if (u.isTrue(LetterPreferences.y_included)) images.add(R.drawable.y);
        if (u.isTrue(LetterPreferences.z_included)) images.add(R.drawable.z);

        return images;
    }

    private static int getRandomElement(List<Integer> list) {
        int randomIndex = (int) (Math.random() * (list.size() - 1));
        return list.get(randomIndex);
    }

}
