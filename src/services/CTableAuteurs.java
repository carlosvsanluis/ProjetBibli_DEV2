/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Auteur;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import entities.Livre; //Inutile dans la nouvelle structure de DB

/**
 *
 * @author SIO_8
 */
public class CTableAuteurs {

    protected CBDD bdd;

    public CTableAuteurs(CBDD bdd) {
        this.bdd = bdd;
    }

    public Auteur convertir_RS_Auteur(ResultSet rs) {
        try {
            String id = rs.getString(1);
            String nomAuteur = rs.getString(2);

            Auteur unAuteur = new Auteur(id, nomAuteur);

            return unAuteur;
        } catch (SQLException ex) {
            Logger.getLogger(CTableOuvrages.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Auteur lireAuteur(int id) {
        Auteur unAuteur = null;
        if (bdd.connecter() == true) {
            System.out.println("Connexion OK");
            ResultSet rs = bdd.executerRequeteQuery("select * from auteurs  WHERE `auteurs`.`idAuteur` = " + id);
            try {
                if (rs.next()) {
                    unAuteur = convertir_RS_Auteur(rs);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return unAuteur;
    }

    public ArrayList<Auteur> lireAuteurs() {

        if (bdd.connecter() == true) {
            ArrayList<Auteur> listeAuteurs = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("select * from auteurs");
            try {
                while (rs.next()) {
                    Auteur unAuteur = convertir_RS_Auteur(rs);
                    listeAuteurs.add(unAuteur);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            bdd.deconnecter();
            return listeAuteurs;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    /**
     * Insère un nouvel auteur dans la base de donnée. Nécessite un objet de
     * type auteur.
     *
     * @param unAuteur
     * @return res
     */
    public int insererAuteur(Auteur unAuteur) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "INSERT INTO `auteurs` (`nomAuteur`)"
                    + "VALUES ('" + CBDD.pretraiterChaineSQL(unAuteur.getNomAuteur())
                    + "');";
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    /**
     * Supprimer un auteur de la table auteur. Nécessite un objet de type auteur
     * en paramètre
     *
     * @param unAuteur
     * @return res
     */
    public int supprimerAuteur(Auteur unAuteur) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "DELETE FROM `auteurs` WHERE `idAuteur` = " + unAuteur.getId();
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    /**
     * Supprimer un auteur de la table auteur. Nécessite l'id d'un auteur en
     * paramètre
     *
     * @param idAuteur
     * @return res
     */
    public int supprimerAuteur(String idAuteur) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "DELETE FROM `auteurs` WHERE `idAuteur` = " + idAuteur;
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

//TODO Réfléchir à comment cette méthode va devoir fonctionner.
    public int modifierAuteur(Auteur unAuteur) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "UPDATE `auteurs` SET "
                    + "`idAuteur` = '"
                    + CBDD.pretraiterChaineSQL(unAuteur.getId())
                    + "', "
                    + "`Auteur` = '"
                    + CBDD.pretraiterChaineSQL(unAuteur.getNomAuteur())
                    + ";";
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    //Méthode main de test unitaire de mes méthodes
    public static void main(String[] args) {
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties")); // ne pas oublier de créer une connexion
        CTableAuteurs table = new CTableAuteurs(bdd);
        Auteur Victor = new Auteur("4", "Victor Hugo"); // objet auteur de test
//        table.insererAuteur(Victor);
        table.lireAuteurs();
//        table.modifierAuteur(Victor); //Not working yet
    }
}
