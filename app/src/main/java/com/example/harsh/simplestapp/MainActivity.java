package com.example.harsh.simplestapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.widget.AdapterView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
//import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> btnList=new ArrayList<>();
    private DataModel[] appData={
           new DataModel ("Spotify Streamer","pkg1"),
            new DataModel ("Football Scores App","pkg2" ),
    new DataModel ("Library App","pkg3" ),
        new DataModel ("Build It Bigger","pkg3" ),
        new DataModel ("XYZ Reader","pkg4" ),
        new DataModel ("Capstone ","pkg5" )
    };
    ListView lv=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        for(DataModel datum:appData){


            btnList.add(datum.appName);

        }
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.buttonKeeper);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.list_item,R.id.item_text,btnList);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new CustomClikcListener());

    }
    class CustomClikcListener implements OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
        long id) {

            String item = appData[position].getAppName()+" will be launched soon";

            Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();

        }
    }

    private class DataModel{
        private String appName;
        private String packageName;

        public DataModel(String appName, String packageName) {
            this.appName = appName;
            this.packageName = packageName;
        }

        public String getPackageName() {
            return packageName;
        }

        public void setPackageName(String packageName) {
            this.packageName = packageName;
        }

        public String getAppName() {
            return appName;
        }

        public void setAppName(String appName) {
            this.appName = appName;
        }
    }
}
