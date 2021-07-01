package com.example.multitypelayoutdemo;

import androidx.annotation.LayoutRes;

/**
 * Email 3301360040@qq.com
 * Created by ZheYu on 2021/6/30.
 * Description:
 */
public class LayoutBean {
    private String LayoutName;
    private int ResId;

    public LayoutBean(String layoutName, @LayoutRes int resId) {
        LayoutName = layoutName;
        ResId = resId;
    }

    public String getLayoutName() {
        return LayoutName;
    }

    public void setLayoutName(String layoutName) {
        LayoutName = layoutName;
    }

    public @LayoutRes int getResId() {
        return ResId;
    }

    public void setResId(@LayoutRes int resId) {
        ResId = resId;
    }
}
