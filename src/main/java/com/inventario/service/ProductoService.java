/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bronti.API.services;

/**
 *
 * @author user
 */
import com.bronti.API.models.ProductoModel;
import com.bronti.API.repositories.IProductoRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
        @Autowired
    IProductoRepository IProductoRepository;
    public ArrayList<ProductoModel> getNombre(){
        return(ArrayList<ProductoModel>) IProductoRepository.findAll();
    }

    public ProductoModel saveUser (ProductoModel productos){
        return IProductoRepository.save(productos);
    }

    public Optional<ProductoModel> getById(Long id){
        return IProductoRepository.findById(id);
    }

    public ProductoModel updateById(ProductoModel request, long id){
        ProductoModel ProductoModel = IProductoRepository.findById(id).get();
        
        ProductoModel.setNombre_producto(request.getNombre_producto());
        ProductoModel.setDescripcion(request.getDescripcion());
        ProductoModel.setPrecio_venta(request.getPrecio_venta());
        ProductoModel.setPrecio_compra(request.getPrecio_compra());
        ProductoModel.setStock(request.getStock());
        ProductoModel.setStock_minimo(request.getStock_minimo());
        ProductoModel.setTipo_despacho(request.getTipo_despacho());
        ProductoModel.setVenta(request.getVenta());
        IProductoRepository.save(ProductoModel);
        return ProductoModel;
    }

    public Boolean deleteUser (Long id){
        try{
            IProductoRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
