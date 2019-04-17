/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.dto;

import com.ibm.entities.Consumo;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author JesusArmando
 */
public class ConsumoDTO implements Serializable {

    private Integer id;
    private String descripcion;
    private String monto;
    private Date fecha;

    public ConsumoDTO() {
    }

    public ConsumoDTO(Consumo consumo) {
        this.descripcion = consumo.getDescripcion();
        this.fecha = consumo.getFecha();
        this.id = consumo.getId();
        this.monto = consumo.getMonto();
    }

    public ConsumoDTO(Integer id, String descripcion, String monto, Date fecha) {
        this.id = id;
        this.descripcion = descripcion;
        this.monto = monto;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
