package com.andreyjig.moviemvp.ui.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andreyjig.moviemvp.R;
import com.andreyjig.moviemvp.entities.holder.Header;

public class HeaderHolder extends RecyclerView.ViewHolder {

    private TextView textView;

    public HeaderHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.header_text_view);
    }

    public void bind(Header header){
        textView.setText(header.getTitleResId());
    }
}
