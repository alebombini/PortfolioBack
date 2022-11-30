
package com.portfolio.AleBombini.repository;

import com.portfolio.AleBombini.model.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepo extends JpaRepository<Experiencia, Integer> {

    public Experiencia findByCargo(String cargo);

   
    
    
}
