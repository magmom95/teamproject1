package com.example.myapplication.ui.missing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListView_Adapter extends BaseAdapter  {

    private ListView_User mUser;
    private Context mContext;

    private ImageView imgDogIcon;
    private TextView tvDogName;
    private TextView tvDogKind;
    private TextView tvDogMiss;


    private ArrayList<ListView_User> mUserData;

    public ListView_Adapter(Context context) {
        super();
        mContext = context;
        mUserData = new ArrayList<ListView_User>();
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mUserData.size();
    }

    public ArrayList<ListView_User> getList(){
        return mUserData;
    }

    @Override
    public ListView_User getItem(int position) {
        // TODO Auto-generated method stub
        return mUserData.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View v = convertView;

        if (v == null) {

            v = ((LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                    .inflate(R.layout.listview_miss, null);

            imgDogIcon = (ImageView) v.findViewById(R.id.user_icon);
            tvDogName = (TextView) v.findViewById(R.id.dog_name);
            tvDogKind = (TextView) v.findViewById(R.id.dog_kind);
            tvDogMiss = (TextView) v.findViewById(R.id.dog_miss);

        }

        mUser = getItem(position);



        if (mUser != null) {
            if (mUser.getmDogIcon() != null) {
                imgDogIcon.setImageDrawable(mUser.getmDogIcon());
            }
            tvDogName.setText(mUser.getmDogName());
            tvDogKind.setText(mUser.getmDogKind());
            tvDogMiss.setText(mUser.getmDogmiss() + "일");


        }
        return v;
    }

    public void add(ListView_User user) {
        mUserData.add(user);
    }

    public void sortName(){
        Collections.sort(mUserData, new ListView_User.nameCompare());
    }

    public void sortbreeds(){
        Collections.sort(mUserData, new ListView_User.breedsCompare());
    }

    public void sortmissDate(){
        Collections.sort(mUserData , new ListView_User.missingCompare());
    }



}
