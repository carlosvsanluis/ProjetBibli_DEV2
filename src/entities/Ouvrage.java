/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author SIO_8
 */
public class Ouvrage {

    /*
    La liste des attributs. Ce sont des variables qui ont une "durée de vie" longue.
    Tant que l'objet créé à partir de cette classe existe, ses attributs existent aussi.
    Ils doivent "définir" l'objet. C'est à dire qu'ils sont importants pour comprendre et
    différencier les objets.
     */
    private String id = "-1";
    private String isbn;
    private String titre;
    private String auteur;
    private String ref;
    private String nbrePages;
    private String edition;
    private String genre;
//    private String anneeEdition;
    private String langue;
    private String format;

    public Ouvrage(String id, String isbn, String titre, String auteur, String ref, String nbrePages, String edition, String genre/*, String anneeEdition*/, String langue, String format) {
        this.id = id;
        this.isbn = isbn;
        this.titre = titre;
        this.auteur = auteur;
        this.ref = ref;
        this.nbrePages = nbrePages;
        this.edition = edition;
        this.genre = genre;
//        this.anneeEdition = anneeEdition;
        this.langue = langue;
        this.format = format;
    }

    public Ouvrage(String isbn, String titre, String auteur, String ref, String nbrePages, String edition, String genre/*, String anneeEdition*/, String langue, String format) {
        this.isbn = isbn;
        this.titre = titre;
        this.auteur = auteur;
        this.ref = ref;
        this.nbrePages = nbrePages;
        this.edition = edition;
        this.genre = genre;
//        this.anneeEdition = anneeEdition;
        this.langue = langue;
        this.format = format;
    }

    /*
    Un contructeur, celui ci attend 11 paramètres de type chaine de caractères et on les
    utilise ensuite pour remplir les différents attributs.
    Pour bien suivre quel paramètre doit aller dans quel attribut on a choisi de
    nommer les paramètres comme les attributs. Attention donc à bien différencier
    les uns des autres grace à "this".
     */
    /**
     * Constructeur pour test unitaire de la classe CTableOuvrages plus simple
     */
    public Ouvrage(String id, String titre, String auteur) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getNbrePages() {
        return nbrePages;
    }

    public void setNbrePages(String nbrePages) {
        this.nbrePages = nbrePages;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

//    public String getAnneeEdition() {
//        return anneeEdition;
//    }
//
//    public void setAnneeEdition(String anneeEdition) {
//        this.anneeEdition = anneeEdition;
//    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
