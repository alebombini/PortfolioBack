
package com.portfolio.AleBombini.controller;

import com.portfolio.AleBombini.model.FotoLinks;
import com.portfolio.AleBombini.service.IFotoLinksService;
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
@CrossOrigin (origins= "http://localhost:4200")
public class FotoLinksController {
    
    @Autowired
    public IFotoLinksService iFotoServ;
    
   @GetMapping("fotoLinks/traer")
   public List<FotoLinks> getFotoLinks() {
        return iFotoServ.getFotoLinks();
    }
   
    @PostMapping("fotoLinks/crear")
    public String saveFotoLinks (@RequestBody FotoLinks foto) {
        iFotoServ.saveFotoLinks(foto);
        return "La foto fue agregada";
    }
   
    @GetMapping("fotoLinks/detail/{id}")
    public ResponseEntity<FotoLinks> getById(@PathVariable("id") int id){
     if(iFotoServ.existById(id)) {
         FotoLinks fotolinks = iFotoServ.getOne(id);
     return new ResponseEntity(fotolinks, HttpStatus.OK);
        } else {
         return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        
    }
    
    @DeleteMapping("/fotoLinks/delete/{id}")
    public String deleteFotoLinks(@PathVariable int id) {
        iFotoServ.deleteFotoLinks(id);
        return "La fotoLink fue eliminada.";
    }
    
    @PutMapping("fotoLinks/edit/{id}") //URL/puerto/edit/id?nombre=Ale&apellido=Bombini   PARA EDITAR
    public FotoLinks editFotoLinks (@PathVariable int id,
            @RequestParam ("PersonaId") Long nuevaPersId,
            @RequestParam("seccion") String nuevaSeccion, //paso los cambios x URL
            @RequestParam("url") String nuevaUrl)
        {
        FotoLinks foto = iFotoServ.getOne(id); //busco la experiencia y le asigno variable  
        foto.setPersonaId(nuevaPersId);
        foto.setSeccion(nuevaSeccion);              //guardo los cambios en la variable
        foto.setUrl_foto(nuevaUrl) ;             //guardo los cambios en la variable
        

        iFotoServ.saveFotoLinks(foto);         //le digo que guarde en la entidad experiencia

        return foto;
    }
    
}
