package com.dylanhouston.rollthedice.ui.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceScreen;
import androidx.preference.SeekBarPreference;
import androidx.preference.SwitchPreferenceCompat;

import com.dylanhouston.rollthedice.LetterPreferences;
import com.dylanhouston.rollthedice.R;
import com.dylanhouston.rollthedice.UserPreferenceManager;
import com.dylanhouston.rollthedice.ui.numerical.NumericalFragment;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        Context context = getPreferenceManager().getContext();
        PreferenceScreen screen = getPreferenceManager().createPreferenceScreen(context);

        // the number of numerical dice automatically loaded
        SeekBarPreference numericalNumPreference = new SeekBarPreference(context);
        numericalNumPreference.setKey("default_num_dice");
        numericalNumPreference.setTitle(R.string.default_numerical);
        numericalNumPreference.setDefaultValue(1);
        numericalNumPreference.setMin(1);
        numericalNumPreference.setMax(NumericalFragment.MAX_NUM_NUMERICAL_DICE);
        numericalNumPreference.setSeekBarIncrement(1);
        numericalNumPreference.setShowSeekBarValue(true);
        screen.addPreference(numericalNumPreference);

        // the letters included in the alphabetical dice
        PreferenceCategory alphabeticalCategory = new PreferenceCategory(context);
        alphabeticalCategory.setKey("alphabetical_category");
        alphabeticalCategory.setTitle(R.string.alphabetical_category);
        screen.addPreference(alphabeticalCategory);

        createAlphabeticalDicePreferences(context, alphabeticalCategory);


        setPreferenceScreen(screen);
    }

    /**
     * Creates all of the preferences for letters to be included in the
     * alphabetical dice and adds them to the appropriate {@code PreferenceCategory}.
     * @param context the {@code Context}
     * @param category the {@code PreferenceCategory}
     */
    private void createAlphabeticalDicePreferences(Context context,
                                                   PreferenceCategory category) {

        for (LetterPreferences preference : LetterPreferences.values()) {
            addLetterPref(context, category, preference);
        }
    }

    /**
     * Adds a letter preference to the category.
     * @param context the {@code Context}
     * @param category the {@code PreferenceCategory}
     * @param preference the case from the {@code LetterPreferences} enum
     */
    private void addLetterPref(Context context, PreferenceCategory category,
                               LetterPreferences preference) {

        SwitchPreferenceCompat prefSwitch = new SwitchPreferenceCompat(context);
        prefSwitch.setKey(preference.toString());
        prefSwitch.setDefaultValue(true);
        String letter = String.valueOf(preference.toString().charAt(0)).toUpperCase();
        prefSwitch.setTitle(letter);
        category.addPreference(prefSwitch);
    }


}
