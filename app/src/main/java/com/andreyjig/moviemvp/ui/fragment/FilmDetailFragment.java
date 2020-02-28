package com.andreyjig.moviemvp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.mvp.presenter.FilmDetailPresenter;
import com.andreyjig.moviemvp.mvp.view.FilmDetailView;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FilmDetailFragment extends BaseFragment implements FilmDetailView {

    @InjectPresenter
    FilmDetailPresenter presenter;
    private ImageView posterImage;
    private Toolbar toolbar;
    private TextView originalNameText;
    private TextView yearText;
    private TextView ratingText;
    private TextView descriptionText;

    @ProvidePresenter
    FilmDetailPresenter providePresenter(){
        return new FilmDetailPresenter(FilmDetailFragmentArgs
                .fromBundle(getArguments()));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_film_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar = view.findViewById(R.id.toolbar_fragment_detail);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        posterImage = view.findViewById(R.id.poster_image_view_detail);
        originalNameText = view.findViewById(R.id.original_name_text_view);
        yearText = view.findViewById(R.id.year_text_view);
        ratingText = view.findViewById(R.id.rating_text_view);
        descriptionText = view.findViewById(R.id.description_text_view);
    }



    @Override
    public void showPoster(String posterUrl) {
        Picasso.get()
                .load(posterUrl)
                .error(R.drawable.ic_video_camera)
                .into(posterImage);
    }

    @Override
    public void showLocalizedName(String localizedName) {
        toolbar.setTitle(localizedName);
    }

    @Override
    public void showName(String name) {
        originalNameText.setText(name);
    }

    @Override
    public void showYear(int year) {
        yearText.setText(Integer.toString(year));
    }

    @Override
    public void showRating(double rating) {
        ratingText.setText(Double.toString(rating));
    }

    @Override
    public void showGenres(ArrayList<String> genres) {

    }

    @Override
    public void showDescription(String description) {
        descriptionText.setText(description);
    }
}
