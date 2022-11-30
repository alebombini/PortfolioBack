
package com.portfolio.AleBombini.repository;

import com.portfolio.AleBombini.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepo extends JpaRepository<Persona, Long> {
    
}
