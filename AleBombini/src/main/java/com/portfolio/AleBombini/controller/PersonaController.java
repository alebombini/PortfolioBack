package com.portfolio.AleBombini.controller;

import com.portfolio.AleBombini.model.Persona;
import com.portfolio.AleBombini.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins= "https://portfolioale-17e1a.web.app/")
public class PersonaController {

    @Autowired
    public IPersonaService iPersoServ;

    
    //login
    @PostMapping("/autenticacion/login")
    public Persona loginPersona(@RequestBody Persona pers){
         return iPersoServ.loginPersona(pers.getEmail(), pers.getClave());
    }
    
    
    @GetMapping("personas/traer")
    public List<Persona> getPersona() {
        return iPersoServ.getPersona();
    }
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return iPersoServ.findPersona((long)1); //uso el 1 porque es la unica persona cargada 
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

    @PutMapping("personas/edit/{id}") 
    public Persona editPersona( @RequestBody Persona pers) {
        iPersoServ.savePersona(pers);
        return pers;
    }
 
    @PutMapping ("personas/editTitulo/{id}") 
    public Persona editarPersona (@PathVariable Long id, @RequestBody Persona per){
        Persona perso = iPersoServ.findPersona(id);
        perso.setTitulo( per.getTitulo());
       return perso;
    } 
    
    
   /*
    @PutMapping("personas/edit/titulo")
    public void updateTitulo(@RequestBody String titu){
        iPersoServ.updateTitulo(titu);
      
    
    
    
    
    
    }
*/
    
}
