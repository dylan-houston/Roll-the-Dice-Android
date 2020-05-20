package com.dylanhouston.rollthedice.ui.alphabetical;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AlphabeticalViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AlphabeticalViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}