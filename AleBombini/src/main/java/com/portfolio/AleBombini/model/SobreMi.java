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
public class SobreMi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Lob
    @Column(name = "presentacion", columnDefinition = "LONGTEXT")
    private String presentacion;

    private String urlVideo;

    @Column(name = "persona_id")
    private Long PersonaId;

    public SobreMi() {
    }

    public SobreMi(String presentacion, String urlVideo, Long PersonaId) {
        this.presentacion = presentacion;
        this.urlVideo = urlVideo;
        this.PersonaId = PersonaId;
    }

}
