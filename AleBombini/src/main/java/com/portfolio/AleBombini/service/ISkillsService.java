
package com.portfolio.AleBombini.service;

import com.portfolio.AleBombini.model.Skills;
import java.util.List;

public interface ISkillsService {
    
     //traer lista de objetos
    public List<Skills> getSkills();
    
    //traer un objeto por id
    public Skills getOne (int id);
    
    //guardar objeto
    public void saveSkill (Skills skill);
    
    //eliminar objeto , lo buscamos por id
    public void deleteSkill(int id);
    
    //buscar proyecto x id
    public Skills findSkill (int id);

    public boolean existById(int id);
    
    
}
