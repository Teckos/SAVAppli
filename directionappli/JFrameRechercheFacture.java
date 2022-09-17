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
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author khaoula
 */
public class JFrameRechercheFacture extends javax.swing.JFrame {

    Statement stm;
    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel dt;
    connexion maConnexion=new connexion();
    /**
     * Creates new form JFrameChangementEtat
     */
    
     void Remplir_TableFA(){
          try{
             // dt.setRowCount(0);
              String sql="select Id_Achat as 'N°',N_Facture as 'N° de Facture',Etat,Prix_Achat as Montant,A.Désignation,P.Nom as Partenaire\n"+
                      "from achat A,partenaire P where A.Id_Partenaire=P.Id_Partenaire ";
             stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
              facture_a.setModel(DbUtils.resultSetToTableModel(rs));
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
    }
     
     void Remplir_TableFV(){
          try{
             // dt.setRowCount(0);
              String sql="select N_Facture_V as 'N° de Facture' ,Etat_F as Etat,Montant_F as Montant,Commentaire as Désignation,P.Nom as Partenaire\n"+
                      "from facture F,partenaire P where F.Id_Partenaire=P.Id_Partenaire AND  N_Facture_V!='1'";
             stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
              facture_v.setModel(DbUtils.resultSetToTableModel(rs));
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
    }
     
   /*  void Selection_Multiple_FV()
     {
         String R=n_reg.getText();
      try{
          int[] rows = facture_v.getSelectedRows();
          for(int i=0;i<rows.length;i++)
           { 
           System.out.println(rows[i]);
         
         String t = (facture_v.getModel().getValueAt(rows[i], 0).toString());
         String requete= "UPDATE facture SET Etat_F= 'Payée',N_Réglement='"+R+"' WHERE N_Facture_V='"+t+"' ";
         stm=maConnexion.get_connexion().createStatement();
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
        stm.executeUpdate(requete); 
        
           }
         JOptionPane.showMessageDialog(null,"l'état de ces factures est changé");
       }
       catch(SQLException e){
           System.err.println(e);
     }
      Remplir_TableFV();  
     }
     /////////////////////***************************************//////////////////////////
     
 /*void Calcul_Montant_FV()
     {
         float mnt=0,s=0;
      try{
          int[] rows = facture_v.getSelectedRows();
          for(int i=0;i<rows.length;i++)
           { 
           System.out.println(rows[i]);
         
         String t = (facture_v.getModel().getValueAt(rows[i], 0).toString());
         String sql= "select Montant_F from facture WHERE N_Facture_V='"+t+"'";
         stm=maConnexion.get_connexion().createStatement();
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
        
         rs=stm.executeQuery(sql); 
          rs.first();
          mnt = rs.getFloat("Montant_F");
          System.out.println(mnt);  
          s+=mnt;
           } 
             String m=String.valueOf(s);
              mt.setText(m);
         JOptionPane.showMessageDialog(null,"le montant est calculé");
       }
      
       catch(SQLException e){
           System.err.println(e);
     }
     
     }
 
 ///////////////////////////////////////////////*************************///////////////////////
 
/*void Selection_Multiple_FA()
     {
      try{
          int[] rows = facture_a.getSelectedRows();
          for(int i=0;i<rows.length;i++)
           { 
           System.out.println(rows[i]);
         
         String t = (facture_a.getModel().getValueAt(rows[i], 0).toString());
         String requete= "UPDATE achat SET Etat='Payée' WHERE N_Facture='"+t+"' ";
         stm=maConnexion.get_connexion().createStatement();
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
        stm.executeUpdate(requete); 
           }
         JOptionPane.showMessageDialog(null,"l'état de ces factures est changé");
       }
       catch(SQLException e){
           System.err.println(e);
     }
      Remplir_TableFA();  
     }

////////////////////***************************************************////////////////

 /*void Calcul_Montant_FA()
     {
      try{
          int[] rows = facture_a.getSelectedRows();
           float mnt=0,s=0;
          for(int i=0;i<rows.length;i++)
           { 
          System.out.println(rows[i]);
         
         String t = (facture_a.getModel().getValueAt(rows[i], 0).toString());
         System.out.println(t);
         String sql= "select Prix_Achat from achat WHERE N_Facture='"+t+"'";
         stm=maConnexion.get_connexion().createStatement();
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
        rs=stm.executeQuery(sql);
        rs.first();
          mnt = rs.getFloat("Prix_Achat");
          System.out.println(mnt);  
         s+=mnt;
           }  
       
          String m=String.valueOf(s);
              mt.setText(m);
           
         JOptionPane.showMessageDialog(null,"le montant est calculé");
       
      }
       catch(SQLException e){
           System.err.println(e);
     }
     
     }*/
    
    public JFrameRechercheFacture() {
        initComponents();
     
        Remplir_TableFV();
        Remplir_TableFA();
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        facture_a = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        facture_v = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        date = new javax.swing.JRadioButton();
        mont = new javax.swing.JRadioButton();
        part = new javax.swing.JRadioButton();
        txt_search = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        n_fact = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        com = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Commentaire  :");

        facture_a.setModel(new javax.swing.table.DefaultTableModel(
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
        facture_a.setEditingRow(0);
        facture_a.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        facture_a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                facture_aMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(facture_a);

        facture_v.setModel(new javax.swing.table.DefaultTableModel(
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
        facture_v.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        facture_v.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                facture_vMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(facture_v);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Factures de Vente :");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Factures d'Achat :");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Recherche  des Factures :");

        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setText("Valider");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton3.setText("Valider");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        date.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        date.setText("Date :");
        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });

        mont.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        mont.setText("Montant");
        mont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                montActionPerformed(evt);
            }
        });

        part.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        part.setText("Partenaire :");
        part.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partActionPerformed(evt);
            }
        });

        txt_search.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setText("Chercher");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton6.setText("Chercher");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        n_fact.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        n_fact.setText("N° Facture :");
        n_fact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_factActionPerformed(evt);
            }
        });

        com.setColumns(20);
        com.setRows(5);
        jScrollPane3.setViewportView(com);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 357, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(128, 128, 128)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(n_fact)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(part))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(date)
                                .addGap(89, 89, 89)
                                .addComponent(mont, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_search))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jButton6)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                                .addGap(19, 19, 19))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(435, 435, 435))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(part, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(n_fact))
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(mont)
                                    .addComponent(date)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jButton1)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1249, 664));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void facture_vMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_facture_vMouseClicked
      
        try{
           int row = facture_v.getSelectedRow();
           String t = (facture_v.getModel().getValueAt(row, 0).toString());
           String requete= "select * from facture where N_Facture_V='"+t+"'";
         stm=maConnexion.get_connexion().createStatement();
        rs=stm.executeQuery(requete); //ne passe pas pour l'insertion dans mysql
        //stm.executeUpdate(requete); 
        if(rs.next())
        {
            String add1 =rs.getString("Commentaire");
            com.setText(add1);
       }
     
       // JOptionPane.showMessageDialog(null,"le nouveau Bon de livraison est ajouté");
       }
       catch(SQLException e){
           System.err.println(e);
      }    
       
    }//GEN-LAST:event_facture_vMouseClicked

    private void facture_aMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_facture_aMouseClicked
      try{
           int row = facture_a.getSelectedRow();
           String t = (facture_a.getModel().getValueAt(row, 0).toString());
           String requete= "select * from achat where Id_Achat='"+t+"'";
         stm=maConnexion.get_connexion().createStatement();
        rs=stm.executeQuery(requete); //ne passe pas pour l'insertion dans mysql
        //stm.executeUpdate(requete); 
        if(rs.next())
        {
            String add1 =rs.getString("Désignation");
            com.setText(add1);
       }
     
       // JOptionPane.showMessageDialog(null,"le nouveau Bon de livraison est ajouté");
       }
       catch(SQLException e){
           System.err.println(e);
      }    
    }//GEN-LAST:event_facture_aMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       //Selection_Multiple_FV();
        String C =com.getText();
     try{
           int row = facture_v.getSelectedRow();
           String t = (facture_v.getModel().getValueAt(row, 0).toString());
           String requete= "update facture set Commentaire='"+C+"' where N_Facture_V='"+t+"'";
          stm=maConnexion.get_connexion().createStatement();
         stm.executeUpdate(requete); //ne passe pas pour l'insertion dans mysql
         }
       catch(SQLException e){
           System.err.println(e);
      }  
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     //Selection_Multiple_FA();
        String C =com.getText();
     try{
           int row = facture_a.getSelectedRow();
           String t = (facture_a.getModel().getValueAt(row, 0).toString());
           String requete= "update achat set Désignation='"+C+"' where Id_Achat='"+t+"'";
          stm=maConnexion.get_connexion().createStatement();
         stm.executeUpdate(requete); //ne passe pas pour l'insertion dans mysql
         }
       catch(SQLException e){
           System.err.println(e);
      }    
     com.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
      if(date.isSelected()==true)
      {
        n_fact.setEnabled(false);
        mont.setEnabled(false);
        part.setEnabled(false);
      }
      else if(date.isSelected()==false)
      {
        n_fact.setEnabled(true);
        mont.setEnabled(true);
        part.setEnabled(true);
      }
    }//GEN-LAST:event_dateActionPerformed

    private void montActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_montActionPerformed
      if(mont.isSelected()==true)
      {
        n_fact.setEnabled(false);
        date.setEnabled(false);
        part.setEnabled(false);
      }
      else if(mont.isSelected()==false)
      {
        n_fact.setEnabled(true);
        date.setEnabled(true);
        part.setEnabled(true);
      }
    }//GEN-LAST:event_montActionPerformed

    private void partActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partActionPerformed
       if(part.isSelected()==true)
      {
        n_fact.setEnabled(false);
        mont.setEnabled(false);
        date.setEnabled(false);
      }
      else if(part.isSelected()==false)
      {
        n_fact.setEnabled(true);
        mont.setEnabled(true);
        date.setEnabled(true);
      }
    }//GEN-LAST:event_partActionPerformed

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
     
    }//GEN-LAST:event_txt_searchKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

       String S=txt_search.getText();
     if(n_fact.isSelected()==true && part.isSelected()==false && mont.isSelected()==false && date.isSelected()==false )
       {   
        try{
        String sql= "select N_Facture_V as 'N° de Facture' ,Etat_F as Etat,Montant_F as Montant from facture where N_Facture_V like '%"+S+"%'  AND N_Facture_V!='1'";
         stm=maConnexion.get_connexion().prepareStatement(sql);
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
         
                 
         rs=stm.executeQuery(sql);
        facture_v.setModel(DbUtils.resultSetToTableModel(rs));
           
         //JOptionPane.showMessageDialog(null,"l'état de ces factures est changé");
       }
       catch(SQLException e){
           System.err.println(e);
     }
       } 
     else if(n_fact.isSelected()==false && part.isSelected()==false && mont.isSelected()==false && date.isSelected()==true )
       {   
        try{
        String sql= "select N_Facture_V as 'N° de Facture' ,Etat_F as Etat,Montant_F as Montant from facture where Date_Facture like '%"+S+"%' AND N_Facture_V!='1' ";
         stm=maConnexion.get_connexion().prepareStatement(sql);
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
         
                 
         rs=stm.executeQuery(sql);
        facture_v.setModel(DbUtils.resultSetToTableModel(rs));
           
         //JOptionPane.showMessageDialog(null,"l'état de ces factures est changé");
       }
       catch(SQLException e){
           System.err.println(e);
     }
       } 
       else  if(n_fact.isSelected()==false && date.isSelected()==false && part.isSelected()==false && mont.isSelected()==true )
       {
         try{
        String sql= "select N_Facture_V as 'N° de Facture' ,Etat_F as Etat,Montant_F as Montant from facture where Montant_F like '%"+S+"%' AND N_Facture_V!='1'";
         stm=maConnexion.get_connexion().prepareStatement(sql);
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
         
                 
         rs=stm.executeQuery(sql);
        facture_v.setModel(DbUtils.resultSetToTableModel(rs));
           
         //JOptionPane.showMessageDialog(null,"l'état de ces factures est changé");
       }
       catch(SQLException e){
           System.err.println(e);
     }
       }
       else  if(n_fact.isSelected()==false && date.isSelected()==false && part.isSelected()==true && mont.isSelected()==false )
       {
         try{
        String sql= "select N_Facture_V as 'N° de Facture' ,Etat_F as Etat,Montant_F as Montant from facture where Id_Partenaire=(select Id_Partenaire from partenaire where Nom like '%"+S+"%' AND Désignation='Client')  AND N_Facture_V!='1' ";
         stm=maConnexion.get_connexion().prepareStatement(sql);
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
         
                 
         rs=stm.executeQuery(sql);
        facture_v.setModel(DbUtils.resultSetToTableModel(rs));
           
         //JOptionPane.showMessageDialog(null,"l'état de ces factures est changé");
       }
       catch(SQLException e){
           System.err.println(e);
     }
       }
     txt_search.setText("");
        n_fact.setSelected(false);
        date.setSelected(false);
        mont.setSelected(false);
        part.setSelected(false);
        n_fact.setEnabled(true);
        date.setEnabled(true);
        mont.setEnabled(true);
        part.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      String S=txt_search.getText();
     if(n_fact.isSelected()==true && part.isSelected()==false && mont.isSelected()==false && date.isSelected()==false )
       {   
        try{
        String sql= "select Id_Achat as 'N°',N_Facture as 'N° de Facture' ,Etat as Etat,Prix_Achat as Montant from achat where N_Facture like '%"+S+"%' ";
         stm=maConnexion.get_connexion().prepareStatement(sql);
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
         
                 
         rs=stm.executeQuery(sql);
        facture_a.setModel(DbUtils.resultSetToTableModel(rs));
           
         //JOptionPane.showMessageDialog(null,"l'état de ces factures est changé");
       }
       catch(SQLException e){
           System.err.println(e);
     }
       } 
     else if(n_fact.isSelected()==false && part.isSelected()==false && mont.isSelected()==false && date.isSelected()==true )
       {   
        try{
        String sql= "select Id_Achat as 'N°',N_Facture as 'N° de Facture' ,Etat as Etat,Prix_Achat as Montant from achat where Date_Achat like '%"+S+"%'  ";
         stm=maConnexion.get_connexion().prepareStatement(sql);
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
         
                 
         rs=stm.executeQuery(sql);
        facture_a.setModel(DbUtils.resultSetToTableModel(rs));
           
         //JOptionPane.showMessageDialog(null,"l'état de ces factures est changé");
       }
       catch(SQLException e){
           System.err.println(e);
     }
       } 
       else  if(n_fact.isSelected()==false && date.isSelected()==false && part.isSelected()==false && mont.isSelected()==true )
       {
         try{
        String sql= "select Id_Achat as 'N°',N_Facture as 'N° de Facture' ,Etat as Etat,Prix_Achat as Montant from achat where Prix_Achat like '%"+S+"%' ";
         stm=maConnexion.get_connexion().prepareStatement(sql);
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
         
                 
         rs=stm.executeQuery(sql);
        facture_a.setModel(DbUtils.resultSetToTableModel(rs));
           
         //JOptionPane.showMessageDialog(null,"l'état de ces factures est changé");
       }
       catch(SQLException e){
           System.err.println(e);
     }
       }
       else  if(n_fact.isSelected()==false && date.isSelected()==false && part.isSelected()==true && mont.isSelected()==false )
       {
         try{
        String sql= "select Id_Achat as 'N°',N_Facture as 'N° de Facture' ,Etat as Etat,Prix_Achat as Montant from achat where Id_Partenaire=(select Id_Partenaire from partenaire where Nom like '%"+S+"%' AND Désignation='Fournisseur')  ";
         stm=maConnexion.get_connexion().prepareStatement(sql);
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
         
                 
         rs=stm.executeQuery(sql);
        facture_a.setModel(DbUtils.resultSetToTableModel(rs));
           
         //JOptionPane.showMessageDialog(null,"l'état de ces factures est changé");
       }
       catch(SQLException e){
           System.err.println(e);
     }
       }
     txt_search.setText("");
     n_fact.setSelected(false);
        date.setSelected(false);
        mont.setSelected(false);
        part.setSelected(false);
        n_fact.setEnabled(true);
        date.setEnabled(true);
        mont.setEnabled(true);
        part.setEnabled(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void n_factActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_factActionPerformed
       if(n_fact.isSelected()==true)
      {
        date.setEnabled(false);
        mont.setEnabled(false);
        part.setEnabled(false);
      }
      else if(n_fact.isSelected()==false)
      {
        date.setEnabled(true);
        mont.setEnabled(true);
        part.setEnabled(true);
      }
    }//GEN-LAST:event_n_factActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameRechercheFacture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameRechercheFacture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameRechercheFacture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameRechercheFacture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameRechercheFacture().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea com;
    private javax.swing.JRadioButton date;
    private javax.swing.JTable facture_a;
    private javax.swing.JTable facture_v;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton mont;
    private javax.swing.JRadioButton n_fact;
    private javax.swing.JRadioButton part;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
