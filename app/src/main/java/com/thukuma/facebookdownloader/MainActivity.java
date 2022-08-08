package com.thukuma.facebookdownloader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new FacebookDownloader("", MainActivity.this, new FacebookDownloader.onComplete() {
            @Override
            public void onComplete(XModal xModal) {

            }
        }, new FacebookDownloader.onError() {
            @Override
            public void onError(Exception error) {

            }
        });
    }
}