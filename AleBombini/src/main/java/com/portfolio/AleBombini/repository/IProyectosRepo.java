
package com.portfolio.AleBombini.repository;

import com.portfolio.AleBombini.model.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectosRepo extends JpaRepository<Proyectos, Integer> {

   
}
