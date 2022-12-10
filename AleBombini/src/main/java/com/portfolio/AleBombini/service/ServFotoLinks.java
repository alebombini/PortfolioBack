
package com.portfolio.AleBombini.service;

import com.portfolio.AleBombini.model.FotoLinks;
import com.portfolio.AleBombini.repository.IFotoLinksRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServFotoLinks implements IFotoLinksService{
    
    
    @Autowired
    public IFotoLinksRepo fotoRepo;

    @Override
    public List<FotoLinks> getFotoLinks() {
        return fotoRepo.findAll();    }

    @Override
    public FotoLinks getOne(int id) {
        return fotoRepo.findById(id).orElse(null);    }


    @Override
    public void saveFotoLinks(FotoLinks foto) {
        fotoRepo.save(foto);
    }

    @Override
    public void deleteFotoLinks(int id) {
        fotoRepo.deleteById(id);
    }

    @Override
    public boolean existById(int id) {
        fotoRepo.existsById(id);
        return true;
    }
    
    
}
