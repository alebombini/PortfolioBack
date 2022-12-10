
package com.portfolio.AleBombini.service;

import com.portfolio.AleBombini.model.Estudios;
import java.util.List;


public interface IEstudiosService {
    
    public List<Estudios> getEstudios();
    
    public Estudios getEstudio (int id);
    
    public Estudios getByTitulo(String titulo);
    
    public void saveEstudios(Estudios estu);
    
    public void deleteEstudios(int id);

    public boolean existById(int id);
    
    
}
