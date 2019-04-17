/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.dao;

import com.ibm.dto.ClienteDTO;
import com.ibm.entities.Cliente;
import com.ibm.persistence.EntityManagerUtil;
import com.ibm.utilities.UTransformacion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author JesusArmando
 */
public class ClienteDAO implements IDAO<ClienteDTO> {

    EntityManager em = EntityManagerUtil.getEntityManager();

    @Override
    public ClienteDTO agregar(ClienteDTO dto) {
        Cliente cliente = new Cliente(dto);
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
        return dto;
    }

    @Override
    public ClienteDTO buscar(int id) {
        em.getTransaction().begin();
        Cliente cliente = em.find(Cliente.class, id);
        em.getTransaction().commit();
        em.close();
        ClienteDTO clienteDto = new ClienteDTO(cliente);
        return clienteDto;
    }

    @Override
    public ClienteDTO eliminar(int id) {
        em.getTransaction().begin();
        Cliente cliente = em.find(Cliente.class, id);
        em.getTransaction().commit();
        em.getTransaction().begin();
        em.remove(cliente);
        em.getTransaction().commit();
        em.close();
        ClienteDTO clienteDto = new ClienteDTO(cliente);
        return clienteDto;
    }

    @Override
    public ClienteDTO actualizar(ClienteDTO t) {
        if (!t.getNombre().equals("")) {
            em.getTransaction().begin();
            Query query = em.createNamedQuery("Cliente.updateNombre");
            query.setParameter("id", t.getId());
            query.setParameter("nombre", t.getNombre());
            query.executeUpdate();
            em.getTransaction().commit();
        }
        if (!t.getCiudad().equals("")) {
            em.getTransaction().begin();
            Query query = em.createNamedQuery("Cliente.updateCiudad");
            query.setParameter("id", t.getId());
            query.setParameter("ciudad", t.getCiudad());
            query.executeUpdate();
            em.getTransaction().commit();
        }
        if (!t.getDireccion().equals("")) {
            em.getTransaction().begin();
            Query query = em.createNamedQuery("Cliente.updateDireccion");
            query.setParameter("id", t.getId());
            query.setParameter("direccion", t.getDireccion());
            query.executeUpdate();
            em.getTransaction().commit();
        }
        if (!t.getTelefono().equals("")) {
            em.getTransaction().begin();
            Query query = em.createNamedQuery("Cliente.updateTelefono");
            query.setParameter("id", t.getId());
            query.setParameter("telefono", t.getTelefono());
            query.executeUpdate();
            em.getTransaction().commit();
        }
        em.close();
        return t;
    }

    @Override
    public List<ClienteDTO> buscarTodos() {
        em.getTransaction().begin();
        List<Cliente> list = em.createNamedQuery("Cliente.findAll").getResultList();
        em.getTransaction().commit();
        em.close();
        return UTransformacion.clienteListToClienteDtoList(list);
    }

}
