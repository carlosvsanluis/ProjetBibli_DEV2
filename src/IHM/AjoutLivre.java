/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import appli.App;
import entities.Ouvrage;
import services.CBDD;
import services.CParametresStockageBDD;
import services.CTableOuvrages;

/**
 *
 * @author SIO_8
 */
public class AjoutLivre extends javax.swing.JDialog {

    public CTableOuvrages tableOuvrages;
    private App monApp;

    public void setTableOuvrages(CTableOuvrages tableOuvrages) {
        this.tableOuvrages = tableOuvrages;
    }

    /**
     * Creates new form AjoutLivre
     */
    public AjoutLivre(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldTitre = new javax.swing.JTextField();
        jTextFieldAuteur = new javax.swing.JTextField();
        jLabelTitre = new javax.swing.JLabel();
        jLabelAuteur = new javax.swing.JLabel();
        jLabelEdition = new javax.swing.JLabel();
        jLabelGenre = new javax.swing.JLabel();
        jLabelFormat = new javax.swing.JLabel();
        jLabelIsbn = new javax.swing.JLabel();
        jTextFieldEdition = new javax.swing.JTextField();
        jTextFieldGenre = new javax.swing.JTextField();
        jTextFieldFormat = new javax.swing.JTextField();
        jTextFieldIsbn = new javax.swing.JTextField();
        jButtonAjouterLivre = new javax.swing.JButton();
        jButtonAnnuler = new javax.swing.JButton();
        jTextFieldAnneeEdition = new javax.swing.JTextField();
        jLabelAnneeEdition = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextFieldTitre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTitreActionPerformed(evt);
            }
        });

        jTextFieldAuteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAuteurActionPerformed(evt);
            }
        });

        jLabelTitre.setText("Titre");

        jLabelAuteur.setText("Auteur");

        jLabelEdition.setText("Edition");

        jLabelGenre.setText("Genre");

        jLabelFormat.setText("Format");

        jLabelIsbn.setText("Isbn");

        jTextFieldEdition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEditionActionPerformed(evt);
            }
        });

        jTextFieldGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGenreActionPerformed(evt);
            }
        });

        jTextFieldFormat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFormatActionPerformed(evt);
            }
        });

        jTextFieldIsbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIsbnActionPerformed(evt);
            }
        });

        jButtonAjouterLivre.setText("Ajouter ce livre");
        jButtonAjouterLivre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterLivreActionPerformed(evt);
            }
        });

        jButtonAnnuler.setText("Annuler");
        jButtonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerActionPerformed(evt);
            }
        });

        jTextFieldAnneeEdition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAnneeEditionActionPerformed(evt);
            }
        });

        jLabelAnneeEdition.setText("Années d'éditions");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelTitre)
                            .addComponent(jLabelAuteur)
                            .addComponent(jLabelEdition)
                            .addComponent(jLabelGenre)
                            .addComponent(jLabelFormat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldAuteur)
                            .addComponent(jTextFieldTitre)
                            .addComponent(jTextFieldEdition, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButtonAnnuler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAjouterLivre))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelIsbn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelAnneeEdition)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldAnneeEdition, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)))
                .addGap(95, 95, 95))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonAjouterLivre, jButtonAnnuler});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTitre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTitre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAuteur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAuteur))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEdition))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGenre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFormat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAnneeEdition)
                    .addComponent(jTextFieldAnneeEdition, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIsbn))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAjouterLivre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonAnnuler, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldTitreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTitreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTitreActionPerformed

    private void jTextFieldAuteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAuteurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAuteurActionPerformed

    private void jTextFieldEditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEditionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEditionActionPerformed

    private void jTextFieldGenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGenreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGenreActionPerformed

    private void jTextFieldFormatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFormatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFormatActionPerformed

    private void jTextFieldIsbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIsbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIsbnActionPerformed

    private void jButtonAjouterLivreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterLivreActionPerformed
        // TODO add your handling code here:
        //  ci-dessous On créer un objet ouvrage via les informations rentrées par notre utilisateur.
        Ouvrage ouvrageInsere = new Ouvrage(jTextFieldTitre.getText(), jTextFieldAuteur.getText(), jTextFieldEdition.getText(), jTextFieldGenre.getText(), jTextFieldFormat.getText(), jTextFieldAnneeEdition.getText(), jTextFieldIsbn.getText());
        this.setTableOuvrages(new CTableOuvrages(new CBDD(new CParametresStockageBDD("parametresBdd.properties"))));
        if (tableOuvrages.insererOuvrage(ouvrageInsere, this.monApp.getMonAdministre()  ) != -1) { //On vérifie que la requête s'exécute bien avant de fermer la page
            this.setVisible(false);
            this.monApp.majBiblio(); // On met à jour notre tableau afin d'afficher le livre que l'on vient d'insérer.
        }
    }//GEN-LAST:event_jButtonAjouterLivreActionPerformed

    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);

    }//GEN-LAST:event_jButtonAnnulerActionPerformed

    private void jTextFieldAnneeEditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAnneeEditionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAnneeEditionActionPerformed

    public App getMonApp() {
        return monApp;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AjoutLivre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjoutLivre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjoutLivre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjoutLivre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AjoutLivre dialog = new AjoutLivre(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjouterLivre;
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JLabel jLabelAnneeEdition;
    private javax.swing.JLabel jLabelAuteur;
    private javax.swing.JLabel jLabelEdition;
    private javax.swing.JLabel jLabelFormat;
    private javax.swing.JLabel jLabelGenre;
    private javax.swing.JLabel jLabelIsbn;
    private javax.swing.JLabel jLabelTitre;
    private javax.swing.JTextField jTextFieldAnneeEdition;
    private javax.swing.JTextField jTextFieldAuteur;
    private javax.swing.JTextField jTextFieldEdition;
    private javax.swing.JTextField jTextFieldFormat;
    private javax.swing.JTextField jTextFieldGenre;
    private javax.swing.JTextField jTextFieldIsbn;
    private javax.swing.JTextField jTextFieldTitre;
    // End of variables declaration//GEN-END:variables

    public void setMonApp(App monApp) {
        this.monApp = monApp;
    }

}
