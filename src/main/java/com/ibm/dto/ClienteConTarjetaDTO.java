/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.dto;

import com.ibm.entities.Cliente;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author JesusArmando
 */
public class ClienteConTarjetaDTO implements Serializable {

    private Integer id;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String telefono;
    private List<TarjetaDTO> tarjetaList;

    public ClienteConTarjetaDTO(Integer id, String nombre, String direccion, String ciudad, String telefono, List<TarjetaDTO> tarjetaList) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.tarjetaList = tarjetaList;
    }

    public ClienteConTarjetaDTO() {
    }

    public ClienteConTarjetaDTO(Cliente cliente) {
        this.ciudad = cliente.getCiudad();
        this.direccion = cliente.getDireccion();
        this.id = cliente.getId();
        this.nombre = cliente.getNombre();
        this.telefono = cliente.getTelefono();
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<TarjetaDTO> getTarjetaList() {
        return tarjetaList;
    }

    public void setTarjetaList(List<TarjetaDTO> tarjetaList) {
        this.tarjetaList = tarjetaList;
    }

}
