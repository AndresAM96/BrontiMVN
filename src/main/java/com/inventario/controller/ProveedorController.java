/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bronti.API.controllers;

/**
 *
 * @author user
 */
import com.bronti.API.models.ProveedorModel;
import com.bronti.API.services.ProveedorService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brontisandwich")
public class ProveedorController {
    @Autowired
    private ProveedorService ProveedorService;    
    
    @GetMapping("/proveedores")
    public ArrayList<ProveedorModel> getNombre(){
        return this.ProveedorService.getNombre();
        
    }
     
    @PostMapping("/proveedores")
    public ProveedorModel saveUser(@RequestBody ProveedorModel proveedores){
        return this.ProveedorService.saveUser(proveedores); 
    }
      
    @GetMapping(path = "/proveedores/{cedula_proveedor}")
    public Optional<ProveedorModel> getUserById(@PathVariable("cedula_proveedor") Long id){
        return this.ProveedorService.getById(id);    
    }
    
    @PutMapping(path = "/proveedores/{cedula_proveedor}")
    public ProveedorModel updateById(@RequestBody ProveedorModel request ,@PathVariable("cedula_proveedor") long id){
        return this.ProveedorService.updateById(request, id);

    }
    @DeleteMapping(path = "/proveedores/{cedula_proveedor}")
    public String deleteById(@PathVariable("cedula_proveedor") long cedula_proveedor){
        boolean ok = this.ProveedorService.deleteUser(cedula_proveedor);
        if (ok){
            return "El proveedor " + cedula_proveedor + " ha sido eliminado!";
        }else{
            return "Error, proveedor no encontrado";
        }
    }
}
