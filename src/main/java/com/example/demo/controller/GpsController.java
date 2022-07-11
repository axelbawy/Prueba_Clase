/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.Gps;
import com.example.demo.service.GpsService;
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
@RequestMapping("/api/gps")
public class GpsController {

    @Autowired
    GpsService gpsservice;

    @GetMapping("/lista")
    public ResponseEntity<List<Gps>> listar() {

        return new ResponseEntity<>(gpsservice.findByAll(), HttpStatus.OK);

    }

    @PostMapping("/crear")
    public ResponseEntity<Gps> crear(@RequestBody Gps g) {
        return new ResponseEntity<>(gpsservice.crear(g), HttpStatus.CREATED);

    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Gps> elimnar(@PathVariable String id) {
        gpsservice.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Gps> buscar(@PathVariable String id) {

        return new ResponseEntity<>(gpsservice.findByID(id), HttpStatus.OK);

    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Gps> actualizar(@PathVariable String id, @RequestBody Gps g) {

        Gps gp = buscarGps(id);
        if (gp == null) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
            try {

                gp.setEquipo(g.getEquipo());
                gp.setNumeroChip(g.getNumeroChip());
                gp.setSerie(g.getSerie());
                gp.setCosto(g.getCosto());
                gp.setObservacion(g.getObservacion());

                return new ResponseEntity<>(gpsservice.crear(gp), HttpStatus.CREATED);

            } catch (Exception e) {

                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

            }

        }

    }

    public Gps buscarGps(String id) {

        return gpsservice.findByID(id);

    }
}
