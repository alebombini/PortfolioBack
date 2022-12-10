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
public class FotoLinks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "persona_id")
    private Long PersonaId;

    private String seccion;
    
    private String link;

    private String url_foto;

    public FotoLinks() {
    }

    public FotoLinks(Long PersonaId, String seccion, String url_foto) {
        this.PersonaId = PersonaId;
        this.link = link;
        this.seccion = seccion;
        this.url_foto = url_foto;
    }

}
