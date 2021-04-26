/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Livre;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe fourni par GIMLI - A n'utiliser qu'en référence de base pour les méthodes ne PAS les appeller dans notre code.
 * @author gimli
 */
public class CTableLivres {

    protected CBDD bdd;

    public CTableLivres(CBDD bdd) {
        this.bdd = bdd;
    }

    public Livre convertir_RS_Livre(ResultSet rs) {
        try {
            String id = rs.getString(1);
            String titre = rs.getString(2);
            String auteur = rs.getString(3);
            String ref = rs.getString(4);
            String nbrePages = rs.getString(5);
            String edition = rs.getString(6);
            String genre = rs.getString(7);
            String anneeEdition = rs.getString(8);
            String langue = rs.getString(9);
            String format = rs.getString(10);

            Livre livre = new Livre(id, titre, auteur, ref, nbrePages, edition, genre, anneeEdition, langue, format);

            return livre;
        } catch (SQLException ex) {
            Logger.getLogger(CTableLivres.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Livre lireLivre(int id) {
        Livre livre = null;
        if (bdd.connecter() == true) {
            System.out.println("Connexion OK");
            ResultSet rs = bdd.executerRequeteQuery("select * from livres  WHERE `livres`.`id` = " + id);
            try {
                if (rs.next()) {
                    livre = convertir_RS_Livre(rs);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return livre;
    }

    public ArrayList<Livre> lireLivres() {

        if (bdd.connecter() == true) {
            ArrayList<Livre> listeLivres = new ArrayList();
            ResultSet rs = bdd.executerRequeteQuery("select * from livres");
            try {
                while (rs.next()) {
                    Livre livre = convertir_RS_Livre(rs);
                    listeLivres.add(livre);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            bdd.deconnecter();
            return listeLivres;
        } else {
            System.out.println("Connexion KO");
        }
        return null;
    }

    public int insererLivre(Livre livre) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "INSERT INTO `livres` (`Titre`, `Auteur`, `Ref`,"
                    + " `NbrPages`, `edition`, `genre`, `anneeEdition`, `langue`, `format`) "
                    + "VALUES ('" + CBDD.pretraiterChaineSQL(livre.getTitre())
                    + "', '" + CBDD.pretraiterChaineSQL(livre.getAuteur())
                    + "', '" + CBDD.pretraiterChaineSQL(livre.getRef())
                    + "', '" + CBDD.pretraiterChaineSQL(livre.getNbrePages())
                    + "', '" + CBDD.pretraiterChaineSQL(livre.getEdition())
                    + "', '" + CBDD.pretraiterChaineSQL(livre.getGenre())
                    + "', '" + CBDD.pretraiterChaineSQL(livre.getAnneeEdition())
                    + "', '" + CBDD.pretraiterChaineSQL(livre.getLangue())
                    + "', '" + CBDD.pretraiterChaineSQL(livre.getFormat())
                    + "');";
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    public int supprimerLivre(Livre livre) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "DELETE FROM `livres` WHERE `id` = " + livre.getId();
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    public int supprimerLivre(String idLivre) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "DELETE FROM `livres` WHERE `id` = " + idLivre;
            res = bdd.executerRequeteUpdate(req);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }


    public int modifierLivre(Livre livre) {
        int res = -1;
        if (bdd.connecter() == true) {
            String req = "UPDATE `livres` SET "
                    + "`Titre` = '"
                    + CBDD.pretraiterChaineSQL(livre.getTitre())
                    + "', "
                    + "`Auteur` = '"
                    + CBDD.pretraiterChaineSQL(livre.getAuteur())
                    + "', "
                    + "`Ref` = '"
                    + CBDD.pretraiterChaineSQL(livre.getRef())
                    + "', "
                    + "`NbrPages` = '"
                    + CBDD.pretraiterChaineSQL(livre.getNbrePages())
                    + "', "
                    + "`edition` = '"
                    + CBDD.pretraiterChaineSQL(livre.getEdition())
                    + "', "
                    + "`genre` = '"
                    + CBDD.pretraiterChaineSQL(livre.getGenre())
                    + "', "
                    + "`anneeEdition` = '"
                    + CBDD.pretraiterChaineSQL(livre.getAnneeEdition())
                    + "', "
                    + "`langue` = '"
                    + CBDD.pretraiterChaineSQL(livre.getLangue())
                    + "', "
                    + "`format` = '"
                    + CBDD.pretraiterChaineSQL(livre.getFormat())
                    + "' WHERE `livres`.`id` = "
                    + CBDD.pretraiterChaineSQL(livre.getId())
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
        CTableLivres table = new CTableLivres(bdd);

        String id = "7"; //A modifier pour donner l'id du livre à supprimer
        String titre = "l'titre";
        String auteur = "l'auteur";
        String ref = "1";
        String nbrePages = "1";
        String edition = "l'edition";
        String genre = "le genre";
        String anneeEdition = "1";
        String langue = "la langue";
        String format = "le format";

        //Livre livreTest = new Livre(titre, auteur, ref, nbrePages, edition, genre, anneeEdition, langue, format);
        Livre livreTest = new Livre(id, titre, auteur, ref, nbrePages, edition, genre, anneeEdition, langue, format);

//        table.insererLivre(livreTest);
//        table.supprimerLivre(livreTest);
//        Livre livre = table.lireLivre(1);
//        livre.afficher();
//        for (Livre livre : table.lireLivres()) {
//            System.out.println("--");
//            livre.afficher();
//        }
    }
}
