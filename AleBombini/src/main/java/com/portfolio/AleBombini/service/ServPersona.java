
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
         return ipersoRepo.findById(id).orElse(null);
    }

    @Override
      public Persona loginPersona(String email, String clave) {
        List <Persona> personas = ipersoRepo.findByEmailAndClave(email, clave);
        if(!personas.isEmpty()){
            return personas.get(0);  //si la lista no esta vacia me devuelve la de la posicion 0
        }
        return null;
    }
/*
    @Override
    public void updateTitulo(String titulo) {
       ipersoRepo.setTitulo(titulo);
    }
   */ 
}
