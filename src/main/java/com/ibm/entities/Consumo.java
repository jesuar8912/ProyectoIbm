/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.entities;

import com.ibm.dto.ConsumoDTO;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JesusArmando
 */
@Entity
@Table(name = "consumo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consumo.findAll", query = "SELECT c FROM Consumo c")
    , @NamedQuery(name = "Consumo.findByTarjeta", query = "SELECT c FROM Consumo c WHERE c.tarjetaid = :tid")
    , @NamedQuery(name = "Consumo.updateMonto", query = "UPDATE Consumo c SET c.monto = :monto WHERE c.id = :id")
    , @NamedQuery(name = "Consumo.updateDescripcion", query = "UPDATE Consumo c SET c.descripcion = :descripcion WHERE c.id = :id")
    , @NamedQuery(name = "Consumo.updateFecha", query = "UPDATE Consumo c SET c.fecha = :fecha WHERE c.id = :id")
    , @NamedQuery(name = "Consumo.findById", query = "SELECT c FROM Consumo c WHERE c.id = :id")
    , @NamedQuery(name = "Consumo.findByFecha", query = "SELECT c FROM Consumo c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "Consumo.findByDescripcion", query = "SELECT c FROM Consumo c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Consumo.findByMonto", query = "SELECT c FROM Consumo c WHERE c.monto = :monto")})
public class Consumo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 12)
    @Column(name = "monto")
    private String monto;
    @JoinColumn(name = "tarjetaid", referencedColumnName = "id")
    @ManyToOne
    private Tarjeta tarjetaid;

    public Consumo() {
    }

    public Consumo(Integer id) {
        this.id = id;
    }

    public Consumo(ConsumoDTO dto) {

        this.descripcion = dto.getDescripcion();
        this.fecha = dto.getFecha();
        this.id = dto.getId();
        this.monto = dto.getMonto();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public Tarjeta getTarjetaid() {
        return tarjetaid;
    }

    public void setTarjetaid(Tarjeta tarjetaid) {
        this.tarjetaid = tarjetaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consumo)) {
            return false;
        }
        Consumo other = (Consumo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibm.controller.Consumo[ id=" + id + " ]";
    }

}
