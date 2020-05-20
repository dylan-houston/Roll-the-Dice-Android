package com.dylanhouston.rollthedice.ui.numerical;

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

import com.dylanhouston.rollthedice.R;

public class NumericalFragment extends Fragment {

    private NumericalViewModel numericalViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        numericalViewModel =
                ViewModelProviders.of(this).get(NumericalViewModel.class);
        View root = inflater.inflate(R.layout.fragment_numerical, container, false);

        return root;
    }
}
