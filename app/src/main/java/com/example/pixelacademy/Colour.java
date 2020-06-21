package com.example.pixelacademy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.widget.ImageView;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;

import java.io.InputStream;

public class Colour extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour);

        final Button button = (Button)findViewById(R.id.button1);
        final ImageView iv = (ImageView)findViewById(R.id.imageView);
        final TextView tv = (TextView)findViewById(R.id.textView1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);
            }
        });

//        iv.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_DOWN){
//                    tv.setText("Touch coordinates : " +
//                            String.valueOf(event.getX()) + "x" + String.valueOf(event.getY()));
//                }
//                return true;
//            }
//        });



//        iv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tv.setText("Hello World!");
//            }
//        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        final ImageView iv = (ImageView)findViewById(R.id.imageView);

        // Check the request we're responding to
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                try {
                    // Create bitmap from image selected
                    InputStream in = getContentResolver().openInputStream(data.getData());
                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();
                    // display image
                    iv.setImageBitmap(img);
                } catch (Exception e) {
                    Log.d("Tag", "Error");
                }
            }
        }

    }

    int RGB = android.graphics.Color.argb(255, Red, Green, Blue);

}


