/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Zapatos;
import com.example.demo.repository.ZapatosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class ZapatosServiceImpl implements ZapatosService {

    @Autowired//Cree como un objeto referencial
    private ZapatosRepository zapatosrepository;

    @Override
    public Zapatos crear(Zapatos z) {
        return zapatosrepository.save(z);
    }

    @Override
    public Zapatos findByID(String id) {
        return zapatosrepository.findById(id).orElse(null);
    }

    @Override
    public List<Zapatos> findByAll() {
        return zapatosrepository.findAll();
    }

    @Override
    public void delete(String id) {
        zapatosrepository.deleteById(id);
    }

}
