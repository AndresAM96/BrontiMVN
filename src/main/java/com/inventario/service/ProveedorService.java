/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.service;

/**
 *
 * @author user
 */
import com.inventario.model.ProveedorModel;
import com.inventario.repository.IProveedorRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorService {
     @Autowired  
    IProveedorRepository proveedorRepository;   
    public ArrayList<ProveedorModel> getNombre(){
        return(ArrayList<ProveedorModel>) proveedorRepository.findAll();
    }
    
    public ProveedorModel saveUser (ProveedorModel proveedores){
        return proveedorRepository.save(proveedores);
    }
    
    public Optional<ProveedorModel> getById(Long id){
        return proveedorRepository.findById(id);
    }
    
    public ProveedorModel updateById(ProveedorModel request, long id){
        ProveedorModel ProveedorModel = proveedorRepository.findById(id).get();
                
        ProveedorModel.setNombre_proveedor(request.getNombre_proveedor());
        ProveedorModel.setDireccion_proveedor(request.getDireccion_proveedor());
        ProveedorModel.setTelefono_proveedor(request.getTelefono_proveedor());
        ProveedorModel.setEmail_proveedor(request.getEmail_proveedor());
        proveedorRepository.save(ProveedorModel);
        return ProveedorModel;
    }
    
    public Boolean deleteUser (Long id){
        try{
            proveedorRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
