
package com.portfolio.AleBombini.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class FotoLinks {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String seccion;

    private String Url_foto;

    public FotoLinks() {
    }

    public FotoLinks(String seccion, String Url_foto) {
        this.seccion = seccion;
        this.Url_foto = Url_foto;
    }

 
    

}
