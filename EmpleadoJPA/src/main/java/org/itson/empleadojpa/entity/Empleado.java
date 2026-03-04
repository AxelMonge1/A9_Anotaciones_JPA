/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.empleadojpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import org.hibernate.annotations.Check;

/**
 *
 * @author axelm
 */
@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @Check(constraints = "salario > 0")
    @Column(name = "salario")
    private Double salario;
    
    @Enumerated(EnumType.STRING)
    private Estatus estatus;
    
    @Column(name = "fechaContratacion", nullable = false)
    private Date fechaContratacion;

    public Empleado() {
    }

    public Empleado(Long id, String nombre, String email, Double salario, Estatus estatus, Date fechaContratacion) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.salario = salario;
        this.estatus = estatus;
        this.fechaContratacion = fechaContratacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public void setEstatus(Estatus estatus) {
        this.estatus = estatus;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public Double getSalario() {
        return salario;
    }

    public Estatus getEstatus() {
        return estatus;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.bancojpa.entity.Empleado[ id=" + id + " ]";
    }
    
}