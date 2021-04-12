/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

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

    protected CBDD bdd;

    public CTableOuvrages(CBDD bdd) {
        this.bdd = bdd;
    }

    public Ouvrage convertir_RS_Ouvrage(ResultSet rs) {
        try {
            String id = rs.getString(1);
            String isbn = rs.getString(2);
            String titre = rs.getString(3);
            String auteur = rs.getString(4);
            String ref = rs.getString(5);
            String nbrePages = rs.getString(6);
            String edition = rs.getString(7);
            String genre = rs.getString(8);
            String anneeEdition = rs.getString(9);
            String langue = rs.getString(10);
            String format = rs.getString(11);

            Ouvrage livre = new Ouvrage(id, isbn, titre, auteur, ref, nbrePages, edition, genre, anneeEdition, langue, format);

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

    /**
     * TODO MODIFIER LA METHODE
     *
     * @param unOuvrage
     * @return
     */
    public int insererOuvrage(Ouvrage unOuvrage) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "INSERT INTO `ouvrages` (`isbnOuvrage`,`titreOuvrage`, `idAuteur`, `refOuvrage`,"
                    + " `nbpageOuvrage`, `idEdition`, `idGenre`, `anneeeditionOuvrage`, `langueOuvrage`, `idFormat`) "
                    + "VALUES ('" + CBDD.pretraiterChaineSQL(unOuvrage.getIsbn())
                    + "', '" + CBDD.pretraiterChaineSQL(unOuvrage.getTitre())
                    + "', '" + CBDD.pretraiterChaineSQL(unOuvrage.getAuteur())
                    + "', '" + CBDD.pretraiterChaineSQL(unOuvrage.getRef())
                    + "', '" + CBDD.pretraiterChaineSQL(unOuvrage.getNbrePages())
                    + "', '" + CBDD.pretraiterChaineSQL(unOuvrage.getEdition())
                    + "', '" + CBDD.pretraiterChaineSQL(unOuvrage.getGenre())
                    + "', '" + CBDD.pretraiterChaineSQL(unOuvrage.getAnneeEdition())
                    + "', '" + CBDD.pretraiterChaineSQL(unOuvrage.getLangue())
                    + "', '" + CBDD.pretraiterChaineSQL(unOuvrage.getFormat())
                    + "');";
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }
//TODO AND DOWN FROM HERE

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
            String req = "DELETE FROM `auteurs` WHERE `id` = " + idOuvrage;
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
                    + "`anneeEdition` = '"
                    + CBDD.pretraiterChaineSQL(unOuvrage.getAnneeEdition())
                    + "', "
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
        Ouvrage livreDeux = new Ouvrage("0000000498", "Tanking the right way", "1", "2", "80", "1", "1", "2021", "English", "2");
        table.insererOuvrage(livreDeux); // Ca marche avec le jeu de valeur actuel
//        table.supprimerOuvrage(livreTest);
//        table.lireOuvrages();
//        livre.afficher();
//        for (Ouvrage livre : table.lireOuvrages()) {
//            System.out.println("--");
//            livre.afficher();
//        }
    }
}
