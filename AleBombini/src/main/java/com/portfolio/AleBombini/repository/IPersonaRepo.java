
package com.portfolio.AleBombini.repository;

import com.portfolio.AleBombini.model.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepo extends JpaRepository<Persona, Long> {
    public List<Persona> findByEmailAndClave(String email, String clave);
}
