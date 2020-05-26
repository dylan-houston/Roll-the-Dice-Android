package com.dylanhouston.rollthedice;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import com.dylanhouston.rollthedice.ui.numerical.NumericalFragment;

import java.util.HashMap;
import java.util.Map;

public class UserPreferenceManager {

    // used for retrieving the properties
    private static final String DEFAULT_NUM_DICE_KEY = "default_num_dice";

    // stores the properties
    private Map<LetterPreferences, Boolean> letterPreferences;
    private int defaultNumberOfDice;

    /**
     * Constructs a {@code UserPreferenceManager} object for handling the
     * included letters and the default number of dice.
     */
    public UserPreferenceManager(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.letterPreferences = new HashMap<>();

        for (LetterPreferences preference : LetterPreferences.values()) {
            this.letterPreferences.put(
                    preference,
                    sharedPreferences.getBoolean(preference.toString(), true)
            );
        }

        this.defaultNumberOfDice = sharedPreferences.getInt(DEFAULT_NUM_DICE_KEY, 1);
    }

    /**
     * Checks if the letter should be included in the alphabetical dice.
     * @param letterPreference the letter to check
     * @return {@code true} if included
     */
    public boolean isTrue(LetterPreferences letterPreference) {
        return letterPreferences.get(letterPreference);
    }

    /**
     * Gets the default number of numerical dice.
     * @return the default number of numerical dice.
     */
    public int getDefaultNumberOfDice() {
        return defaultNumberOfDice;
    }

}

