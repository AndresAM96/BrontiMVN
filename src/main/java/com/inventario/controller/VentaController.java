package com.inventario.controller;

import com.inventario.model.VentaModel;
import com.inventario.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/brontisandwich")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping("/ventas")
    public ArrayList<VentaModel> getNombre() {
        return this.ventaService.getNombre();
    }

    @PostMapping("/ventas")
    public VentaModel saveUser(@RequestBody VentaModel movimientos) {
        return this.ventaService.saveUser(movimientos);
    }

    @GetMapping(path = "/ventas/{id_venta}")
    public Optional<VentaModel> getUserById(@PathVariable("id_venta") Long id) {
        return this.ventaService.getById(id);
    }

    @PutMapping(path = "/ventas/{id_venta}")
    public VentaModel updateById(@RequestBody VentaModel request, @PathVariable("id_venta") long id) {
        return this.ventaService.updateById(request, id);
    }

    @DeleteMapping(path = "/ventas/{id_venta}")
    public String deleteById(@PathVariable("id_venta") long id) {
        boolean ok = this.ventaService.deleteUser(id);
        if (ok) {
            return "La venta " + id + " ha sido eliminada!";
        } else {
            return "Error, venta no encontrada";
        }
    }
}