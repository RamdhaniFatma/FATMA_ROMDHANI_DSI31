package com.example.tvaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText prixF;
    EditText prixI;
    Button btnC,btnR;
    RadioButton r1,r2;
    CheckBox ch;
    float resulat1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prixI=(EditText)findViewById(R.id.editText);
        prixF=(EditText)findViewById(R.id.editText2);
        btnC=(Button)findViewById(R.id.Button01);
        btnR=(Button)findViewById(R.id.Button02);
        r1=(RadioButton)findViewById(R.id.radio_pirates);
        r2=(RadioButton)findViewById(R.id.radio_ninjas);
        ch=(CheckBox)findViewById(R.id.checkbox);


        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resulat1=Float.parseFloat(prixI.getText().toString());
                if (r1.isChecked()&&(ch.isChecked())){
                    resulat1=(resulat1+resulat1*19/100);
                    resulat1=resulat1-resulat1*10/100;
                    prixF.setText(String.valueOf(resulat1));
                }
                else if (r1.isChecked()) {
                    resulat1=(resulat1+resulat1*19/100);
                    prixF.setText(String.valueOf(resulat1));
                }
                else if(r2.isChecked()&&(ch.isChecked())){
                    resulat1=(resulat1+resulat1*12/100);
                    resulat1=resulat1-resulat1*10/100;
                    prixF.setText(String.valueOf(resulat1));
                }
                else if (r2.isChecked()) {
                    resulat1=(resulat1+resulat1*12/100);
                    prixF.setText(String.valueOf(resulat1));
                }

            }
        });
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((prixI.getText().toString().isEmpty())&&(prixF.getText().toString().isEmpty())&& (ch.isChecked()==false)&& (r1.isChecked()==false) || (r2.isChecked()==false)){
                    Toast.makeText(getApplicationContext(),"Already Empty !!!",Toast.LENGTH_LONG).show();
                }else{
                    prixI.setText("");
                    prixF.setText("");
                    ch.setChecked(false);
                    r1.setChecked(false);
                    r2.setChecked(false);

                }
            }
        });

    }
}