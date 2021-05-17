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
    public CTableOuvrages tableOuvrages;
    public CTableAdministres tableAdministres;
    private Administre monAdministre;

    /**
     * Méthode s'exécutant au lancement de l'application. Elle créer tout les
     * controlleurs et toute les frame nécessaires au bon fonctionnement de
     * notre application.
     */
    public void runBibliothequeIHM() {

        biblio = new Bibliotheque();

        jFrameConnection = new JFrameConnection(this);

        jFrameBiblio = new JFrameBibliotheque(this); //On a créer un constructeur pour faire le lien de JframeBibliotheque vers App.
//        this.jFrameBiblio.monApp = this; // Si on ne souhaite pas ajouter de constructeur qui demande une app en paramètre dans JframeBibliotheque on peut faire ça

        jDialogAjoutLivre = new AjoutLivre(jFrameBiblio, true);
        this.jDialogAjoutLivre.setMonApp(this);  // Si l'attribut est privé on utilise un setter car l'attribut existe déjà bien que vide. 

        tableOuvrages = new CTableOuvrages(new CBDD(new CParametresStockageBDD("parametresBdd.properties")), this);
        tableAdministres = new CTableAdministres(new CBDD(new CParametresStockageBDD("parametresBdd.properties")));
//        this.majBiblio(); //Désormais on ne peut l'appeller qu'avec un Administre car on a modifié la méthode lireOuvrages. On ne l'appelle donc plus au lancement mais quand une connexion s'effectue avec succès.

//        this.jFrameBiblio.getjTableBibliotheque().setRowSelectionInterval(0, 0);
        jFrameConnection.setVisible(true);

    }

    /**
     * Méthode permettant de mettre à jour les infos dans le tableau des livres.
     * Pour se faire elle set la liste de l'objet bibliothèque en utilisant la
     * méthode lireOuvrages du controlleur des ouvrages. On utilise la nouvelle
     * version de lireOuvrages ayant en paramètre un Administre afin de
     * n'afficher les bouquins que de l'administre s'étant connecté.
     */
    public void majBiblio() {
        biblio.setListeOuvrages(tableOuvrages.lireOuvrages(monAdministre));

        this.afficherListejTableBiblio();
    }

    /**
     * Créer le tableau vide dans la frame Bibliothèque. NE PAS L'APPELLER
     * DIRECTEMENT SAUF SI BESOIN ABSOLU Elle est utilisé dans la méthode
     * majBiblio qui est celle à utiliser
     *
     * @param rowCount
     */
    public void setRowCountjTableBiblio(int rowCount) {
        DefaultTableModel model = (DefaultTableModel) jFrameBiblio.getjTableBibliotheque().getModel();
        model.setRowCount(rowCount);
        jFrameBiblio.getjTableBibliotheque().setModel(model); //A .setModel va venir écraser les anciennes lignes qu'on avait
        this.jFrameBiblio.idLivres = new String[rowCount]; //A Prépare un tableau d'ID de la taille du nb de livres déterminé au dessus
    }

    /**
     * 1er temps: Créer un tableau vide de la taille du nb de livres en
     * appellant la méthode setRowCountjTableBiblio. 2nd temps: Insère les
     * données récupérées dans la DB dans le tableau.
     */
    public void afficherListejTableBiblio() {
        this.setRowCountjTableBiblio(this.biblio.getListeLivres().size()); // créer un tableau vide dans la jframe de la taille du nb de livres

        // On ajoute ensuite les données.
        for (int i = 0; i < this.biblio.getListeLivres().size(); i++) {
            this.jFrameBiblio.idLivres[i] = this.biblio.getListeLivres().get(i).getId();
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getId(), i, 0);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getTitre(), i, 1);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getAuteur(), i, 2);
//            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getRef(), i, 2);
//            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getNbrePages(), i, 3);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getEdition(), i, 3);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getGenre(), i, 4);
//            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getLangue(), i, 7);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getFormat(), i, 5);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getAnneeEdition(), i, 6);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getIsbn(), i, 7);
//            this.retirerColomneGauche();

        }
    }

    /**
     * NE PAS UTILISER POUR LE MOMENT. Méthode de test de removeColumn pour
     * l'appeller depuis d'autres méthodes/éléments (ex bouton) Elle ne
     * fonctionne pas actuellement. PISTE -> Notre modèle est redéfini dans
     * setRowCountjTableBiblio(int)
     */
    public void retirerColomneGauche() {
        this.jFrameBiblio.getjTableBibliotheque().removeColumn(this.jFrameBiblio.getjTableBibliotheque().getColumnModel().getColumn(0));
    }
    
//    /**
//     * Ancienne méthode qui fonctionnait en appelant la liste de notre
//     * bibliothque on ne l'utilise pas actuellement.
//     *
//     * @param list
//     */
//    public void afficherListejTableBiblio(ArrayList<Ouvrage> list) {
//        this.setRowCountjTableBiblio(list.size());
//
//        for (int i = 0; i < list.size(); i++) {
//            this.jFrameBiblio.idLivres[i] = list.get(i).getId();
//            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getTitre(), i, 0);
//            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getAuteur(), i, 1);
////            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getRef(), i, 2);
////            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getNbrePages(), i, 3);
//            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getEdition(), i, 2);
//            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getGenre(), i, 3);
////            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getAnneeEdition(), i, 6);
////            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getLangue(), i, 7);
//            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getFormat(), i, 4);
//            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getIsbn(), i, 5);
//        }
//    }

    public Administre getMonAdministre() {
        return monAdministre;
    }

    public void setMonAdministre(Administre monAdministre) {
        this.monAdministre = monAdministre;
    }

    public static void main(String[] args) {
        new App().runBibliothequeIHM();

    }
}
