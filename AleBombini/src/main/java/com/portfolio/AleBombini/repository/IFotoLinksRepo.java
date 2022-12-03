
package com.portfolio.AleBombini.repository;

import com.portfolio.AleBombini.model.FotoLinks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFotoLinksRepo extends JpaRepository <FotoLinks, Integer>{
    
}
