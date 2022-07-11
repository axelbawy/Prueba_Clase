/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Zapatos;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface ZapatosService {

    public Zapatos crear(Zapatos z);

    public Zapatos findByID(String id);

    public List<Zapatos> findByAll();

    public void delete(String id);
}
