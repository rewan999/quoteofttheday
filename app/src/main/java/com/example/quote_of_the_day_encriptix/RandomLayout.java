package com.example.quote_of_the_day_encriptix;


import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;

public class RandomLayout extends LinearLayoutManager {
    private Random random=new Random();
    public RandomLayout(Context context) {
        super(context);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler,
                                 RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);

        int chiledcount=getChildCount();
        for (int i=0;i<chiledcount;i++){
            View child= getChildAt(i);
            int randompoistion = random.nextInt(chiledcount);
            layoutDecorated(child,randompoistion,0,randompoistion,getHeight());

        }
    }
    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler,
                                  RecyclerView.State state) {
        int scrolled = super.scrollVerticallyBy(dy, recycler, state);
        int itemCount = getItemCount();
        if (itemCount == 0) {
            return scrolled;
        }
        int offset = scrolled % itemCount;
        if (offset > 0) {
            offset = getItemCount() - offset;
        }
        return scrolled - offset;
    }

}
