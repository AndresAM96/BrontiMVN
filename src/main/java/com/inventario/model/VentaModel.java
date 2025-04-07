/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.model;

/**
 *
 * @author user
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ventas")
public class VentaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Variables a guardar

    private int id_venta;

    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "tipo_factura", nullable = false)
    private String tipo_factura;
    
    @Column(name = "forma_pago", nullable = false)
    private String forma_pago;
    
    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "descuento", nullable = false)
    private String descuento;

    @ManyToOne
    @JoinColumn(name = "cedula_usuario", nullable = false)
    @JsonProperty
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "cedula_producto", nullable = false)
    @JsonProperty
    private ProductoModel producto;

    public int getId_venta() {
        return id_venta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo_factura() {
        return tipo_factura;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDescuento() {
        return descuento;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public ProductoModel getProducto() {
        return producto;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo_factura(String tipo_factura) {
        this.tipo_factura = tipo_factura;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public void setProducto(ProductoModel producto) {
        this.producto = producto;
    }
    
    
}
