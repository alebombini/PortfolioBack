
package com.portfolio.AleBombini.service;

import com.portfolio.AleBombini.model.FotoLinks;
import java.util.List;


public interface IFotoLinksService {
    
    public List<FotoLinks> getFotoLinks();
    
    public FotoLinks getOne (int id);
    
    public void deleteFotoLinks(int id);
    
    public void saveFotoLinks(FotoLinks foto);

    public boolean existById(int id);
    
}
