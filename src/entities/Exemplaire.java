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
public class Exemplaire {
    private String idExemplaire;
    private String idOuvrage;
    private String idAdministre;
    private String idLieu;

    public Exemplaire(String idExemplaire, String idOuvrage, String idAdministre, String idLieu) {
        this.idExemplaire = idExemplaire;
        this.idOuvrage = idOuvrage;
        this.idAdministre = idAdministre;
        this.idLieu = idLieu;
    }

    public String getIdExemplaire() {
        return idExemplaire;
    }

    public void setIdExemplaire(String idExemplaire) {
        this.idExemplaire = idExemplaire;
    }

    public String getIdOuvrage() {
        return idOuvrage;
    }

    public void setIdOuvrage(String idOuvrage) {
        this.idOuvrage = idOuvrage;
    }

    public String getIdAdministre() {
        return idAdministre;
    }

    public void setIdAdministre(String idAdministre) {
        this.idAdministre = idAdministre;
    }

    public String getIdLieu() {
        return idLieu;
    }

    public void setIdLieu(String idLieu) {
        this.idLieu = idLieu;
    }
    
}
