/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "pantalones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pantalones.findAll", query = "SELECT p FROM Pantalones p"),
    @NamedQuery(name = "Pantalones.findByCodigo", query = "SELECT p FROM Pantalones p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Pantalones.findByMarca", query = "SELECT p FROM Pantalones p WHERE p.marca = :marca"),
    @NamedQuery(name = "Pantalones.findByModelo", query = "SELECT p FROM Pantalones p WHERE p.modelo = :modelo"),
    @NamedQuery(name = "Pantalones.findByFabricante", query = "SELECT p FROM Pantalones p WHERE p.fabricante = :fabricante"),
    @NamedQuery(name = "Pantalones.findByCosto", query = "SELECT p FROM Pantalones p WHERE p.costo = :costo"),
    @NamedQuery(name = "Pantalones.findByCantidad", query = "SELECT p FROM Pantalones p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "Pantalones.findByOrigen", query = "SELECT p FROM Pantalones p WHERE p.origen = :origen"),
    @NamedQuery(name = "Pantalones.findByCostoTotal", query = "SELECT p FROM Pantalones p WHERE p.costoTotal = :costoTotal")})
public class Pantalones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @Column(name = "fabricante")
    private String fabricante;
    @Basic(optional = false)
    @Column(name = "costo")
    private float costo;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "origen")
    private String origen;
    @Basic(optional = false)
    @Column(name = "costo_total")
    private float costoTotal;

    public Pantalones() {
    }

    public Pantalones(String codigo) {
        this.codigo = codigo;
    }

    public Pantalones(String codigo, String marca, String modelo, String fabricante, float costo, int cantidad, String origen, float costoTotal) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.costo = costo;
        this.cantidad = cantidad;
        this.origen = origen;
        this.costoTotal = costoTotal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public float getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pantalones)) {
            return false;
        }
        Pantalones other = (Pantalones) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.model.Pantalones[ codigo=" + codigo + " ]";
    }
    
}
