package com.portfolio.AleBombini.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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

    private String inicio;

    private String fin;
    
    private boolean esTrabajoActual;

    public Experiencia() {
    }

    public Experiencia(Long PersonaId, String empresa, String logo, String cargo, String descripcion, String inicio, String fin, boolean esTrabajoActual) {
        this.PersonaId = PersonaId;
        this.empresa = empresa;
        this.logo = logo;
        this.cargo = cargo;
        this.descripcion = descripcion;
        this.inicio = inicio;
        this.fin = fin;
        this.esTrabajoActual = esTrabajoActual;
    }

   /* public Experiencia orElse(Object object) {
    }*/

    public Experiencia orElse(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
