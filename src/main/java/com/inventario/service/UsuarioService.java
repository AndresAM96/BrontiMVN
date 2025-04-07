/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bronti.API.services;

/**
 *
 * @author user
 */
import com.bronti.API.models.UsuarioModel;
import com.bronti.API.repositories.IUsuarioRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
     @Autowired  
    IUsuarioRepository usuarioRepository;   
    public ArrayList<UsuarioModel> getNombre(){
        return(ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }
    
    public UsuarioModel saveUser (UsuarioModel usuarios){
        return usuarioRepository.save(usuarios);
    }
    
    public Optional<UsuarioModel> getById(Long id){
        return usuarioRepository.findById(id);
    }
    
    public UsuarioModel updateById(UsuarioModel request, long id){
        UsuarioModel UsuarioModel = usuarioRepository.findById(id).get();
                
        UsuarioModel.setNombre(request.getNombre());
        UsuarioModel.setContrasena(request.getContrasena());
        UsuarioModel.setRol(request.getRol());
        usuarioRepository.save(UsuarioModel);
        return UsuarioModel;
    }
    
    public Boolean deleteUser (Long id){
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
