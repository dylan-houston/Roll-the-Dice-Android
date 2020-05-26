package com.dylanhouston.rollthedice.ui.alphabetical;

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

public class AlphabeticalFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ViewModelProviders.of(this).get(AlphabeticalViewModel.class);
        View root = inflater.inflate(R.layout.fragment_alphabetical, container, false);

        return root;
    }
}
