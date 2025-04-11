package com.inventario.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.model.DetalleVentaModel;
import com.inventario.model.ProductoModel;
import com.inventario.model.UsuarioModel;
import com.inventario.model.VentaModel;
import com.inventario.repository.IDetalleVentaRepository;
import com.inventario.repository.IVentaRepository;
import com.inventario.repository.ProductoRepository;
import com.inventario.repository.UsuarioRepository;

@Service
public class VentaService {

    @Autowired
    private IVentaRepository ventaRepository;

    @Autowired
    private IDetalleVentaRepository detalleVentaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private UsuarioRepository userRepository;

    public ArrayList<VentaModel> getNombre() {
        return (ArrayList<VentaModel>) ventaRepository.findAll();
    }

    public VentaModel saveUser(VentaModel movimientos) {
        if (movimientos.getFecha() == null) {
            movimientos.setFecha(LocalDateTime.now());
        }
    
        UsuarioModel usuario = userRepository.findById(movimientos.getUsuario().getCedula_usuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    
        movimientos.setUsuario(usuario);
    
        // Asignar los productos y vincular cada detalle con la venta
        for (DetalleVentaModel detalle : movimientos.getDetalles()) {
            ProductoModel producto = productoRepository.findById(detalle.getProducto().getId_producto())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    
            detalle.setProducto(producto);
            detalle.setVenta(movimientos); // Aquí lo importante
        }
    
        return ventaRepository.save(movimientos);
    }

    public Optional<VentaModel> getById(Long id) {
        return ventaRepository.findById(id);
    }

    public VentaModel updateById(VentaModel request, long id) {
        VentaModel ventaExistente = ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada con ID: " + id));

        ventaExistente.setNombre(request.getNombre());
        ventaExistente.setTipo_factura(request.getTipo_factura());
        ventaExistente.setForma_pago(request.getForma_pago());
        ventaExistente.setFecha(request.getFecha() != null ? request.getFecha() : LocalDateTime.now());
        ventaExistente.setDescripcion(request.getDescripcion());
        ventaExistente.setDescuento(request.getDescuento());

        UsuarioModel usuario = userRepository.findById(request.getUsuario().getCedula_usuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + request.getUsuario().getCedula_usuario()));
        ventaExistente.setUsuario(usuario);

        return ventaRepository.save(ventaExistente);
    }

    public Boolean deleteUser(Long id) {
        try {
            ventaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}