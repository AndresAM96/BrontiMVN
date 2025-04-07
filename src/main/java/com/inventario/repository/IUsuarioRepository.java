/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.inventario.repository;

/**
 *
 * @author user
 */
import com.inventario.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface IUsuarioRepository extends JpaRepository<UsuarioModel,Long> {
    
}
