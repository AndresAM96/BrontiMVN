/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.model;

/**
 *
 * @author user
 */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class ClienteModel {
    @Id
    @Column(name = "cedula_cliente", nullable = false)
    private int cedula_cliente;

    @Column(name = "nombre_cliente", nullable = false)
    private String nombre_cliente;
    
    @Column(name = "direccion_cliente", nullable = false)
    private String direccion_cliente;

    @Column(name = "telefono_cliente", nullable = false)
    private String telefono_cliente;

    @Column(name = "email_cliente", nullable = false)
    private String email_cliente;

    public int getCedula_cliente() {
        return cedula_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    public String getTelefono_cliente() {
        return telefono_cliente;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setCedula_cliente(int cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    public void setTelefono_cliente(String telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }
    
}
