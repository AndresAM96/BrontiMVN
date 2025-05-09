package com.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventario.model.VentaModel;

@Repository
public interface IVentaRepository extends JpaRepository<VentaModel, Long> {

}