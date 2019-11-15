package com.example.jetcktraining;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.jetcktraining.adapters.NoteListAdapter;
import com.example.jetcktraining.databinding.ActivityMainBinding;
import com.example.jetcktraining.models.Note;
import com.example.jetcktraining.viewmodels.MainActivityViewModel;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    ActivityMainBinding binding;
    private NoteListAdapter noteListAdapter;
    private RecyclerView recyclerView;
    private MainActivityViewModel model;
    private GridLayoutManager mGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main );
        binding.setViewModel(this);

        recyclerView = findViewById( R.id.RecyclerView );
        model = ViewModelProviders.of(this).get( MainActivityViewModel.class);
        model.init();
        model.getNotePlaces().observe( this, new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable  List<Note> notes) {
                noteListAdapter.notifyDataSetChanged();
            }
        });

        mGridLayoutManager = new GridLayoutManager( this,1 );
        noteListAdapter = new NoteListAdapter(this, this, model.getNotePlaces().getValue());
       // recyclerView.setLayoutManager( new LinearLayoutManager( this ));
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager( linearLayoutManager);
        recyclerView.setAdapter(noteListAdapter);


        //String myRandomNumber  = model.getNumber();
        //Toast.makeText(MainActivity.this, "Random number is "+ myRandomNumber, Toast.LENGTH_LONG).show();

    }

}
