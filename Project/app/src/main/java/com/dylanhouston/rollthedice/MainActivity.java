package com.dylanhouston.rollthedice;

import android.os.Bundle;

import com.dylanhouston.rollthedice.ui.numerical.NumericalRecyclerAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // the preferences
    private UserPreferenceManager pref = new UserPreferenceManager(this);

    // the adviews
    private AdView numericalAdView;

    protected static final int MAX_NUM_NUMERICAL_DICE = 6;

    // the recycler view for displaying the dice
    private RecyclerView numericalDiceRecyclerView;
    private RecyclerView.Adapter numericalDiceRecyclerViewAdapter;
    private RecyclerView.LayoutManager numericalDiceRecyclerLayoutMan;

    // the numerical dice to display
    private int[] diceImages = {};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_numerical, R.id.navigation_alphabetical, R.id.navigation_settings)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        setupAds();
    }

    /**
     * Sets up the ads for the app and the ad views on each page.
     */
    private void setupAds() {
        // sets up the ads in the app
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        // sets up ad in numerical controller
        numericalAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        numericalAdView.loadAd(adRequest);
    }

    private void setupNumericalRecycler() {
        // sets up the dice images
        diceImages = new int[pref.getDefaultNumberOfDice()];
        Arrays.fill(diceImages, R.drawable.blank_dice);

        numericalDiceRecyclerView = findViewById(R.id.dice_recycle_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        numericalDiceRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        numericalDiceRecyclerLayoutMan = new LinearLayoutManager(this);
        numericalDiceRecyclerView.setLayoutManager(numericalDiceRecyclerLayoutMan);

        // specify an adapter
        numericalDiceRecyclerViewAdapter = new NumericalRecyclerAdapter(diceImages);
        numericalDiceRecyclerView.setAdapter(numericalDiceRecyclerViewAdapter);
    }
}

