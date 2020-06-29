package com.example.myapplication.ui.adopt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.ui.missing.ListView_Adapter;
import com.example.myapplication.ui.missing.ListView_User;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Collections;

public class ListView_Adapter_Adopt extends BaseAdapter  {

    private ListView_Adopt mUser;
    private Context mContext;

    private ImageView imgDogIcon;
    private TextView tvDogName;
    private TextView tvDogKind;
    private TextView tvDogAge;


    private ArrayList<ListView_Adopt> mUserData;

    public ListView_Adapter_Adopt(Context context) {
        super();
        mContext = context;
        mUserData = new ArrayList<ListView_Adopt>();
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mUserData.size();
    }

    @Override
    public ListView_Adopt getItem(int position) {
        // TODO Auto-generated method stub
        return mUserData.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public ArrayList<ListView_Adopt> getList(){
        return mUserData;
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
            tvDogAge = v.findViewById(R.id.dog_miss);

        }

        mUser = getItem(position);



        if (mUser != null) {
            if (mUser.getmDogIcon() != null) {
                imgDogIcon.setImageDrawable(mUser.getmDogIcon());
            }
            tvDogName.setText(mUser.getmDogName());
            tvDogKind.setText(mUser.getmDogKind());
            tvDogAge.setText(mUser.getmDogAge()+ "살");

        }
        return v;
    }

    public void add(ListView_Adopt user) {
        mUserData.add(user);
    }

    public void sortName(){
        Collections.sort(mUserData, new ListView_Adopt.nameCompare());
    }

    public void sortbreeds(){
        Collections.sort(mUserData, new ListView_Adopt.breedsCompare());
    }

    public void sortAge(){
        Collections.sort(mUserData , new ListView_Adopt.ageCompare());
    }


}
