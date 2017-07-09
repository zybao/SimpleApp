package com.oab.simpleapp.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.oab.simpleapp.R;

import java.util.List;


/**
 * Created by bao on 2017/7/9.
 */

public class HeadGridAdapter extends ArrayAdapter<GridEntity> {

    public HeadGridAdapter(@NonNull Context context, int resource, @NonNull List<GridEntity> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(getContext(), R.layout.item_head_grid, null);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.iv_expression);
        TextView textView = (TextView) convertView.findViewById(R.id.tv_name);
        final GridEntity item = getItem(position);
        if(textView != null && item.itemName != null){
            textView.setText(item.itemName);
        }

        if (imageView != null && item.drawableRes != 0) {
            imageView.setImageResource(item.drawableRes);
        } else {
            Glide.with(getContext())
                    .load(item.iconPath)
                    .into(imageView);
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.listener.onClick(item.getItemId(), item.itemName);
            }
        });

        return convertView;
    }
}
