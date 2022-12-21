
package com.portfolio.AleBombini.service;

import com.portfolio.AleBombini.model.Persona;
import java.util.List;


public interface IPersonaService {
    
   //login
    public Persona loginPersona(String pers, String clave);
   
//traer persona
    public List<Persona> getPersona();
    
    //guardar objeto persona
    public void savePersona(Persona pers);
    
    //eliminar objeto persona, lo buscamos por id
    public void deletePersona(Long id);
    
    //buscar persona x id
    public Persona findPersona (Long id);
    
    
   // public void updateTitulo (String titulo);
    
}
