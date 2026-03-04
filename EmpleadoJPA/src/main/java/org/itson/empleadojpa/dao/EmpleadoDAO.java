/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.empleadojpa.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import org.itson.empleadojpa.entity.Empleado;

/**
 *
 * @author axelm
 */
public class EmpleadoDAO implements iEmpleadoDAO{

    @Override
    public void guardar(EntityManager em, Empleado e) {
        em.persist(e);
    }

    @Override
    public void actualizar(EntityManager em, Empleado e) {
        em.merge(e);
    }

    @Override
    public void eliminar(EntityManager em, Empleado e) {
        em.remove(em.contains(e) ? e : em.merge(e));    
    }

    @Override
    public Empleado buscar(EntityManager em, Long id) {
        return em.find(Empleado.class, id);    }

    @Override
    public List<Empleado> listar(EntityManager em) {
        return em.createQuery("SELECT e FROM Empleado e", Empleado.class).getResultList();
    }   
}