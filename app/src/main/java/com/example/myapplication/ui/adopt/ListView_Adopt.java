package com.example.myapplication.ui.adopt;

import android.graphics.drawable.Drawable;

import com.example.myapplication.ui.missing.ListView_User;

import java.util.Comparator;

public class ListView_Adopt {
    private Drawable mDogIcon;
    private String mDogName;
    private String mDogKind;
    private String mDogAge;

    public ListView_Adopt(Drawable dogIcon, String dogName, String dogKind , String dogAge) {
        mDogIcon = dogIcon;
        mDogName = dogName;
        mDogKind = dogKind;
        mDogAge = dogAge;
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

    public String getmDogAge(){return mDogAge;}



    static class nameCompare implements Comparator<ListView_Adopt> {

        /**
         * 오름차순
         */
        @Override
        public int compare(ListView_Adopt a, ListView_Adopt b) {
            // TODO Auto-generated method stub
            return a.getmDogName().compareTo(b.getmDogName());
        }

    }

    static class breedsCompare implements Comparator<ListView_Adopt> {

        /**
         * 오름차순
         */
        @Override
        public int compare(ListView_Adopt a, ListView_Adopt b) {
            // TODO Auto-generated method stub
            return a.getmDogKind().compareTo(b.getmDogKind());
        }

    }

    static class ageCompare implements Comparator<ListView_Adopt> {

        /**
         * 오름차순
         */
        @Override
        public int compare(ListView_Adopt a, ListView_Adopt b) {
            // TODO Auto-generated method stub
            return Integer.parseInt(a.getmDogAge())- Integer.parseInt(b.getmDogAge());
        }

    }
}
