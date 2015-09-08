package com.vrs.carfyron.model;

import android.graphics.drawable.Drawable;

/**
 * Created by poliveira on 24/10/2014.
 */
public class NavigationItem {
    private String mText;
    private Integer mDrawableId;

    public NavigationItem(String text, Integer drawableID) {
        mText = text;
        mDrawableId = drawableID;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public Integer getDrawable() {
        return mDrawableId;
    }

    public void setDrawable(Integer drawableId) {
        mDrawableId = drawableId;
    }
}
