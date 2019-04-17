/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author JesusArmando
 */
public class HistorialConsumoDTO implements Serializable {

    private ClienteDTO clienteDto;
    private TarjetaDTO tarjetaDto;
    private List<ConsumoDTO> listaConsumo;

    public HistorialConsumoDTO(ClienteDTO clienteDto, TarjetaDTO tarjetaDto, List<ConsumoDTO> listaConsumo) {
        this.clienteDto = clienteDto;
        this.tarjetaDto = tarjetaDto;
        this.listaConsumo = listaConsumo;
    }

    public HistorialConsumoDTO() {
    }

    public ClienteDTO getClienteDto() {
        return clienteDto;
    }

    public void setClienteDto(ClienteDTO clienteDto) {
        this.clienteDto = clienteDto;
    }

    public TarjetaDTO getTarjetaDto() {
        return tarjetaDto;
    }

    public void setTarjetaDto(TarjetaDTO tarjetaDto) {
        this.tarjetaDto = tarjetaDto;
    }

    public List<ConsumoDTO> getListaConsumo() {
        return listaConsumo;
    }

    public void setListaConsumo(List<ConsumoDTO> listaConsumo) {
        this.listaConsumo = listaConsumo;
    }
}
