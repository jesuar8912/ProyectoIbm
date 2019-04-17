/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.entities;

import com.ibm.dto.AsesorDTO;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JesusArmando
 */
@Entity
@Table(name = "asesor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asesor.findAll", query = "SELECT a FROM Asesor a")
    , @NamedQuery(name = "Asesor.updateNombre", query = "UPDATE Asesor a SET a.nombre = :nombre WHERE a.id = :id")
    , @NamedQuery(name = "Asesor.updateEspecialidad", query = "UPDATE Asesor a SET a.especialidad = :especialidad WHERE a.id = :id")
    , @NamedQuery(name = "Asesor.findById", query = "SELECT a FROM Asesor a WHERE a.id = :id")
    , @NamedQuery(name = "Asesor.findByNombre", query = "SELECT a FROM Asesor a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Asesor.findByEspecialidad", query = "SELECT a FROM Asesor a WHERE a.especialidad = :especialidad")})
public class Asesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "especialidad")
    private String especialidad;

    public Asesor() {
    }

    public Asesor(AsesorDTO dto) {
        this.especialidad = dto.getEspecialidad();
        this.id = dto.getId();
        this.nombre = dto.getNombre();
    }

    public Asesor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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
        if (!(object instanceof Asesor)) {
            return false;
        }
        Asesor other = (Asesor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibm.controller.Asesor[ id=" + id + " ]";
    }

}
