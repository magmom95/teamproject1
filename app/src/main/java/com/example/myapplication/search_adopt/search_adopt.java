package com.example.myapplication.search_adopt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;

import com.example.myapplication.DogStore;
import com.example.myapplication.R;
import com.example.myapplication.search_miss.ListView_Adapter_Search_missing;
import com.example.myapplication.search_miss.ListView_Search_missing;

public class search_adopt extends AppCompatActivity {
    private ListView userList;
    private ListView_adapter_search_adopt adapter;
    private DogStore dogStore = DogStore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_search_adopt);


        if(adapter==null) {
            adapter = new ListView_adapter_search_adopt(this.getApplicationContext());
        }

        if(dogStore.searchList_adopt.size() == 0){
            ListView_Search_adopt none = new ListView_Search_adopt(getResources().getDrawable(
                    R.drawable.icon_dog), "검색결과가 없습니다.", "" , "");
            adapter.add(none);
        }else{
            for(ListView_Search_adopt a : dogStore.searchList_adopt){
                adapter.add(a);
            }
        }

        userList= findViewById(R.id.user_list_search);
        userList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void mOk(View v) {
        for(ListView_Search_adopt a : dogStore.searchList_adopt){
            dogStore.searchList_adopt.remove(a);
        }
        finish();
    }
}
