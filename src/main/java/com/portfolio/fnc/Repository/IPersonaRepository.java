
package com.portfolio.fnc.Repository;

import com.portfolio.fnc.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long> { 
    
}
