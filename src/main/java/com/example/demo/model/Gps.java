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
@Table(name = "gps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gps.findAll", query = "SELECT g FROM Gps g"),
    @NamedQuery(name = "Gps.findByImei", query = "SELECT g FROM Gps g WHERE g.imei = :imei"),
    @NamedQuery(name = "Gps.findByEquipo", query = "SELECT g FROM Gps g WHERE g.equipo = :equipo"),
    @NamedQuery(name = "Gps.findByNumeroChip", query = "SELECT g FROM Gps g WHERE g.numeroChip = :numeroChip"),
    @NamedQuery(name = "Gps.findBySerie", query = "SELECT g FROM Gps g WHERE g.serie = :serie"),
    @NamedQuery(name = "Gps.findByCosto", query = "SELECT g FROM Gps g WHERE g.costo = :costo"),
    @NamedQuery(name = "Gps.findByObservacion", query = "SELECT g FROM Gps g WHERE g.observacion = :observacion")})
public class Gps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "imei")
    private Integer imei;
    @Basic(optional = false)
    @Column(name = "equipo")
    private String equipo;
    @Basic(optional = false)
    @Column(name = "numero_chip")
    private String numeroChip;
    @Basic(optional = false)
    @Column(name = "serie")
    private String serie;
    @Basic(optional = false)
    @Column(name = "costo")
    private float costo;
    @Basic(optional = false)
    @Column(name = "observacion")
    private String observacion;

    public Gps() {
    }

    public Gps(Integer imei) {
        this.imei = imei;
    }

    public Gps(Integer imei, String equipo, String numeroChip, String serie, float costo, String observacion) {
        this.imei = imei;
        this.equipo = equipo;
        this.numeroChip = numeroChip;
        this.serie = serie;
        this.costo = costo;
        this.observacion = observacion;
    }

    public Integer getImei() {
        return imei;
    }

    public void setImei(Integer imei) {
        this.imei = imei;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getNumeroChip() {
        return numeroChip;
    }

    public void setNumeroChip(String numeroChip) {
        this.numeroChip = numeroChip;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imei != null ? imei.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gps)) {
            return false;
        }
        Gps other = (Gps) object;
        if ((this.imei == null && other.imei != null) || (this.imei != null && !this.imei.equals(other.imei))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.model.Gps[ imei=" + imei + " ]";
    }
    
}
