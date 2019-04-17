/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.dao;

import com.ibm.dto.TarjetaDTO;
import com.ibm.entities.Cliente;
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
public class TarjetaDAO implements IDAO<TarjetaDTO> {

    EntityManager em = EntityManagerUtil.getEntityManager();

    @Override
    public TarjetaDTO agregar(TarjetaDTO dto) {
        Tarjeta tarjeta = new Tarjeta(dto);
        em.getTransaction().begin();
        em.persist(tarjeta);
        em.getTransaction().commit();
        em.close();
        return dto;
    }

    @Override
    public TarjetaDTO buscar(int id) {
        em.getTransaction().begin();
        Tarjeta tarjeta = em.find(Tarjeta.class, id);
        em.getTransaction().commit();
        em.close();
        TarjetaDTO tarjetaDto = new TarjetaDTO(tarjeta);
        return tarjetaDto;
    }

    @Override
    public TarjetaDTO eliminar(int id) {
        em.getTransaction().begin();
        Tarjeta tarjeta = em.find(Tarjeta.class, id);
        em.getTransaction().commit();
        em.getTransaction().begin();
        em.remove(tarjeta);
        em.getTransaction().commit();
        em.close();
        TarjetaDTO tarjetaDto = new TarjetaDTO(tarjeta);
        return tarjetaDto;
    }

    @Override
    public TarjetaDTO actualizar(TarjetaDTO t) {
        if (!t.getTipo().equals("")) {
            em.getTransaction().begin();
            Query query = em.createNamedQuery("Tarjeta.updateTipo");
            query.setParameter("id", t.getId());
            query.setParameter("tipo", t.getTipo());
            query.executeUpdate();
            em.getTransaction().commit();
        }
        if (!t.getCcv().equals("")) {
            em.getTransaction().begin();
            Query query = em.createNamedQuery("Tarjeta.updateCcv");
            query.setParameter("id", t.getId());
            query.setParameter("ccv", t.getCcv());
            query.executeUpdate();
            em.getTransaction().commit();
        }
        if (!t.getNumero().equals("")) {
            em.getTransaction().begin();
            Query query = em.createNamedQuery("Tarjeta.updateNumero");
            query.setParameter("id", t.getId());
            query.setParameter("numero", t.getNumero());
            query.executeUpdate();
            em.getTransaction().commit();
        }

        em.close();
        return t;
    }

    @Override
    public List<TarjetaDTO> buscarTodos() {
        em.getTransaction().begin();
        List<Tarjeta> list = em.createNamedQuery("Tarjeta.findAll").getResultList();
        em.getTransaction().commit();
        em.close();
        return UTransformacion.tarjetaListToTarjetaDtoList(list);
    }

    public TarjetaDTO agregarACliente(TarjetaDTO dto, Integer id) {
        em.getTransaction().begin();
        Cliente cliente = em.find(Cliente.class, id);
        em.getTransaction().commit();
        Tarjeta tarjeta = new Tarjeta(dto);
        tarjeta.setClienteid(cliente);
        em.getTransaction().begin();
        em.persist(tarjeta);
        em.getTransaction().commit();
        em.close();
        return dto;
    }

    public TarjetaDTO actualizarAll(TarjetaDTO t) {
        String numero = t.getNumero();
        String ccv = t.getCcv();
        String tipo = t.getTipo();
        int ide = t.getId();
        String complemento = "";
        if (numero != null) {
            complemento += "a.nombre = '" + numero + "'";
        }
        if (ccv != null) {
            if ("".equals(complemento)) {
                complemento += "a.ccv = '" + ccv + "'";
            } else {
                complemento += " , a.ccv = '" + ccv + "'";
            }
        }
        if (tipo != null) {
            if ("".equals(complemento)) {
                complemento += "a.tipo = '" + tipo + "'";
            } else {
                complemento += " , a.tipo = '" + tipo + "'";
            }
        }
        complemento += " WHERE a.id = " + ide;
        em.getTransaction().begin();
        int res = em.createQuery("UPDATE a FROM Tarjeta a SET " + complemento).executeUpdate();
        em.getTransaction().commit();
        em.close();
        return t;
    }
}
