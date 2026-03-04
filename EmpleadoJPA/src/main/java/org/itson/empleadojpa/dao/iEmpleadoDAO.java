/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.empleadojpa.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import org.itson.empleadojpa.entity.Empleado;

/**
 *
 * @author axelm
 */
public interface iEmpleadoDAO {
    void guardar(EntityManager em, Empleado e);
    void actualizar(EntityManager em,Empleado e);
    void eliminar(EntityManager em,Empleado e);
    Empleado buscar(EntityManager em,Long id);
    List<Empleado> listar(EntityManager em);
}
