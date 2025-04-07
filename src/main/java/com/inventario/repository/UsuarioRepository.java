/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bronti.API.repositories;

import com.bronti.API.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author user
 */
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
    
}
