/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Casas;
import com.example.demo.repository.CasasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class CasasServiceImpl implements CasasService{

    @Autowired//Cree como un objeto referencial
    private CasasRepository casasrepository;
    
    @Override
    public Casas crear(Casas c) {
        return casasrepository.save(c);
    }

    @Override
    public Casas findByID(String id) {
        return casasrepository.findById(id).orElse(null);
    }

    @Override
    public List<Casas> findByAll() {
        return casasrepository.findAll();
    }

    @Override
    public void delete(String id) {
        casasrepository.deleteById(id);
    }

    
}
