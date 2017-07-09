package com.oab.simpleapp.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

import com.oab.simpleapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bao on 2017/7/9.
 */

public class HeadGridViewPager extends ViewPager {
    public static final int DEFAULT_ROWS = 2;
    public static final int DEFAULT_COLUMNS = 4;
    private Context context;
    private int rows = DEFAULT_ROWS;
    private int columns = DEFAULT_COLUMNS;
    private List<View> viewpages;
    private List<GridEntity> entities;

    public HeadGridViewPager(Context context) {
        this(context, null);
    }

    public HeadGridViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public void init(@NonNull List<GridEntity> gridEntities, int columns, int rows) {
        this.rows = rows;
        this.columns = columns;
        this.entities = gridEntities;

        viewpages.addAll(getPagerViews(gridEntities));
        HeadGridPagerAdapter pagerAdapter = new HeadGridPagerAdapter(viewpages);
        setAdapter(pagerAdapter);
    }


    public List<View> getPagerViews(List<GridEntity> entities) {
        int itemSize = rows * columns;
        int totalSize = entities.size();
        int pageSize = totalSize % itemSize == 0 ? totalSize / itemSize : totalSize / itemSize + 1;
        List<View> views = new ArrayList<>();

        for (int i = 0; i < pageSize; i++) {
            View view = View.inflate(context, R.layout.view_head_grid, null);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(),columns));
            List<GridEntity> list = new ArrayList<>();
            if (i != pageSize - 1) {
                list.addAll(entities.subList(i * itemSize, (i + 1) * itemSize));
            } else {
                list.addAll(entities.subList(i * itemSize, totalSize));
            }
            HeadViewAdapter adapter = new HeadViewAdapter(context, list);
            recyclerView.setAdapter(adapter);
            views.add(view);
        }
        return views;
    }

}
