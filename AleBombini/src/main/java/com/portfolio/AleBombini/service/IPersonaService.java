
package com.portfolio.AleBombini.service;

import com.portfolio.AleBombini.model.Persona;
import java.util.List;


public interface IPersonaService {
    
//traer persona
    public List<Persona> getPersona();
    
    //guardar objeto persona
    public void savePersona(Persona pers);
    
    //eliminar objeto persona, lo buscamos por id
    public void deletePersona(Long id);
    
    //buscar persona x id
    public Persona findPersona (Long id);
    
}
