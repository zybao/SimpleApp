package com.oab.simpleapp.widget;

import android.support.annotation.DrawableRes;

import com.oab.simpleapp.listener.HeadGridListener;

/**
 * Created by bao on 2017/7/9.
 */

public class GridEntity {
    public String itemName;
    public HeadGridListener listener;
    public @DrawableRes int drawableRes;
    private int itemId;
    public String iconPath = "";

    public int getItemId() {
        return itemId;
    }

    public GridEntity(String itemName, int drawableRes, int itemId, String iconPath, HeadGridListener listener) {
        this.itemName = itemName;
        this.listener = listener;
        this.drawableRes = drawableRes;
        this.itemId = itemId;
        this.iconPath = iconPath;
    }
}
