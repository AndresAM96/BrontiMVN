/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.controller;

/**
 *
 * @author user
 */
import com.inventario.model.ClienteModel;
import com.inventario.service.ClienteService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brontisandwich")
public class ClienteController {
    @Autowired
    private ClienteService ClienteService;    
    
    @GetMapping("/clientes")
    public ArrayList<ClienteModel> getNombre(){
        return this.ClienteService.getNombre();
        
    }
     
    @PostMapping("/clientes")
    public ClienteModel saveUser(@RequestBody ClienteModel clientes){
        return this.ClienteService.saveUser(clientes); 
    }
      
    @GetMapping(path = "/clientes/{cedula_cliente}")
    public Optional<ClienteModel> getUserById(@PathVariable("cedula_cliente") Long id){
        return this.ClienteService.getById(id);    
    }
    
    @PutMapping(path = "/clientes/{cedula_cliente}")
    public ClienteModel updateById(@RequestBody ClienteModel request ,@PathVariable("cedula_cliente") long id){
        return this.ClienteService.updateById(request, id);

    }
    @DeleteMapping(path = "/clientes/{cedula_cliente}")
    public String deleteById(@PathVariable("cedula_cliente") long cedula_cliente){
        boolean ok = this.ClienteService.deleteUser(cedula_cliente);
        if (ok){
            return "El cliente " + cedula_cliente + " ha sido eliminado!";
        }else{
            return "Error, cliente no encontrado";
        }
    }
}
