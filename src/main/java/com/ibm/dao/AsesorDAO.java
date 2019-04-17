/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.dao;

import com.ibm.dto.AsesorDTO;
import com.ibm.entities.Asesor;
import com.ibm.persistence.EntityManagerUtil;
import com.ibm.utilities.UTransformacion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author JesusArmando
 */
public class AsesorDAO implements IDAO<AsesorDTO> {

    EntityManager em = EntityManagerUtil.getEntityManager();

    @Override
    public AsesorDTO agregar(AsesorDTO dto) {
        Asesor asesor = new Asesor(dto);
        em.getTransaction().begin();
        em.persist(asesor);
        em.getTransaction().commit();
        em.close();
        return dto;
    }

    @Override
    public AsesorDTO buscar(int id) {
        em.getTransaction().begin();
        Asesor asesor = em.find(Asesor.class, id);
        em.getTransaction().commit();
        em.close();
        AsesorDTO asesorDto = new AsesorDTO(asesor);
        return asesorDto;
    }

    @Override
    public List<AsesorDTO> buscarTodos() {
        em.getTransaction().begin();
        List<Asesor> list = em.createNamedQuery("Asesor.findAll").getResultList();
        em.getTransaction().commit();
        em.close();
        return UTransformacion.asesorListToAsesorDtoList(list);
    }

    @Override
    public AsesorDTO eliminar(int id) {
        em.getTransaction().begin();
        Asesor asesor = em.find(Asesor.class, id);
        em.getTransaction().commit();
        em.getTransaction().begin();
        em.remove(asesor);
        em.getTransaction().commit();
        em.close();
        AsesorDTO asesorDto = new AsesorDTO(asesor);
        return asesorDto;
    }

    @Override
    public AsesorDTO actualizar(AsesorDTO t) {
        if (!t.getNombre().equals("")) {
            Query query = em.createNamedQuery("Asesor.updateNombre");
            em.getTransaction().begin();
            query.setParameter("nombre", t.getNombre());
            query.setParameter("id", t.getId());
            query.executeUpdate();
            em.getTransaction().commit();
        }
        if (!t.getEspecialidad().equals("")) {
            Query query = em.createNamedQuery("Asesor.updateEspecialidad");
            em.getTransaction().begin();
            query.setParameter("especialidad", t.getEspecialidad());
            query.setParameter("id", t.getId());
            query.executeUpdate();
            em.getTransaction().commit();
        }
        em.close();
        return t;
    }

}
