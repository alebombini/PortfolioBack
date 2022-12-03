
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
public class SobreMi {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
  
    @Lob
    private String presentacion;
    
    private String urlVideo;

    public SobreMi() {
    }

    public SobreMi(String presentacion, String urlVideo) {
        this.presentacion = presentacion;
        this.urlVideo = urlVideo;
    }
    
    
}
