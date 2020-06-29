package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class addMissing extends AppCompatActivity {
    InputMethodManager imm;
    LinearLayout ll;
    EditText missingDate;
    DogStore dogStore = DogStore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_add_missing);

        ll = findViewById(R.id.ll2);
        missingDate = findViewById(R.id.missing_date);

        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        ll.setOnClickListener(myClickListener);
    }

    public void mOk(View v) {
        for(Dog i  : dogStore.getDogList()) {
            if (i.flag == true) {
                i.missingDate = String.valueOf(missingDate.getText());
                i.flag = false;
                break;
            }
        }
        Toast.makeText(this, "신고완료!", Toast.LENGTH_LONG).show();

        finish();
    }

    public void mCancle(View v) {
        for(Dog i  : dogStore.getDogList()) {
            if (i.flag == true) {
                i.flag = false;
                i.missing = false;
                break;
            }
        }
        finish();
    }

    public boolean onTouchEvent(MotionEvent event) {
        return event.getAction() != MotionEvent.ACTION_OUTSIDE;
    }

    public void onBackPressed() {
        return;
    }

    public void hideKeyboard() {
        imm.hideSoftInputFromWindow(missingDate.getWindowToken(), 0);

    }

    View.OnClickListener myClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            hideKeyboard();
            switch (v.getId()) {
                case R.id.ll2:
                    break;

            }
        }
    };
}
