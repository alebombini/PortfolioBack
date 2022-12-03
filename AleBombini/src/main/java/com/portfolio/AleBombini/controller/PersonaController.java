package com.portfolio.AleBombini.controller;

import com.portfolio.AleBombini.model.Persona;
import com.portfolio.AleBombini.service.IPersonaService;
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
public class PersonaController {

    @Autowired
    public IPersonaService iPersoServ;

    
    //endpoints persona

    
    @GetMapping("personas/traer")
    public List<Persona> getPersona() {
        return iPersoServ.getPersona();
    }

    @PostMapping("/personas/crear")
    public String savePersona(@RequestBody Persona pers) {
        iPersoServ.savePersona(pers);
        return "La persona fue agregada";
    }

    @DeleteMapping("/personas/delete/{id}")
    public String deletePersona(@PathVariable Long id) {
        iPersoServ.deletePersona(id);
        return "La persona fue eliminada.";
    }

    @PutMapping("personas/edit/{id}") //URL/puerto/edit/id?nombre=Ale&apellido=Bombini   PARA EDITAR
    public Persona editPersona(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre, //paso los cambios x URL
            @RequestParam("apellido") String nuevoApellido) {
        Persona perso = iPersoServ.findPersona(id);  //busco la persona y le asigno variable  
        perso.setNombre(nuevoNombre);        //guardo los cambios en la variable
        perso.setApellido(nuevoApellido);

        iPersoServ.savePersona(perso);         //le digo que guarde en la entidad persona

        return perso;
    }

}
