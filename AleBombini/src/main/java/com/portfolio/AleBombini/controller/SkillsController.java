
package com.portfolio.AleBombini.controller;

import com.portfolio.AleBombini.model.Skills;
import com.portfolio.AleBombini.service.ISkillsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillsController {
    
    @Autowired
    public ISkillsService iSkillsServ;
    
    //endpoints
    
    @GetMapping("skills/traer")
    public List<Skills> getSkill() {
        return iSkillsServ.getSkills();
    }

    @PostMapping("/skills/crear")
    public String saveSkill(@RequestBody Skills skill) {
        iSkillsServ.saveSkill(skill);
        return "Skill fue agregada";
    }

    @DeleteMapping("/skills/delete/{id}")
    public String deleteSkill(@PathVariable int id) {
        iSkillsServ.deleteSkill(id);
        return "Skill fue eliminada.";
    }

    @PutMapping("skills/edit/{id}") //URL/puerto/proyectos/edit/id?   PARA EDITAR
    public Skills editSkill(@PathVariable int id,
            @RequestParam("nombreS") String nuevoNombreS, //paso los cambios x URL
            @RequestParam("nivel") String nuevoNivel)
    {
        Skills skill = iSkillsServ.findSkill(id);  //busco la persona y le asigno variable  
        skill.setNombreS(nuevoNombreS);        //guardo los cambios en la variable
        skill.setNivel(nuevoNivel);
 
        iSkillsServ.saveSkill(skill);         //le digo que guarde en la entidad persona

        return skill;
    }
}
