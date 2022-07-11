/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.Pantalones;
import com.example.demo.service.PantalonesService;
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
@RequestMapping("/api/pantalones")
public class PantalonesController {

    @Autowired
    PantalonesService pantalonesservice;

    @GetMapping("/lista")
    public ResponseEntity<List<Pantalones>> listar() {

        return new ResponseEntity<>(pantalonesservice.findByAll(), HttpStatus.OK);

    }

    @PostMapping("/crear")
    public ResponseEntity<Pantalones> crear(@RequestBody Pantalones p) {
        p.setCostoTotal(p.getCosto() * p.getCantidad());
        return new ResponseEntity<>(pantalonesservice.crear(p), HttpStatus.CREATED);

    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Pantalones> elimnar(@PathVariable String id) {
        pantalonesservice.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Pantalones> buscar(@PathVariable String id) {

        return new ResponseEntity<>(pantalonesservice.findByID(id), HttpStatus.OK);

    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Pantalones> actualizar(@PathVariable String id, @RequestBody Pantalones p) {

        Pantalones pan = buscarPantalones(id);
        if (pan == null) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
            try {

                pan.setMarca(p.getMarca());
                pan.setModelo(p.getModelo());
                pan.setFabricante(p.getFabricante());
                pan.setCosto(p.getCosto());
                pan.setCantidad(p.getCantidad());
                pan.setOrigen(p.getOrigen());
                pan.setCostoTotal(pan.getCantidad()* pan.getCosto());

                return new ResponseEntity<>(pantalonesservice.crear(pan), HttpStatus.CREATED);

            } catch (Exception e) {

                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

            }

        }

    }

    public Pantalones buscarPantalones(String id) {

        return pantalonesservice.findByID(id);

    }
}
