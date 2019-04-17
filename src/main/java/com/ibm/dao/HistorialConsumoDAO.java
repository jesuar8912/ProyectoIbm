/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.dao;

import com.ibm.dto.ClienteDTO;
import com.ibm.dto.HistorialConsumoDTO;
import com.ibm.dto.TarjetaDTO;
import com.ibm.entities.Cliente;
import com.ibm.entities.Consumo;
import com.ibm.entities.Tarjeta;
import com.ibm.persistence.EntityManagerUtil;
import com.ibm.utilities.UTransformacion;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author JesusArmando
 */
public class HistorialConsumoDAO {

    EntityManager em = EntityManagerUtil.getEntityManager();

    public HistorialConsumoDTO buscarHistorial(String numero) {
        HistorialConsumoDTO historialConsumoDto = new HistorialConsumoDTO();
        em.getTransaction().begin();
        Tarjeta tjt = (Tarjeta) em.createNamedQuery("Tarjeta.findByNumero").setParameter("numerotarjeta", numero).getSingleResult();
        em.getTransaction().commit();
        em.getTransaction().begin();
        Cliente cliente = (Cliente) em.createNamedQuery("Cliente.findById").setParameter("id", tjt.getClienteid().getId()).getSingleResult();
        em.getTransaction().commit();
        em.getTransaction().begin();
        List<Consumo> listaConsumos = em.createNamedQuery("Consumo.findByTarjeta").setParameter("tid", tjt).getResultList();
        em.getTransaction().commit();
        em.close();
        historialConsumoDto.setClienteDto(new ClienteDTO(cliente));
        historialConsumoDto.setListaConsumo(UTransformacion.consumoListToConsumoDtoList(listaConsumos));
        historialConsumoDto.setTarjetaDto(new TarjetaDTO(tjt));
        return historialConsumoDto;
    }
}
