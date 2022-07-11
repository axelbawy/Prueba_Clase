/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Casas;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface CasasService {

    public Casas crear(Casas c);

    public Casas findByID(String id);

    public List<Casas> findByAll();

    public void delete(String id);
}
