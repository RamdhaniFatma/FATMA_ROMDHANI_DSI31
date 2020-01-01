package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.text.BreakIterator;

public class AactivityB extends AppCompatActivity {

    private BreakIterator NomEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ab);
        SharedPreferences prefs=getSharedPreferences("Mydata", Context.MODE_PRIVATE);
        String name =prefs.getString("nom","N/D");

        if(name.equals("N/D"))
            Log.d("TAG","Valeur de nom introuvable");
        else
            NomEditText.setText(name);
    }
}
