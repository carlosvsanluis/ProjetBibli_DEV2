/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appli;

import IHM.AjoutLivre;
import entities.Bibliotheque;
import services.CBDD;
import services.CParametresStockageBDD;
import IHM.JFrameBibliotheque;
import IHM.JFrameConnection;
import entities.Administre;
import entities.Ouvrage;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import services.CTableAdministres;
import services.CTableOuvrages;

/**
 *
 * @author gimli
 */
public class App {

    public Bibliotheque biblio;
    public JFrameBibliotheque jFrameBiblio;
    public AjoutLivre jDialogAjoutLivre;
    public JFrameConnection jFrameConnection;
//    public CTableLivres tableLivres; //TODO à commenter quand tout sera créer correctement ancienne table
    public CTableOuvrages tableOuvrages;
    public CTableAdministres tableAdministres;
    private Administre monAdministre;

    public void runBibliothequeIHM() {

        biblio = new Bibliotheque();

        jFrameConnection = new JFrameConnection(this);

        jFrameBiblio = new JFrameBibliotheque(this); //On a créer un constructeur pour créer le lien de JframeBibliotheque vers App.
//        this.jFrameBiblio.monApp = this; // Si on ne créer pas de constructeur qui demande une app dans JframeBibliotheque on peut faire ça

        jDialogAjoutLivre = new AjoutLivre(jFrameBiblio, true);
//        this.jDialogAjoutLivre.getMonApp() = this; // Comment faire si l'attribut est privé ?
        this.jDialogAjoutLivre.monApp = this;

//        ctable.setJframeBiblio(jFrameBiblio); // TODO DELETE ?
        tableOuvrages = new CTableOuvrages(new CBDD(new CParametresStockageBDD("parametresBdd.properties")), this);
        tableAdministres = new CTableAdministres(new CBDD(new CParametresStockageBDD("parametresBdd.properties")));
//        this.majBiblio(); //On ne le fait que quand on se connecte pas avant
//        this.afficherListejTableBiblio();

//        this.setRowCountjTableBiblio(0);
        this.jFrameBiblio.getjTableBibliotheque().setRowSelectionInterval(0, 0);
        jFrameConnection.setVisible(true);
//        jFrameBiblio.setVisible(true);
//        jDialogAjoutLivre.setVisible(true); //TODO A commenter quand on veut repassers sur le tableau en attendant d'avoir lié tout ça proprement

    }

    public void majBiblio() {
        biblio.setListeLivres(tableOuvrages.lireOuvrages(monAdministre));

        this.afficherListejTableBiblio();
    }

    public void setRowCountjTableBiblio(int rowCount) {
        DefaultTableModel model = (DefaultTableModel) jFrameBiblio.getjTableBibliotheque().getModel();
        model.setRowCount(rowCount);
        jFrameBiblio.getjTableBibliotheque().setModel(model); //A .setModel va venir écraser les anciennes lignes qu'on avait
        this.jFrameBiblio.idLivres = new String[rowCount]; //A Prépare un tableau d'ID de la taille du nb de livres déterminé au dessus
    }

    public Administre getMonAdministre() {
        return monAdministre;
    }

    public void afficherListejTableBiblio() {
        this.setRowCountjTableBiblio(this.biblio.getListeLivres().size()); // créer un tableau vide dans la jfram de la taille du nb de livres

        for (int i = 0; i < this.biblio.getListeLivres().size(); i++) {
            this.jFrameBiblio.idLivres[i] = this.biblio.getListeLivres().get(i).getId();
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getTitre(), i, 0);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getAuteur(), i, 1);
//            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getRef(), i, 2);
//            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getNbrePages(), i, 3);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getEdition(), i, 2);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getGenre(), i, 3);
//            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getAnneeEdition(), i, 6);
//            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getLangue(), i, 7);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getFormat(), i, 4);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getIsbn(), i, 5);
        }
    }

    public void afficherListejTableBiblio(ArrayList<Ouvrage> list) {
        this.setRowCountjTableBiblio(list.size());

        for (int i = 0; i < list.size(); i++) {
            this.jFrameBiblio.idLivres[i] = list.get(i).getId();
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getTitre(), i, 0);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getAuteur(), i, 1);
//            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getRef(), i, 2);
//            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getNbrePages(), i, 3);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getEdition(), i, 2);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getGenre(), i, 3);
//            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getAnneeEdition(), i, 6);
//            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getLangue(), i, 7);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getFormat(), i, 4);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getIsbn(), i, 5);
        }
    }

    public static void main(String[] args) {
        new App().runBibliothequeIHM();

    }

    public void setMonAdministre(Administre monAdministre) {
        this.monAdministre = monAdministre;
    }
}
