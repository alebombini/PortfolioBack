
package com.portfolio.AleBombini.repository;

import com.portfolio.AleBombini.model.Estudios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstudiosRepo extends JpaRepository <Estudios, Integer> {

    public Object findByTitulo(String titulo);
    
}
