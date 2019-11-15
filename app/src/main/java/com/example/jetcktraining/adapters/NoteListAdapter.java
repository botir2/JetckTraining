package com.example.jetcktraining.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jetcktraining.MainActivity;
import com.example.jetcktraining.R;
import com.example.jetcktraining.models.Note;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.NoteViewHolder> {

    private List<Note> mNotes = new ArrayList<>( );
    private final LayoutInflater layoutInflater;
    private Context mContext;
    private MainActivity mAinActivity;

    public NoteListAdapter(Context context, MainActivity mainActivity, List<Note> value) {
        mContext = context;
        layoutInflater = LayoutInflater.from( context );
        this.mAinActivity = mainActivity;
        mNotes = value;
    }


    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate( R.layout.list_item, parent, false );
        return new NoteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {

        LinearLayout lay  = new LinearLayout(mContext);
        //lay.setLayoutParams()
        holder.leftTop.setText(mNotes.get( position ).getLeftTopText());
        holder.leftBottom.setText(mNotes.get( position ).getLeftBottomText());
        holder.rightTop.setText(mNotes.get( position ).getRightTopText());
        holder.rightBottom.setText(mNotes.get( position ).getRightBottomText());
        holder.layout.setBackgroundColor(mContext.getResources().getColor( mNotes.get( position ).getBackGroudColor() ));
        // for ceter image
        Picasso.get().load( mNotes.get( position ).getCeterImage()).error( R.drawable.ic_launcher_background).into(holder.FoodImage);
        // for right bottom image
        Picasso.get().load( mNotes.get( position ).getImageDowm()).error( R.drawable.ic_launcher_background).into(holder.imgDown);
    }


    @Override
    public int getItemCount() {
        if(mNotes != null)
            return mNotes.size();
        return 0;
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {

        private TextView leftTop, leftBottom, rightTop, rightBottom;
        private ImageView FoodImage, imgDown;
        private int mPosition;
        private LinearLayout layout;
        private View backGroud;

        public NoteViewHolder(View itemView){
            super(itemView);
            leftTop = itemView.findViewById(R.id.leftTop );
            leftBottom = itemView.findViewById(R.id.leftBottom );
            rightTop = itemView.findViewById(R.id.rightTop );
            rightBottom = itemView.findViewById(R.id.rightBottom );
            FoodImage = itemView.findViewById( R.id.FoodImage);
            imgDown = itemView.findViewById( R.id.imageDowm);
            layout = itemView.findViewById(R.id.ProductBacgroundColor);
           // backGroud = itemView.findViewById( R.id.ProductBacgroundColor);
        }

    }
}
