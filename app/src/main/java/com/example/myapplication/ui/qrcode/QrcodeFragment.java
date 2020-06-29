package com.example.myapplication.ui.qrcode;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.Dog;
import com.example.myapplication.DogStore;
import com.example.myapplication.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QrcodeFragment extends Fragment {
    private DogStore dogStore = DogStore.getInstance();
    private Dog dog;
    private Button button;
    private ImageView imageView;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_qrcode, container, false);

        final Context context=container.getContext();

        button=(Button) root.findViewById(R.id.button);
        imageView=(ImageView) root.findViewById(R.id.imageView);
        dog = dogStore.getItem(0);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MultiFormatWriter multiFormatWriter=new MultiFormatWriter();
                try{
                    BitMatrix bitMatrix=multiFormatWriter.encode(dog.ownerNum, BarcodeFormat.QR_CODE,200,200);
                    BarcodeEncoder barcodeEncoder=new BarcodeEncoder();
                    Bitmap bitmap=barcodeEncoder.createBitmap(bitMatrix);
                    imageView.setImageBitmap(bitmap);
                }catch(WriterException e){
                    e.printStackTrace();
                }
            }
        });

        return root;
    }
}