/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.service;

/**
 *
 * @author user
 */
import com.inventario.model.ClienteModel;
import com.inventario.repository.IClienteRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
         @Autowired  
    IClienteRepository clienteRepository;   
    public ArrayList<ClienteModel> getNombre(){
        return(ArrayList<ClienteModel>) clienteRepository.findAll();
    }
    
    public ClienteModel saveUser (ClienteModel clientes){
        return clienteRepository.save(clientes);
    }
    
    public Optional<ClienteModel> getById(Long id){
        return clienteRepository.findById(id);
    }
    
    public ClienteModel updateById(ClienteModel request, long id){
        ClienteModel ClienteModel = clienteRepository.findById(id).get();
                
        ClienteModel.setNombre_cliente(request.getNombre_cliente());
        ClienteModel.setDireccion_cliente(request.getDireccion_cliente());
        ClienteModel.setTelefono_cliente(request.getTelefono_cliente());
        ClienteModel.setEmail_cliente(request.getEmail_cliente());
        clienteRepository.save(ClienteModel);
        return ClienteModel;
    }
    
    public Boolean deleteUser (Long id){
        try{
            clienteRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
