
package com.portfolio.AleBombini.service;

import com.portfolio.AleBombini.model.SobreMi;
import java.util.List;


public interface ISobreMiService {
    
     //traer lista de objetos
    public List<SobreMi> getSobreMi();
    
    //traer un objeto por id
    public SobreMi getOne (int id);
    
    //guardar objeto
    public void saveSobreMi (SobreMi sobremi);
    
    
    //eliminar objeto , lo buscamos por id
    public void deleteSobreMi(int id);
    
    //buscar proyecto x id
    public SobreMi findSobreMi (int id);
    
    public boolean existById(int id);
}
