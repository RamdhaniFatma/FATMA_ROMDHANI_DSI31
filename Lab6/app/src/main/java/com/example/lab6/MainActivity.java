package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
public Spinner spinner ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList maliste =new ArrayList();
        maliste.add("rouge");
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,maliste);
        spinner.setAdapter(adapter);
        String couleur = spinner.getSelectedItem().toString();
        ConstraintLayout layout=(ConstraintLayout)findViewById(R.id.ecran);
        for (int i=0;i<layout.getChildCount();i++){
            View child=layout.getChildAt(i);
            if (child instanceof TextView) {
                TextView textView=(TextView)child;
                textView.setTextColor(Color.RED);
            }
        }
    }
}
