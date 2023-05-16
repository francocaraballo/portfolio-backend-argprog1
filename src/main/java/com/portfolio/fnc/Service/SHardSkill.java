/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.fnc.Service;

import com.portfolio.fnc.Entity.SkillHard;
import com.portfolio.fnc.Repository.RHardSkill;
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
public class SHardSkill {
    @Autowired
    RHardSkill rHardSkill;
    
    public List<SkillHard> list(){
        return rHardSkill.findAll();
    }
    
    public Optional<SkillHard> getOne(int id){
        return rHardSkill.findById(id);
    }
    
    public Optional<SkillHard> getByTitulo(String titulo){
        return rHardSkill.findByTitulo(titulo);
    }
    
    public void save(SkillHard skill){
        rHardSkill.save(skill);
    }
    
    public void delete(int id){
        rHardSkill.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rHardSkill.existsById(id);
    }
    
    public boolean existsByTitulo(String titulo){
        return rHardSkill.existsByTitulo(titulo);
    }
    
    
}
