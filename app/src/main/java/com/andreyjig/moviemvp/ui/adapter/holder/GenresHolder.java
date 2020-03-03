package com.andreyjig.moviemvp.ui.adapter.holder;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.entities.holder.Genres;
import com.andreyjig.moviemvp.ui.adapter.FilmListAdapter;
import com.andreyjig.moviemvp.utils.MovieUtils;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;

public class GenresHolder extends RecyclerView.ViewHolder {

    private ChipGroup genresChipGroup;
    private Context context;

    public GenresHolder(@NonNull View itemView, Context context, String genre, FilmListAdapter.FilmListAdapterCallback callback) {
        super(itemView);
        this.context = context;
        genresChipGroup = itemView.findViewById(R.id.genres_chip_group);
        genresChipGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId != -1){
                Chip chip = group.findViewById(checkedId);
                callback.selectGenre(chip.getText().toString());
                Log.d("MovieMVP", "select genre " + chip.getText().toString());
            } else {
                callback.selectGenre("");
            }
        });
    }

    public void bind (Genres genres){
        if (genresChipGroup.getChildCount() == 0) {
            ArrayList<String> arrayGenres = genres.getGenres();
            for (int i = 0; i < arrayGenres.size(); i++) {
                Chip chip = new Chip(context);
                chip.setId(i);
                chip.setText(arrayGenres.get(i));
                chip.setCheckable(true);
                genresChipGroup.addView(chip);
            }
        }
    }
}
