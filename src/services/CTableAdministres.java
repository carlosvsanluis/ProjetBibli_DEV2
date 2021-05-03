/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Administre;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SIO_8
 */
public class CTableAdministres {

    protected CBDD bdd;

    public CTableAdministres(CBDD bdd) {
        this.bdd = bdd;
    }
//private String id;
//    private String nom;
//    private String prenom;
//    private String telephone;
//    private String email;

    public Administre convertir_RS_Administre(ResultSet rs) {
        try {
            String id = rs.getString(1);
            String nomAdministre = rs.getString(2);
            String prenomAdministre = rs.getString(3);
            String telephoneAdministre = rs.getString(4);
            String emailAdministre = rs.getString(5);
            String adresseAdministre = rs.getString(6);
            String password = rs.getString(7);

            Administre unAdministre = new Administre(id, nomAdministre, prenomAdministre, telephoneAdministre, emailAdministre, adresseAdministre, password);

            return unAdministre;
        } catch (SQLException ex) {
            Logger.getLogger(CTableOuvrages.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Administre lireAdministre(String email, String password) {
        Administre unAdministre = null;
        if (bdd.connecter() == true) {
            System.out.println("Connexion OK");
            ResultSet rs = bdd.executerRequeteQuery("select * from administres  WHERE `emailAdministre` = '" + email 
                    + "' AND `password` = '"+ password + "';");
            try {
                if (rs.next()) {
                    unAdministre = convertir_RS_Administre(rs); //Ne pas oublier de vérifier cette méthode elle est très importante et permet de transformer un objet rs en Administre
                }
            } catch (SQLException ex) {
                Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return unAdministre;
    }

    public ArrayList<Administre> lireAdministres() {

        if (bdd.connecter() == true) {
            ArrayList<Administre> listeAdministres = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("select * from administres");
            try {
                while (rs.next()) {
                    Administre unAdministre = convertir_RS_Administre(rs);
                    listeAdministres.add(unAdministre);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            bdd.deconnecter();
            return listeAdministres;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    /**
     * Insère un nouvel auteur dans la base de donnée. Nécessite un objet
     * Administre.
     *
     * @param unAdministre
     * @return res
     */
    public int insererAdministre(Administre unAdministre) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "INSERT INTO `administres` (`idAdministre`,`nomAdministre`,`prenomAdministre`,`telephoneAdministre`,`emailAdministre`,`adresseAdministre`)"
                    + "VALUES ('" + CBDD.pretraiterChaineSQL(unAdministre.getId())
                    + "', '" + CBDD.pretraiterChaineSQL(unAdministre.getNom())
                    + "', '" + CBDD.pretraiterChaineSQL(unAdministre.getPrenom())
                    + "', '" + CBDD.pretraiterChaineSQL(unAdministre.getTelephone())
                    + "', '" + CBDD.pretraiterChaineSQL(unAdministre.getEmail())
                    + "', '" + CBDD.pretraiterChaineSQL(unAdministre.getAdresse())
                    + "');";
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    /**
     * Supprimer un administre de la table administres. Nécessite un objet de
     * type auteur en paramètre
     *
     * @param unAdministre
     * @return res
     */
    public int supprimerAdministre(Administre unAdministre) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "DELETE FROM `administres` WHERE `idAdministre` = " + unAdministre.getId();
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    /**
     * Supprimer un administre de la table administres. Nécessite l'id d'un
     * auteur en paramètre
     *
     * @param idAdministre
     * @return res
     */
    public int supprimerAdministre(String idAdministre) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "DELETE FROM `administres` WHERE `idAdministre` = " + idAdministre;
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

//TODO Réfléchir à comment cette méthode va devoir fonctionner.
    public int modifierAdministre(Administre unAdministre) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "UPDATE `auteurs` SET "
                    + "`idAdministre` = '"
                    + CBDD.pretraiterChaineSQL(unAdministre.getId())
                    + "', "
                    + "`nomAdministre` = '"
                    + CBDD.pretraiterChaineSQL(unAdministre.getNom())
                    + ","
                    + "`prenomAdministre` = '"
                    + CBDD.pretraiterChaineSQL(unAdministre.getPrenom())
                    + ","
                    + "`telephoneAdministre` = '"
                    + CBDD.pretraiterChaineSQL(unAdministre.getTelephone())
                    + ","
                    + "`emailAdministre` = '"
                    + CBDD.pretraiterChaineSQL(unAdministre.getEmail())
                    + ","
                    + "`adresseAdministre` = '"
                    + CBDD.pretraiterChaineSQL(unAdministre.getAdresse())
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
        CTableAdministres controlleur = new CTableAdministres(bdd);
        // public Administre(String id, String nom, String prenom, String telephone, String email, String adresse)
//        Administre Victor = new Administre("2", "Dupont", "Philippe", "0299784512", "dupont.philippe@wanadoo.fr", "1 avenue Mervaud 35400 Saint-malo"); // objet administre de test
//        table.insererAdministre(Victor);
//        table.supprimerAdministre("2");
        controlleur.lireAdministre("lemorvanjulien35@gmail.com", "Bonjour"); // DONE ça fonctionne bien en vérifiant en debug on avait bien l'administre entier.
        System.out.println("");
    }
}
