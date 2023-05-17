/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.fnc.Controller;

import com.portfolio.fnc.Dto.dtoFormacion;
import com.portfolio.fnc.Entity.Formacion;
import com.portfolio.fnc.Security.Controller.Mensaje;
import com.portfolio.fnc.Service.SFormacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author franc
 */

@RestController
@RequestMapping("formacion")
@CrossOrigin(origins = "https://portfoliofnc.web.app/")
public class CFormacion {
    @Autowired
    SFormacion sFormacion;
    
    @GetMapping("/list")
    public ResponseEntity<List<Formacion>> list(){
        List<Formacion> list = sFormacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoFormacion dtoformacion){
        if(StringUtils.isBlank(dtoformacion.getNombreF()))
            return new ResponseEntity(
                new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sFormacion.existsByNombreF(dtoformacion.getNombreF()))
            return new ResponseEntity(
                new Mensaje("Esa formacion ya se encuentra registrada"), HttpStatus.BAD_REQUEST);
        
        Formacion formacion = new Formacion(dtoformacion.getNombreF(), dtoformacion.getDescripcionF(), dtoformacion.getImagenUrl());
        sFormacion.save(formacion);
        
        return new ResponseEntity(new Mensaje("Formacion agregada correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoFormacion dtoformacion){
        if(!sFormacion.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if(sFormacion.existsByNombreF(dtoformacion.getNombreF()) && sFormacion.getByNombreF(dtoformacion.getNombreF()).get().getId() != id)
             return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoformacion.getNombreF()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Formacion formacion = sFormacion.getOne(id).get();
        formacion.setNombreF(dtoformacion.getNombreF());
        formacion.setDescripcionF(dtoformacion.getDescripcionF());
        formacion.setImagenUrl(dtoformacion.getImagenUrl());
        
        sFormacion.save(formacion);
        return new ResponseEntity(new Mensaje("Formacion actualizada correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sFormacion.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        
        sFormacion.delete(id);
        
        return new ResponseEntity(new Mensaje("Formacion eliminada correctamente"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Formacion> getById(@PathVariable("id") int id){
        if(!sFormacion.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        
        Formacion formacion = sFormacion.getOne(id).get();
        return new ResponseEntity(formacion, HttpStatus.OK);           
    }
}
