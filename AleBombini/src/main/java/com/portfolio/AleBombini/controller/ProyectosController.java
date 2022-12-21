package com.portfolio.AleBombini.controller;

import com.portfolio.AleBombini.model.Proyectos;
import com.portfolio.AleBombini.service.IProyectosService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectosController {

    @Autowired
    public IProyectosService iProyeServ;

    //endpoints
    @GetMapping("proyectos/traer")
    public List<Proyectos> getProyectos() {
        return iProyeServ.getProyectos();
    }

    @GetMapping("proyectos/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id) {
        if (iProyeServ.existById(id)) {
            Proyectos proyectos = iProyeServ.getOne(id);
            return new ResponseEntity(proyectos, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/proyectos/crear")
    public String saveProyecto(@RequestBody Proyectos proye) {
        iProyeServ.saveProyecto(proye);
        return "El proyecto fue agregado";
    }

    @DeleteMapping("/proyectos/delete/{id}")
    public String deleteProyecto(@PathVariable int id) {
        iProyeServ.deleteProyecto(id);
        return "El proyecto fue eliminado.";
    }

    @PutMapping("proyectos/edit/{id}") //URL/puerto/proyectos/edit/id?   PARA EDITAR
    public Proyectos editProyecto (@RequestBody Proyectos proye) {
        iProyeServ.saveProyecto(proye);
        return proye;
    }

}
