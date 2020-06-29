package com.example.myapplication;

import com.example.myapplication.search_adopt.ListView_Search_adopt;
import com.example.myapplication.search_miss.ListView_Adapter_Search_missing;
import com.example.myapplication.search_miss.ListView_Search_missing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DogStore {
    private static DogStore instance = new DogStore();

    private String searchDogName;

    private final List<Dog> dogList = new ArrayList<>();

    public List<ListView_Search_missing> searchList = new ArrayList<>();
    public List<ListView_Search_adopt> searchList_adopt = new ArrayList<>();


    private Map<Object, OnDogStoreChangedListener> listeners = new HashMap<>();

    private DogStore() {

    }


    public void setSearchDogName(String searchDogName){
        this.searchDogName = searchDogName;
    }

    public String getSearchDogName(){
        return this.searchDogName;
    }

    public void addListener(Object object, OnDogStoreChangedListener listener) {
        listeners.put(object, listener);
    }

    public void removeListener(Object object) {
        listeners.remove(object);
    }

    public int getCount() {
        return dogList.size();
    }

    public void addDog(Dog dog) {
        dogList.add(dog);

        for (OnDogStoreChangedListener listener : listeners.values()) {
            listener.onDogAdded(dog);
        }
    }

    public void removeDog(Dog dog){
        dogList.remove(dog);
    }


    public List<Dog> getDogList() {
        return dogList;
    }

    public Dog getItem(int position) {
        return dogList.get(position);
    }

    public static DogStore getInstance() {
        return instance;
    }

    public interface OnDogStoreChangedListener {
        void onDogAdded(Dog dog);
    }
}
