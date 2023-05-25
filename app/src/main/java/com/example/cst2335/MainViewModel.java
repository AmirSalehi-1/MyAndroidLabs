package com.example.cst2335;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Boolean> isSelected = new MutableLiveData<>();

    public MainViewModel(){
        isSelected.setValue(false);
    }

    public MutableLiveData<Boolean> getIsSelected(){
        return isSelected;
    }

    public void setIsSelected(Boolean selected){
        this.isSelected.setValue(selected);
    }
}
