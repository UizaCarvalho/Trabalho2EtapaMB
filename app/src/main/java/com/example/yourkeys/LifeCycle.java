package com.example.yourkeys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class LifeCycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("lifecycle", this.getNameClass() + " - onCreate() " + savedInstanceState);
    }

    protected void onStart() {
        super.onStart();
        Log.i("lifecycle", this.getNameClass() + " - onStart()");
    }

    protected void onResume() {
        super.onResume();
        Log.i("lifecycle", this.getNameClass() + " - onResume()");
    }

    protected void onRestart() {
        super.onRestart();
        Log.i("lifecycle", this.getNameClass() + " - onRestart()");
    }

    protected void onPause() {
        super.onPause();
        Log.i("lifecycle", this.getNameClass() + " - onPause()");
    }

    protected void onStop() {
        super.onStop();
        Log.i("lifecycle", this.getNameClass() + " - onStop()");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i("lifecycle", this.getNameClass() + " - onDestroy()");
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("lifecycle", this.getNameClass() + " - onSaveInstanceState()");
    }

    public String getNameClass() {
        String s = getClass().getName();
        return s.substring(s.lastIndexOf('.'));
    }
}
