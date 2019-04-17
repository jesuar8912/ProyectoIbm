/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.dao;

import com.ibm.dto.ClienteConTarjetaDTO;
import com.ibm.dto.TarjetaDTO;
import com.ibm.entities.Cliente;
import com.ibm.entities.Tarjeta;
import com.ibm.persistence.EntityManagerUtil;
import com.ibm.utilities.UTransformacion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author JesusArmando
 */
public class ClienteConTarjetaDAO {

    EntityManager em = EntityManagerUtil.getEntityManager();

    public List<ClienteConTarjetaDTO> buscarClientesConTarjetas() {
        em.getTransaction().begin();
        List<Cliente> ls = em.createNamedQuery("Cliente.findAll").getResultList();
        em.getTransaction().commit();
        List<ClienteConTarjetaDTO> clienteList = new ArrayList<>();
        for (Cliente cliente : ls) {
            em.getTransaction().begin();
            List<Tarjeta> lst = em.createNamedQuery("Tarjeta.findByCliente").setParameter("clid", cliente).getResultList();
            em.getTransaction().commit();
            List<TarjetaDTO> lstDTO = UTransformacion.tarjetaListToTarjetaDtoList(lst);
            cliente.setTarjetaCollection(lst);
            ClienteConTarjetaDTO clienteConTarjetaDto = new ClienteConTarjetaDTO(cliente);
            clienteConTarjetaDto.setTarjetaList(lstDTO);
            clienteList.add(clienteConTarjetaDto);
        }
        em.close();
        return clienteList;
    }
}
