package com.oab.simpleapp.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.oab.simpleapp.R;

/**
 * Created by bao on 2017/7/9.
 */

public class HeadViewHolder extends RecyclerView.ViewHolder {

    public  ImageView imageView;
    public  TextView textView;

    public HeadViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.iv_expression);
        textView = (TextView) itemView.findViewById(R.id.tv_name);
    }
}
