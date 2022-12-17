package com.portfolio.AleBombini.controller;

import com.portfolio.AleBombini.model.Persona;
import com.portfolio.AleBombini.service.IPersonaService;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@CrossOrigin(origins= "http://localhost:4200")
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
        return iPersoServ.findPersona((long)2);
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
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("clave") String nuevaClave, //paso los cambios x URL
            @RequestParam("titulo") String nuevoTitulo, //paso los cambios x URL
            @RequestParam("email") String nuevoEmail,
            @RequestParam("whatsapp") String nuevoWhatsapp, //paso los cambios x URL
            @RequestParam("UrlTelegram") String nuevaUrlTele,
            @RequestParam("UrlLinkedIn") String nuevaUrlLinkedIn,
            @RequestParam("presentacion") String nuevaPresentacion, //paso los cambios x URL
            @RequestParam("urlVideo") String nuevaUrlVideo,
            @RequestParam("urlFoto") String nuevaUrlFoto)
    
    
    
    {
        Persona perso = iPersoServ.findPersona(id);  //busco la persona y le asigno variable  
        perso.setNombre(nuevoNombre);        //guardo los cambios en la variable
        perso.setApellido(nuevoApellido);
        perso.setClave(nuevaClave);
        perso.setTitulo(nuevoTitulo);
        perso.setEmail(nuevoEmail);
        perso.setWhatsapp (nuevoWhatsapp);
        perso.setUrlTelegram (nuevaUrlTele);
        perso.setUrlLinkedIn (nuevaUrlLinkedIn);
        perso.setPresentacion (nuevaPresentacion);
        perso.setUrlVideo (nuevaUrlVideo);
        perso.setUrlFoto(nuevaUrlFoto);

        iPersoServ.savePersona(perso);         //le digo que guarde en la entidad persona

        return perso;
    }

}
