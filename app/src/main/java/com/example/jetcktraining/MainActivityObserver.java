package com.example.jetcktraining;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MainActivityObserver extends ViewModel {
    private String TAG = this.getClass().getSimpleName();
    private String myRandomNumber;
    public String getNumber(){
        Log.i(TAG, "Get number");
        if (myRandomNumber == null){
          //  myRndomNuber = new MutableLiveData<>();
            onCreateEvent();
        }
        return myRandomNumber;
    }

    public void onCreateEvent() {
        Log.i( TAG, "Observer ON_CREATE" );
        Random random = new Random();
        myRandomNumber = "Number: " + (random.nextInt( 10 - 1 ) + 1);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "ViewModel Destroyed");
    }

    @Override
    public int hashCode() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<String>();
        mutableLiveData.postValue( myRandomNumber );
        return super.hashCode();
    }

}
