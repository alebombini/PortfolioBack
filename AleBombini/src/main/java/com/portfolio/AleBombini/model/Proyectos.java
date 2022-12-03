
package com.portfolio.AleBombini.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyectos {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombreP;
    
    private String urlProyecto;
    
    private String urlFotoProyecto;

    public Proyectos() {
    }

    public Proyectos(String nombreP, String urlProyecto, String urlFotoProyecto) {
        this.nombreP = nombreP;
        this.urlProyecto = urlProyecto;
        this.urlFotoProyecto = urlFotoProyecto;
    }

    
    
    
}
