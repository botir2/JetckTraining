package com.example.jetcktraining.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.jetcktraining.R;
import com.example.jetcktraining.models.Note;

import java.util.ArrayList;
import java.util.List;

public class NotePlaceRepository {
    private static NotePlaceRepository instance;
    private ArrayList<Note> dataSet =  new ArrayList<>();

    public static NotePlaceRepository getInstance(){
        if(instance == null){
            instance = new NotePlaceRepository();
        }
        return instance;
    }

    // Pretend to get data from a webservice or online source
    public MutableLiveData<List<Note>> getNotePlaces(){
        setNicePlaces();
        MutableLiveData<List<Note>> data = new MutableLiveData<>();
        data.setValue( dataSet );
        return data;
    }

    private void setNicePlaces(){
        dataSet.add( new Note( "버거","십다", "10개", "2019.07.20", R.drawable.burger, R.drawable.emoji, R.color.Red));
        dataSet.add( new Note( "분위","기갑", "42개", "2019.07.03", R.drawable.salad,  R.drawable.kok, R.color.Blue));
        dataSet.add( new Note( "고기","뜯자", "23개", "2019.06.17", R.drawable.steak,   R.drawable.yellow, R.color.Yellow));
        dataSet.add( new Note( "지킨","닭", "3개", "2019.06.5", R.drawable.chiken,  R.drawable.emoji, R.color.FullYellow));
        dataSet.add( new Note( "밥","십다", "50개", "2019.05.02", R.drawable.rise, R.drawable.emoji, R.color.colorPrimaryDark));

}

}
