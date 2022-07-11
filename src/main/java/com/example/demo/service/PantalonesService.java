/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Pantalones;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface PantalonesService {

    public Pantalones crear(Pantalones p);

    public Pantalones findByID(String id);

    public List<Pantalones> findByAll();

    public void delete(String id);
}
