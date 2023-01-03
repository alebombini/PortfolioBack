
package com.portfolio.AleBombini.controller;

import com.portfolio.AleBombini.model.Estudios;
import com.portfolio.AleBombini.service.IEstudiosService;
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
@CrossOrigin (origins= "https://portfolioale-17e1a.web.app/")
public class EstudiosController {
    
    
   @Autowired
   IEstudiosService iEstuServ;
   
   
   //endpoints estudios
   
    @GetMapping("estudios/traer")
   public List<Estudios> getEstudios() {
        return iEstuServ.getEstudios();
    }
   @GetMapping("estudios/detail/{id}")
    public ResponseEntity<Estudios> getById(@PathVariable("id") int id){
     if(iEstuServ.existById(id)) {
         Estudios estudios = iEstuServ.getEstudio(id);
     return new ResponseEntity(estudios, HttpStatus.OK);
        } else {
         return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        
    }
    
   @PostMapping("estudios/crear")
    public String saveEstudios (@RequestBody Estudios estu) {
        iEstuServ.saveEstudios(estu);
        return "La experiencia fue agregada";
    }
    
    @DeleteMapping("/estudios/delete/{id}")
    public String deleteEstudios(@PathVariable int id) {
        iEstuServ.deleteEstudios(id);
        return "El estudio fue eliminado.";
    }
    
  @PutMapping("estudios/edit/{id}") //URL/puerto/edit/id?nombre=Ale&apellido=Bombini   PARA EDITAR
    public Estudios editEstudios(@RequestBody Estudios estu) {
        iEstuServ.saveEstudios(estu);         //le digo que guarde en la entidad experiencia
        return estu;
    }
}
