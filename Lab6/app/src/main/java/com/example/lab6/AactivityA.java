package com.example.lab6;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Context;
import android.content.SharedPreferences;
import android.icu.text.BreakIterator;
import android.os.Build;
import android.os.Bundle;

public class AactivityA extends AppCompatActivity {


    private BreakIterator NomEditText;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aactivity);
        SharedPreferences mespefs = getSharedPreferences("Mydata", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit=mespefs.edit();
        edit.putString("nom",NomEditText.getText().toString());
        edit.commit();

    }
}
