/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Gps;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface GpsService {

    public Gps crear(Gps g);

    public Gps findByID(String id);

    public List<Gps> findByAll();

    public void delete(String id);
}
