
package com.portfolio.AleBombini.controller;

import com.portfolio.AleBombini.model.Proyectos;
import com.portfolio.AleBombini.service.IProyectosService;
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
public class ProyectosController {
    
    @Autowired
    public IProyectosService iProyeServ;
    
    //endpoints
    
    @GetMapping("proyectos/traer")
    public List<Proyectos> getProyectos() {
        return iProyeServ.getProyectos();
    }

    @PostMapping("/proyectos/crear")
    public String savePersona(@RequestBody Proyectos proye) {
        iProyeServ.saveProyecto(proye);
        return "El proyecto fue agregado";
    }

    @DeleteMapping("/proyectos/delete/{id}")
    public String deletePersona(@PathVariable int id) {
        iProyeServ.deleteProyecto(id);
        return "El proyecto fue eliminado.";
    }

    @PutMapping("proyectos/edit/{id}") //URL/puerto/proyectos/edit/id?   PARA EDITAR
    public Proyectos editProyecto(@PathVariable int id,
            @RequestParam("nombreP") String nuevoNombreP, //paso los cambios x URL
            @RequestParam("urlProyecto") String nuevaUrlProy,
            @RequestParam("urlFotoProyecto") String nuevaUrlFotoProy)
    {
        Proyectos proye = iProyeServ.findProyecto(id);  //busco la persona y le asigno variable  
        proye.setNombreP(nuevoNombreP);        //guardo los cambios en la variable
        proye.setUrlProyecto(nuevaUrlProy);
        proye.setUrlFotoProyecto(nuevaUrlFotoProy);


        iProyeServ.saveProyecto(proye);         //le digo que guarde en la entidad persona

        return proye;
    }

    
}
