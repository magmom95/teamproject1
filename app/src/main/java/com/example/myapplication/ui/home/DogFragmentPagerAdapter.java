package com.example.myapplication.ui.home;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.myapplication.Dog;
import com.example.myapplication.TestFragment;

import java.util.ArrayList;
import java.util.List;

public class DogFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private List<Dog> dogs = new ArrayList<>();

    public DogFragmentPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        TestFragment fragment = new TestFragment();
        fragment.setDog(dogs.get(position));
        return fragment;
    }

    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return dogs.size();
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
        notifyDataSetChanged();
    }

}
