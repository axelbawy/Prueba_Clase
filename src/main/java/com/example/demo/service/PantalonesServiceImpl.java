/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Pantalones;
import com.example.demo.repository.PantalonesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class PantalonesServiceImpl implements PantalonesService{

        @Autowired//Cree como un objeto referencial
    private PantalonesRepository pantalonesrepository;
    
    @Override
    public Pantalones crear(Pantalones p) {
        return pantalonesrepository.save(p);
    }

    @Override
    public Pantalones findByID(String id) {
        return pantalonesrepository.findById(id).orElse(null);
    }

    @Override
    public List<Pantalones> findByAll() {
        return pantalonesrepository.findAll();
    }

    @Override
    public void delete(String id) {
        pantalonesrepository.deleteById(id);
    }
    
}
