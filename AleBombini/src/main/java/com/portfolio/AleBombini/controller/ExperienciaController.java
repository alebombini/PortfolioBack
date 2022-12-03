package com.portfolio.AleBombini.controller;

import com.portfolio.AleBombini.model.Experiencia;
import com.portfolio.AleBombini.service.IExperienciaService;
import java.sql.Date;
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
public class ExperienciaController {

    @Autowired
    public IExperienciaService iExpeServ;
    
   @GetMapping("experiencia/traer")
   public List<Experiencia> getExperiencia() {
        return iExpeServ.getExperiencia();
    }
   
    @PostMapping("experiencia/crear")
    public String saveExperiencia (@RequestBody Experiencia expe) {
        iExpeServ.saveExperiencia(expe);
        return "La experiencia fue agregada";
    }
    
    @DeleteMapping("/experiencia/delete/{id}")
    public String deleteExperiencia(@PathVariable int id) {
        iExpeServ.deleteExperiencia(id);
        return "La experiencia fue eliminada.";
    }
    
    @PutMapping("experiencia/edit/{id}") //URL/puerto/edit/id?nombre=Ale&apellido=Bombini   PARA EDITAR
    public Experiencia editExperiencia(@PathVariable int id,
            @RequestParam("cargo") String nuevoCargo, //paso los cambios x URL
            @RequestParam("empresa") String nuevaEmpresa,
            @RequestParam("descripcion") String nuevaDesc, 
            @RequestParam("inicio") Date nuevoInicio,
            @RequestParam("fin") Date nuevoFin) {
        Experiencia expe = iExpeServ.getOne(id);      //busco la experiencia y le asigno variable  
        expe.setCargo(nuevoCargo);              //guardo los cambios en la variable
        expe.setEmpresa(nuevaEmpresa) ;
        expe.setDescripcion(nuevaDesc);              //guardo los cambios en la variable
        expe.setInicio(nuevoInicio) ;
        expe.setFin(nuevoFin) ;

        iExpeServ.saveExperiencia(expe);         //le digo que guarde en la entidad experiencia

        return expe;
    }

    
    
    
    
/*
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = iExpeServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public String create(@RequestBody DtoExperiencia dtoExp) {

        if (StringUtils.isBlank(dtoExp.getCargo())) {
            return "El nombre es obligatorio";
        }
        /*   
    if (expeService.existByCargo(dtoExp.getCargo()))
        return "Esa experiencia existe";
         *///este metodo no me funciona porque no tengo creada la clase mensaje en un package securiry 
        //en caso de querer agregarlo tengo que cambiar String por PesponseEntity<?>
/*
        Experiencia experiencia = new Experiencia(dtoExp.getCargo(),
                dtoExp.getEmpresa(), dtoExp.getDescripcion(),
                dtoExp.getInicio(), dtoExp.getFin());
        iExpeServ.save(experiencia);
        return "Experiencia agregada";
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoExpe) {
        if (!iExpeServ.existById(id)) {
            return "el id no existe";
        }
        Experiencia experiencia = iExpeServ.getOne(id).get();
        experiencia.setCargo(dtoExpe.getCargo());
        experiencia.setEmpresa(dtoExpe.getEmpresa());
        experiencia.setDescripcion(dtoExpe.getDescripcion());
        experiencia.setInicio(dtoExpe.getInicio());
        experiencia.setFin(dtoExpe.getFin());

        iExpeServ.save(experiencia);
        return "Experiencia actualizada";
    }

    @DeleteMapping
   public String delete(@PathVariable("id") int id){
   if (!iExpeServ.existById(id)) {
            return "el id no existe";
        }
   iExpeServ.delete(id);
   return "Experiencia eliminada";
    }
   */ 
}
