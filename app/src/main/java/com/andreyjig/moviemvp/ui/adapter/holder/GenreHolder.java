package com.andreyjig.moviemvp.ui.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.ui.adapter.holder.handler.GenreHolderCallback;

public class GenreHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView genreTextView;
    private Context context;
    private String genre;
    private GenreHolderCallback callback;

    public GenreHolder(@NonNull View itemView, Context context,
                       GenreHolderCallback callback) {
        super(itemView);
        this.context = context;
        this.callback = callback;
        genreTextView = itemView.findViewById(android.R.id.text1);
        itemView.setOnClickListener(this);
    }

    public void bind(String genre){
        this.genre = genre;
        genreTextView.setText(genre);
    }

    public void highlightHolder(){
        itemView.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
        genreTextView.setTextColor(context.getResources().getColor(android.R.color.white));
    }

    public void cancelHolder(){
        itemView.setBackgroundColor(context.getResources().getColor(android.R.color.white));
        genreTextView.setTextColor(context.getResources().getColor(android.R.color.black));
    }

    @Override
    public void onClick(View v) {
        callback.onClickGenre(genre);
    }
}
