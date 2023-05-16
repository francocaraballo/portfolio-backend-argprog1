/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.fnc.Service;

import com.portfolio.fnc.Entity.SkillSoft;
import com.portfolio.fnc.Repository.RSoftSkill;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author franc
 */
@Service
@Transactional
public class SSoftSkill {
    @Autowired
    RSoftSkill rSoftSkill;
    
    public List<SkillSoft> list(){
        return rSoftSkill.findAll();
    }
    
    public Optional<SkillSoft> getOne(int id){
        return rSoftSkill.findById(id);
    }
    
    public Optional<SkillSoft> getByTitulo(String titulo){
        return rSoftSkill.findByTitulo(titulo);
    }
    
    public void save(SkillSoft skill){
        rSoftSkill.save(skill);
    }
    
    public void delete(int id){
        rSoftSkill.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rSoftSkill.existsById(id);
    }
    
    public boolean existsByTitulo(String titulo){
        return rSoftSkill.existsByTitulo(titulo);
    }
    
}
