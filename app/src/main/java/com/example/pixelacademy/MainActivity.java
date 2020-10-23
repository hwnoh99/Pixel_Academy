package com.example.pixelacademy;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;

import android.widget.ImageView;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button button = (Button)findViewById(R.id.button1);
        final Button button2 = (Button)findViewById(R.id.button2);

        //button for upload picture activity
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Colour.class);
                startActivity(intent);
            }
        });

        //Link button to access the app's Github page
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Accessing GitHub by Pixel Academy", Toast.LENGTH_LONG).show();
                // Pop up toast message for long period

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/hwnoh99/Pixel_Academy"));
                startActivity(intent);
            }
        });
    }

}
