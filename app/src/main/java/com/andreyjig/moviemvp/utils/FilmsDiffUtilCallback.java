package com.andreyjig.moviemvp.utils;

import android.util.Log;

import androidx.recyclerview.widget.DiffUtil;
import com.andreyjig.moviemvp.entities.Film;
import java.util.ArrayList;

public class FilmsDiffUtilCallback extends DiffUtil.Callback {
    private final ArrayList<Object> oldList;
    private final ArrayList<Object> newList;

    public FilmsDiffUtilCallback(ArrayList<Object> oldList, ArrayList<Object> newList) {
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
        Log.d("MovieMVP", "oldPos = " + oldItemPosition + " new Position = " + newItemPosition);
        Object oldObject = oldList.get(oldItemPosition);
        Object newObject = newList.get(newItemPosition);
        if ((oldObject instanceof Film)
                && (newObject instanceof Film)){
            int oldId = ((Film)oldObject).getId();
            int newId = ((Film)newObject).getId();
            return oldId == newId;
        } else {
            return true;
        }
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Object oldObject = oldList.get(oldItemPosition);
        Object newObject = newList.get(newItemPosition);
        if ((oldObject instanceof Film)
                && (newObject instanceof Film)){
            String oldName = ((Film)oldObject).getName();
            String newName = ((Film)newObject).getName();
            String oldPoster = ((Film)oldObject).getImageUrl();
            String newPoster = ((Film)newObject).getImageUrl();
            int oldYear = ((Film)oldObject).getYear();
            int newYear = ((Film)newObject).getYear();
            return oldName.equals(newName) && oldPoster.equals(newPoster)
                    && oldYear == newYear;
        } else {
            return true;
        }
    }
}
