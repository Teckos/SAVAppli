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
public class JFrameChangementEtat extends javax.swing.JFrame {

    Statement stm;
    PreparedStatement pst;
    ResultSet rs,rs2,rs3;
    DefaultTableModel dt;
    connexion maConnexion=new connexion();
    /**
     * Creates new form JFrameChangementEtat
     */
    
     void Remplir_TableFA(){
          try{
             // dt.setRowCount(0);
              String sql="select Id_Achat as 'N°',N_Facture as 'N° de Facture',Date_Achat as Date,Etat,Prix_Achat as Montant,N_Reglement_A as 'N° de Réglement',A.Désignation,P.Nom as Partenaire\n"+
                      "from achat A,partenaire P where A.Id_Partenaire=P.Id_Partenaire AND Etat='Non payée' ORDER BY id_achat ASC";
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
              String sql="select N_Facture_V as 'N° de Facture',Date_Facture as Date,Etat_F as Etat,Montant_F as Montant,N_Réglement as 'N° de Réglement',Commentaire as Désignation,P.Nom as Partenaire\n"+
                      "from facture F,partenaire P where F.Id_Partenaire=P.Id_Partenaire AND Etat_F='Non payée' AND N_Facture_V!='1'";
             stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
              facture_v.setModel(DbUtils.resultSetToTableModel(rs));
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
    }
     
     void Selection_Multiple_FV()
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
     
 void Calcul_Montant_FV()
     {
         float mnt=0,s=0;
      try{
          int[] rows = facture_v.getSelectedRows();
          for(int i=0;i<rows.length;i++)
           { 
           System.out.println(rows[i]);
         
         String t = (facture_v.getModel().getValueAt(rows[i], 0).toString());
         String sql= "select Montant_F, N_Réglement from facture WHERE N_Facture_V='"+t+"'";
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
              n_reg.setText(rs.getString("N_Réglement"));
         /*JOptionPane.showMessageDialog(null,"le montant est calculé");*/
       }
      
       catch(SQLException e){
           System.err.println(e);
     }
     
     }
 ///////////////************Calcul Montant TCC *************//////////////////
 
  void Calcul_Montant_TCC_FV()
     {
      try{
          int[] rows = facture_v.getSelectedRows();
           double mnt=0,s=0,tva=0,pa=0,result=0;
          for(int i=0;i<rows.length;i++)
           { 
          System.out.println(rows[i]);
         
         String t = (facture_v.getModel().getValueAt(rows[i], 0).toString());
         System.out.println(t);
         String sql= "select Montant_F,TVA_V from facture WHERE N_Facture_V='"+t+"'";
         stm=maConnexion.get_connexion().createStatement();
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
        rs=stm.executeQuery(sql);
       if(rs.first())
                 {
                 tva = rs.getDouble("TVA_V");
                // System.out.println(tva);
                 pa = rs.getDouble("Montant_F");
                // System.out.println(pa);
                 
                  //System.out.println(div);
                 result=(double)((tva/100)*pa)+pa;
                 // System.out.println(result);
                  s+=result;
                 }
           }  
       
          String m=String.valueOf(s);
              ttc.setText(m);
           
        /* JOptionPane.showMessageDialog(null,"le montant est calculé");*/
       
      }
       catch(SQLException e){
           System.err.println(e);
     }
     
     }
 
 ///////////////////////////////////////////////*************************///////////////////////
 
void Selection_Multiple_FA()
     {
         String R=n_reg.getText();
         try{
          int[] rows = facture_a.getSelectedRows();
          for(int i=0;i<rows.length;i++)
           { 
           System.out.println(rows[i]);
         
         String t = (facture_a.getModel().getValueAt(rows[i], 0).toString());
         String requete= "UPDATE achat SET Etat='Payée', N_Reglement_A='"+R+"' WHERE Id_Achat='"+t+"' ";
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

 void Calcul_Montant_FA()
     {
      try{
          int[] rows = facture_a.getSelectedRows();
           float mnt=0,s=0;
          for(int i=0;i<rows.length;i++)
           { 
          System.out.println(rows[i]);
         
         String t = (facture_a.getModel().getValueAt(rows[i], 0).toString());
         System.out.println(t);
         String sql= "select Prix_Achat, N_Reglement_A from achat WHERE Id_Achat='"+t+"'";
         stm=maConnexion.get_connexion().createStatement();
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
        rs=stm.executeQuery(sql);
        rs.first();
          mnt = rs.getFloat("Prix_Achat");
          System.out.println(mnt);  
         s+=mnt;
         n_reg.setText(rs.getString("N_Reglement_A"));
           }  
       
          String m=String.valueOf(s);
              mt.setText(m);
           
        /* JOptionPane.showMessageDialog(null,"le montant est calculé");*/
       
      }
       catch(SQLException e){
           System.err.println(e);
     }
     
     }
 ///////////////************Calcul Montant TCC *************//////////////////
 
  void Calcul_Montant_TCC_FA()
     {
      try{
          int[] rows = facture_a.getSelectedRows();
           double mnt=0,s=0,tva=0,pa=0,result=0;
          for(int i=0;i<rows.length;i++)
           { 
          System.out.println(rows[i]);
         
         String t = (facture_a.getModel().getValueAt(rows[i], 0).toString());
         System.out.println(t);
         String sql= "select Prix_Achat,TVA from achat WHERE Id_Achat='"+t+"'";
         stm=maConnexion.get_connexion().createStatement();
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
        rs=stm.executeQuery(sql);
       if(rs.first())
                 {
                 tva = rs.getDouble("TVA");
                // System.out.println(tva);
                 pa = rs.getDouble("Prix_Achat");
                // System.out.println(pa);
                 
                  //System.out.println(div);
                 result=(double)((tva/100)*pa)+pa;
                 // System.out.println(result);
                  s+=result;
                 }
           }  
       
          String m=String.valueOf(s);
              ttc.setText(m);
           
        /* JOptionPane.showMessageDialog(null,"le montant est calculé");*/
       
      }
       catch(SQLException e){
           System.err.println(e);
     }
     
     }
  
            
  
  
 
 void Calcul_Position_Effective()
 {
    //Calcul de Position Effective
     double tva=0,pa=0,result=0,result_v=0,s1=0,s2=0,tva_v=0,pv=0;
    String sql2="select Prix_Achat , TVA from achat where Etat='payée'";
    String sql3="select Montant_F , TVA_V from facture where Etat_F='payée'";
     //Calcul des Achats Inclut la TVA dont l'état est payé     
         try{
            stm=maConnexion.get_connexion().createStatement();
            rs2=stm.executeQuery(sql2); 
            
              for(int i=1;i<1000;i++)
             {
                 if(rs2.absolute(i))
                 {
                 tva = rs2.getDouble("TVA");
                // System.out.println(tva);
                 pa = rs2.getDouble("Prix_Achat");
                // System.out.println(pa);
                 double div=tva/100;
                  //System.out.println(div);
                 result=(double)((tva/100)*pa)+pa;
                 // System.out.println(result);
                  s1+=result;
                 }
            
              }
          System.out.println(s1);
           // mt_a=String.valueOf(s1);
           // pos_ef.setText(mt_a);
            
             }
        catch(SQLException e){
           System.err.println(e);    
    }
         
    //Calcul des Ventes Inclut la TVA dont l'état est payé 
    try{
            stm=maConnexion.get_connexion().createStatement();
            rs3=stm.executeQuery(sql3); 
            
              for(int i=1;i<1000;i++)
             {
                 if(rs3.absolute(i))
                 {
                 tva_v = rs3.getDouble("TVA_V");
                // System.out.println(tva_v);
                 pv = rs3.getDouble("Montant_F");
                 //System.out.println(pv);
                 
                 //float div=(float)tva_v/100;
                 
                 //System.out.println(div);
                 result_v=(double)((tva_v/100)*pv)+pv;
                 // System.out.println(result_v);
                  s2+=result_v;
                 }
            
              }
            //System.out.println(s2);
            //mt_v=String.valueOf(s2);
           // pos_ef.setText(mt);
            
             }
        catch(SQLException e){
           System.err.println(e);    
    }	
     double mt_res=0;
     mt_res=s2-s1; 
     String mt_rs=String.valueOf(mt_res);
     pos_eff.setText(mt_rs);
     mt.setText("");
     ttc.setText("");
     n_reg.setText("");
 }
    
    public JFrameChangementEtat() {
        initComponents();
     
        Remplir_TableFV();
        Remplir_TableFA();
        Calcul_Position_Effective();
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
        jLabel2 = new javax.swing.JLabel();
        mt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        facture_a = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        facture_v = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        n_reg = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        pos_eff = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        ttc = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("N° de Réglement :");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Montant  Total :");

        mt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        mt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mtActionPerformed(evt);
            }
        });

        facture_a.setAutoCreateRowSorter(true);
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

        facture_v.setAutoCreateRowSorter(true);
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
        jLabel5.setText("Etat des Factures :");

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

        n_reg.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jButton4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton4.setText("Calcul Montant Vente");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton5.setText("Calcul Montant Achat");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Position Effective  :");

        pos_eff.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/directionappli/actualiser.jpg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Montant  Total  (TTC):");

        ttc.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(268, 268, 268))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)
                        .addGap(22, 22, 22))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton4)))
                .addGap(106, 106, 106)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(n_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(85, 85, 85)
                        .addComponent(pos_eff, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mt)
                            .addComponent(ttc, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 308, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(376, 376, 376)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButton1)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton5))
                        .addGap(27, 27, 27))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ttc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n_reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pos_eff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1373, 730));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void facture_vMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_facture_vMouseClicked
      
       
    }//GEN-LAST:event_facture_vMouseClicked

    private void facture_aMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_facture_aMouseClicked
   
    }//GEN-LAST:event_facture_aMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       Selection_Multiple_FV();
       Calcul_Position_Effective();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     Selection_Multiple_FA();
     Calcul_Position_Effective();
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      Calcul_Montant_FV();
      Calcul_Montant_TCC_FV();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Calcul_Montant_FA();
        Calcul_Montant_TCC_FA();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Remplir_TableFA();
        Remplir_TableFV();
        mt.setText("");
        n_reg.setText("");
        ttc.setText("");
  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void mtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mtActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameChangementEtat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameChangementEtat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameChangementEtat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameChangementEtat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameChangementEtat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable facture_a;
    private javax.swing.JTable facture_v;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField mt;
    private javax.swing.JTextField n_reg;
    private javax.swing.JTextField pos_eff;
    private javax.swing.JTextField ttc;
    // End of variables declaration//GEN-END:variables
}
