package com.portfolio.AleBombini.controller;

import com.portfolio.AleBombini.model.Experiencia;
import com.portfolio.AleBombini.service.IExperienciaService;
import java.sql.Date;
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
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {

    @Autowired
    public IExperienciaService iExpeServ;

    @GetMapping("experiencia/traer")
    public List<Experiencia> getExperiencia() {
        return iExpeServ.getExperiencia();
    }

    @GetMapping("experiencia/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id) {
        if (iExpeServ.existById(id)) {
            Experiencia experiencia = iExpeServ.getOne(id);
            return new ResponseEntity(experiencia, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("experiencia/crear")
    public String saveExperiencia(@RequestBody Experiencia expe) {
        iExpeServ.saveExperiencia(expe);
        return "La experiencia fue agregada";
    }

    @DeleteMapping("/experiencia/delete/{id}")
    public String deleteExperiencia(@PathVariable int id) {
        iExpeServ.deleteExperiencia(id);
        return "La experiencia fue eliminada.";
    }

    @PutMapping("experiencia/edit/{id}") //URL/puerto/edit/id?nombre=Ale&apellido=Bombini   PARA EDITAR
    public Experiencia editExperiencia(@RequestBody Experiencia expe) {
            iExpeServ.saveExperiencia(expe);
        return expe;
    }

    
}
