/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package directionappli;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author khaoula
 */
public class JFrameModifErreur extends javax.swing.JFrame {
    Statement stm;
    ResultSet rs;
    DefaultTableModel dt;
    connexion maConnexion=new connexion();
    String teck1;

    /**
     * Creates new form JFrameProductivitéPersonnelle
     */
    /* void Remplir_TableProd(){
          try{
             // dt.setRowCount(0);
              String sql="select N_Serie,Date_E,N_Dossier, from facture where N_Facture_V NOT IN (select N_Facture_V from facture where Date_Facture='0000-00-00')";
             stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
              TableProd.setModel(DbUtils.resultSetToTableModel(rs));
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
    }*/
    
     private void Remplir_ComboType(){
          try{
              String sql="select distinct(Type_Mat) from materiel where Id_Materiel!=1";
              stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
               while(rs.next())
                {
                  String name=rs.getString("Type_Mat");
                  ComboType.addItem(name);
                  }
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
    }
  
   private void Remplir_ComboNom(){
          try{
              String sql="select distinct(Nom) from materiel where Id_Materiel!=1";
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
              String sql="select distinct(Couleur) from materiel where Id_Materiel!=1";
              stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
               while(rs.next())
                {
                  String name=rs.getString("Couleur");
                  ComboCouleur.addItem(name);
                  }
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
    }
    public void Date_courante()
{
    Calendar cal = new GregorianCalendar();
    SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
    int annee = cal.get(Calendar.YEAR);
    int mois=cal.get(Calendar.MONTH); 
    int jour=cal.get(Calendar.DAY_OF_MONTH);
   // date_r.setText(date_format.format(cal.getTime()));
   // date_e.setText(date_format.format(cal.getTime()));
    String date = date_format.format(cal.getTime());
           
}
     void Rechercher()
     {
          String N_SD=n_sd.getText();
        if(n_serie.isSelected()==true && n_dossier.isSelected()==false)
        {
        
         try{
             // dt.setRowCount(0);
              String sql="select A.N_Serie,A.N_Dossier,A.Date_E as Date_Entrée,A.Date_R as Date_Réparation,A.Type_App ,I.type_In AS Intervention,A.Etat,P.type as Panne,A.Description,MO.Type_MO as Main_Oeuvre,MA.Nom as Façade,MA.Type_Mat as Appareil,MA.Couleur,II.Nom\n" +
"from appareil A,materiel MA,intervention I,panne P,maindoeuvre MO,intervenant II\n" +
"where MA.`Id_Materiel`=A.`Id_Materiel`\n" +
"AND I.`Id_Intervention`=A.`Id_Intervention`\n" +
"AND P.`Id_panne`=A.`Id_panne`\n" +
"AND MO.`Id_MO`=A.`Id_MO`\n" +
"AND II.`Id_Intervenant`=A.`Id_Intervenant`\n" +
"AND A.N_Serie like '%"+N_SD+"%' ";
             stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
              TableProd.setModel(DbUtils.resultSetToTableModel(rs));
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }  
        // n_sd.setText("");
         
        }
        else if(n_dossier.isSelected()==true && n_serie.isSelected()==false)
        {
        try{
             // dt.setRowCount(0);
              String sql="select A.N_Serie,A.N_Dossier,A.Date_E as Date_Entrée,A.Date_R as Date_Réparation,A.Type_App ,I.type_In AS Intervention,A.Etat,P.type as Panne,A.Description,MO.Type_MO as Main_Oeuvre,MA.Nom as Façade,MA.Type_Mat as Appareil,MA.Couleur,II.Nom\n" +
"from appareil A,materiel MA,intervention I,panne P,maindoeuvre MO,intervenant II\n" +
"where MA.`Id_Materiel`=A.`Id_Materiel`\n" +
"AND I.`Id_Intervention`=A.`Id_Intervention`\n" +
"AND P.`Id_panne`=A.`Id_panne`\n" +
"AND MO.`Id_MO`=A.`Id_MO`\n" +
"AND II.`Id_Intervenant`=A.`Id_Intervenant`\n" +
"AND A.N_Dossier like '%"+N_SD+"%' ";
             stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
              TableProd.setModel(DbUtils.resultSetToTableModel(rs));
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
         //n_sd.setText("");
        
        }
        if(n_serie.isSelected()==true)
      {
          n_sd.requestFocusInWindow();
      }else if(n_dossier.isSelected()==true)
      {
          n_sd.requestFocusInWindow();
      }
        
     
     }
    
    public JFrameModifErreur() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableProd = new javax.swing.JTable();
        n_serie = new javax.swing.JRadioButton();
        n_dossier = new javax.swing.JRadioButton();
        n_sd = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        ComboNom = new javax.swing.JComboBox();
        ComboType = new javax.swing.JComboBox();
        ComboCouleur = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Modification En Cas d'erreur dans le matériel Utilisé");

        TableProd.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TableProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TableProd);

        n_serie.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        n_serie.setText("N° Série  :");
        n_serie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_serieActionPerformed(evt);
            }
        });

        n_dossier.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        n_dossier.setText("N° Dossier  :");
        n_dossier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_dossierActionPerformed(evt);
            }
        });

        n_sd.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        n_sd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n_sdMouseClicked(evt);
            }
        });
        n_sd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_sdActionPerformed(evt);
            }
        });
        n_sd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                n_sdKeyPressed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setText("Chercher");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton3.setText("Remettre le matériel en Stock");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        ComboNom.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        ComboType.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        ComboCouleur.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jButton4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton4.setText("Modifier");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Chercher les informations de l'Appareil :");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Ajouter Le bon Matériel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ComboType, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ComboNom, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ComboCouleur, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(n_serie)
                                        .addGap(26, 26, 26)
                                        .addComponent(n_dossier))
                                    .addComponent(n_sd))
                                .addGap(35, 35, 35)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(n_serie)
                    .addComponent(n_dossier))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(n_sd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(28, 28, 28)
                .addComponent(ComboNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ComboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ComboCouleur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(881, 616));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void n_serieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_serieActionPerformed
      if(n_serie.isSelected()==true)
      {
          n_sd.requestFocusInWindow();
        n_dossier.setEnabled(false);
      }
      else if(n_serie.isSelected()==false)
      {
        n_dossier.setEnabled(true);
      }
    }//GEN-LAST:event_n_serieActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    Rechercher();       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void n_dossierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_dossierActionPerformed
       if(n_dossier.isSelected()==true)
      {
          n_sd.requestFocusInWindow();
        n_serie.setEnabled(false);
      }
      else if(n_dossier.isSelected()==false)
      {
        n_serie.setEnabled(true);
      }
       
    }//GEN-LAST:event_n_dossierActionPerformed
                
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
    /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
      

        int row = TableProd.getSelectedRow();
          teck1 = TableProd.getModel().getValueAt(row, 2).toString();
          String tN_serie = TableProd.getModel().getValueAt(row, 0).toString();
          String tN_Dossier = TableProd.getModel().getValueAt(row, 1).toString();
          if(n_serie.isSelected()==true)
     {             
        String sql="SELECT Id_Materiel from appareil where N_Serie='"+tN_serie+"' AND Date_E='"+teck1+"' AND N_BL IN(1,2,3)" ;
  
          
        //Exécuter la requête
       try{
         stm=maConnexion.get_connexion().createStatement();
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
       rs=stm.executeQuery(sql);
       rs.first();
       String sql1="UPDATE materiel set Etat='Acheté',Date_Utilisation='0000-00-00' where Id_Materiel='"+rs.getString("Id_Materiel")+"'";
       String sql2= "UPDATE appareil SET Id_Materiel= '1' WHERE N_Serie='"+tN_serie+"' AND Date_E='"+teck1+"' AND N_BL IN(1,2,3)"; 
       stm.executeUpdate(sql1);
       stm.executeUpdate(sql2);
         JOptionPane.showMessageDialog(null,"Le matériel est remis en stock");
       }
        
       catch(SQLException e){
           System.err.println(e);    }}
      else if(n_dossier.isSelected()==true)
      {String sql="SELECT Id_Materiel from appareil where N_Dossier='"+tN_Dossier+"' AND Date_E='"+teck1+"'AND N_BL IN(1,2,3)" ;
          
        //Exécuter la requête
       try{
         stm=maConnexion.get_connexion().createStatement();
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
       rs=stm.executeQuery(sql);
       rs.first();
       String sql1="UPDATE materiel set Etat='Acheté',Date_Utilisation='0000-00-00' where Id_Materiel='"+rs.getString("Id_Materiel")+"'";
       String sql2= "UPDATE appareil SET Id_Materiel= '1' WHERE N_Dossier='"+tN_Dossier+"'  AND Date_E='"+teck1+"'AND N_BL IN(1,2,3)"; 
       stm.executeUpdate(sql1);
       stm.executeUpdate(sql2);
         JOptionPane.showMessageDialog(null,"Le matériel est remis en stock");
       }
       catch(SQLException e){
           System.err.println(e);    }
    }  
       
       Remplir_ComboType();
       Remplir_ComboNom();
       Remplir_ComboCouleur();
               
               
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Calendar cal = new GregorianCalendar();
        SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
        String date = date_format.format(cal.getTime());
        String sql= "select min(Id_Materiel) as id from materiel M\n" +
                "where Nom='"+ComboNom.getSelectedItem()+"'\n" +
                "AND Type_Mat='"+ComboType.getSelectedItem()+"'\n" +
                "AND Couleur = '"+ComboCouleur.getSelectedItem()+"' \n" +
                "AND Etat != 'Défectueux' AND Etat != 'Utilisé'" ;
       String N_SD=n_sd.getText();
             int row = TableProd.getSelectedRow();
       teck1 = TableProd.getModel().getValueAt(row, 2).toString();
       String tN_serie = TableProd.getModel().getValueAt(row, 0).toString();
       String tN_Dossier = TableProd.getModel().getValueAt(row, 1).toString();
       try{
         stm=maConnexion.get_connexion().createStatement();
       
        rs=stm.executeQuery(sql);
        
        rs.first();
        System.out.println(""+rs.getString("id")+"");
        /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/ 
               
        String requete1= "UPDATE appareil SET Id_Materiel= '"+rs.getString("id")+"' WHERE N_Dossier='"+tN_Dossier+"' AND N_Serie='"+tN_serie+"' AND Date_E='"+teck1+"' AND N_BL IN(1,2,3)";
        
        String requete2= "UPDATE materiel SET Date_Utilisation= '"+date+"',Etat= 'Utilisé' WHERE Id_Materiel='"+rs.getString("id")+"' ";
       
        
        stm.executeUpdate(requete1);
        JOptionPane.showMessageDialog(null,"le materiel choisi est affecté à cet appareil");
        stm.executeUpdate(requete2); 
        JOptionPane.showMessageDialog(null,"la date d'utilisation et l'état du matériel a été modifié");
         
       }
       catch(SQLException e){
           System.err.println(e);
           JOptionPane.showMessageDialog(null,e);
                   
       }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void n_sdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n_sdMouseClicked
         
    }//GEN-LAST:event_n_sdMouseClicked

    private void n_sdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_n_sdKeyPressed
     if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
          Rechercher();  
        }
    }//GEN-LAST:event_n_sdKeyPressed

    private void n_sdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_sdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n_sdActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameModifErreur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameModifErreur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameModifErreur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameModifErreur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameModifErreur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboCouleur;
    private javax.swing.JComboBox ComboNom;
    private javax.swing.JComboBox ComboType;
    private javax.swing.JTable TableProd;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton n_dossier;
    private javax.swing.JTextField n_sd;
    private javax.swing.JRadioButton n_serie;
    // End of variables declaration//GEN-END:variables
}
