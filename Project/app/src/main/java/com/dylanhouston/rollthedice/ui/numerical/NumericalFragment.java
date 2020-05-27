package com.dylanhouston.rollthedice.ui.numerical;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dylanhouston.rollthedice.DiceUtilities;
import com.dylanhouston.rollthedice.R;
import com.dylanhouston.rollthedice.UserPreferenceManager;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Arrays;

import static com.google.android.gms.ads.RequestConfiguration.TAG_FOR_UNDER_AGE_OF_CONSENT_TRUE;

public class NumericalFragment extends Fragment {

    // the maximum possible number of dice
    public static final int MAX_NUM_NUMERICAL_DICE = 6;

    // the view adapter that stores the dice
    private NumericalRecyclerAdapter numericalDiceRecyclerViewAdapter;

    // the number of dice and images used for changing this
    private int numberOfDice;
    private ImageButton incrementButton;
    private ImageButton decrementButton;
    private TextView numDiceLabel;

    // the numerical dice to display
    private int[] diceImages = {};


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // sets up the view
        NumericalViewModel numericalViewModel = ViewModelProviders.of(this).
                get(NumericalViewModel.class);
        View root = inflater.inflate(R.layout.fragment_numerical, container, false);

        // gets the user's preferences for setting the view up
        UserPreferenceManager pref = new UserPreferenceManager(getContext());

        // sets up the individual components
        setupNumericalRecycler(pref, root);
        setupAds(root, this);
        setupRollButton(root);
        setupNumDiceButtons(root);
        setupNumDiceLabel(root);

        return root;
    }

    /**
     * Sets up the displaying of the dice.
     * @param pref {@code UserPreferenceManager} to get the initial number
     *                                          of dice
     * @param view the view for this fragment
     */
    private void setupNumericalRecycler(UserPreferenceManager pref, View view) {
        // sets up the dice images
        numberOfDice = pref.getDefaultNumberOfDice();
        diceImages = new int[numberOfDice];
        Arrays.fill(diceImages, R.drawable.blank_dice);

        // the recycler view
        // the recycler view for displaying the dice
        RecyclerView numericalDiceRecyclerView =
                view.findViewById(R.id.dice_recycle_view);
        numericalDiceRecyclerView.setHasFixedSize(true);

        // the layout of the recycler
        RecyclerView.LayoutManager numericalDiceRecyclerLayoutMan =
                new LinearLayoutManager(getContext());
        numericalDiceRecyclerView.setLayoutManager(numericalDiceRecyclerLayoutMan);

        // the content of the recycler (the dice)
        numericalDiceRecyclerViewAdapter = new NumericalRecyclerAdapter(view, diceImages);
        numericalDiceRecyclerView.setAdapter(numericalDiceRecyclerViewAdapter);
    }

    /**
     * Sets up the ads for the app and the ad views on each page.
     * @param fragment the fragment
     * @param view the view for this fragment
     */
    public static void setupAds(View view, Fragment fragment) {
        // sets up the ads in the app
        MobileAds.initialize(fragment.getContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        // sets up ad in numerical controller
        AdView adView = view.findViewById(R.id.adView);
        AdRequest.Builder reqBuilder = new AdRequest.Builder();
        AdRequest adRequest = reqBuilder.build();
        adView.loadAd(adRequest);
    }

    /**
     * Sets up the roll button to carry out the appropriate actions.
     * @param view the view for this fragment
     */
    private void setupRollButton(View view) {
        Button rollButton = view.findViewById(R.id.numerical_roll_button);
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });
    }

    /**
     * Rolls all of the dice in the view.
     */
    private void rollDice() {
        for (int i = 0; i < diceImages.length; i++) {
            diceImages[i] = DiceUtilities.getRandomNumericalDiceImage();
        }
        numericalDiceRecyclerViewAdapter.notifyDataSetChanged();
    }

    /**
     * Sets up the buttons to increment and decrement the number of dice being
     * rolled.
     * @param view the view for this fragment
     */
    private void setupNumDiceButtons(View view) {
        incrementButton = view.findViewById(R.id.inc_num_dice_button);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeNumDice(true);
            }
        });

        decrementButton = view.findViewById(R.id.red_num_dice_button);
        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeNumDice(false);
            }
        });

        setDiceNumButtonsEnabled();
    }

    /**
     * Changes the number of dice by 1 and updates all views.
     * @param increment {@code true} to add one or {@code false} to remove one.
     */
    private void changeNumDice(boolean increment) {
        // updates the number of dice attribute
        if (increment) numberOfDice += 1;
        else numberOfDice -= 1;

        // remakes the data-set for the recycler view with the correct number of
        // dice
        diceImages = new int[numberOfDice];
        Arrays.fill(diceImages, R.drawable.blank_dice);
        numericalDiceRecyclerViewAdapter.diceImages = diceImages;
        numericalDiceRecyclerViewAdapter.notifyDataSetChanged();

        // sets the buttons to enabled or disabled
        setDiceNumButtonsEnabled();
        setNumDiceLabelText();
    }

    /**
     * Enables and disables the increment and decrement buttons appropriately.
     * Hides disabled buttons
     */
    private void setDiceNumButtonsEnabled() {
        if (numberOfDice > 1) {
            decrementButton.setEnabled(true);
            decrementButton.setVisibility(View.VISIBLE);
        } else {
            decrementButton.setEnabled(false);
            decrementButton.setVisibility(View.INVISIBLE);
        }
        if (numberOfDice < MAX_NUM_NUMERICAL_DICE) {
            incrementButton.setEnabled(true);
            incrementButton.setVisibility(View.VISIBLE);
        } else  {
            incrementButton.setEnabled(false);
            incrementButton.setVisibility(View.INVISIBLE);
        }

    }

    /**
     * Sets up the number of dice label
     * @param view the view to set the label in
     */
    private void setupNumDiceLabel(View view) {
        numDiceLabel = view.findViewById(R.id.num_dice_text_view);
        setNumDiceLabelText();
    }

    /**
     * Sets the number of dice label to the correct number of dice.
     */
    private void setNumDiceLabelText() {
        int resid;
        switch (numberOfDice) {
            case 2:
                resid = R.string.two_dice; break;
            case 3:
                resid = R.string.three_dice; break;
            case 4:
                resid = R.string.four_dice; break;
            case 5:
                resid = R.string.five_dice; break;
            case 6:
                resid = R.string.six_dice; break;
            default:
                resid = R.string.one_die; break;
        }
        numDiceLabel.setText(resid);
    }


}
