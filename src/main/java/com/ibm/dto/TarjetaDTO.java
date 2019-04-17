/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.dto;

import com.ibm.entities.Tarjeta;
import java.io.Serializable;

/**
 *
 * @author JesusArmando
 */
public class TarjetaDTO implements Serializable{
    private Integer id;
    private String numero;
    private String ccv;
    private String tipo;

    public TarjetaDTO(Integer id, String numero, String ccv, String tipo) {
        this.id = id;
        this.numero = numero;
        this.ccv = ccv;
        this.tipo = tipo;
    }

    public TarjetaDTO() {
    }
    
    public TarjetaDTO(Tarjeta tarjeta) {
        this.ccv = tarjeta.getCcv();
        this.id = tarjeta.getId();
        this.numero = tarjeta.getNumero();
        this.tipo = tarjeta.getTipo();
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
}
