/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Gps;
import com.example.demo.repository.GpsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class GpsServiceImpl implements GpsService {

    @Autowired//Cree como un objeto referencial
    private GpsRepository gpsrepository;

    @Override
    public Gps crear(Gps g) {
        return gpsrepository.save(g);
    }

    @Override
    public Gps findByID(String id) {
        return gpsrepository.findById(id).orElse(null);
    }

    @Override
    public List<Gps> findByAll() {
        return gpsrepository.findAll();
    }

    @Override
    public void delete(String id) {
        gpsrepository.deleteById(id);
    }

}
