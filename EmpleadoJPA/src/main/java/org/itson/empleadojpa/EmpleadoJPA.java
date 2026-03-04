/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.itson.empleadojpa;

import jakarta.persistence.EntityManager;
import java.sql.Date;
import java.time.LocalDate;
import org.itson.empleadojpa.entity.Empleado;
import org.itson.empleadojpa.service.EmpresaService;
import org.itson.empleadojpa.util.JpaUtil;

/**
 *
 * @author axelm
 */
public class EmpleadoJPA {

    public static void main(String[] args) {
        //Entity Manager
        EntityManager em = JpaUtil.getEntityManager();
        //Instacia de servicios
        EmpresaService service = new EmpresaService();
        // 1. Insertar
        Empleado emp1 = new Empleado();
        emp1.setNombre("Axel Meza");
        emp1.setSalario(1000.0);
        emp1.setEmail("axel@mail.com");
        emp1.setFechaContratacion(Date.valueOf(LocalDate.now()));
        service.guardar(emp1);
        // 2. Listar
        System.out.println("Lista inicial:");
        service.listar().forEach(e -> System.out.println(e.getNombre() + "$" + e.getSalario()));
        // 3. Modificar (Aumento del 50%)
        service.aumentarSalario(1L, 50.0);
        // 4. Listar final
        System.out.println("\nLista tras aumento:");
        service.listar().forEach(e -> System.out.println(e.getNombre() + "$" + e.getSalario()));
        em.close();
    }
}
