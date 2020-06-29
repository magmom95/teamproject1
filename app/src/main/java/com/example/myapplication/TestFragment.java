package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class TestFragment extends Fragment {
    private Dog dog;
    TextView textView1 , textView2, textView3, textView4, textView5;
    ImageView imageView;
    Button buttonMiss , buttonAdopt;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        textView1 = view.findViewById(R.id.dogs_name);
        textView2 = view.findViewById(R.id.dogs_breeds);
        textView3 = view.findViewById(R.id.dogs_age);
        textView4 = view.findViewById(R.id.owners_num);
        textView5 = view.findViewById(R.id.owners_adress);

        textView1.setText(dog.dogName);
        textView2.setText(dog.dogBreeds);
        textView3.setText(dog.dogAge);
        textView4.setText(dog.ownerNum);
        textView5.setText(dog.ownerAddress);

        imageView = view.findViewById(R.id.dog_image);
        imageView.setImageResource(R.drawable.icon_dog);

        buttonAdopt = view.findViewById(R.id.dog_adopt);
        buttonMiss = view.findViewById(R.id.dog_missing);

        if(dog.missing == true){
            buttonMiss.setText("신고취소");
        }
        if(dog.adopt == true){
            buttonAdopt.setText("신청취소");
        }


        buttonMiss.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dog.missing == false){
                    dog.missing = true;
                    dog.flag = true;
                    buttonMiss.setText("신고취소");
                    Intent intent = new Intent(getActivity(), addMissing.class);
                    startActivity(intent);

                }else{
                    dog.missing = false;
                    buttonMiss.setText("실종신고");

                }

            }
        });


        buttonAdopt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dog.adopt == false){
                    dog.adopt = true;
                    buttonAdopt.setText("신청취소");
                }else{
                    dog.adopt = false;
                    buttonAdopt.setText("입양신청");
                }
            }
        });

        return view;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
