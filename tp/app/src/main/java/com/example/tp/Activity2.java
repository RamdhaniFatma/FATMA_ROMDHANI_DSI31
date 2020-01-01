package com.example.tp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Vector;
public class Activity2 extends AppCompatActivity {

        public static Vector users;
        public static final String LOGIN="login";
        public static final String MDP="mdp";
        EditText t1;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_2);
            Intent i = getIntent();
            String s1 = i.getStringExtra(LOGIN);
            String s2 = i.getStringExtra(MDP);
            boolean trouve = false;
            for (int cpt = 0; cpt < MainActivity.users.size(); cpt++) {
                user u = (user) users.elementAt(cpt);
                if (s1.equals(u.log) && s2.equals(u.mdps)) {
                    t1.setText("bonjour" + u.name);
                    trouve = true;
                    break;
                }
            }
            if (trouve == false) {
                Toast.makeText(this, "erreur de login", Toast.LENGTH_LONG).show();
                this.finish();
            }
        }

    }



