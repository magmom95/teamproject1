package com.example.myapplication.search_adopt;

import android.graphics.drawable.Drawable;

public class ListView_Search_adopt {

    private Drawable mDogIcon;
    private String mDogName;
    private String mDogKind;
    private String mDogage;

    public ListView_Search_adopt(Drawable dogIcon, String dogName, String dogKind , String dogmiss) {
        mDogIcon = dogIcon;
        mDogName = dogName;
        mDogKind = dogKind;
        mDogage = dogmiss;
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

    public String getmDogage(){return mDogage;}

}
