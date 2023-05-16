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
public class dtoSkill {
    @NotBlank
    private String titulo;
    @NotBlank
    private String color;
    @NotBlank
    private int porcentaje;
    
    // Constructor

    public dtoSkill() {
    }

    public dtoSkill(String titulo, String color, int porcentaje) {
        this.titulo = titulo;
        this.color = color;
        this.porcentaje = porcentaje;
    }
    
    //Getters and Setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
      
}
