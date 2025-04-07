/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bronti.API.controllers;

/**
 *
 * @author user
 */
import com.bronti.API.models.UsuarioModel;
import com.bronti.API.services.UsuarioService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brontisandwich")
public class UsuarioController {
    @Autowired
    private UsuarioService UsuarioService;    
    
    @GetMapping("/usuarios")
    public ArrayList<UsuarioModel> getNombre(){
        return this.UsuarioService.getNombre();
        
    }
     
    @PostMapping("/usuarios")
    public UsuarioModel saveUser(@RequestBody UsuarioModel usuarios){
        return this.UsuarioService.saveUser(usuarios); 
    }
      
    @GetMapping(path = "/usuarios/{cedula_usuario}")
    public Optional<UsuarioModel> getUserById(@PathVariable("cedula_usuario") Long id){
        return this.UsuarioService.getById(id);    
    }
    
    @PutMapping(path = "/usuarios/{cedula_usuario}")
    public UsuarioModel updateById(@RequestBody UsuarioModel request ,@PathVariable("cedula_usuario") long id){
        return this.UsuarioService.updateById(request, id);

    }
    @DeleteMapping(path = "/usuarios/{cedula_usuario}")
    public String deleteById(@PathVariable("cedula_usuario") long cedula_usuario){
        boolean ok = this.UsuarioService.deleteUser(cedula_usuario);
        if (ok){
            return "El usuario " + cedula_usuario + " ha sido eliminado!";
        }else{
            return "Error, usuario no encontrado";
        }
    }
}
