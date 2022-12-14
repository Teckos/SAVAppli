/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package directionappli;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author khaoula
 */
public class JFrameMatérielRemplacé extends javax.swing.JFrame {
    Statement stm;
    private PreparedStatement pst;
    ResultSet rs;
    connexion maConnexion= new connexion();

    /**
     * Creates new form JFrameMatérielUtilisé
     */
    
    void Remplir_ComboPart(){
          try{
              String sql="select Nom from partenaire where Désignation='Fournisseur'";
              stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
               while(rs.next())
                {
                  String name=rs.getString("Nom");
                  ComboPart.addItem(name);
                  }
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
    }
   
    private void Remplir_ComboType(){
          try{
              String sql="select distinct(Type_App) from materiel where Id_Materiel!='1'";
              stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
               while(rs.next())
                {
                  String name=rs.getString("Type_App");
                  ComboType.addItem(name);
                  }
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
    }
    
     private void Remplir_ComboApp(){
          try{
              String sql="select distinct(Type_Mat) from materiel where Type_Mat NOT IN (select Type_Mat from materiel where Id_Materiel='1')";
              stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
               while(rs.next())
                {
                  String name=rs.getString("Type_Mat");
                  ComboApp.addItem(name);
                  }
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
    }
  
   private void Remplir_ComboNom(){
          try{
              String sql="select distinct(Nom) from materiel  where Nom NOT IN (select Nom from materiel where Id_Materiel='1')";
              stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
               while(rs.next())
                {
                  String name=rs.getString("Nom");
                  ComboNom.addItem(name);
                  }
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
    }
   
    private void Remplir_ComboCouleur(){
          try{
              String sql="select distinct(Couleur) from materiel where Couleur NOT IN (select Couleur from materiel where Id_Materiel='1')";
              stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
               while(rs.next())
                {
                  String name=rs.getString("Couleur");
                  ComboCoul.addItem(name);
                  }
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
    }
    
     
    
    public JFrameMatérielRemplacé() {
        initComponents();
        Remplir_ComboApp();
        Remplir_ComboNom();
        Remplir_ComboCouleur();
        Remplir_ComboPart();
        Remplir_ComboType();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        prix_a = new javax.swing.JTextField();
        taux = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        date_a = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        nbr = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        ComboPart = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        n_facture = new javax.swing.JTextField();
        ComboNom = new javax.swing.JComboBox();
        ComboApp = new javax.swing.JComboBox();
        ComboCoul = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        ComboType = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(0, 153, 153));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Ajout du Matériels de Remplacement :");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Nom :");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Couleur :");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Date d'Achat :");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Prix d'Achat ($):");

        prix_a.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        taux.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("taux :");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Type Appareil :");

        date_a.setDateFormatString("yyyy-MM-dd");
        date_a.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Nombre :");

        nbr.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Partenaire");

        ComboPart.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("N° de Facture :");

        n_facture.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        n_facture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_factureActionPerformed(evt);
            }
        });

        ComboNom.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        ComboApp.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        ComboCoul.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ComboCoul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboCoulActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Nom Appareil :");

        ComboType.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(nbr, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(date_a, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(2, 2, 2))
                                    .addComponent(ComboNom, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(n_facture, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prix_a, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel11)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ComboApp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboPart, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboCoul, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(taux, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ComboType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(222, 222, 222))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nbr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(ComboPart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(ComboApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ComboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(ComboNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(date_a, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(prix_a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboCoul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(taux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(n_facture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(586, 410));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:7
        String NR = nbr.getText();
       // String TVA = tva.getText();
        String N_F = n_facture.getText();
        //String N = nom.getText();
        String D_A = ((JTextField)date_a.getDateEditor().getUiComponent()).getText();
        String P_A = prix_a.getText();
       //String T = type.getText();
       // String C = couleur.getText();
        String T_X = taux.getText();
        //la requête
        
       
        
        String requete="INSERT INTO materiel(Nom,Type_Mat,Couleur,Date_Achat,Prix_Achat,Prix_Vente,Date_Utilisation,Taux_Conversion,Etat,Type_App)\n"+
                "VALUES ('"+ComboNom.getSelectedItem()+"','"+ComboApp.getSelectedItem()+"','"+ComboCoul.getSelectedItem()+"','"+D_A+"','"+P_A+"',0,'0000-00-00','"+T_X+"','Remplacé','"+ComboType.getSelectedItem()+"') " ;
        //Exécuter la requête
        int j;
         j=Integer.parseInt(NR);
        float k = Float.parseFloat(P_A);
        float l = Float.parseFloat(T_X);
        float resultat =j*k*l;
        System.out.println(resultat);
       try{
         stm=maConnexion.get_connexion().createStatement();
          for(int i=0;i<j;i++)
         {
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
        stm.executeUpdate(requete); 
         }
         JOptionPane.showMessageDialog(null,"le matériel de remplacement est ajouté");
         
       }
       catch(SQLException e){
           System.err.println(e);
         JOptionPane.showMessageDialog(null,e);
       }
       String requete1="INSERT INTO achat(Type,Désignation,Quantité,Date_Achat,Prix_Achat,N_Facture,TVA,Etat,Id_Partenaire)\n"+
                 "VALUES ('Matériel','"+ComboApp.getSelectedItem()+"','"+NR+"','"+D_A+"','"+resultat+"','"+N_F+"','0','Non payé',\n"+
                 "(select Id_Partenaire from partenaire where Nom='"+ComboPart.getSelectedItem()+"')) " ;
         try{
         stm=maConnexion.get_connexion().createStatement();
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
        stm.executeUpdate(requete1); 
         JOptionPane.showMessageDialog(null,"le nouveau Achat est ajouté");
          }
       catch(SQLException e){
           System.err.println(e);
         
       }
       nbr.setText("");
       //nom.setText("ecran");
       //type.setText("");
        // date_a.setText("");
       ((JTextField)date_a.getDateEditor().getUiComponent()).setText("");
       prix_a.setText("");
       //couleur.setText("noir");
       taux.setText("");
         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void n_factureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_factureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n_factureActionPerformed

    private void ComboCoulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboCoulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboCoulActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameMatérielRemplacé.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameMatérielRemplacé.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameMatérielRemplacé.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameMatérielRemplacé.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameMatérielRemplacé().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboApp;
    private javax.swing.JComboBox ComboCoul;
    private javax.swing.JComboBox ComboNom;
    private javax.swing.JComboBox ComboPart;
    private javax.swing.JComboBox ComboType;
    private com.toedter.calendar.JDateChooser date_a;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField n_facture;
    private javax.swing.JTextField nbr;
    private javax.swing.JTextField prix_a;
    private javax.swing.JTextField taux;
    // End of variables declaration//GEN-END:variables
}
