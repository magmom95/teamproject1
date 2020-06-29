package com.example.myapplication.ui.missing;

import android.graphics.drawable.Drawable;

import java.util.Comparator;

public class ListView_User{
    private Drawable mDogIcon;
    private String mDogName;
    private String mDogKind;
    private String mDogmiss;

    public ListView_User(Drawable dogIcon, String dogName, String dogKind , String dogmiss) {
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



    static class nameCompare implements Comparator<ListView_User> {

        /**
         * 오름차순
         */
        @Override
        public int compare(ListView_User a, ListView_User b) {
            // TODO Auto-generated method stub
            return a.getmDogName().compareTo(b.getmDogName());
        }

    }

    static class breedsCompare implements Comparator<ListView_User> {

        /**
         * 오름차순
         */
        @Override
        public int compare(ListView_User a, ListView_User b) {
            // TODO Auto-generated method stub
            return a.getmDogKind().compareTo(b.getmDogKind());
        }

    }

    static class missingCompare implements Comparator<ListView_User> {

        /**
         * 오름차순
         */
        @Override
        public int compare(ListView_User a, ListView_User b) {
            // TODO Auto-generated method stub
            return Integer.parseInt(a.getmDogmiss())- Integer.parseInt(b.getmDogmiss());
        }

    }
}
