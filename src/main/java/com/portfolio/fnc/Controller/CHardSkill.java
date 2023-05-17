/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.fnc.Controller;

import com.portfolio.fnc.Dto.dtoSkill;
import com.portfolio.fnc.Entity.SkillHard;
import com.portfolio.fnc.Security.Controller.Mensaje;
import com.portfolio.fnc.Service.SHardSkill;
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
@RequestMapping("hardskill")
@CrossOrigin(origins = "https://portfoliofnc.web.app/")
public class CHardSkill {
    @Autowired
    SHardSkill sHardSkill;
    
    @GetMapping("/list")
    public ResponseEntity<List<SkillHard>> list(){
        List<SkillHard> list = sHardSkill.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkill dtoskill){
        if(StringUtils.isBlank(dtoskill.getTitulo()))
            return new ResponseEntity(new Mensaje("El titutlo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(sHardSkill.existsByTitulo(dtoskill.getTitulo()))
            return new ResponseEntity(new Mensaje("Esta habilidad ya existe"), HttpStatus.BAD_REQUEST);
        
        SkillHard hardSkill = new SkillHard(dtoskill.getTitulo(), dtoskill.getColor(), dtoskill.getPorcentaje());
        sHardSkill.save(hardSkill);
        
        return new ResponseEntity(new Mensaje("Habilidad agregada correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkill dtoskill){
        if(!sHardSkill.existsById(id))
             return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
         
         if(sHardSkill.existsByTitulo(dtoskill.getTitulo()) && sHardSkill.getByTitulo(dtoskill.getTitulo()).get().getId() != id)
             return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
         
         if(StringUtils.isBlank(dtoskill.getTitulo()))
             return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
         
         SkillHard hardSkill = sHardSkill.getOne(id).get();
         hardSkill.setTitulo(dtoskill.getTitulo());
         hardSkill.setColor(dtoskill.getColor());
         hardSkill.setPorcentaje(dtoskill.getPorcentaje());
         
         sHardSkill.save(hardSkill);
         return new ResponseEntity(new Mensaje("Habilidad actualizada correctamente"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sHardSkill.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        
        sHardSkill.delete(id);
        
        return new ResponseEntity(new Mensaje("Habilidad eliminada correctamente"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<SkillHard> getById(@PathVariable("id") int id){
        if(!sHardSkill.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        SkillHard hardSkill = sHardSkill.getOne(id).get();
        return new ResponseEntity(hardSkill, HttpStatus.OK);
    }
}
