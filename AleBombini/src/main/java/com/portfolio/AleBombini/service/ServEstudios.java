
package com.portfolio.AleBombini.service;

import com.portfolio.AleBombini.model.Estudios;
import com.portfolio.AleBombini.repository.IEstudiosRepo;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional  //indica que va a mantener la persistencia
public class ServEstudios implements IEstudiosService {
    
    
    @Autowired
    public IEstudiosRepo estuRepo; 

    @Override
    public List<Estudios> getEstudios() {
            return estuRepo.findAll();
    }

    @Override
    public Estudios getEstudio(int id) {
            return estuRepo.findById(id).orElse(null);
    }

    @Override
    public Estudios getByTitulo(String titulo) {
           return (Estudios) estuRepo.findByTitulo(titulo);
    }

    @Override
    public void saveEstudios(Estudios estu) {
            estuRepo.save(estu);
    }

    @Override
    public void deleteEstudios(int id) {
            estuRepo.deleteById(id);
    }

    @Override
    public boolean existById(int id) {
            estuRepo.existsById(id);
        return true;    }
    
}
