/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import IHM.JFrameBibliotheque;
import entities.Exemplaire;

/**
 *
 * @author SIO_8
 */
public class CTableExemplaires {
    
    protected CBDD bdd;
    private JFrameBibliotheque jframeBiblio;

    public CTableExemplaires(CBDD bdd) {
        this.bdd = bdd;
    }
    
    /**
     * Méthode qui FONCTIONNE en test dans la psvm de cette classe actuellement permettant d'insérer un exemplaire d'un livre dans la table exemplaire de la DB.
     * @param unExemplaire
     * @return null
     */
    public int insererExemplaire(Exemplaire unExemplaire) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "INSERT INTO `exemplaires` (`idExemplaire`,`idOuvrage`, `idAdministre`, `idLieu`) "
                    + "VALUES ('" + CBDD.pretraiterChaineSQL(unExemplaire.getIdExemplaire())
                    + "', '" + CBDD.pretraiterChaineSQL(unExemplaire.getIdOuvrage())
                    + "', '" + CBDD.pretraiterChaineSQL(unExemplaire.getIdAdministre())
                    + "', '" + CBDD.pretraiterChaineSQL(unExemplaire.getIdLieu())
                    + "');";
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }
    
    public int supprimerExemplaire(Exemplaire unExemplaire) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "DELETE FROM `exemplaires` WHERE `idExemplaire` = " + unExemplaire.getIdExemplaire();
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }
    
    public static void main(String[] args) {
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        CTableExemplaires table = new CTableExemplaires(bdd);
        // Ordre des id de l'objet exemplaire: exemplaire ouvrage administre lieu
        Exemplaire unExemplaire = new Exemplaire("3", "5", "1", "2");
//        table.insererExemplaire(unExemplaire);
//      table.supprimerExemplaire(unExemplaire);
    }

    public JFrameBibliotheque getJframeBiblio() {
        return jframeBiblio;
    }

    public void setJframeBiblio(JFrameBibliotheque jframeBiblio) {
        this.jframeBiblio = jframeBiblio;
    }
}
