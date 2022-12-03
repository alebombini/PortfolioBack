
package com.portfolio.AleBombini.repository;

import com.portfolio.AleBombini.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillsRepo extends JpaRepository <Skills, Integer> {
    
}
