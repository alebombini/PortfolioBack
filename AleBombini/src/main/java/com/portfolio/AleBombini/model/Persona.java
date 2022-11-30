
package com.portfolio.AleBombini.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Size(max = 50, message = "No cumple con la longitud minima")
    private String nombre;
    
    @NotBlank
    private String apellido;
    
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

    public Persona() {
    }

    public Persona(String nombre, String apellido, String titulo, Date fechaNac, String email, String UrlGithub, String whatsapp, String UrlTelegram, String UrlLinkedIn) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.fechaNac = fechaNac;
        this.email = email;
        this.UrlGithub = UrlGithub;
        this.whatsapp = whatsapp;
        this.UrlTelegram = UrlTelegram;
        this.UrlLinkedIn = UrlLinkedIn;
    }
    

    
}
