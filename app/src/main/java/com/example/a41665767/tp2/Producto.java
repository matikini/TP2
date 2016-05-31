package com.example.a41665767.tp2;

/**
 * Created by 41665767 on 10/5/2016.
 */
public class Producto {
    private String Categoria;
    private String Descripcion;
    private int Precio;
    private String Foto;

    public Producto(String categoria, String descripcion, int precio, String foto) {
        Categoria = categoria;
        Descripcion = descripcion;
        Precio = precio;
        Foto = foto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public String getFoto() { return Foto; }

    public void setFoto(String Foto) { this.Foto = Foto;  }
}