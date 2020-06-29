package com.example.myapplication.ui.adopt;

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
import com.example.myapplication.search_adopt.ListView_Search_adopt;
import com.example.myapplication.search_adopt.search_adopt;
import com.example.myapplication.search_miss.ListView_Search_missing;
import com.example.myapplication.search_miss.search_miss;
import com.example.myapplication.ui.missing.ListView_User;

public class AdoptFragment extends Fragment {

    private ListView userList;
    private ListView_Adapter_Adopt adapter;
    private EditText temp;

    private LinkedList linkedList = new LinkedList();
    private DogStore dogStore = DogStore.getInstance();



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_adopt, container, false);

        if(adapter==null) {
            adapter = new ListView_Adapter_Adopt(getActivity().getApplicationContext());
        }
        userList=(ListView) root.findViewById(R.id.adopt_list);

        userList.setAdapter(adapter);

        searchAdoptDog(dogStore);
        for(int i = 0 ; i < linkedList.size() ; i++){

            ListView_Adopt user = new ListView_Adopt(getResources().getDrawable(
                    R.drawable.icon_dog), linkedList.get(i).dogName, linkedList.get(i).dogBreeds , linkedList.get(i).dogAge);
            adapter.add(user);
        }

        Button name_btn = root.findViewById(R.id.adopt_name);
        name_btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.sortName();
                userList.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }
        });

        Button breeds_btn = root.findViewById(R.id.adopt_breeds);
        breeds_btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.sortbreeds();
                userList.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }
        });

        Button age_btn = root.findViewById(R.id.adpot_age);
        age_btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.sortAge();
                userList.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });
        addAdoptDog();

        temp = root.findViewById(R.id.search_key_adopt);

        Button search_btn = root.findViewById(R.id.search_adopt);
        search_btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                dogStore.setSearchDogName(String.valueOf(temp.getText()));
                search(dogStore);
                Intent intent = new Intent(getActivity(), search_adopt.class);
                startActivity(intent);
            }
        });



        adapter.notifyDataSetChanged();

        return root;

    }

    public void searchAdoptDog(DogStore dogStore){
        int count = 0;
        for(Dog dog : dogStore.getDogList()){

            if(dog.adopt == true){
                linkedList.add(count, dog);
                count++;
            }
        }
    }


    public void search(DogStore dogStore){


        for(ListView_Adopt user : adapter.getList()){

            if(user.getmDogName().equals(dogStore.getSearchDogName())){
                ListView_Search_adopt missSearch = new ListView_Search_adopt(getResources().getDrawable(
                        R.drawable.icon_dog), user.getmDogName(), user.getmDogKind() , user.getmDogAge()+"살");
                dogStore.searchList_adopt.add(missSearch);
            }
        }
        dogStore.setSearchDogName("0");
    }

    public void addAdoptDog(){
        ListView_Adopt user1 = new ListView_Adopt(getResources().getDrawable(
                R.drawable.icon_dog), "두부", "치와와", "1");
        adapter.add(user1);

        ListView_Adopt user2 = new ListView_Adopt(getResources().getDrawable(
                R.drawable.icon_dog), "초코", "푸들", "3");
        adapter.add(user2);

        ListView_Adopt user3 = new ListView_Adopt(getResources().getDrawable(
                R.drawable.icon_dog), "누렁이", "진돗개", "11");
        adapter.add(user3);

        ListView_Adopt user4 = new ListView_Adopt(getResources().getDrawable(
                R.drawable.icon_dog), "흰둥이", "말티즈", "8");
        adapter.add(user4);

        ListView_Adopt user5 = new ListView_Adopt(getResources().getDrawable(
                R.drawable.icon_dog), "몽이", "치와와", "8");
        adapter.add(user5);

        ListView_Adopt user6 = new ListView_Adopt(getResources().getDrawable(
                R.drawable.icon_dog), "보리", "달마시안", "7");
        adapter.add(user6);

        ListView_Adopt user7 = new ListView_Adopt(getResources().getDrawable(
                R.drawable.icon_dog), "사랑이", "도베르만", "3");
        adapter.add(user7);

        ListView_Adopt user8 = new ListView_Adopt(getResources().getDrawable(
                R.drawable.icon_dog), "민트", "웰시코기", "2");
        adapter.add(user8);

        ListView_Adopt user9 = new ListView_Adopt(getResources().getDrawable(
                R.drawable.icon_dog), "라이언", "허스키", "10");
        adapter.add(user9);

        ListView_Adopt user10 = new ListView_Adopt(getResources().getDrawable(
                R.drawable.icon_dog), "레오", "도베르만", "5");
        adapter.add(user10);

    }
}