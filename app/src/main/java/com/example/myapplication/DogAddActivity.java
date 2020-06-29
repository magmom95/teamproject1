package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DogAddActivity extends AppCompatActivity {
    Button okBtn, cancelBtn;
    DogStore dogStore = DogStore.getInstance();
    EditText editText1, editText2, editText3, editText4, editText5;
    InputMethodManager imm;
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dogadd);

        ll = findViewById(R.id.ll);

        okBtn = findViewById(R.id.okBtn);
        cancelBtn = findViewById(R.id.cancleBtn);

        editText1 = findViewById(R.id.dog_name);
        editText2 = findViewById(R.id.dog_age);
        editText3 = findViewById(R.id.dog_breeds);
        editText4 = findViewById(R.id.owner_num);
        editText5 = findViewById(R.id.owner_adress);

        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        ll.setOnClickListener(myClickListener);
    }

    public void mOk(View v) {
        Dog dog = new Dog();
        dog.dogName = String.valueOf(editText1.getText());
        dog.dogAge = String.valueOf(editText2.getText());
        dog.dogBreeds = String.valueOf(editText3.getText());
        dog.ownerNum = String.valueOf(editText4.getText());
        dog.ownerAddress = String.valueOf(editText5.getText());

        dogStore.addDog(dog);
        Toast.makeText(this, "추가완료!", Toast.LENGTH_LONG).show();
        finish();
    }

    public void mCancle(View v) {
        finish();
    }

    public boolean onTouchEvent(MotionEvent event) {
        return event.getAction() != MotionEvent.ACTION_OUTSIDE;
    }

    public void onBackPressed() {
        return;
    }

    public void hideKeyboard() {
        imm.hideSoftInputFromWindow(editText1.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(editText2.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(editText3.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(editText4.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(editText5.getWindowToken(), 0);
    }

    View.OnClickListener myClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            hideKeyboard();
            switch (v.getId()) {
                case R.id.ll:
                    break;

            }
        }
    };


}
