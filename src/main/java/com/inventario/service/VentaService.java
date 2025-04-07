/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.service;

/**
 *
 * @author user
 */

import com.inventario.model.VentaModel;
import com.inventario.model.ProductoModel;
import com.inventario.model.UsuarioModel;
import com.inventario.repository.IVentaRepository;
import com.inventario.repository.ProductoRepository;
import com.inventario.repository.UsuarioRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService {
        @Autowired
    IVentaRepository ventaRepository;
    @Autowired
    private ProductoRepository productoRepository;  // Repositorio para Producto

    @Autowired
    private UsuarioRepository userRepository;  // Repositorio para Usuario

    public ArrayList<VentaModel> getNombre(){
        return (ArrayList<VentaModel>) ventaRepository.findAll();
    }

    public VentaModel saveUser(VentaModel movimientos){
        
        if (movimientos.getFecha() == null) {
        movimientos.setFecha(LocalDateTime.now());
        }
        
        // Obtener las entidades relacionadas desde la base de datos
        ProductoModel producto = productoRepository.findById(movimientos.getProducto().getId_producto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        UsuarioModel usuario = userRepository.findById(movimientos.getUsuario().getCedula_usuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Asignar las entidades al movimiento
        movimientos.setProducto(producto);
        movimientos.setUsuario(usuario);

        // Guardar el movimiento con las entidades completas
        return ventaRepository.save(movimientos);
        
         
        
    }
    
    public Optional<VentaModel> getById(Long id){
        return ventaRepository.findById(id);
    }

    public VentaModel updateById(VentaModel request, long id) {
    VentaModel VentaModel = ventaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Venta no encontrado con ID: " + id));
    VentaModel.setNombre(request.getNombre());
    VentaModel.setTipo_factura(request.getTipo_factura());
    VentaModel.setForma_pago(request.getForma_pago());
    if (request.getFecha() != null) {
        VentaModel.setFecha(request.getFecha());
    }
    VentaModel.setDescripcion(request.getDescripcion());
    VentaModel.setDescuento(request.getDescuento());
    ProductoModel producto = productoRepository.findById(request.getProducto().getId_producto())
            .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + request.getProducto().getId_producto()));
    UsuarioModel usuario = userRepository.findById(request.getUsuario().getCedula_usuario())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + request.getUsuario().getCedula_usuario()));
    VentaModel.setProducto(producto);
    VentaModel.setUsuario(usuario);
        ventaRepository.save(VentaModel);
        return VentaModel;
    }

    public Boolean deleteUser (Long id){
        try{
            ventaRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
