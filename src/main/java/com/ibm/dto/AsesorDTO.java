/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.dto;

import com.ibm.entities.Asesor;
import java.io.Serializable;

/**
 *
 * @author JesusArmando
 */
public class AsesorDTO implements Serializable {

    private Integer id;
    private String nombre;
    private String especialidad;

    public AsesorDTO(Integer id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public AsesorDTO() {
    }

    public AsesorDTO(Asesor asesor) {
        this.id = asesor.getId();
        this.especialidad = asesor.getEspecialidad();
        this.nombre = asesor.getNombre();
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
}
