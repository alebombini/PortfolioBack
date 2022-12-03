
package com.portfolio.AleBombini.service;

import com.portfolio.AleBombini.model.Proyectos;
import java.util.List;


public interface IProyectosService {
    
    //traer lista de objetos
    public List<Proyectos> getProyectos();
    
    //guardar objeto
    public void saveProyecto (Proyectos proye);
    
    //eliminar objeto , lo buscamos por id
    public void deleteProyecto(int id);
    
    //buscar proyecto x id
    public Proyectos findProyecto (int id);
    
}
