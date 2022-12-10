package com.portfolio.AleBombini.service;

import com.portfolio.AleBombini.model.Experiencia;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.AleBombini.repository.IExperienciaRepo;

@Service
@Transactional  //indica que va a mantener la persistencia
public class ExperienciaService implements IExperienciaService {

    
    @Autowired
    public IExperienciaRepo expeRepo;

   
    
    @Override
    public List<Experiencia> getExperiencia() {
        return expeRepo.findAll();
    }

    @Override
    public Experiencia getOne(int id) {
        return expeRepo.findById(id).orElse(null);
    }

    @Override
    public Experiencia getByCargo(String cargo) {
       return expeRepo.findByCargo(cargo).orElse(null);

    }

    @Override
    public void saveExperiencia(Experiencia expe) {
        expeRepo.save(expe);
    }

    @Override
    public void deleteExperiencia(int id) {
        expeRepo.deleteById(id);
    }

    @Override
    public boolean existById(int id) {
        expeRepo.existsById(id);
        return true;
    }

    
  
}
