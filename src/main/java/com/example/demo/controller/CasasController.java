/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.Casas;
import com.example.demo.service.CasasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/api/casas")
public class CasasController {

    private float costoKM=(float) 10;
    
    @Autowired
    CasasService casasservice;

    @GetMapping("/lista")
    public ResponseEntity<List<Casas>> listar() {

        return new ResponseEntity<>(casasservice.findByAll(), HttpStatus.OK);

    }

    @PostMapping("/crear")
    public ResponseEntity<Casas> crear(@RequestBody Casas c) {
        c.setCostoTotal(costoKM*c.getArea());
        return new ResponseEntity<>(casasservice.crear(c), HttpStatus.CREATED);

    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Casas> elimnar(@PathVariable String id) {
        casasservice.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Casas> buscar(@PathVariable String id) {

        return new ResponseEntity<>(casasservice.findByID(id), HttpStatus.OK);

    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Casas> actualizar(@PathVariable String id, @RequestBody Casas c) {

        Casas cas = buscarCasas(id);
        if (cas == null) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
            try {

                cas.setPropietario(c.getPropietario());
                cas.setArea(c.getArea());
                cas.setTipoTerreno(c.getTipoTerreno());
                cas.setCostoTotal(cas.getArea()*costoKM);
                
                return new ResponseEntity<>(casasservice.crear(cas), HttpStatus.CREATED);

            } catch (Exception e) {

                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

            }

        }

    }

    public Casas buscarCasas(String id) {

        return casasservice.findByID(id);

    }
}
