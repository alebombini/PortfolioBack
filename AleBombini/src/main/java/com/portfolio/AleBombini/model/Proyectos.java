package com.portfolio.AleBombini.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Proyectos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "persona_id")
    private Long PersonaId;

    private String nombreP;
    
    @Lob
    private String descripcionP;

    private String urlProyecto;

    private String urlFotoProyecto;

    public Proyectos() {
    }

    public Proyectos(Long PersonaId, String nombreP, String descripcionP, String urlProyecto, String urlFotoProyecto) {
        this.PersonaId = PersonaId;
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.urlProyecto = urlProyecto;
        this.urlFotoProyecto = urlFotoProyecto;
    }

  
}
