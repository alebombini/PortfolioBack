package com.portfolio.AleBombini.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "persona_id")
    private Long PersonaId;

    private String empresa;

    private String logo;

    private String cargo;

    @Lob
    @Column(name = "descripcion", columnDefinition = "LONGTEXT")
    private String descripcion;

    private Date inicio;

    private Date fin;
    
    private boolean esTrabajoActual;

    public Experiencia() {
    }

    public Experiencia(Long PersonaId, String empresa, String logo, String cargo, String descripcion, Date inicio, Date fin) {
        this.PersonaId = PersonaId;
        this.empresa = empresa;
        this.logo = logo;
        this.cargo = cargo;
        this.descripcion = descripcion;
        this.inicio = inicio;
        this.fin = fin;
    }

    public Experiencia orElse(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
