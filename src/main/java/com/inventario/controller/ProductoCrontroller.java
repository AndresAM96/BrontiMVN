/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.controller;

/**
 *
 * @author user
 */
import com.inventario.model.ProductoModel;
import com.inventario.service.ProductoService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brontisandwich")
public class ProductoCrontroller {
    @Autowired
    private ProductoService ProductoService;    
    
    @GetMapping("/productos")
    public ArrayList<ProductoModel> getNombre(){
        return this.ProductoService.getNombre();
        
    }
     
    @PostMapping("/productos")
    public ProductoModel saveUser(@RequestBody ProductoModel productos){
        return this.ProductoService.saveUser(productos); 
    }
      
    @GetMapping(path = "/productos/{id_producto}")
    public Optional<ProductoModel> getUserById(@PathVariable("id_producto") Long id){
        return this.ProductoService.getById(id);    
    }
    
    @PutMapping(path = "/productos/{id_producto}")
    public ProductoModel updateById(@RequestBody ProductoModel request ,@PathVariable("id_producto") long id){
        return this.ProductoService.updateById(request, id);

    }
    @DeleteMapping(path = "/productos/{id_producto}")
    public String deleteById(@PathVariable("id_producto") long id_producto){
        boolean ok = this.ProductoService.deleteUser(id_producto);
        if (ok){
            return "El producto " + id_producto + " ha sido eliminado!";
        }else{
            return "Error, producto no encontrado";
        }
    }
}
