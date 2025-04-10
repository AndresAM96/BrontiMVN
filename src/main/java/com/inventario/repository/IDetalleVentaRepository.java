package com.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventario.model.DetalleVentaModel;

@Repository
public interface IDetalleVentaRepository extends JpaRepository<DetalleVentaModel, Integer> {
}