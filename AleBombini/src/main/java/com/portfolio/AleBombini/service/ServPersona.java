
package com.portfolio.AleBombini.service;

import com.portfolio.AleBombini.model.Persona;
import com.portfolio.AleBombini.repository.IPersonaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServPersona implements IPersonaService{

    @Autowired //me permite inyectad dependencias mas facil
    public IPersonaRepo ipersoRepo;   //creo esa conecion con el repositorio Persona, como una "instancia"
    
    
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> personas = ipersoRepo.findAll();
        return personas;
    }

    @Override
    public void savePersona(Persona pers) {
        ipersoRepo.save(pers);
    }

    @Override
    public void deletePersona(Long id) {
        ipersoRepo.deleteById(id);

    }

    @Override
    public Persona findPersona(Long id) {
         Persona persona = ipersoRepo.findById(id).orElse(null);
         return persona;
    }
    
}
