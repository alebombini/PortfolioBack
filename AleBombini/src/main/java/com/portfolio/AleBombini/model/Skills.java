package com.portfolio.AleBombini.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombreS;

    
    private String nivel;


    public Skills() {
    }

    public Skills(String nombreS, String nivel, String urlFotoProyecto) {
        this.nombreS = nombreS;
        this.nivel = nivel;
       
    }
    
    
    
}
