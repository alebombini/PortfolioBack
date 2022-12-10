package com.portfolio.AleBombini.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50, message = "No cumple con la longitud minima")
    private String nombre;

    @NotBlank
    private String apellido;

    @NotBlank
    private String clave;

    private String titulo;

    private Date fechaNac;

    @Lob
    private String email;

    @Lob
    private String UrlGithub;

    @NotBlank
    private String whatsapp;

    @Lob
    @NotBlank
    private String UrlTelegram;

    @Lob
    @NotBlank
    private String UrlLinkedIn;

    @OneToMany(mappedBy = "PersonaId")
    private List<SobreMi> sobremi;

    @OneToMany(mappedBy = "PersonaId")
    private List<Estudios> estudios;

    @OneToMany(mappedBy = "PersonaId")
    private List<Experiencia> experiencia;

    @OneToMany(mappedBy = "PersonaId")
    private List<FotoLinks> fotoLinks;

    @OneToMany(mappedBy = "PersonaId")
    private List<Proyectos> proyectos;

    @OneToMany(mappedBy = "PersonaId")
    private List<Skills> skills;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String clave, String titulo, Date fechaNac, String email, String UrlGithub, String whatsapp, String UrlTelegram, String UrlLinkedIn, List<SobreMi> sobremi, List<Estudios> estudios, List<Experiencia> experiencia, List<FotoLinks> fotoLinks, List<Proyectos> proyectos, List<Skills> skills) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.clave = clave;
        this.titulo = titulo;
        this.fechaNac = fechaNac;
        this.email = email;
        this.UrlGithub = UrlGithub;
        this.whatsapp = whatsapp;
        this.UrlTelegram = UrlTelegram;
        this.UrlLinkedIn = UrlLinkedIn;
        this.sobremi = sobremi;
        this.estudios = estudios;
        this.experiencia = experiencia;
        this.fotoLinks = fotoLinks;
        this.proyectos = proyectos;
        this.skills = skills;

        estudios = new ArrayList();
        experiencia = new ArrayList();
        proyectos = new ArrayList();
        sobremi = new ArrayList();
        skills = new ArrayList();
        fotoLinks = new ArrayList();
    }

}
