package com.dylanhouston.rollthedice.ui.alphabetical;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.dylanhouston.rollthedice.DiceUtilities;
import com.dylanhouston.rollthedice.R;
import com.dylanhouston.rollthedice.UserPreferenceManager;
import com.dylanhouston.rollthedice.ui.numerical.NumericalFragment;

public class AlphabeticalFragment extends Fragment {

    private ImageView diceImageView;

    private UserPreferenceManager userPreferenceManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ViewModelProviders.of(this).get(AlphabeticalViewModel.class);
        View root = inflater.inflate(R.layout.fragment_alphabetical, container, false);

        userPreferenceManager = new UserPreferenceManager(getContext());

        NumericalFragment.setupAds(root, this);
        setupDiceImage(root);
        setupRollButton(root);

        return root;
    }

    /**
     * Sets up the image view inside of the dice card.
     * @param view the view for this fragment
     */
    private void setupDiceImage(View view) {
        View cardView = view.findViewById(R.id.alpha_dice_card);
        diceImageView = cardView.findViewById(R.id.imageView);
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
        try {
            int imageID = DiceUtilities.getRandomAlphabeticalDiceImage(userPreferenceManager);
            diceImageView.setImageResource(imageID);
        } catch (IndexOutOfBoundsException e) {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(getContext());
            alertBuilder.setMessage("You have removed all letters from the dice," +
                    " at least one must be included. Adjust the settings and" +
                    " try again.");
            alertBuilder.setCancelable(false);
            alertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.dismiss();
                }
            });

            AlertDialog dialog = alertBuilder.create();
            dialog.show();
        }
    }
}
