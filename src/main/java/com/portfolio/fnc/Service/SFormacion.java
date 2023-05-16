/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.fnc.Service;

import com.portfolio.fnc.Entity.Formacion;
import com.portfolio.fnc.Repository.RFormacion;
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
public class SFormacion {
    @Autowired
    RFormacion rFormacion;
    
    public List<Formacion> list(){
        return rFormacion.findAll();
    }
    
    public Optional<Formacion> getOne(int id){
        return rFormacion.findById(id);
    }
    
    public Optional<Formacion> getByNombreF(String nombreF){
        return rFormacion.findByNombreF(nombreF);
    }
    
    public void save(Formacion formacion){
        rFormacion.save(formacion);
    }
    
    public void delete(int id){
        rFormacion.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rFormacion.existsById(id);
    }
    
    public boolean existsByNombreF(String nombreF){
        return rFormacion.existsByNombreF(nombreF);
    }
    
}
