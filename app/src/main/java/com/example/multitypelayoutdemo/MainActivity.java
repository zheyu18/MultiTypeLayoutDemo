package com.example.multitypelayoutdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] itemViews = {"one", "two", "three", "four", "five"};
    private MultiTypeLayout mMultiLayout;
    private List<LayoutBean> layoutBeanList = new ArrayList<>();
    private int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMultiLayout = findViewById(R.id.multi_layout);
        initData();
        initItemView();
    }

    private void initData() {
        layoutBeanList.add(new LayoutBean("one", R.layout.layout_item01));
        layoutBeanList.add(new LayoutBean("two", R.layout.layout_item02));
        layoutBeanList.add(new LayoutBean("three", R.layout.layout_item03));
        layoutBeanList.add(new LayoutBean("four", R.layout.layout_item04));
        layoutBeanList.add(new LayoutBean("five", R.layout.layout_item05));
    }

    private void initItemView() {
        for (LayoutBean layoutBean : layoutBeanList) {
            mMultiLayout.addItemView(layoutBean.getLayoutName(), layoutBean.getResId());
        }
    }

    public void onAddClick(View view) {
        index++;
        TextView textView = new TextView(this);
        ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10,20,10,20);
        textView.setLayoutParams(layoutParams);
        textView.setBackgroundColor(getResources().getColor(R.color.teal_200));
        textView.setGravity(Gravity.CENTER);
        textView.setText("郑继宇"+index);
        textView.setPadding(40,40,40,40);
        mMultiLayout.addItemView("add" + index,textView);
    }

    public void onRemoveClick(View view) {
        mMultiLayout.removeItemViewAt(0);
    }

    public void onRemoveAllClick(View view) {
        index = 0;
        mMultiLayout.removeAllView();
    }

    public void onReplaceClick(View view) {
        TextView textView = new TextView(this);
        ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10,20,10,20);
        textView.setLayoutParams(layoutParams);
        textView.setBackgroundColor(getResources().getColor(R.color.teal_200));
        textView.setGravity(Gravity.CENTER);
        textView.setText("我是替换后的View"+index);
        textView.setPadding(40,40,40,40);
        mMultiLayout.replaceItemView(textView,1);
    }
}