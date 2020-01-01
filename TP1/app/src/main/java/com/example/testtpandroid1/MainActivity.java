package com.example.testtpandroid1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText zone1, zone2;
    private Button btn;
    private TextView msg;
    private RadioButton rouge;
    private RadioButton bleu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btn = (Button) this.findViewById(R.id.btn);
        this.zone1 = (EditText) this.findViewById(R.id.zone1);
        this.zone2 = (EditText) this.findViewById(R.id.zone2);
        this.msg = (TextView) this.findViewById(R.id.msg);
        this.rouge = (RadioButton) this.findViewById(R.id.rouge);
        this.bleu = (RadioButton) this.findViewById(R.id.bleu);
        this.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = zone1.getText().toString();
                String s2 = zone2.getText().toString();
                String res = "bonjour !" + s1 + "" + s2 + "!";

                if (rouge.isChecked()) {
                    msg.setTextColor(Color.RED);


                }

                if (bleu.isChecked()) {
                    msg.setTextColor(Color.BLUE);

                }
                msg.setText(res);

            }
        });
        this.rouge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bleu.setChecked(false);
            }
        });
        this.bleu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rouge.setChecked(false);
            }
        });
    }
}