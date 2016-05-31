package com.example.a41665767.tp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.ImageView;


import java.util.ArrayList;

/**
 * Created by 41665569 on 17/5/2016.
 */


public class ProductosAdapter extends BaseAdapter {

    ArrayList<Producto> productos;
    Context context;
    TextView tvDescripcion, tvPrecio, tvCategoria;
    ImageView ivfoto;

    public ProductosAdapter(Context context, ArrayList<Producto> productos) {
        this.context = context;
        this.productos=productos;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int posicion, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item, viewGroup, false);
        }

        tvDescripcion = (TextView) view.findViewById(R.id.descripcion);
        ivfoto = (ImageView) view.findViewById(R.id.foto);
        tvCategoria = (TextView) view.findViewById(R.id.categoria);
        tvPrecio = (TextView) view.findViewById(R.id.precio);

        Producto p = productos.get(posicion);
        tvCategoria.setText(p.getCategoria().toString());
        tvDescripcion.setText(p.getDescripcion().toString());
        tvPrecio.setText(p.getPrecio());
        return view;
    }
}


