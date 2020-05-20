package com.dylanhouston.rollthedice.ui.numerical;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NumericalViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NumericalViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}