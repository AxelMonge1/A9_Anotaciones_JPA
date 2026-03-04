/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.empleadojpa.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author axelm
 */
public class JpaUtil {
    private static final String PERSISTENCE_UNIT = "EmpresaPU";
    private static EntityManagerFactory emf;

    private JpaUtil() {}

    public static EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        return emf.createEntityManager();
    }
}