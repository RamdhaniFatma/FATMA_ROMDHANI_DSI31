package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Button ajout;
    public Button supp;
    public Button rech;
    public EditText idp;
    public EditText nomp;
    public EditText qtep;
    public Button btnsom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ajout = (Button) findViewById(R.id.ajout);
        supp = (Button) findViewById(R.id.supp);
        rech = (Button) findViewById(R.id.rech);
          btnsom=(Button) findViewById(R.id.btnsom);


        class GestionMaBase extends SQLiteOpenHelper {
            private SQLiteDatabase bd;
            private GestionMaBase helper;
            private static final int DATABASE_VERSION = 1;
            private static final String DATABASE_NAME = "Mabase";
            private static final String TABLE_PRODUIT = "Produit";
            private static final String COLUMN_ID = "_Id";
            private static final String COLUMN_NOM = "NomProduit";
            private static final String COLUMN_QTE = "QteProduit";

            public GestionMaBase(Context context) {
                super(context, DATABASE_NAME, null, DATABASE_VERSION);
            }

            @Override
            public void onCreate(SQLiteDatabase sqLiteDatabase) {
                String CREATE_TABLE_PRODUIT = " CREATE TABLE " + TABLE_PRODUIT +
                        "(" + COLUMN_ID + " INTEGER PRIMARY KEY, " + COLUMN_NOM + "TEXT,"
                        + COLUMN_QTE + "INTEGER"
                        + ")";
                sqLiteDatabase.execSQL(CREATE_TABLE_PRODUIT);

                ajout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bd = helper.getWritableDatabase();
                        String requeteAjoute = "insert into produit values (" + idp.getText() + ", '" + nomp.getText() + "'," + qtep.getText() + ")";
                        bd.execSQL(requeteAjoute);
                    }
                });

                rech.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String requeteSelect = "select * from Produit where _Id=" + idp.getText();
                        bd = helper.getReadableDatabase();
                        Cursor curseur = bd.rawQuery(requeteSelect, null);
                        if (curseur.moveToFirst()) {
                            curseur.moveToFirst();
                            int elem1 = Integer.parseInt(curseur.getString(0));
                            String elem2 = curseur.getString(1);
                            nomp.setText(elem2);
                            int elem3 = Integer.parseInt(curseur.getString(2));
                            qtep.setText(curseur.getString(2));
                            curseur.close();
                        }
                        bd.close();
                    }
                });
                supp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bd = helper.getWritableDatabase();
                        String requeteDelete = "delete from Produit where _Id=" + ajout.getText();
                        bd.execSQL(requeteDelete);
                    }
                });
               btnsom.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String requeteSelect ="select * from produits";
                                bd=helper.getWritableDatabase();
                                Cursor cursor=bd.rawQuery(requeteSelect,null);
                                int s=0;
                                while (cursor.moveToNext()){
                                    s=s+Integer.parseInt(cursor.getString(2));
                                }
                                cursor.close();
                                bd.close();
                        Toast.makeText(MainActivity.this,"somme="+s,Toast.LENGTH_LONG).show();

                    }
                });
             }
            @Override
            public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
                sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_PRODUIT);
                onCreate(sqLiteDatabase);
            }
            }




        }
    }
