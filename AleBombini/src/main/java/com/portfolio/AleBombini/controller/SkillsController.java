package com.portfolio.AleBombini.controller;

import com.portfolio.AleBombini.model.Skills;
import com.portfolio.AleBombini.service.ISkillsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://portfolioale-17e1a.web.app/")
public class SkillsController {

    @Autowired
    public ISkillsService iSkillsServ;

    //endpoints
    @GetMapping("skills/traer")
    public List<Skills> getSkill() {
        return iSkillsServ.getSkills();
    }

    @GetMapping("skills/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id) {
        if (iSkillsServ.existById(id)) {
            Skills skills = iSkillsServ.getOne(id);
            return new ResponseEntity(skills, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

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
    public Skills editSkill(@RequestBody Skills skill) {
        iSkillsServ.saveSkill(skill);
        return skill;
    }
}
