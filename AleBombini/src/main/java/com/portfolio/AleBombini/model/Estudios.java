package com.portfolio.AleBombini.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Estudios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String titulo;

    private String institucion;

    private String inicio;

    private String fin;
    
    @Column (name= "persona_id")
    private Long PersonaId;

    public Estudios() {
    }

    public Estudios(String titulo, String institucion, String inicio, String fin, Long PersonaId) {
        this.titulo = titulo;
        this.institucion = institucion;
        this.inicio = inicio;
        this.fin = fin;
        this.PersonaId = PersonaId;
    }

   

}
