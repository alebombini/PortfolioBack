package com.portfolio.AleBombini.model;

import jakarta.persistence.Column;
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

    @Column(name = "persona_id")
    private Long PersonaId;

    private String nombreS;

    private int nivel;

    public Skills() {
    }

    public Skills(Long PersonaId, String nombreS, int nivel) {
        this.PersonaId = PersonaId;
        this.nombreS = nombreS;
        this.nivel = nivel;
    }

}
