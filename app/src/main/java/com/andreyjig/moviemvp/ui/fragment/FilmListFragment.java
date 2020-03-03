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
import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.entities.Film;
import com.andreyjig.moviemvp.mvp.presenter.FilmListPresenter;
import com.andreyjig.moviemvp.mvp.view.FilmListView;
import com.andreyjig.moviemvp.ui.adapter.FilmListAdapter;
import com.andreyjig.moviemvp.ui.adapter.handler.FilmListAdapterCallback;
import com.arellomobile.mvp.presenter.InjectPresenter;
import java.util.ArrayList;


public class FilmListFragment extends BaseFragment implements FilmListView, FilmListAdapterCallback {

    @InjectPresenter
    FilmListPresenter presenter;

    private RecyclerView filmRecyclerView;
    private FilmListAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_films_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        filmRecyclerView = view.findViewById(R.id.fragment_films_list_recycler_view);
        filmRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void setFilmList(ArrayList<Film> films) {
        adapter = new FilmListAdapter(getContext(), films, FilmListFragment.this);
        filmRecyclerView.setAdapter(adapter);
    }

    @Override
    public void updateGenre(String genre) {
        adapter.setItems(genre);
    }

    @Override
    public void selectGenre(String genre) {
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
