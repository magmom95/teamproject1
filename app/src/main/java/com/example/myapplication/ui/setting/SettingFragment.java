package com.example.myapplication.ui.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class SettingFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        ConstraintLayout root = (ConstraintLayout)inflater.inflate(R.layout.fragment_setting, container, false);



        return root;
    }
}