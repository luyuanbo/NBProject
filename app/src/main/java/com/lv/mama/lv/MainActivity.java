package com.lv.mama.lv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("MainActivity+++++", "onSaveInstanceState: +++++");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("MainActivity+++++", "onRestoreInstanceState: +++++");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity+++++", "onCreate: +++++");

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity+++++", "onStart: +++++");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity+++++", "onStop: +++++");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("MainActivity+++++", "onDestroy: +++++");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity+++++", "onPause: +++++");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("MainActivity+++++", "onRestart: +++++");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity+++++", "onResume: +++++");
    }
}
