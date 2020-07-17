/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER
 */
@Entity
@Table(catalog = "tienda", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orden.findAll", query = "SELECT o FROM Orden o")
    , @NamedQuery(name = "Orden.findByIdorden", query = "SELECT o FROM Orden o WHERE o.idorden = :idorden")
    , @NamedQuery(name = "Orden.findByCantidad", query = "SELECT o FROM Orden o WHERE o.cantidad = :cantidad")
    , @NamedQuery(name = "Orden.findByFecha", query = "SELECT o FROM Orden o WHERE o.fecha = :fecha")})
public class Orden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idorden;
    private Integer cantidad;
    @Size(max = 50)
    @Column(length = 50)
    private String fecha;
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto", nullable = false)
    @ManyToOne(optional = false)
    private Producto idproducto;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente", nullable = false)
    @ManyToOne(optional = false)
    private Cliente idcliente;

    public Orden() {
    }

    public Orden(Integer idorden) {
        this.idorden = idorden;
    }

    public Integer getIdorden() {
        return idorden;
    }

    public void setIdorden(Integer idorden) {
        this.idorden = idorden;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Producto getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Producto idproducto) {
        this.idproducto = idproducto;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idorden != null ? idorden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orden)) {
            return false;
        }
        Orden other = (Orden) object;
        if ((this.idorden == null && other.idorden != null) || (this.idorden != null && !this.idorden.equals(other.idorden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.entity.Orden[ idorden=" + idorden + " ]";
    }
    
}
