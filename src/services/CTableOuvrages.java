/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import appli.App;
import entities.Administre;
import entities.Ouvrage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SIO_8
 */
public class CTableOuvrages {

    public App monApp;
    protected CBDD bdd;

    public CTableOuvrages(CBDD bdd) {
        this.bdd = bdd;
        this.monApp = monApp;
    }

    public CTableOuvrages(CBDD bdd, App monApp) {
        this.bdd = bdd;
        this.monApp = monApp;
    }

    public Ouvrage convertir_RS_Ouvrage(ResultSet rs) {
        try {
            String id = rs.getString(1);
            String titre = rs.getString(2);
            String auteur = rs.getString(3);
            String edition = rs.getString(4);
            String genre = rs.getString(5);
            String format = rs.getString(6);
            String anneeEdition = rs.getString(7);
            String isbn = rs.getString(8);
            String ref = rs.getString(9);
            String nbPages = rs.getString(10);
            String langue = rs.getString(11);

            Ouvrage livre = new Ouvrage(id, titre, auteur, edition, genre, format, anneeEdition, isbn);

            return livre;
        } catch (SQLException ex) {
            Logger.getLogger(CTableOuvrages.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Ouvrage lireOuvrage(int id) {
        Ouvrage unOuvrage = null;
        if (bdd.connecter() == true) {
            System.out.println("Connexion OK");
            ResultSet rs = bdd.executerRequeteQuery("select * from ouvrages  WHERE `ouvrages`.`idOuvrage` = " + id);
            try {
                if (rs.next()) {
                    unOuvrage = convertir_RS_Ouvrage(rs);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return unOuvrage;
    }

    public ArrayList<Ouvrage> lireOuvrages() {

        if (bdd.connecter() == true) {
            ArrayList<Ouvrage> listeOuvrages = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("select * from ouvrages");
            try {
                while (rs.next()) {
                    Ouvrage unOuvrage = convertir_RS_Ouvrage(rs);
                    listeOuvrages.add(unOuvrage);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            bdd.deconnecter();
            return listeOuvrages;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    public ArrayList<Ouvrage> lireOuvrages(Administre unAdministre) {

        if (bdd.connecter() == true) {
            ArrayList<Ouvrage> listeOuvrages = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("select * from ouvrages where idAdministre = " + unAdministre.getId());
            try {
                while (rs.next()) {
                    Ouvrage unOuvrage = convertir_RS_Ouvrage(rs);
                    listeOuvrages.add(unOuvrage);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            bdd.deconnecter();
            return listeOuvrages;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    /**
     * Méthode permettant d'insérer un ouvrage dans le tableau de l'application.
     * Utilise un ouvrage et un administre en paramètre (l'administre est
     * nécessaire pour insérer le bon ID)
     *
     * @param unOuvrage
     * @param unAdministre
     * @return res
     */
    public int insererOuvrage(Ouvrage unOuvrage, Administre unAdministre) { //TODO Solution curieuse de rajouter l'administre à voir si il y a plus propre
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "INSERT INTO `ouvrages` (`titreOuvrage`,`auteur`, `edition`,"
                    + "`genre`, `format`,`anneeeditionOuvrage`, `isbnOuvrage`, `idAdministre`) "
                    + "VALUES ('" + CBDD.pretraiterChaineSQL(unOuvrage.getTitre())
                    + "', '" + CBDD.pretraiterChaineSQL(unOuvrage.getAuteur())
                    + "', '" + CBDD.pretraiterChaineSQL(unOuvrage.getEdition())
                    + "', '" + CBDD.pretraiterChaineSQL(unOuvrage.getGenre())
                    + "', '" + CBDD.pretraiterChaineSQL(unOuvrage.getFormat())
                    + "', '" + CBDD.pretraiterChaineSQL(unOuvrage.getAnneeEdition())
                    + "', '" + CBDD.pretraiterChaineSQL(unOuvrage.getIsbn())
                    + "', '" + CBDD.pretraiterChaineSQL(unAdministre.getId())
                    + "');";
            System.out.println("");
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    public int supprimerOuvrage(Ouvrage unOuvrage) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "DELETE FROM `ouvrages` WHERE `id` = " + unOuvrage.getId();
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    public int supprimerOuvrage(String idOuvrage) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "DELETE FROM `ouvrages` WHERE `idOuvrage` = " + idOuvrage;
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    public int modifierOuvrage(Ouvrage unOuvrage) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "UPDATE `auteurs` SET "
                    + "`Titre` = '"
                    + CBDD.pretraiterChaineSQL(unOuvrage.getTitre())
                    + "', "
                    + "`Auteur` = '"
                    + CBDD.pretraiterChaineSQL(unOuvrage.getAuteur())
                    + "', "
                    + "`Ref` = '"
                    + CBDD.pretraiterChaineSQL(unOuvrage.getRef())
                    + "', "
                    + "`NbrPages` = '"
                    + CBDD.pretraiterChaineSQL(unOuvrage.getNbrePages())
                    + "', "
                    + "`edition` = '"
                    + CBDD.pretraiterChaineSQL(unOuvrage.getEdition())
                    + "', "
                    + "`genre` = '"
                    + CBDD.pretraiterChaineSQL(unOuvrage.getGenre())
                    + "', "
                    //                    + "`anneeEdition` = '"
                    //                    + CBDD.pretraiterChaineSQL(unOuvrage.getAnneeEdition())
                    //                    + "', "
                    + "`langue` = '"
                    + CBDD.pretraiterChaineSQL(unOuvrage.getLangue())
                    + "', "
                    + "`format` = '"
                    + CBDD.pretraiterChaineSQL(unOuvrage.getFormat())
                    + "' WHERE `livres`.`id` = "
                    + CBDD.pretraiterChaineSQL(unOuvrage.getId())
                    + ";";
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    public static void main(String[] args) {
        CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
        CTableOuvrages table = new CTableOuvrages(bdd);

        String id = "7"; //A modifier pour donner l'id du livre à supprimer
        String isbn = "0001111111"; // rajouter pour correspondre à notre modèle,
        String titre = "Un titre"; // probleme que is   bn soit un int dépasse la valeur max de int
        String auteur = "1";
        String ref = "1";
        String nbrePages = "120";
        String edition = "1";
        String genre = "1";
        String anneeEdition = "1980";
        String langue = "la langue";
        String format = "1";

        // Constructeur public Ouvrage(isbn,titre,ref,nbrePages,langue, String anneeEdition,edition,format,auteur,genre)
//        Ouvrage livreTest = new Ouvrage(isbn, titre, auteur, ref, nbrePages, edition, genre, anneeEdition, langue, format);
//        Ouvrage livreDeux = new Ouvrage("0000000498", "Tanking the right way", "1", "2", "80", "1", "1", "2021", "English", "2");
//        table.insererOuvrage(livreDeux); // Ca marche avec le jeu de valeur actuel
//        table.supprimerOuvrage(livreTest);
        table.lireOuvrages();
//        livre.afficher();
//        for (Ouvrage livre : table.lireOuvrages()) {
//            System.out.println("--");
//            livre.afficher();
//        }
    }
}
