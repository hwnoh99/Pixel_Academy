package com.example.pixelacademy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

import android.provider.MediaStore;

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
        final Button button2 = (Button)findViewById(R.id.button2);
        final ImageView iv = (ImageView)findViewById(R.id.imageView);

        final TextView tv = (TextView)findViewById(R.id.textView1);
        Bitmap bitmap;

        //camera button
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //Run camera app when user click
                startActivity(intent);
            }
        });

        //google photo button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);
            }
        });

        iv.setOnTouchListener(new OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                //Get the Pixel coordinates where touched
                int x = (int)event.getX();
                int y = (int)event.getY();
                String x_str = Integer.toString(x);
                String y_str = Integer.toString(y);

                iv.buildDrawingCache();
                Bitmap bitmap = iv.getDrawingCache(); // Create bitmap from image selected

                int pixel = bitmap.getPixel(x,y);

                //get pixel variables
                int redValue = Color.red(pixel);
                int blueValue = Color.blue(pixel);
                int greenValue = Color.green(pixel);
                int alphaValue = Color.alpha(pixel);

                printLocation(x_str, y_str, redValue, greenValue, blueValue, alphaValue);

                return true;
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check the request we're responding to
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                try {
                    final ImageView iv = (ImageView)findViewById(R.id.imageView);
                    // Create bitmap from image selected
                    InputStream in = getContentResolver().openInputStream(data.getData());
                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();

                    //Output the image file's name
                    iv.setImageBitmap(img);
                    String result = data.getDataString();
                    printFileName(result);
                }
                catch (Exception e) {
                    Log.d("Tag", "Error");
                }
            }
        }
    }

    public void printFileName (String x) {
        final TextView tv = (TextView)findViewById(R.id.textView1);
        tv.setText(x);
    }
    public void printLocation (String x, String y, int r, int g, int b, int a) {
        //Set text with the parameter gotten
        final TextView tvR = (TextView)findViewById(R.id.textView_R);
        final TextView tvG = (TextView)findViewById(R.id.textView_G);
        final TextView tvB = (TextView)findViewById(R.id.textView_B);
        final TextView tvA = (TextView)findViewById(R.id.textView4);

        final TextView tvX = (TextView)findViewById(R.id.textView_X);
        final TextView tvY = (TextView)findViewById(R.id.textView_Y);

        tvR.setText("R: " + r);
        tvG.setText("G: " + g);
        tvB.setText("B: " + b);
        tvA.setText("A: " + a);

        tvX.setText("X: " + x);
        tvY.setText("Y: " + y);

    }

}


