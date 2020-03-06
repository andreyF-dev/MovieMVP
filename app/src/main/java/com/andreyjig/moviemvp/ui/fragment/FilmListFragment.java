package com.andreyjig.moviemvp.ui.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.entities.Film;
import com.andreyjig.moviemvp.entities.holder.Genre;
import com.andreyjig.moviemvp.mvp.presenter.BaseFilmPresenter;
import com.andreyjig.moviemvp.mvp.presenter.FilmListPresenter;
import com.andreyjig.moviemvp.mvp.view.FilmListView;
import com.andreyjig.moviemvp.ui.adapter.FilmListAdapter;
import com.andreyjig.moviemvp.ui.adapter.handler.FilmListAdapterCallback;
import com.arellomobile.mvp.presenter.InjectPresenter;
import java.util.ArrayList;

public class FilmListFragment extends BaseFilmFragment implements FilmListView, FilmListAdapterCallback {

    @InjectPresenter
    FilmListPresenter presenter;

    private RecyclerView filmRecyclerView;
    private FilmListAdapter adapter;
    private ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public BaseFilmPresenter getPresenter() {
        return presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_films_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar = view.findViewById(R.id.progress_bar_list_films);
        filmRecyclerView = view.findViewById(R.id.fragment_films_list_recycler_view);
        filmRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void setFilmList(ArrayList<Genre> genres, ArrayList<Film> films) {
        if (adapter == null || filmRecyclerView.getAdapter() == null) {
            adapter = new FilmListAdapter(getContext(), FilmListFragment.this);
            filmRecyclerView.setAdapter(adapter);
            adapter.setNewList(genres, films);
        } else {
            adapter.setNewList(genres, films);
        }
    }

    @Override
    public void showPreviewScreen() {
        filmRecyclerView.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidePreviewScreen() {
        filmRecyclerView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setGenre(String genre) {
        presenter.setGenre(genre);
    }

    @Override
    public void selectFilm(int id) {
        if (getView() != null) {
            FilmListFragmentDirections.ActionFilmsListFragmentToFilmDetailFragment action =
                    FilmListFragmentDirections.actionFilmsListFragmentToFilmDetailFragment();
            action.setId(id);
            Navigation.findNavController(getView()).navigate(action);
        }
    }

}
