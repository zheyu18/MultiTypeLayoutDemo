package com.example.multitypelayoutdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;

import java.util.HashMap;
import java.util.Map;

/**
 * Email 3301360040@qq.com
 * Created by ZheYu on 2021/6/30.
 * Description:
 */
public class MultiTypeLayout extends NestedScrollView {
    private LinearLayout mContainer;
    private Map<String, View> viewItems;

    public MultiTypeLayout(Context context) {
        this(context, null);
    }

    public MultiTypeLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MultiTypeLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContainer = new LinearLayout(context);
        mContainer.setOrientation(LinearLayout.VERTICAL);
        addView(mContainer);
        viewItems = new HashMap<>();
    }

    public void addItemView(String name, @LayoutRes int layoutResID) {
        View view = LayoutInflater.from(getContext()).inflate(layoutResID, mContainer, true);
        viewItems.put(name, view);
    }

    public void addItemView(String name, View view) {
        mContainer.addView(view);
        viewItems.put(name, view);
    }

    public View getItemView(String name) {
        return viewItems.get(name);
    }

    public void removeItemViewAt(int index) {
        if (mContainer.getChildCount() == 0) return;
        mContainer.removeViewAt(mContainer.getChildCount() - 1);
    }

    public void removeAllView() {
        mContainer.removeAllViews();
    }

    public void replaceItemView(View replaceView, int position) {
        mContainer.removeViewAt(position);
        mContainer.addView(replaceView, position);
    }

}
