package com.example.myapplication.search_miss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;


import com.example.myapplication.DogStore;
import com.example.myapplication.R;


public class search_miss extends AppCompatActivity {

    private ListView userList;
    private ListView_Adapter_Search_missing adapter;
    private DogStore dogStore = DogStore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_search);


        if(adapter==null) {
            adapter = new ListView_Adapter_Search_missing(this.getApplicationContext());
        }

        if(dogStore.searchList.size() == 0){
            ListView_Search_missing none = new ListView_Search_missing(getResources().getDrawable(
                    R.drawable.icon_dog), "검색결과가 없습니다.", "" , "");
            adapter.add(none);
        }else{
            for(ListView_Search_missing a : dogStore.searchList){
                adapter.add(a);
            }
        }

        userList= findViewById(R.id.user_list);
        userList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void mOk(View v) {
        for(ListView_Search_missing a : dogStore.searchList){
            dogStore.searchList.remove(a);
        }
        finish();
    }
}
