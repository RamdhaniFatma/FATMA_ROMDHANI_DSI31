package com.example.callbackmethod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
String tag ="tag";
Button btn;



    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag,"appel onpause method ");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag,"appel ondestroy method ");

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(tag,"appel onpostresume method ");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag,"appel onstop method ");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag,"appel onstart method ");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(tag,"appel oncreat method ");
        this.btn = (Button) this.findViewById((R.id.b1));

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(i);
                setContentView(R.layout.activity_main2);
            }


        });

    }}
