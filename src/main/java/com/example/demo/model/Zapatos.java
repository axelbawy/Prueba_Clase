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
@Table(name = "zapatos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zapatos.findAll", query = "SELECT z FROM Zapatos z"),
    @NamedQuery(name = "Zapatos.findByCodigo", query = "SELECT z FROM Zapatos z WHERE z.codigo = :codigo"),
    @NamedQuery(name = "Zapatos.findByMarca", query = "SELECT z FROM Zapatos z WHERE z.marca = :marca"),
    @NamedQuery(name = "Zapatos.findByCosto", query = "SELECT z FROM Zapatos z WHERE z.costo = :costo"),
    @NamedQuery(name = "Zapatos.findByCantidad", query = "SELECT z FROM Zapatos z WHERE z.cantidad = :cantidad"),
    @NamedQuery(name = "Zapatos.findByCostoTotal", query = "SELECT z FROM Zapatos z WHERE z.costoTotal = :costoTotal")})
public class Zapatos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @Column(name = "costo")
    private float costo;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "costo_total")
    private float costoTotal;

    public Zapatos() {
    }

    public Zapatos(String codigo) {
        this.codigo = codigo;
    }

    public Zapatos(String codigo, String marca, float costo, int cantidad, float costoTotal) {
        this.codigo = codigo;
        this.marca = marca;
        this.costo = costo;
        this.cantidad = cantidad;
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
        if (!(object instanceof Zapatos)) {
            return false;
        }
        Zapatos other = (Zapatos) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.model.Zapatos[ codigo=" + codigo + " ]";
    }
    
}
