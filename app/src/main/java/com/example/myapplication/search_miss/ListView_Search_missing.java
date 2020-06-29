package com.example.myapplication.search_miss;

import android.graphics.drawable.Drawable;

import com.example.myapplication.ui.missing.ListView_User;

import java.util.Comparator;

public class ListView_Search_missing {
    private Drawable mDogIcon;
    private String mDogName;
    private String mDogKind;
    private String mDogmiss;

    public ListView_Search_missing(Drawable dogIcon, String dogName, String dogKind , String dogmiss) {
        mDogIcon = dogIcon;
        mDogName = dogName;
        mDogKind = dogKind;
        mDogmiss = dogmiss;
    }

    public Drawable getmDogIcon(){
        return mDogIcon;
    }

    public String getmDogName() {
        return mDogName;
    }

    public String  getmDogKind() {
        return mDogKind;
    }

    public String getmDogmiss(){return mDogmiss;}





}
