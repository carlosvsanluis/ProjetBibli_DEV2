/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Damien
 */

/*
Cette classe nous servira à créer des objets de type "Livre", ils devront représenter
des livres physiques ou virtuels et donc posséder les attributs permettant de les définir.
 */
public class Livre {

    /*
    La liste des attributs. Ce sont des variables qui ont une "durée de vie" longue.
    Tant que l'objet créé à partir de cette classe existe, ses attributs existent aussi.
    Ils doivent "définir" l'objet. C'est à dire qu'ils sont importants pour comprendre et
    différencier les objets.
     */
    private String id = "-1";
    private String titre;
    private String auteur;
    private String ref;
    private String nbrePages;
    private String edition;
    private String genre;
    private String anneeEdition;
    private String langue;
    private String format;


    /*
    Un contructeur, celui ci attend 9 paramètres de type chaine de caractères et on les
    utilise ensuite pour remplir les différents attributs.
    Pour bien suivre quel paramètre doit aller dans quel attribut on a choisi de
    nommer les paramètres comme les attributs. Attention donc à bien différencier
    les uns des autres grace à "this".
     */
    public Livre(String titre, String auteur, String ref, String nbrePages, String edition, String genre, String anneeEdition, String langue, String format) {
        this.titre = titre;
        this.auteur = auteur;
        this.ref = ref;
        this.nbrePages = nbrePages;
        this.edition = edition;
        this.genre = genre;
        this.anneeEdition = anneeEdition;
        this.langue = langue;
        this.format = format;
    }

    public Livre(String id, String titre, String auteur, String ref, String nbrePages, String edition, String genre, String anneeEdition, String langue, String format) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.ref = ref;
        this.nbrePages = nbrePages;
        this.edition = edition;
        this.genre = genre;
        this.anneeEdition = anneeEdition;
        this.langue = langue;
        this.format = format;
    }
    

    /*
    D'autres contructeurs, ici commentés car je ne souhaite pas laisser de choix.
    Dans cet état il est obligatoire d'utiliser le contructeur qui remplit tous les
    attributs avec des chaines de caractères.
     */
    public Livre() {
    }

    /**
     * Un constructeur pour faire un livre juste avec l'id
     * @param idString 
     */
    public Livre(String idString) {
        this.id = idString;
    }

    public Livre(String titreDonne, String nomAuteur) {
        this.titre = titreDonne;
        this.auteur = nomAuteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * @return the auteur
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * @param auteur the auteur to set
     */
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    /**
     * @return the ref
     */
    public String getRef() {
        return ref;
    }

    /**
     * @param ref the ref to set
     */
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * @return the nbrePages
     */
    public String getNbrePages() {
        return nbrePages;
    }

    /**
     * @param nbrePages the nbrePages to set
     */
    public void setNbrePages(String nbrePages) {
        this.nbrePages = nbrePages;
    }

    /**
     * @return the edition
     */
    public String getEdition() {
        return edition;
    }

    /**
     * @param edition the edition to set
     */
    public void setEdition(String edition) {
        this.edition = edition;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * @return the anneeEdition
     */
    public String getAnneeEdition() {
        return anneeEdition;
    }

    /**
     * @param anneeEdition the anneeEdition to set
     */
    public void setAnneeEdition(String anneeEdition) {
        this.anneeEdition = anneeEdition;
    }

    /**
     * @return the langue
     */
    public String getLangue() {
        return langue;
    }

    /**
     * @param langue the langue to set
     */
    public void setLangue(String langue) {
        this.langue = langue;
    }

    /**
     * @return the format
     */
    public String getFormat() {
        return format;
    }

    /**
     * @param format the format to set
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /*
    Nous souhaitons pouvoir afficher un apperçu des informations du livre, cette
    méthode nous le permet.
     */
    public void afficher() {
        System.out.println("Titre : " + this.titre);
        System.out.println("Auteur : " + this.auteur);
        System.out.println("Année d'édition : " + this.anneeEdition);
    }

    @Override
    public String toString() {
        String str = "Titre : " + this.titre + "\nAuteur : "
                + this.auteur + "\nAnnée d'édition : "
                + this.anneeEdition;
        return str;
    }

    /*
    Lorsque l'on n'utilise pas de framework de test comme jUnit, il est nécessaire
    de tester nos méthodes au minimum localement comme ci dessous.
     */
    public static void main(String[] args) {
        String titre = "titre";
        String auteur = "auteur";
        String ref = "ref";
        String nbrePages = "nbrePage";
        String edition = "edition";
        String genre = "genre";
        String anneeEdition = "anneeEdition";
        String langue = "langue";
        String format = "format";

        Livre livreTest = new Livre(titre, auteur, ref, nbrePages, edition, genre, anneeEdition, langue, format);

        // livreTest.afficher();
        System.out.println(livreTest.toString());
        System.out.println(livreTest);
        livreTest.afficher();
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
}
