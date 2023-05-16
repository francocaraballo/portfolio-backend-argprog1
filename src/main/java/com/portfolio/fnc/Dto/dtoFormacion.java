/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.fnc.Dto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author franc
 */
public class dtoFormacion {
    @NotBlank
    private String nombreF;
    @NotBlank
    private String descripcionF;
    @NotBlank
    private String imagenUrl;
    
    //Constructores

    public dtoFormacion() {
    }

    public dtoFormacion(String nombreF, String descripcionF, String imagenUrl) {
        this.nombreF = nombreF;
        this.descripcionF = descripcionF;
        this.imagenUrl = imagenUrl;
    }
    
    // Getters and Setters

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
