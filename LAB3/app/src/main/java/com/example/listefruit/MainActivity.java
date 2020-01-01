package com.example.listefruit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView liste;
    TextView res;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] listItem = getResources().getStringArray(R.array.array_fruit);
        liste = (ListView) this.findViewById(R.id.liste);
        res = (TextView) this.findViewById(R.id.res);
        image = (ImageView) this.findViewById(R.id.imgview);
        final ArrayAdapter <String> adapter = new ArrayAdapter<String>(this,
                R.layout.mylist, R.id.texte, listItem);
        liste.setAdapter(adapter);
        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String valeur = adapter.getItem(i);
                res.setText("Vous avez choisis "+valeur);
                if (valeur.equalsIgnoreCase("Pomme")){
                    image.setImageResource(R.drawable.pomme);
                }
                if (valeur.equalsIgnoreCase("Kiwi")){
                    image.setImageResource(R.drawable.kiwi);
                }
                if (valeur.equalsIgnoreCase("Banane")){
                    image.setImageResource(R.drawable.banane);
                }
                if (valeur.equalsIgnoreCase("Poire")){
                    image.setImageResource(R.drawable.poire);
                }
                if (valeur.equalsIgnoreCase("Figue")){
                    image.setImageResource(R.drawable.figue);
                }
                if (valeur.equalsIgnoreCase("Raisin")){
                    image.setImageResource(R.drawable.raisin);
                }
                if (valeur.equalsIgnoreCase("Abricot")){
                    image.setImageResource(R.drawable.abricot);
                }
                if (valeur.equalsIgnoreCase("Datte")){
                    image.setImageResource(R.drawable.datte);
                }
            }
        });
    }
}
