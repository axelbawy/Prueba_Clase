/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.Zapatos;
import com.example.demo.service.ZapatosService;
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
@RequestMapping("/api/zapatos")
public class ZapatosController {
    
    
    @Autowired
    ZapatosService zapatosservice;

    @GetMapping("/lista")
    public ResponseEntity<List<Zapatos>> listar() {

        return new ResponseEntity<>(zapatosservice.findByAll(), HttpStatus.OK);

    }

    @PostMapping("/crear")
    public ResponseEntity<Zapatos> crear(@RequestBody Zapatos z) {
        z.setCostoTotal(z.getCantidad()*z.getCosto());
        return new ResponseEntity<>(zapatosservice.crear(z), HttpStatus.CREATED);

    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Zapatos> elimnar(@PathVariable String id) {
        zapatosservice.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Zapatos> buscar(@PathVariable String id) {

        return new ResponseEntity<>(zapatosservice.findByID(id), HttpStatus.OK);

    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Zapatos> actualizar(@PathVariable String id, @RequestBody Zapatos z) {

        Zapatos zap = buscarZapatos(id);
        if (zap == null) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
            try {

                zap.setMarca(z.getMarca());
                zap.setCosto(z.getCosto());
                zap.setCantidad(z.getCantidad());
                zap.setCostoTotal(zap.getCantidad()*zap.getCosto());
                
                return new ResponseEntity<>(zapatosservice.crear(zap), HttpStatus.CREATED);

            } catch (Exception e) {

                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

            }

        }

    }

    public Zapatos buscarZapatos(String id) {

        return zapatosservice.findByID(id);

    }
}
