package com.example.a41665767.tp2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_GET = 1;

    EditText descripcionET, precioET, uriET;
    ImageButton imagenIB;
    Spinner categoriaSp;
    ArrayList<Producto> productos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        descripcionET = (EditText) findViewById(R.id.descripcion);
        imagenIB = (ImageButton) findViewById(R.id.imagen);
        categoriaSp = (Spinner) findViewById(R.id.categoria);
        precioET = (EditText) findViewById(R.id.precio);
        uriET = (EditText) findViewById(R.id.Uri2);
        productos = new ArrayList<>();

        // Datos de categoria
        ArrayList<String> categoriasAL = new ArrayList<>();
        categoriasAL.add("Electronica");
        categoriasAL.add("Calzado");
        categoriasAL.add("Hogar");
        categoriasAL.add("Automoviles");

        // Creo Adapter
        ArrayAdapter<String> categAdapter;
        categAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,categoriasAL);

        // Seteo el layout de cada fila q se muestra
        categAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Asocio adapter con spinner
        categoriaSp.setAdapter(categAdapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_IMAGE_GET && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();
            uriET.setText(uri.toString());
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                imagenIB.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void selectImage(View v) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_GET);
        }
    }
    public void btnAgregar (View v){
        int precio = Integer.valueOf (precioET.getText().toString());
        Producto p = new Producto((String) categoriaSp.getSelectedItem(), descripcionET.getText().toString(), precio, uriET.getText().toString());
        productos.add(p);
    }
    public void btnActualizar (View v){
        int precio = Integer.valueOf (precioET.getText().toString());
        Producto p = new Producto((String) categoriaSp.getSelectedItem(), descripcionET.getText().toString(), precio, uriET.getText().toString());
        productos.add(p);
    }
    public void btnListar (View v){
        Intent intent = new Intent(this, Imprimir.class);
        startActivity(intent);
    }

}
