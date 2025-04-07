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
@Table(name = "usuarios")

public class UsuarioModel {
    @Id
    @Column(name="cedula_usuario", nullable= false)
    private int cedula_usuario;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "contrasena", nullable = false)
    private String contrasena;
    
    @Column(name = "rol", nullable = false)
    private String rol;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<VentaModel> venta = new ArrayList<>();
    

    public int getCedula_usuario() {
        return cedula_usuario;
    }        
    
    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setVenta(List<VentaModel> venta) {
        this.venta = venta;
    }


    public void setCedula_usuario(int cedula_usuario) {
        this.cedula_usuario = cedula_usuario;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<VentaModel> getVenta() {
        return venta;
    }
}
