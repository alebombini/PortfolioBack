package com.portfolio.AleBombini.controller;

import com.portfolio.AleBombini.model.SobreMi;
import com.portfolio.AleBombini.service.ISobreMiService;
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
public class SobreMiController {

    @Autowired
    public ISobreMiService iSobreServ;

//endpoints
    @GetMapping("/sobremi/traer")
    public List<SobreMi> getSobreMi() {
        return iSobreServ.getSobreMi();
    }

    @GetMapping("/sobremi/detail/{id}")
    public ResponseEntity<SobreMi> getById(@PathVariable int id) {
        if (iSobreServ.existById(id)) {
            SobreMi sobremi = iSobreServ.getOne(id);
            return new ResponseEntity(sobremi, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/sobremi/crear")
    public String saveSobreMi(@RequestBody SobreMi sobre) {
        iSobreServ.saveSobreMi(sobre);
        return "La informacion fue agregada";
    }

    @DeleteMapping("/sobremi/delete/{id}")
    public String deleteSobreMi(@PathVariable int id) {
        iSobreServ.deleteSobreMi(id);
        return "La informacion fue eliminada.";
    }

    @PutMapping("/sobremi/edit/{id}")          //URL/puerto/sobremi/edit/id?   PARA EDITAR
    public SobreMi editSobreMi(@PathVariable int id, @RequestBody SobreMi sobre){
    iSobreServ.saveSobreMi(sobre);
       return sobre;
    
    }
    
    //asi seria un @requestParam 
    /*public SobreMi editSobreMi(@PathVariable int id,
            @RequestParam("presentacion") String nuevaPresenta, //paso los cambios x URL
            @RequestParam("urlVideo") String nuevaUrl,
            @RequestParam("PersonaId") Long personaId) {
        SobreMi sobre = iSobreServ.findSobreMi(id);  //busco la persona y le asigno variable  
        sobre.setPresentacion(nuevaPresenta);        //guardo los cambios en la variable
        sobre.setUrlVideo(nuevaUrl);
        sobre.setPersonaId(personaId);

        iSobreServ.saveSobreMi(sobre);         //le digo que guarde en la entidad persona

        return sobre;
    }*/

}
