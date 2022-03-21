package com.example.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class HelloActivity1 extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Hello1";
    private static int objCount = 0;
    private int mObjCount;

//活动的生命周期函数，回调函数
//事件驱动编程
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //与布局文件名必须一样
        setContentView(R.layout.activity_hello1);
        objCount++;
        mObjCount = objCount;
        Log.d(TAG, mObjCount + "-onCreate execute");
        setTitle("Hello1");
        setupButtons();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, mObjCount + "-onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, mObjCount + "-onResume");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(TAG, mObjCount + "-onPostResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, mObjCount + "-onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, mObjCount + "-onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        objCount--;
        Log.d(TAG, mObjCount + "-onDestroy");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btToHello1) {
            Intent intent;
            intent = new Intent(this, HelloActivity1.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.btToHello2) {
            Intent intent;
            intent = new Intent(this, HelloActivity2.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.btToHello3) {
            Intent intent;
            String string1 = "com.example.helloworld.intent.action.H3";
     //        intent = new Intent(this, HelloActivity3.class);
            intent = new Intent(string1);
            startActivity(intent);
            Intent intent1 = new Intent(Intent.ACTION_VIEW);
            intent1.setData(Uri.parse("http://www.hstc.edu.cn"));
            startActivity(intent1);
        }
    }

    private void setupButtons() {
        Button b;

        b = (Button) findViewById(R.id.btToHello1);
        b.setOnClickListener(this);
        b = (Button) findViewById(R.id.btToHello2);
        b.setOnClickListener(this);
        b = (Button) findViewById(R.id.btToHello3);
        b.setOnClickListener(this);

    }
}
