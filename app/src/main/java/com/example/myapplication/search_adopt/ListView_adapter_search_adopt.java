package com.example.myapplication.search_adopt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.search_miss.ListView_Search_missing;

import java.util.ArrayList;

public class ListView_adapter_search_adopt extends BaseAdapter {

    private ListView_Search_adopt mUser;
    private Context mContext;

    private ImageView imgDogIcon;
    private TextView tvDogName;
    private TextView tvDogKind;
    private TextView tvDogMiss;


    private ArrayList<ListView_Search_adopt> mUserData;

    public ListView_adapter_search_adopt(Context context) {
        super();
        mContext = context;
        mUserData = new ArrayList<ListView_Search_adopt>();
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mUserData.size();
    }

    @Override
    public ListView_Search_adopt getItem(int position) {
        // TODO Auto-generated method stub
        return mUserData.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public void add(ListView_Search_adopt user) {
        mUserData.add(user);
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
            tvDogMiss.setText(mUser.getmDogage());


        }
        return v;
    }
}
