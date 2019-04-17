/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.dao;

import com.ibm.dto.ConsumoDTO;
import com.ibm.entities.Consumo;
import com.ibm.entities.Tarjeta;
import com.ibm.persistence.EntityManagerUtil;
import com.ibm.utilities.UTransformacion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author JesusArmando
 */
public class ConsumoDAO implements IDAO<ConsumoDTO> {

    EntityManager em = EntityManagerUtil.getEntityManager();

    @Override
    public ConsumoDTO agregar(ConsumoDTO dto) {
        Consumo consumo = new Consumo(dto);
        em.getTransaction().begin();
        em.persist(consumo);
        em.getTransaction().commit();
        em.close();
        return dto;
    }

    public ConsumoDTO agregarATarjeta(ConsumoDTO dto, Integer id) {
        em.getTransaction().begin();
        Tarjeta tarjeta = em.find(Tarjeta.class, id);
        em.getTransaction().commit();
        Consumo consumo = new Consumo(dto);
        consumo.setTarjetaid(tarjeta);
        em.getTransaction().begin();
        em.persist(consumo);
        em.getTransaction().commit();
        em.close();
        return dto;
    }

    @Override
    public ConsumoDTO buscar(int id) {
        em.getTransaction().begin();
        Consumo consumo = em.find(Consumo.class, id);
        em.getTransaction().commit();
        em.close();
        ConsumoDTO consumoDto = new ConsumoDTO(consumo);
        return consumoDto;
    }

    @Override
    public ConsumoDTO eliminar(int id) {
        em.getTransaction().begin();
        Consumo consumo = em.find(Consumo.class, id);
        em.getTransaction().commit();
        em.getTransaction().begin();
        em.remove(consumo);
        em.getTransaction().commit();
        em.close();
        ConsumoDTO consumoDto = new ConsumoDTO(consumo);
        return consumoDto;
    }

    @Override
    public ConsumoDTO actualizar(ConsumoDTO t) {
        if (!t.getMonto().equals("")) {
            em.getTransaction().begin();
            Query query = em.createNamedQuery("Consumo.updateMonto");
            query.setParameter("id", t.getId());
            query.setParameter("monto", t.getMonto());
            query.executeUpdate();
            em.getTransaction().commit();
        }
        if (!t.getDescripcion().equals("")) {
            em.getTransaction().begin();
            Query query = em.createNamedQuery("Consumo.updateDescripcion");
            query.setParameter("id", t.getId());
            query.setParameter("descripcion", t.getDescripcion());
            query.executeUpdate();
            em.getTransaction().commit();
        }
        if (null != t.getFecha()) {
            em.getTransaction().begin();
            Query query = em.createNamedQuery("Consumo.updateFecha");
            query.setParameter("id", t.getId());
            query.setParameter("fecha", t.getFecha());
            query.executeUpdate();
            em.getTransaction().commit();
        }

        em.close();
        return t;
    }

    @Override
    public List<ConsumoDTO> buscarTodos() {
        em.getTransaction().begin();
        List<Consumo> list = em.createNamedQuery("Consumo.findAll").getResultList();
        em.getTransaction().commit();
        em.close();
        return UTransformacion.consumoListToConsumoDtoList(list);
    }

}
