/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.fnc.Repository;

import com.portfolio.fnc.Entity.SkillHard;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author franc
 */
@Repository
public interface RHardSkill extends JpaRepository<SkillHard, Integer> {
    
    public Optional<SkillHard> findByTitulo(String titulo);
    public boolean existsByTitulo(String titulo);
    
}
