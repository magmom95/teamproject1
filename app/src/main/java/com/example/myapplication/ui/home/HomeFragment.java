package com.example.myapplication.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.Dog;
import com.example.myapplication.DogAddActivity;
import com.example.myapplication.DogStore;
import com.example.myapplication.R;

public class HomeFragment extends Fragment implements DogStore.OnDogStoreChangedListener {
    private DogStore dogStore = DogStore.getInstance();

    private int current = 0;

    private ViewPager viewPager;
    private DogFragmentPagerAdapter pagerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_home, container, false);

        Button button1 = root.findViewById(R.id.Button_addf);
        button1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DogAddActivity.class);
                startActivity(intent);
            }
        });


        pagerAdapter = new DogFragmentPagerAdapter(getChildFragmentManager());
        pagerAdapter.setDogs(dogStore.getDogList());

        viewPager = root.findViewById(R.id.viewPager);
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                dogStore = DogStore.getInstance();
                pagerAdapter.setDogs(dogStore.getDogList());

                current = position;
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        Button button2 = root.findViewById(R.id.Button_delf);
        button2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dogStore.getDogList().isEmpty()){}
                else{
                    Toast.makeText(getContext(), "삭제완료!", Toast.LENGTH_LONG).show();
                    viewPager.setCurrentItem(current);
                    dogStore.removeDog(dogStore.getDogList().get(viewPager.getCurrentItem()));
                    onDestroyView();
                    viewPager.setAdapter(pagerAdapter);

                }

            }
        });


        dogStore.addListener(this, this);

        return root;
    }

    public void onResume(){
        super.onResume();
        dogStore = DogStore.getInstance();
        pagerAdapter.setDogs(dogStore.getDogList());
    }



    @Override
    public void onDestroyView() {
        dogStore.removeListener(this);

        super.onDestroyView();
    }

    @Override
    public void onDogAdded(Dog dog) {
        pagerAdapter.setDogs(dogStore.getDogList());
        viewPager.setCurrentItem(dogStore.getCount()-1);
    }
}

