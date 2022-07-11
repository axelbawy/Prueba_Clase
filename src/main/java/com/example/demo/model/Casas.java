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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "casas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Casas.findAll", query = "SELECT c FROM Casas c"),
    @NamedQuery(name = "Casas.findByCodigo", query = "SELECT c FROM Casas c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Casas.findByPropietario", query = "SELECT c FROM Casas c WHERE c.propietario = :propietario"),
    @NamedQuery(name = "Casas.findByArea", query = "SELECT c FROM Casas c WHERE c.area = :area"),
    @NamedQuery(name = "Casas.findByTipoTerreno", query = "SELECT c FROM Casas c WHERE c.tipoTerreno = :tipoTerreno"),
    @NamedQuery(name = "Casas.findByCostoTotal", query = "SELECT c FROM Casas c WHERE c.costoTotal = :costoTotal")})
public class Casas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "propietario")
    private String propietario;
    @Basic(optional = false)
    @Column(name = "area")
    private float area;
    @Basic(optional = false)
    @Column(name = "tipo_terreno")
    private String tipoTerreno;
    @Basic(optional = false)
    @Column(name = "costo_total")
    private float costoTotal;


    
    public Casas() {
    }

    public Casas(String codigo) {
        this.codigo = codigo;
    }

    public Casas(String codigo, String propietario, float area, String tipoTerreno, float costoTotal) {
        this.codigo = codigo;
        this.propietario = propietario;
        this.area = area;
        this.tipoTerreno = tipoTerreno;
        this.costoTotal = costoTotal;
    }
 
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public String getTipoTerreno() {
        return tipoTerreno;
    }

    public void setTipoTerreno(String tipoTerreno) {
        this.tipoTerreno = tipoTerreno;
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
        if (!(object instanceof Casas)) {
            return false;
        }
        Casas other = (Casas) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.model.Casas[ codigo=" + codigo + " ]";
    }
    
}
