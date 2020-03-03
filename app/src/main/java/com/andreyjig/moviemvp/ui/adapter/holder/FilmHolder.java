package com.andreyjig.moviemvp.ui.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.entities.Film;
import com.andreyjig.moviemvp.ui.adapter.handler.FilmListAdapterCallback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FilmHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView headerText;
    private TextView yearGenreText;
    private TextView descriptionText;
    private ImageView posterImage;
    private int id;
    private FilmListAdapterCallback callback;

    public FilmHolder(@NonNull View itemView, FilmListAdapterCallback callback) {
        super(itemView);
        headerText = itemView.findViewById(R.id.header_text_view_item_movie);
        yearGenreText = itemView.findViewById(R.id.year_genre_text_view_item_movie);
        descriptionText = itemView.findViewById(R.id.description_text_view_item_movie);
        posterImage = itemView.findViewById(R.id.poster_image_view_item_movie);
        itemView.setOnClickListener(this);
        this.callback = callback;
    }

    @Override
    public void onClick(View v) {
        callback.selectFilm(id);
    }

    public void bind(Film film){
        id = film.getId();
        headerText.setText(film.getLocalizedName());
        yearGenreText.setText(getStringYearGenre(film));
        descriptionText.setText(film.getDescription());
        Picasso.get()
                .load(film.getImageUrl())
                .error(R.drawable.ic_video_camera)
                .into(posterImage);
    }

    private String getStringYearGenre(Film film){
        ArrayList<String> genres = film.getGenres();
        if (genres != null && genres.size() > 0){
            return film.getYear() + ", " + genres.get(0);
        } else {
            return Integer.toString(film.getYear());
        }
    }
}
