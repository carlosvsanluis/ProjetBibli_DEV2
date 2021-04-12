/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author SIO_8
 */
public class Auteur {
    
    private String id;
    private String nomAuteur;

    public Auteur(String id, String nomAuteur) {
        this.id = id;
        this.nomAuteur = nomAuteur;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomAuteur() {
        return nomAuteur;
    }

    public void setNomAuteur(String nomAuteur) {
        this.nomAuteur = nomAuteur;
    }
}
