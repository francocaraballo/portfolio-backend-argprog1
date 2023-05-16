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
public class dtoProyecto {
    @NotBlank
    private String nombreP;
    @NotBlank
    private String descripcionP;
    @NotBlank
    private String imagenUrl;
    
    // Constructor

    public dtoProyecto() {
    }

    public dtoProyecto(String nombreP, String descripcionP, String imagenUrl) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.imagenUrl = imagenUrl;
    }
    
    // Getters and Setters

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }
    
    
    
}
