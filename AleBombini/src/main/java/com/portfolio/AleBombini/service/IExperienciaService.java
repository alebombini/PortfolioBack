

package com.portfolio.AleBombini.service;

import com.portfolio.AleBombini.model.Experiencia;
import java.util.List;

public interface IExperienciaService {
    
    public List<Experiencia> getExperiencia();
    
    public Experiencia getOne (int id);
    
    public Experiencia getByCargo(String cargo);
    
    public void saveExperiencia(Experiencia expe);
    
    public void deleteExperiencia(int id);
    
    
}
