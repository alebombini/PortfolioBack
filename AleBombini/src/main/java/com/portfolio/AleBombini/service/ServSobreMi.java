
package com.portfolio.AleBombini.service;

import com.portfolio.AleBombini.model.SobreMi;
import com.portfolio.AleBombini.repository.ISobreMiRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServSobreMi implements ISobreMiService{
    
    @Autowired
    public ISobreMiRepo iSobreRepo;

    @Override
    public List<SobreMi> getSobreMi() {
        List <SobreMi> sobre = iSobreRepo.findAll();
        return sobre;
    }
    @Override
    public SobreMi getOne(int id) {
        return  iSobreRepo.findById(id).orElse(null);
    }
    

    @Override
    public void saveSobreMi(SobreMi sobre) {
        iSobreRepo.save(sobre);
    }

    @Override
    public void deleteSobreMi(int id) {
        iSobreRepo.deleteById(id);
    }

    @Override
    public SobreMi findSobreMi(int id) {
        SobreMi sobre = iSobreRepo.findById(id).orElse(null);
        return sobre;
    }

    @Override
    public boolean existById(int id) {
        iSobreRepo.existsById(id);
        return true; 
    }

    
}
