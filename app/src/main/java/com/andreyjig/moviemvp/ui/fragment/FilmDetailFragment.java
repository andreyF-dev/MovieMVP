package com.andreyjig.moviemvp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.mvp.presenter.FilmDetailPresenter;
import com.andreyjig.moviemvp.mvp.view.AppBarCustom;
import com.andreyjig.moviemvp.mvp.view.FilmDetailView;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import java.util.ArrayList;

public class FilmDetailFragment extends BaseFragment implements FilmDetailView {

    private final int MAX_RATING = 10;
    private final  float RATING_STEP = 0.5f;
    @InjectPresenter
    FilmDetailPresenter presenter;
    private TextView localizedNameText;
    private TextView originalNameText;
    private TextView yearText;
    private RatingBar ratingBar;
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
        originalNameText = view.findViewById(R.id.original_name_text_view);
        yearText = view.findViewById(R.id.year_text_view);
        descriptionText = view.findViewById(R.id.description_text_view);
        localizedNameText = view.findViewById(R.id.localized_name_text_view);
        ratingBar = view.findViewById(R.id.rating_bar_details);
    }



    @Override
    public void showPoster(String posterUrl) {
       ((AppBarCustom)getActivity()).setAppBarImage(posterUrl);
    }

    @Override
    public void showLocalizedName(String localizedName) {
        localizedNameText.setText(localizedName);
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
    public void showRating(float rating) {
        ratingBar.setNumStars(MAX_RATING);
        ratingBar.setStepSize(RATING_STEP);
        ratingBar.setRating(rating);
    }

    @Override
    public void showGenres(ArrayList<String> genres) {

    }

    @Override
    public void showDescription(String description) {
        descriptionText.setText(description);
    }
}
