package services;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CBDD {

    protected CParametresStockageBDD parametresStockageBDD = null;
    Connection conn = null;
    Statement stmt = null;

    public CBDD(CParametresStockageBDD parametresStockageBDD) {
        this.parametresStockageBDD = parametresStockageBDD;
        try {
            Class.forName(parametresStockageBDD.getDriver()); // Chargement du driver
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean connecter() {
        try {
            conn = DriverManager.getConnection(getParametresStockageBDD().getProtocole() + "//"
                    + getParametresStockageBDD().getIp() + "/"
                    + getParametresStockageBDD().getNomBase(),
                    getParametresStockageBDD().getUtilisateur(),
                    getParametresStockageBDD().getMotDePasse()
            );
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean deconnecter() {
        try {
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public int executerRequeteUpdate(String requete) {
        try {
            stmt = conn.createStatement();
            return stmt.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

   public static boolean testerConnexion(String nomFichierProperties) {
        CBDD bdd = new CBDD(new CParametresStockageBDD(nomFichierProperties));
        if (bdd.connecter() == true) {

            bdd.deconnecter();
            return true;
        } else {
            return false;

        }
    }

    public ResultSet executerRequeteQuery(String requete) {
        try {
            stmt = conn.createStatement();
            return stmt.executeQuery(requete);
        } catch (SQLException ex) {
            Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static String pretraiterChaineSQL(String s) // A NE PAS OUBLIER DE L'UTILISER POUR EVITER LES SOUCIS AVEC LES QUERIES SQL
    {
        return s.trim().replace("'", "''");
    }
    
    public static void main(String[] args) {

        // Programme de test de connexion/déconnexion à la BDD
        //
        if (CBDD.testerConnexion("parametresBdd.properties")) {
            System.out.println("Connexion OK");
        } else {
            System.out.println("Connexion impossible");
        }

    }

    public CParametresStockageBDD getParametresStockageBDD() {
        return parametresStockageBDD;
    }

}

/*
 String reqCreation = "CREATE TABLE etablissements "
 + "(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
 + "ref INTEGER,"
 + "nom VARCHAR(50),"
 + "CONSTRAINT primary_key PRIMARY KEY (id))";
 System.out.println("Req " + reqCreation);
 ArrayList<CEtab> listeEtab = new ArrayList();
 CBDD bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));
 if (bdd.connecter() == true) {
 System.out.println("Connexion OK");
 //    System.out.println("Création de la table OK");
 //   int res = bdd.exexcuterRequeteUpdate(reqCreation);
 System.out.println("Insertion d'un établissement dans la table");
 int res = bdd.exexcuterRequeteUpdate("INSERT INTO etablissements (ref, nom) VALUES (12, 'iyuiuyi')");
 System.out.println("Insertion d'un établissement dans la table");
 res = bdd.exexcuterRequeteUpdate("INSERT INTO etablissements (ref, nom) VALUES (13, 'iydfsdfdsfdsuiuyi')");

 System.out.println("Contenu de la table etablissements");
 ResultSet rs = bdd.exexcuterRequeteQuery("select * from etablissements");
 try {
 while (rs.next()) {
 int id = rs.getInt("id");
 int ref = rs.getInt("ref");
 String nom = rs.getString("nom");
 CEtab etab = new CEtab(id, ref, nom);
 listeEtab.add(etab);
 }
 } catch (SQLException ex) {
 Logger.getLogger(CBDD.class.getName()).log(Level.SEVERE, null, ex);
 }
 bdd.deconnecter();
 } else {
 System.out.println("Connexion KO");
 }
 for (CEtab etab : listeEtab) {
 System.out.println("" + etab.toString());
 }*/
