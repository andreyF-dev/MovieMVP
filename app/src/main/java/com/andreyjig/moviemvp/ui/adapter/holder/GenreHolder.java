package com.andreyjig.moviemvp.ui.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.entities.holder.Genre;
import com.andreyjig.moviemvp.ui.adapter.holder.handler.GenreHolderCallback;

public class GenreHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView genreText;
    private Context context;
    private GenreHolderCallback callback;
    private Genre genreHolder;

    public GenreHolder(@NonNull View itemView, Context context, GenreHolderCallback callback) {
        super(itemView);
        this.context = context;
        this.callback = callback;
        genreText = itemView.findViewById(android.R.id.text1);
        itemView.setOnClickListener(this);
    }

    public void bind (Genre genre){
        genreHolder = genre;
        genreText.setText(genreHolder.getName());
        if (genreHolder.isSelected()){
            highlightHolder();
        } else {
            deselectHolder();
        }
    }

    private void highlightHolder(){
        itemView.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
        genreText.setTextColor(context.getResources().getColor(R.color.colorAccent));
    }

    private void deselectHolder(){
        itemView.setBackgroundColor(context.getResources().getColor(android.R.color.white));
        genreText.setTextColor(context.getResources().getColor(R.color.textColorPrimary));
    }

    @Override
    public void onClick(View v) {
        callback.onClickGenre(genreHolder.getName());
    }
}
