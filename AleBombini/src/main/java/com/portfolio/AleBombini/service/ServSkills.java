
package com.portfolio.AleBombini.service;

import com.portfolio.AleBombini.model.Skills;
import com.portfolio.AleBombini.repository.ISkillsRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServSkills implements ISkillsService{

    @Autowired
    public ISkillsRepo iSkillsRepo;
    
    @Override
    public List<Skills> getSkills() {
        List <Skills> skills = iSkillsRepo.findAll();
        return skills;
    }

    @Override
    public void saveSkill(Skills skill) {
        iSkillsRepo.save(skill);
    }

    @Override
    public void deleteSkill(int id) {
        iSkillsRepo.deleteById(id);
    }

    @Override
    public Skills findSkill(int id) {
        Skills skill = iSkillsRepo.findById(id).orElse(null);
        return skill;
    }
    
    
}
