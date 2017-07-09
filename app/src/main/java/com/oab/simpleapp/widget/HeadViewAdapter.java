package com.oab.simpleapp.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bumptech.glide.Glide;
import com.oab.simpleapp.R;

import java.util.List;

/**
 * Created by bao on 2017/7/9.
 */

public class HeadViewAdapter extends RecyclerView.Adapter<HeadViewHolder> {
    private Context context;
    private List<GridEntity> entities;

    public HeadViewAdapter(Context context, List<GridEntity> entities) {
        this.context = context;
        this.entities = entities;
    }

    @Override
    public HeadViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_head_grid, parent, false);
        return new HeadViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HeadViewHolder holder, int position) {
        GridEntity entity = entities.get(position);
        holder.textView.setText(entity.itemName);
        Glide.with(context).load(entity.iconPath).into(holder.imageView);
        holder.imageView.setOnClickListener(v -> {
            entity.listener.onClick(entity.getItemId(), entity.itemName);
        });
    }

    @Override
    public int getItemCount() {
        return entities==null ? 0:entities.size();
    }
}
