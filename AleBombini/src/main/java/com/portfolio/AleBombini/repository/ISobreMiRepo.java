
package com.portfolio.AleBombini.repository;

import com.portfolio.AleBombini.model.SobreMi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISobreMiRepo extends JpaRepository <SobreMi, Integer> {
    
}
