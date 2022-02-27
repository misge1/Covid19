package com.mirena.covid19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdapterMunicipios adapter = null;
        try {
            adapter = new AdapterMunicipios(this);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        recyclerView.setAdapter(adapter);
    }
}