/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.entities;

import com.ibm.dto.TarjetaDTO;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JesusArmando
 */
@Entity
@Table(name = "tarjeta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarjeta.findAll", query = "SELECT t FROM Tarjeta t")
    , @NamedQuery(name = "Tarjeta.findByCliente", query = "SELECT t FROM Tarjeta t  WHERE t.clienteid = :clid")
    , @NamedQuery(name = "Tarjeta.updateTipo", query = "UPDATE Tarjeta t SET t.tipo = :tipo WHERE t.id = :id")
    , @NamedQuery(name = "Tarjeta.updateNumero", query = "UPDATE Tarjeta t SET t.numero = :numero WHERE t.id = :id")
    , @NamedQuery(name = "Tarjeta.updateCcv", query = "UPDATE Tarjeta t SET t.ccv = :ccv WHERE t.id = :id")
    , @NamedQuery(name = "Tarjeta.findById", query = "SELECT t FROM Tarjeta t WHERE t.id = :id")
    , @NamedQuery(name = "Tarjeta.findByNumero", query = "SELECT t FROM Tarjeta t WHERE t.numero = :numerotarjeta")
    , @NamedQuery(name = "Tarjeta.findByCcv", query = "SELECT t FROM Tarjeta t WHERE t.ccv = :ccv")
    , @NamedQuery(name = "Tarjeta.findByTipo", query = "SELECT t FROM Tarjeta t WHERE t.tipo = :tipo")})
public class Tarjeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 16)
    @Column(name = "numero")
    private String numero;
    @Size(max = 4)
    @Column(name = "ccv")
    private String ccv;
    @Size(max = 50)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(mappedBy = "tarjetaid")
    private Collection<Consumo> consumoCollection;
    @JoinColumn(name = "clienteid", referencedColumnName = "id")
    @ManyToOne
    private Cliente clienteid;

    public Tarjeta() {
    }

    public Tarjeta(Integer id) {
        this.id = id;
    }

    public Tarjeta(TarjetaDTO dto) {
        this.ccv = dto.getCcv();
        this.id = dto.getId();
        this.numero = dto.getNumero();
        this.tipo = dto.getTipo();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<Consumo> getConsumoCollection() {
        return consumoCollection;
    }

    public void setConsumoCollection(Collection<Consumo> consumoCollection) {
        this.consumoCollection = consumoCollection;
    }

    public Cliente getClienteid() {
        return clienteid;
    }

    public void setClienteid(Cliente clienteid) {
        this.clienteid = clienteid;
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
        if (!(object instanceof Tarjeta)) {
            return false;
        }
        Tarjeta other = (Tarjeta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibm.controller.Tarjeta[ id=" + id + " ]";
    }

}
