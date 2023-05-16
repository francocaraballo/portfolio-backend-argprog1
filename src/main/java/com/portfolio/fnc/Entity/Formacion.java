/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.fnc.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author franc
 */
@Entity
public class Formacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreF;
    private String descripcionF;
    private String imagenUrl;
    
    // Constructores

    public Formacion() {
    }
    
    public Formacion(String nombreF, String descripcionF, String imagenUrl) {
        this.nombreF = nombreF;
        this.descripcionF = descripcionF;
        this.imagenUrl = imagenUrl;
    }
    
    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreF() {
        return nombreF;
    }

    public void setNombreF(String nombreF) {
        this.nombreF = nombreF;
    }

    public String getDescripcionF() {
        return descripcionF;
    }

    public void setDescripcionF(String descripcionF) {
        this.descripcionF = descripcionF;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }
       
}
