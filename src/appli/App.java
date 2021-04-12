/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appli;

import entities.Bibliotheque;
import services.CBDD;
import services.CParametresStockageBDD;
import IHM.JFrameBibliotheque;
import entities.Ouvrage;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import services.CTableExemplaires;
import services.CTableLivres;
import services.CTableOuvrages;
//testing for git tyuktyktyukttyjrjhr
        
        

/**
 *
 * @author gimli
 */
public class App {

    public Bibliotheque biblio;
    public JFrameBibliotheque jFrameBiblio;
    public CTableLivres tableLivres; //TODO à commenter quand tout sera créer correctement ancienne table
    public CTableOuvrages tableOuvrages;

    public void runBibliothequeIHM() {

        CTableExemplaires ctable= new CTableExemplaires(new CBDD(new CParametresStockageBDD("parametresBdd.properties")));
        
        
        biblio = new Bibliotheque();
        jFrameBiblio = new JFrameBibliotheque();
        ctable.setJframeBiblio(jFrameBiblio);
        jFrameBiblio.setTableExemplaires(ctable);
        tableOuvrages = new CTableOuvrages(new CBDD(new CParametresStockageBDD("parametresBdd.properties")));
        this.majBiblio();
        //this.afficherListejTableBiblio();

        //this.setRowCountjTableBiblio(0);
        this.jFrameBiblio.getjTableBibliotheque().setRowSelectionInterval(0, 0);
        jFrameBiblio.setVisible(true);

    }

    public void majBiblio() {
        biblio.setListeLivres(tableOuvrages.lireOuvrages());
        this.afficherListejTableBiblio();
    }

    public void setRowCountjTableBiblio(int rowCount) {
        DefaultTableModel model = (DefaultTableModel) jFrameBiblio.getjTableBibliotheque().getModel();
        model.setRowCount(rowCount);
        jFrameBiblio.getjTableBibliotheque().setModel(model); //A .setModel va venir écraser les anciennes lignes qu'on avait
        this.jFrameBiblio.idLivres = new String[rowCount]; //A Prépare un tableau d'ID de la taille du nb de livres déterminé au dessus
    }

    public void afficherListejTableBiblio() {
        this.setRowCountjTableBiblio(this.biblio.getListeLivres().size()); // créer un tableau vide dans la jfram de la taille du nb de livres

        for (int i = 0; i < this.biblio.getListeLivres().size(); i++) {
            this.jFrameBiblio.idLivres[i] = this.biblio.getListeLivres().get(i).getId();
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getTitre(), i, 0);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getAuteur(), i, 1);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getRef(), i, 2);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getNbrePages(), i, 3);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getEdition(), i, 4);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getGenre(), i, 5);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getAnneeEdition(), i, 6);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getLangue(), i, 7);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getFormat(), i, 8);
        }
    }

    public void afficherListejTableBiblio(ArrayList<Ouvrage> list) {
        this.setRowCountjTableBiblio(list.size());

        for (int i = 0; i < list.size(); i++) {
            this.jFrameBiblio.idLivres[i] = list.get(i).getId();
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getTitre(), i, 0);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getAuteur(), i, 1);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getRef(), i, 2);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getNbrePages(), i, 3);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getEdition(), i, 4);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getGenre(), i, 5);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getAnneeEdition(), i, 6);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getLangue(), i, 7);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getFormat(), i, 8);
        }
    }

    public static void main(String[] args) {
        new App().runBibliothequeIHM();

    }
}
