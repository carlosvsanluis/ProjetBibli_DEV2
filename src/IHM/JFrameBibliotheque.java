/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import appli.App;
import java.awt.AWTException;
import static java.awt.Event.ENTER;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author gimli
 */
public class JFrameBibliotheque extends javax.swing.JFrame {

    public String[] idLivres;
    private App monApp;

    /**
     * Creates new form JFrameBibliothèque Dans l'idéal d'un rendu très propre
     * il faudrait le comment pour s'assurer qu'on appelle que l'autre mais pour
     * le moment il faut "jouer safe"
     */
    public JFrameBibliotheque() {
        initComponents();
    }

    // On créer un constructeur qui oblige de créer le lien avec l'application pour que Jframe puisse l'utiliser.
    public JFrameBibliotheque(App uneApp) {
        this.monApp = uneApp;
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

        jDialog1 = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBibliotheque = new javax.swing.JTable();
        jLabelBibliotheque = new javax.swing.JLabel();
        addBook = new javax.swing.JButton();
        removeBook = new javax.swing.JButton();
        editBook = new javax.swing.JButton();

        jDialog1.setAlwaysOnTop(true);

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableBibliotheque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "int", "Titre", "Auteur", "Edition", "Genre", "Format", "Année d'éditions", "Isbn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableBibliotheque.setColumnSelectionAllowed(true);
        jTableBibliotheque.setFocusable(false);
        jTableBibliotheque.setRowSelectionAllowed(true);
        jTableBibliotheque.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableBibliotheque);
        jTableBibliotheque.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabelBibliotheque.setText("Bibliotheque");

        addBook.setText("Ajouter un livre");
        addBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookActionPerformed(evt);
            }
        });

        removeBook.setText("TODO Supprimer un livre");
        removeBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBookActionPerformed(evt);
            }
        });

        editBook.setText("TODO modifier le livre select");
        editBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelBibliotheque)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addBook)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeBook)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editBook)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabelBibliotheque)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBook)
                    .addComponent(removeBook)
                    .addComponent(editBook))
                .addContainerGap(176, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookActionPerformed
        //TODO add your handling code here:
        // On veut  setVisible(true) la fenêtre jDialogAjoutLivre
        this.monApp.jDialogAjoutLivre.setVisible(true);
    }//GEN-LAST:event_addBookActionPerformed

    private void removeBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBookActionPerformed
        // TODO add your handling code here:
        // On veut supprimer le livre qui est actuellement sélectionné dans le tableau. Il va falloir faire une petite recherche dans les méthodes des jtable pour bien cibler un row.
        // Ou peut-être juste appeller une méthode qui va supprimer celui sélectionné de la DB puis mettre à jour via majBiblio()
//        String idLivre = new String (jTableBibliotheque.getSelectedRow());

//        this.monApp.tableOuvrages.supprimerOuvrage(jTableBibliotheque.getSelectedRow()); //Doute sur la nature de l'id qu'il va récupérer. Est-ce la valeur dans java ou l'id de notre db ?
        // C'est bien le cas de décrit juste avant.
//this.monApp.retirerColomneGauche();
//        jTableBibliotheque.set
//        this.monApp.majBiblio();
    }//GEN-LAST:event_removeBookActionPerformed

    private void editBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBookActionPerformed
        // TODO add your handling code here:
        // On va essayer d'ouvrir une nouvelle fenêtre de type jdialog avec des jtextfield rempli avec les valeurs de la colonne sélectionnée dans jFrameBibliotheque.
        //Créer un objet qu'on donne dans la fenêtre des jtextfields ?
//        jTableBibliotheque.getValueAt(int row, int column) //maybe cette méthode sera utiliser dans la nouvelle fenêtre ? Il faudra pouvoir accéder à la table de la fenêtre parent.
    }//GEN-LAST:event_editBookActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameBibliotheque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameBibliotheque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameBibliotheque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameBibliotheque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameBibliotheque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBook;
    private javax.swing.JButton editBook;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabelBibliotheque;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableBibliotheque;
    private javax.swing.JButton removeBook;
    // End of variables declaration//GEN-END:variables

    public JTable getjTableBibliotheque() {
        return jTableBibliotheque;
    }

}
