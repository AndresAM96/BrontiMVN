/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bronti.API.models;

/**
 *
 * @author user
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "productos")
public class ProductoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Crear las variables que va a guardar la BD

    private int id_producto;

    @Column(name = "nombre_producto", nullable = false)
    private String nombre_producto;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "precio_venta", nullable = false)
    private int precio_venta;
    
    @Column(name = "precio_compra", nullable = false)
    private int precio_compra;

    @Column(name = "stock", nullable = false)
    private int stock;
    
    @Column(name = "stock_minimo", nullable = false)
    private int stock_minimo;
    
    @Column(name="tipo_despacho", nullable= false)
    private String tipo_despacho;

    @OneToMany(mappedBy = "producto")
    @JsonIgnore
    private List<VentaModel> venta = new ArrayList<>();

    public int getId_producto() {
        return id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrecio_venta() {
        return precio_venta;
    }

    public int getPrecio_compra() {
        return precio_compra;
    }

    public int getStock() {
        return stock;
    }

    public int getStock_minimo() {
        return stock_minimo;
    }

    public String getTipo_despacho() {
        return tipo_despacho;
    }

    public List<VentaModel> getVenta() {
        return venta;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio_venta(int precio_venta) {
        this.precio_venta = precio_venta;
    }

    public void setPrecio_compra(int precio_compra) {
        this.precio_compra = precio_compra;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setStock_minimo(int stock_minimo) {
        this.stock_minimo = stock_minimo;
    }

    public void setTipo_despacho(String tipo_despacho) {
        this.tipo_despacho = tipo_despacho;
    }

    public void setVenta(List<VentaModel> venta) {
        this.venta = venta;
    }

    
    
}
