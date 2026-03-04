/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.empleadojpa.service;

import jakarta.persistence.EntityManager;
import java.util.List;
import org.itson.empleadojpa.dao.EmpleadoDAO;
import org.itson.empleadojpa.entity.Empleado;
import org.itson.empleadojpa.util.JpaUtil;

/**
 *
 * @author axelm
 */
public class EmpresaService {
    private final EmpleadoDAO eDAO = new EmpleadoDAO();
    
    public void guardar(Empleado e) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            eDAO.guardar(em, e);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.err.println("Error al guardar: " + ex.getMessage());
        } finally {
            em.close();
        }
    }

    public List<Empleado> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return eDAO.listar(em);
        } finally {
            em.close();
        }
    }

    public void actualizar(Empleado e) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            eDAO.actualizar(em, e);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            System.err.println("Error al actualizar: " + ex.getMessage());
        } finally {
            em.close();
        }
    }
    
    public void eliminarEmpleado(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Empleado e = em.find(Empleado.class, id);
            if (e != null) {
                eDAO.eliminar(em, e);
                em.getTransaction().commit();
                System.out.println("Empleado con ID " + id + " eliminado con éxito.");
            } else {
                System.out.println("No se encontró el empleado con ID " + id);
                em.getTransaction().rollback();
            }
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al eliminar empleado: " + ex.getMessage());
        } finally {
            em.close();
        }
    }
    
    public void aumentarSalario(Long id, Double porcentaje) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Empleado e = em.find(Empleado.class, id);
            if (e != null) {
                Double nuevoSalario = e.getSalario() * (1 + (porcentaje / 100));
                e.setSalario(nuevoSalario);
                em.getTransaction().commit();
                System.out.println("Salario actualizado con éxito.");
            } else {
                System.out.println("Empleado no encontrado. Transacción terminada.");
                em.getTransaction().rollback(); 
            }
        }catch(Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Error en la transacción: " + ex.getMessage());
        }finally{
            em.close();
        }
    }
}
