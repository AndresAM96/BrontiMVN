/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.model;

/**
 *
 * @author user
 */

import jakarta.persistence.*;

@Entity
@Table(name = "proveedores")
public class ProveedorModel {
    @Id
    @Column(name = "cedula_proveedor", nullable = false)
    private int cedula_proveedor;

    @Column(name = "nombre_proveedor", nullable = false)
    private String nombre_proveedor;
    
    @Column(name = "direccion_proveedor", nullable = false)
    private String direccion_proveedor;

    @Column(name = "telefono_proveedor", nullable = false)
    private String telefono_proveedor;

    @Column(name = "email_proveedor", nullable = false)
    private String email_proveedor;

    public int getCedula_proveedor() {
        return cedula_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public String getDireccion_proveedor() {
        return direccion_proveedor;
    }

    public String getTelefono_proveedor() {
        return telefono_proveedor;
    }

    public String getEmail_proveedor() {
        return email_proveedor;
    }

    public void setCedula_proveedor(int cedula_proveedor) {
        this.cedula_proveedor = cedula_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public void setDireccion_proveedor(String direccion_proveedor) {
        this.direccion_proveedor = direccion_proveedor;
    }

    public void setTelefono_proveedor(String telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }

    public void setEmail_proveedor(String email_proveedor) {
        this.email_proveedor = email_proveedor;
    }

}
