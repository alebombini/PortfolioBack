package com.portfolio.AleBombini.service;

import com.portfolio.AleBombini.model.Proyectos;
import com.portfolio.AleBombini.repository.IProyectosRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServProyectos implements IProyectosService {

    @Autowired
    public IProyectosRepo iProyeRepo;

    @Override
    public List<Proyectos> getProyectos() {
        List<Proyectos> proyectos = iProyeRepo.findAll();
        return proyectos;
    }

    @Override
    public void saveProyecto(Proyectos proye) {
        iProyeRepo.save(proye);
    }

    @Override
    public void deleteProyecto(int id) {
        iProyeRepo.deleteById(id);
    }

    @Override
    public Proyectos findProyecto(int id) {
        Proyectos proyecto = iProyeRepo.findById(id).orElse(null);
         return proyecto;
    }

}
