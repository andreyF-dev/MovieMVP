package com.andreyjig.moviemvp.utils;

import android.util.Log;

import androidx.recyclerview.widget.DiffUtil;

import com.andreyjig.moviemvp.entities.Film;

import java.util.ArrayList;

public class FilmListAdapterDiffCallback extends DiffUtil.Callback {

    private ArrayList<Object> oldList;
    private ArrayList<Object> newList;

    public FilmListAdapterDiffCallback(ArrayList<Object> oldList, ArrayList<Object> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        Object oldObject = oldList.get(oldItemPosition);
        Object newObject = newList.get(newItemPosition);
        if (oldObject.getClass() != newObject.getClass()) {
            return false;
        }
        if (oldObject instanceof Film) {
            return ((Film) oldObject).getId() == ((Film) newObject).getId();
        } else {
            return oldObject.equals(newObject);
        }
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Object oldObject = oldList.get(oldItemPosition);
        Object newObject = newList.get(newItemPosition);
        return oldObject.equals(newObject);
    }
}
