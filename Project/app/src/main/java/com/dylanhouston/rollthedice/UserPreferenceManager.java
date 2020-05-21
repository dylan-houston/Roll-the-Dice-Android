package com.dylanhouston.rollthedice;

import android.content.Context;
import android.content.SharedPreferences;

import com.dylanhouston.rollthedice.ui.numerical.NumericalFragment;

import java.util.HashMap;
import java.util.Map;

public class UserPreferenceManager {

    // used for retrieving the properties
    private static final String PREFERENCES = "PREFERENCES";
    private static final String DEFAULT_NUM_DICE_KEY = "default_num_dice";
    private final SharedPreferences sharedPreferences;

    // stores the properties
    private Map<LetterPreferences, Boolean> letterPreferences;
    private int defaultNumberOfDice;

    /**
     * Constructs a {@code UserPreferenceManager} object for handling the
     * included letters and the default number of dice.
     */
    public UserPreferenceManager(Context context) {
        this.sharedPreferences = context.getSharedPreferences(
                PREFERENCES, 0);
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
     * Sets the desired letter inclusion preference to a given value.
     * @param preference the preference to set
     * @param value the value of the preference
     */
    public void setLetterPreference(LetterPreferences preference, boolean value) {
        // changes the preference in the map
        letterPreferences.put(preference, value);

        // changes the preference
        SharedPreferences.Editor prefEditor = this.sharedPreferences.edit();
        prefEditor.putBoolean(preference.toString(), value);
        prefEditor.apply();
    }

    /**
     * Sets the desired default number of numerical dice.
     * @param value the value of the preference
     */
    public void setDefaultNumberOfDice(int value) {
        if (value > 0 && value <= NumericalFragment.MAX_NUM_NUMERICAL_DICE) {
            // changes the preference in the map
            defaultNumberOfDice = value;

            // changes the preference
            SharedPreferences.Editor prefEditor = this.sharedPreferences.edit();
            prefEditor.putInt(DEFAULT_NUM_DICE_KEY, value);
            prefEditor.apply();
        }
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

enum LetterPreferences {
    a_included,
    b_included,
    c_included,
    d_included,
    e_included,
    f_included,
    g_included,
    h_included,
    i_included,
    j_included,
    k_included,
    l_included,
    m_included,
    n_included,
    o_included,
    p_included,
    q_included,
    r_included,
    s_included,
    t_included,
    u_included,
    v_included,
    w_included,
    x_included,
    y_included,
    z_included
}
