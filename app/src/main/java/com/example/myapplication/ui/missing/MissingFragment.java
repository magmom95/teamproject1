package com.example.myapplication.ui.missing;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.Dog;
import com.example.myapplication.DogStore;
import com.example.myapplication.LinkedList;
import com.example.myapplication.R;
import com.example.myapplication.search_miss.ListView_Search_missing;
import com.example.myapplication.search_miss.search_miss;

public class MissingFragment extends Fragment {
    private ListView userList;
    private ListView_Adapter adapter;
    private LinkedList linkedList = new LinkedList();
    private DogStore dogStore = DogStore.getInstance();
    private EditText search_miss;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_missing, container, false);

        if(adapter==null) {
            adapter = new ListView_Adapter(getActivity().getApplicationContext());
        }

        userList=(ListView) root.findViewById(R.id.user_list);
        userList.setAdapter(adapter);

        searchMissDog(dogStore);
        for(int i = 0 ; i < linkedList.size() ; i++){

            ListView_User user = new ListView_User(getResources().getDrawable(
                    R.drawable.icon_dog), linkedList.get(i).dogName, linkedList.get(i).dogBreeds , linkedList.get(i).missingDate);
            adapter.add(user);
        }
        addMissDog();

        Button name_btn = root.findViewById(R.id.name);
        name_btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.sortName();
                userList.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }
        });

        Button breeds_btn = root.findViewById(R.id.breeds);
        breeds_btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.sortbreeds();
                userList.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }
        });

        Button date_btn = root.findViewById(R.id.date);
        date_btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.sortmissDate();
                userList.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });

        search_miss = root.findViewById(R.id.search_key);

        Button search_btn = root.findViewById(R.id.search_miss);
        search_btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                dogStore.setSearchDogName(String.valueOf(search_miss.getText()));
                search(dogStore);
                Intent intent = new Intent(getActivity(), search_miss.class);
                startActivity(intent);
            }
        });

        adapter.notifyDataSetChanged();

        return root;
    }


    public void searchMissDog(DogStore dogStore){
        int count = 0;
        for(Dog dog : dogStore.getDogList()){

            if(dog.missing == true){
                linkedList.add(count, dog);
                count++;
            }
        }
    }

    public void search(DogStore dogStore){


        for(ListView_User user : adapter.getList()){

            if(user.getmDogName().equals(dogStore.getSearchDogName())){
                ListView_Search_missing missSearch = new ListView_Search_missing(getResources().getDrawable(
                        R.drawable.icon_dog), user.getmDogName(), user.getmDogKind() , user.getmDogmiss()+"");
                dogStore.searchList.add(missSearch);
            }
        }

        dogStore.setSearchDogName("0");
    }

    public void addMissDog(){
        ListView_User user1 = new ListView_User(getResources().getDrawable(
                R.drawable.icon_dog), "두부", "치와와" , "1");
        adapter.add(user1);

        ListView_User user2 = new ListView_User(getResources().getDrawable(
                R.drawable.icon_dog), "초코", "푸들", "30");
        adapter.add(user2);

        ListView_User user3 = new ListView_User(getResources().getDrawable(
                R.drawable.icon_dog), "누렁이", "진돗개", "100");
        adapter.add(user3);

        ListView_User user4 = new ListView_User(getResources().getDrawable(
                R.drawable.icon_dog), "흰둥이", "말티즈", "40");
        adapter.add(user4);

        ListView_User user5 = new ListView_User(getResources().getDrawable(
                R.drawable.icon_dog), "몽이", "치와와", "29") ;
        adapter.add(user5);

        ListView_User user6 = new ListView_User(getResources().getDrawable(
                R.drawable.icon_dog), "보리", "달마시안", "49" );
        adapter.add(user6);

        ListView_User user7 = new ListView_User(getResources().getDrawable(
                R.drawable.icon_dog), "사랑이", "도베르만", "78");
        adapter.add(user7);

        ListView_User user8 = new ListView_User(getResources().getDrawable(
                R.drawable.icon_dog), "민트", "웰시코기", "357");
        adapter.add(user8);

        ListView_User user9 = new ListView_User(getResources().getDrawable(
                R.drawable.icon_dog), "라이언", "허스키", "61");
        adapter.add(user9);

        ListView_User user10 = new ListView_User(getResources().getDrawable(
                R.drawable.icon_dog), "레오", "도베르만", "77");
        adapter.add(user10);

    }

}