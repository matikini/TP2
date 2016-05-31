package com.example.a41665767.tp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Imprimir extends AppCompatActivity {
    ListView listVw;
    ArrayList<Producto> prod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imprimir);
        listVw = (ListView) findViewById(R.id.listVW);
    }

}

