package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    class TacheChargement  extends AsyncTask<Void, Void,String> {
        @Override
        protected String doInBackground (Void... Voids){

          StringBuilder sb=  new StringBuilder();
          try{
              URL url= new URL("http://www.android.com/");
              HttpURLConnection urlConnection=(HttpURLConnection)url.openConnection();
              urlConnection.setRequestMethod("GET");
              InputStream  in= new BufferedInputStream(urlConnection.getInputStream());
              InputStreamReader inputStreamReader=new InputStreamReader(in);
              BufferedReader bf = new BufferedReader(inputStreamReader);
              String ligne = "" ;
              while ((ligne=bf.readLine())!=null){
                  sb.append(ligne+"\n");

              }
              bf.close();
          }catch (IOException e){
              e.printStackTrace();

          }
          return sb.toString();

        }
        protected void onPostExecute(String result){
            EditText edt=(EditText)findViewById(R.id.txt);
            edt.setText(result);
        }


    }

    public void parcoursDonnees() throws XmlPullParserException, IOException {
       StringBuilder strb= new StringBuilder();
        Resources res =getResources();
        XmlResourceParser xp =res.getXml(R.xml.donnees);
        xp.next();
        int evt=xp.getEventType();
        while (evt!= XmlPullParser.END_DOCUMENT){
            if (evt==XmlPullParser.START_DOCUMENT){
                strb.append("start");

            }
            else if (evt==XmlPullParser.START_TAG){
                strb.append("\nTAG"+xp.getName());
            }
            else if (evt==XmlPullParser.END_TAG){
                strb.append("\nFIN DE BALISE"+xp.getName());

            } else if (evt==XmlPullParser.TEXT){
                strb.append("\nTEXTE :"+xp.getText());

            }
            evt=xp.next();
        }
        EditText ed=(EditText) findViewById(R.id.txt);
    ed.setText(strb.toString());}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            parcoursDonnees();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
