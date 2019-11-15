package com.example.jetcktraining.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.jetcktraining.models.Note;
import com.example.jetcktraining.repositories.NotePlaceRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<Note>> mNotePlaces;
    private NotePlaceRepository mRepo;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void init(){
        if(mNotePlaces != null){ return; }
        mRepo = NotePlaceRepository.getInstance();
        mNotePlaces = mRepo.getNotePlaces();
    }


    public LiveData<List<Note>> getNotePlaces(){return mNotePlaces;}

    public LiveData<Boolean> getListUpdating(){return mIsUpdating;}
}
