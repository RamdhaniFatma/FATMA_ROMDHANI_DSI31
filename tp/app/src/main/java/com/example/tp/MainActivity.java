package com.example.tp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    public static Vector users;
    public static final String LOGIN="login";
    public static final String MDP="mdp";
    Button b1;
    Button b2;
    EditText t1;
    EditText t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.b1);
        users = new Vector();
        user u1 = new user("xxx", "123", "ali");
        user u2 = new user("yyy", "456", "mohamed");
        user u3 = new user("zzz", "789", "salah");
        users.add(u1);
        users.add(u2);
        users.add(u3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Activity2.class);
                i.putExtra(LOGIN, t1.getText().toString());
                i.putExtra(MDP, t2.getText().toString());
                startActivity(i);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent X = new Intent(MainActivity.this, Activity3.class);
                X.putExtra(LOGIN, t1.getText().toString());
                X.putExtra(MDP, t2.getText().toString());
                startActivityForResult(X, 2);

            }
        });
    }
    protected void OnActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==2){
            if(resultCode==RESULT_OK)
            {
                Toast.makeText(this,"au revoir",Toast.LENGTH_SHORT).show();
            }
            if(resultCode==RESULT_CANCELED)
            {
                Toast.makeText(this, "erreur de login", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
