/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.fnc.Controller;

import com.portfolio.fnc.Dto.dtoSkill;
import com.portfolio.fnc.Entity.SkillSoft;
import com.portfolio.fnc.Security.Controller.Mensaje;
import com.portfolio.fnc.Service.SSoftSkill;
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
@RequestMapping("softskill")
@CrossOrigin(origins = "https://portfoliofnc.web.app/")
public class CSoftSkill {
    @Autowired
    SSoftSkill sSoftSkill;
    
    @GetMapping("/list")
    public ResponseEntity<List<SkillSoft>> list(){
        List<SkillSoft> list = sSoftSkill.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkill dtoskill){
        if(StringUtils.isBlank(dtoskill.getTitulo()))
            return new ResponseEntity(new Mensaje("El titutlo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(sSoftSkill.existsByTitulo(dtoskill.getTitulo()))
            return new ResponseEntity(new Mensaje("Esta habilidad ya existe"), HttpStatus.BAD_REQUEST);
        
        SkillSoft softSkill = new SkillSoft(dtoskill.getTitulo(), dtoskill.getColor(), dtoskill.getPorcentaje());
        sSoftSkill.save(softSkill);
        
        return new ResponseEntity(new Mensaje("Habilidad agregada correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkill dtoskill){
        if(!sSoftSkill.existsById(id))
             return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
         
         if(sSoftSkill.existsByTitulo(dtoskill.getTitulo()) && sSoftSkill.getByTitulo(dtoskill.getTitulo()).get().getId() != id)
             return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
         
         if(StringUtils.isBlank(dtoskill.getTitulo()))
             return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
         
         SkillSoft softSkill = sSoftSkill.getOne(id).get();
         softSkill.setTitulo(dtoskill.getTitulo());
         softSkill.setColor(dtoskill.getColor());
         softSkill.setPorcentaje(dtoskill.getPorcentaje());
         
         sSoftSkill.save(softSkill);
         return new ResponseEntity(new Mensaje("Habilidad actualizada correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sSoftSkill.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        
        sSoftSkill.delete(id);
        
        return new ResponseEntity(new Mensaje("Habilidad eliminada correctamente"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<SkillSoft> getById(@PathVariable("id") int id){
        if(!sSoftSkill.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        SkillSoft softSkill = sSoftSkill.getOne(id).get();
        return new ResponseEntity(softSkill, HttpStatus.OK);
    }
    
}
