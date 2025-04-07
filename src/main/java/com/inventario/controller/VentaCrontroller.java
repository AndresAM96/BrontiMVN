/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.controller;

/**
 *
 * @author user
 */
import com.inventario.model.VentaModel;
import com.inventario.service.VentaService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brontisandwich")
public class VentaCrontroller {
    @Autowired
    private VentaService VentaService;    
    
    @GetMapping("/ventas")
    public ArrayList<VentaModel> getNombre(){
        return this.VentaService.getNombre();
        
    }
     
    @PostMapping("/ventas")
    public VentaModel saveUser(@RequestBody VentaModel ventas){
        return this.VentaService.saveUser(ventas); 
    }
      
    @GetMapping(path = "/ventas/{id_venta}")
    public Optional<VentaModel> getUserById(@PathVariable("id_venta") Long id){
        return this.VentaService.getById(id);    
    }
    
    @PutMapping(path = "/ventas/{id_venta}")
    public VentaModel updateById(@RequestBody VentaModel request ,@PathVariable("id_venta") long id){
        return this.VentaService.updateById(request, id);

    }
    @DeleteMapping(path = "/ventas/{id_venta}")
    public String deleteById(@PathVariable("id_venta") long id_venta){
        boolean ok = this.VentaService.deleteUser(id_venta);
        if (ok){
            return "La venta " + id_venta + " ha sido eliminado!";
        }else{
            return "Error, venta no encontrada";
        }
    }
}
