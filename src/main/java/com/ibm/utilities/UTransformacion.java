/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.utilities;

import com.ibm.dto.AsesorDTO;
import com.ibm.dto.ClienteDTO;
import com.ibm.dto.ConsumoDTO;
import com.ibm.dto.TarjetaDTO;
import com.ibm.entities.Asesor;
import com.ibm.entities.Cliente;
import com.ibm.entities.Consumo;
import com.ibm.entities.Tarjeta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JesusArmando
 */
public class UTransformacion {

    public static List<ClienteDTO> clienteListToClienteDtoList(List<Cliente> list) {
        List<ClienteDTO> dtoList = new ArrayList<>();
        for (Cliente element : list) {
            ClienteDTO aux = new ClienteDTO(element);
            dtoList.add(aux);
        }
        return dtoList;
    }

    public static List<ConsumoDTO> consumoListToConsumoDtoList(List<Consumo> list) {
        List<ConsumoDTO> dtoList = new ArrayList<>();
        for (Consumo element : list) {
            ConsumoDTO aux = new ConsumoDTO(element);
            dtoList.add(aux);
        }
        return dtoList;
    }

    public static List<TarjetaDTO> tarjetaListToTarjetaDtoList(List<Tarjeta> list) {
        List<TarjetaDTO> dtoList = new ArrayList<>();
        for (Tarjeta element : list) {
            TarjetaDTO aux = new TarjetaDTO(element);
            dtoList.add(aux);
        }
        return dtoList;
    }

    public static List<AsesorDTO> asesorListToAsesorDtoList(List<Asesor> list) {
        List<AsesorDTO> dtoList = new ArrayList<>();
        for (Asesor element : list) {
            AsesorDTO aux = new AsesorDTO(element);
            dtoList.add(aux);
        }
        return dtoList;
    }
}
