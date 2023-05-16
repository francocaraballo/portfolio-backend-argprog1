/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.fnc.Repository;

import com.portfolio.fnc.Entity.SkillSoft;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author franc
 */
@Repository
public interface RSoftSkill extends JpaRepository<SkillSoft, Integer> {
    
    public Optional<SkillSoft> findByTitulo(String titulo);
    public boolean existsByTitulo(String titulo);
     
}
