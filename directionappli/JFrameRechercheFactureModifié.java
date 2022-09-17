/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package directionappli;

import java.awt.Component;
import java.awt.event.KeyEvent;
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
public class JFrameRechercheFactureModifié extends javax.swing.JFrame {

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
              String sql="select Id_Achat as 'N°',N_Facture as 'N° de Facture',Date_Achat as Date,N_Reglement_A as N_Réglement,Etat,Prix_Achat as Montant,A.Désignation,P.Nom as Partenaire\n"+
                      "from achat A,partenaire P where A.Id_Partenaire=P.Id_Partenaire ORDER BY id_achat ASC";
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
              String sql="select N_Facture_V as 'N° de Facture',Date_Facture as Date,N_Réglement,Etat_F as Etat,Montant_F as Montant,Commentaire as Désignation,P.Nom as Partenaire\n"+
                      "from facture F,partenaire P where F.Id_Partenaire=P.Id_Partenaire AND  N_Facture_V!='1'";
             stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
              facture_v.setModel(DbUtils.resultSetToTableModel(rs));
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
    }
     
   void Recherche_Vente()
   {
     String S=txt_search.getText();
     if(n_fact.isSelected()==true && part.isSelected()==false && mont.isSelected()==false && date.isSelected()==false && n_reg.isSelected()==false)
       {   
        try{
        String sql= "select N_Facture_V as 'N° de Facture' ,Date_Facture as Date,N_Réglement,Etat_F as Etat,Montant_F as Montant\n"+
                ",Commentaire as Désignation,,P.Nom as Partenaire from facture F,partenaire P\n"+
                "where F.Id_Partenaire=P.Id_Partenaire AND N_Facture_V like '%"+S+"%'  AND N_Facture_V!='1'";
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
     else if(n_fact.isSelected()==false && part.isSelected()==false && mont.isSelected()==false && date.isSelected()==true && n_reg.isSelected()==false )
       {   
        try{
        String sql= "select N_Facture_V as 'N° de Facture' ,Date_Facture as Date,N_Réglement,Etat_F as Etat,Montant_F as Montant\n"+
                ",Commentaire as Désignation,P.Nom as Partenaire from facture F,partenaire P\n"+
                "where F.Id_Partenaire=P.Id_Partenaire AND Date_Facture like '%"+S+"%' AND N_Facture_V!='1' ";
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
       else  if(n_fact.isSelected()==false && date.isSelected()==false && part.isSelected()==false && mont.isSelected()==true && n_reg.isSelected()==false )
       {
         try{
        String sql= "select N_Facture_V as 'N° de Facture' ,Date_Facture as Date,N_Réglement,Etat_F as Etat,Montant_F as Montant \n"+
                ",Commentaire as Désignation,P.Nom as Partenaire from facture F,partenaire P\n"+
                "where F.Id_Partenaire=P.Id_Partenaire AND Montant_F like '%"+S+"%' AND N_Facture_V!='1'";
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
       else  if(n_fact.isSelected()==false && date.isSelected()==false && part.isSelected()==true && mont.isSelected()==false && n_reg.isSelected()==false)
       {
         try{
        String sql= "select N_Facture_V as 'N° de Facture' ,Date_Facture as Date,N_Réglement,Etat_F as Etat,Montant_F as Montant \n"+
                ",Commentaire as Désignation,P.Nom as Partenaire from facture F,partenaire P\n"+
                "where F.Id_Partenaire=P.Id_Partenaire AND F.Id_Partenaire IN (select Id_Partenaire from partenaire where Nom like '%"+S+"%' AND Désignation='Client')  AND N_Facture_V!='1' ";
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
     else  if(n_fact.isSelected()==false && date.isSelected()==false && part.isSelected()==false && mont.isSelected()==false && n_reg.isSelected()==true)
       {
         try{
        String sql= "select N_Facture_V as 'N° de Facture' ,Date_Facture as Date,N_Réglement,Etat_F as Etat,Montant_F as Montant \n"+
                ",Commentaire as Désignation,P.Nom as Partenaire from facture F,partenaire P\n"+
                "where F.Id_Partenaire=P.Id_Partenaire AND N_Réglement like '%"+S+"%' AND N_Facture_V!='1'";
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
        n_reg.setSelected(false);
        date.setSelected(false);
        mont.setSelected(false);
        part.setSelected(false);
        n_fact.setEnabled(true);
        n_reg.setEnabled(true);
        date.setEnabled(true);
        mont.setEnabled(true);
        part.setEnabled(true);
   }
   
   
   /////////////////////***********Recherche         Vente*******************////////////////////////
   void Recherche_Achat()
   {
    String S=txt_search.getText();
     if(n_fact.isSelected()==true && part.isSelected()==false && mont.isSelected()==false && date.isSelected()==false && n_reg.isSelected()==false)
       {   
        try{
        String sql= "select Id_Achat as 'N°',N_Facture as 'N° de Facture',Date_Achat as Date,N_Reglement_A as N_Réglement,Etat as Etat,Prix_Achat as Montant, A.Désignation,P.Nom as Partenaire\n"+
                      "from achat A,partenaire P where A.Id_Partenaire=P.Id_Partenaire AND N_Facture like '%"+S+"%' ";
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
     else if(n_fact.isSelected()==false && part.isSelected()==false && mont.isSelected()==false && date.isSelected()==true && n_reg.isSelected()==false)
       {   
        try{
        String sql= "select Id_Achat as 'N°',N_Facture as 'N° de Facture' ,Date_Achat as Date,N_Reglement_A as N_Réglement,Etat as Etat,Prix_Achat as Montant, A.Désignation,P.Nom as Partenaire\n"+
                      "from achat A,partenaire P where A.Id_Partenaire=P.Id_Partenaire AND Date_Achat like '%"+S+"%'  ";
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
       else  if(n_fact.isSelected()==false && date.isSelected()==false && part.isSelected()==false && mont.isSelected()==true && date.isSelected()==false && n_reg.isSelected()==false )
       {
         try{
        String sql= "select Id_Achat as 'N°',N_Facture as 'N° de Facture' ,Date_Achat as Date,N_Reglement_A as N_Réglement,Etat as Etat,Prix_Achat as Montant,A.Désignation,P.Nom as Partenaire\n"+
                      "from achat A,partenaire P where A.Id_Partenaire=P.Id_Partenaire AND Prix_Achat like '%"+S+"%' ";
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
       else  if(n_fact.isSelected()==false && date.isSelected()==false && part.isSelected()==true && mont.isSelected()==false && date.isSelected()==false && n_reg.isSelected()==false)
       {
         try{
        String sql= "select Id_Achat as 'N°',N_Facture as 'N° de Facture',Date_Achat as Date,N_Reglement_A as N_Réglement,Etat as Etat,Prix_Achat as Montant, A.Désignation,P.Nom as Partenaire\n"+
                      "from achat A,partenaire P where A.Id_Partenaire=P.Id_Partenaire AND A.Id_Partenaire in (select Id_Partenaire from partenaire where Nom like '%"+S+"%' AND Désignation='Fournisseur')  ";
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
     else  if(n_fact.isSelected()==false && date.isSelected()==false && part.isSelected()==false && mont.isSelected()==false && date.isSelected()==false && n_reg.isSelected()==true )
       {
         try{
        String sql= "select Id_Achat as 'N°',N_Facture as 'N° de Facture',Date_Achat as Date,N_Reglement_A as N_Réglement,Etat as Etat,Prix_Achat as Montant,A.Désignation,P.Nom as Partenaire\n"+
                      "from achat A,partenaire P where A.Id_Partenaire=P.Id_Partenaire AND N_Reglement_A like '%"+S+"%' ";
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
        n_reg.setSelected(false);
        date.setSelected(false);
        mont.setSelected(false);
        part.setSelected(false);
        n_fact.setEnabled(true);
        n_reg.setEnabled(true);
        date.setEnabled(true);
        mont.setEnabled(true);
        part.setEnabled(true);
   }
   
   ////////////**************Modification Vente *********/////////
   void Modification_Vente()
   {
     String N_F =n_fac.getText();
     String D_F =date_fac.getText();
     String M =mt.getText();
     String P =part_f.getText();
     String E =etat.getText();
     String C =com.getText();
     String N_R =N_rgmt.getText();
   
     try{
           int row = facture_v.getSelectedRow();
           String t = (facture_v.getModel().getValueAt(row, 0).toString());
           String requete= " update facture set Commentaire='"+C+"',N_Facture_V='"+N_F+"',Etat_F='"+E+"'\n, N_Réglement='"+N_R+
           "',Montant_F='"+M+"',Id_Partenaire=(select Id_Partenaire from partenaire where Nom='"+P+"' AND Désignation='Client') where N_Facture_V='"+t+"' ";
          stm=maConnexion.get_connexion().createStatement();
         stm.executeUpdate(requete); //ne passe pas pour l'insertion dans mysql
         }
       catch(SQLException e){
           System.err.println(e);
      }
     n_fact.setSelected(false);
        date.setSelected(false);
        mont.setSelected(false);
        part.setSelected(false);
        n_fact.setEnabled(true);
        date.setEnabled(true);
        mont.setEnabled(true);
        part.setEnabled(true);
     Remplir_TableFV();
   }
    ////////////**************Modification Achat *********/////////
   void Modification_Achat()
   {
      String N_F =n_fac.getText();
      String D_F =date_fac.getText();
      String M =mt.getText();
      String P =part_f.getText();
      String E =etat.getText();
       String C =com.getText();
       String N_R =N_rgmt.getText();
     try{
           int row = facture_a.getSelectedRow();
           String t = (facture_a.getModel().getValueAt(row, 0).toString());
           String requete= "update achat set Désignation='"+C+"',N_Facture='"+N_F+"',Etat='"+E+"'\n, N_reglement_A='"+N_R+
           "',Prix_Achat='"+M+"',Id_Partenaire=(select Id_Partenaire from partenaire where Nom='"+P+"' AND Désignation!='Client'), Date_achat='"+D_F+"'  where Id_Achat='"+t+"'";
          stm=maConnexion.get_connexion().createStatement();
         stm.executeUpdate(requete); //ne passe pas pour l'insertion dans mysql
         }
       catch(SQLException e){
           System.err.println(e);
      }    
     com.setText("");
     n_fac.setText("");
     date_fac.setText("");
     etat.setText("");
     part_f.setText("");
     mt.setText("");
     N_rgmt.setText("");
     Remplir_TableFA();
   }
   
   void Supression_Achat()
   {
   try{
           int row = facture_a.getSelectedRow();
           String t = (facture_a.getModel().getValueAt(row, 0).toString());
          String sql="delete from achat where Id_Achat='"+t+"' " ;   
          stm=maConnexion.get_connexion().createStatement();
           int p= JOptionPane.showConfirmDialog((Component)null, "Vous être sûr de vouloir supprimer cette facture?", "Informations saisies", JOptionPane.OK_OPTION);    
       if (p==0)
       {
         stm.executeUpdate(sql); //ne passe pas pour l'insertion dans mysql
         
         }
       }
       catch(SQLException e){
           System.err.println(e);
      }   
     Remplir_TableFA();
     com.setText("");
     n_fac.setText("");
     date_fac.setText("");
     etat.setText("");
     part_f.setText("");
     mt.setText("");
     N_rgmt.setText("");
   }
   
   void Supression_Vente()
   {
   try{
           int row = facture_v.getSelectedRow();
           String t = (facture_v.getModel().getValueAt(row, 0).toString());
          String sql="delete from facture where N_Facture_V='"+t+"' " ;   
          stm=maConnexion.get_connexion().createStatement();
           int p= JOptionPane.showConfirmDialog((Component)null, "Vous être sûr de vouloir supprimer cette facture?", "Informations saisies", JOptionPane.OK_OPTION);    
       if (p==0)
       {
         stm.executeUpdate(sql); //ne passe pas pour l'insertion dans mysql
         
         }
       }
       catch(SQLException e){
           System.err.println(e);
      }   
     Remplir_TableFV();
     com.setText("");
     n_fac.setText("");
     date_fac.setText("");
     etat.setText("");
     part_f.setText("");
     mt.setText("");
     N_rgmt.setText("");
   }
   
    public JFrameRechercheFactureModifié() {
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
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        com = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        txt_search = new javax.swing.JTextField();
        n_fact = new javax.swing.JRadioButton();
        date = new javax.swing.JRadioButton();
        part = new javax.swing.JRadioButton();
        mont = new javax.swing.JRadioButton();
        f_achat = new javax.swing.JCheckBox();
        f_vente = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        n_reg = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        n_fac = new javax.swing.JTextField();
        date_fac = new javax.swing.JTextField();
        mt = new javax.swing.JTextField();
        part_f = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        etat = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        N_rgmt = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Commentaire  :");

        facture_a.setAutoCreateRowSorter(true);
        facture_a.setBackground(new java.awt.Color(204, 204, 204));
        facture_a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
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
        facture_v.setBackground(new java.awt.Color(204, 204, 204));
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

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Rechercher  ");

        com.setColumns(20);
        com.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        com.setRows(5);
        jScrollPane3.setViewportView(com);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204))));

        txt_search.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_searchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        n_fact.setBackground(new java.awt.Color(255, 204, 204));
        n_fact.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        n_fact.setText("   N° Facture :");
        n_fact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/directionappli/f.jpg"))); // NOI18N
        n_fact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_factActionPerformed(evt);
            }
        });

        date.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        date.setText("   Date :");
        date.setIcon(new javax.swing.ImageIcon(getClass().getResource("/directionappli/date1.jpg"))); // NOI18N
        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });

        part.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        part.setText("    Partenaire ");
        part.setIcon(new javax.swing.ImageIcon(getClass().getResource("/directionappli/part.jpg"))); // NOI18N
        part.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partActionPerformed(evt);
            }
        });

        mont.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        mont.setText("    Montant");
        mont.setIcon(new javax.swing.ImageIcon(getClass().getResource("/directionappli/mt1.png"))); // NOI18N
        mont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                montActionPerformed(evt);
            }
        });

        f_achat.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        f_achat.setText("  Achat");
        f_achat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f_achatActionPerformed(evt);
            }
        });

        f_vente.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        f_vente.setText("  Vente");
        f_vente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f_venteActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/directionappli/icone_modifier.png"))); // NOI18N
        jButton2.setText("Modifier");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/directionappli/im_valves_delete.png"))); // NOI18N
        jButton1.setText("Supprimer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/directionappli/loupe.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        n_reg.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        n_reg.setText("N° Réglement :");
        n_reg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/directionappli/reg1.png"))); // NOI18N
        n_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_regActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(f_vente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(f_achat)))
                .addGap(47, 47, 47))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(65, 65, 65)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(n_reg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(n_fact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(mont, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(part, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(f_achat)
                    .addComponent(f_vente))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(n_fact, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(n_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(part, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(mont, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jButton2)
                .addGap(41, 41, 41)
                .addComponent(jButton1)
                .addGap(25, 25, 25))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("N° de Facture :");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Partenaire  :");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Date Facture :");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Montant  :");

        n_fac.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        date_fac.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        date_fac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                date_facActionPerformed(evt);
            }
        });

        mt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        part_f.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Etat :");

        etat.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Règlement :");

        N_rgmt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        N_rgmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                N_rgmtActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/directionappli/actualiser.jpg"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(n_fac)
                                            .addComponent(date_fac, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(mt)
                                            .addComponent(part_f, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(N_rgmt, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etat, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(416, 416, 416)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(n_fac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(etat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(date_fac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(part_f, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(N_rgmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 45, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1377, 775));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void facture_vMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_facture_vMouseClicked
      String PP=null;
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
            String add2 =rs.getString("N_Facture_V");
            n_fac.setText(add2);
            String add3 =rs.getString("Date_Facture");
            date_fac.setText(add3);
            String add4 =rs.getString("Montant_F");
            mt.setText(add4);
            String add5 =rs.getString("Etat_F");
            etat.setText(add5);
            String add6 =rs.getString("N_Réglement");
            N_rgmt.setText(add6);
            PP =rs.getString("Id_Partenaire");
       }
     
       // JOptionPane.showMessageDialog(null,"le nouveau Bon de livraison est ajouté");
       }
       catch(SQLException e){
           System.err.println(e);
      } 
        try{
           
           String requete= "select Nom from partenaire where Id_Partenaire='"+PP+"' ";
         stm=maConnexion.get_connexion().createStatement();
        rs=stm.executeQuery(requete);
        rs.first();
        String a =rs.getString("Nom");
        part_f.setText(a);
        }
       catch(SQLException e){
           System.err.println(e);
      } 
       
    }//GEN-LAST:event_facture_vMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       if(f_vente.isSelected()==true && f_achat.isSelected()==false)
       {
           Modification_Vente();
       }
       else if(f_vente.isSelected()==false && f_achat.isSelected()==true)
       {
           Modification_Achat();
       }
      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
      if(date.isSelected()==true)
      {
          txt_search.requestFocusInWindow();
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
        txt_search.requestFocusInWindow();  
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
          txt_search.requestFocusInWindow();
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

    private void n_factActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_factActionPerformed
       if(n_fact.isSelected()==true)
      {
          txt_search.requestFocusInWindow();
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

    private void f_venteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f_venteActionPerformed
         if(f_vente.isSelected()==true)
      {
         txt_search.requestFocusInWindow();
        f_achat.setEnabled(false);
      }
      else if(f_vente.isSelected()==false)
      {
        f_achat.setEnabled(true);
      }
    }//GEN-LAST:event_f_venteActionPerformed

    private void f_achatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f_achatActionPerformed
        if(f_achat.isSelected()==true)
      {
         txt_search.requestFocusInWindow();
        f_vente.setEnabled(false);
      }
      else if(f_achat.isSelected()==false)
      {
        f_vente.setEnabled(true);
      }
    }//GEN-LAST:event_f_achatActionPerformed

    private void txt_searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
        if(f_vente.isSelected()==true && f_achat.isSelected()==false)
       {
           Recherche_Vente();
       }
       else if(f_vente.isSelected()==false && f_achat.isSelected()==true)
       {
           Recherche_Achat();
       }
        }
    }//GEN-LAST:event_txt_searchKeyPressed

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void facture_aMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_facture_aMouseClicked
       String PP=null;
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
                String add2 =rs.getString("N_Facture");
            n_fac.setText(add2);
            String add3 =rs.getString("Date_Achat");
            date_fac.setText(add3);
            String add4 =rs.getString("Prix_Achat");
            mt.setText(add4);
            String add5 =rs.getString("Etat");
            etat.setText(add5);
            String add6 =rs.getString("N_Reglement_A");
            N_rgmt.setText(add6);
            PP =rs.getString("Id_Partenaire");
            
            }

            // JOptionPane.showMessageDialog(null,"le nouveau Bon de livraison est ajouté");
        }
        catch(SQLException e){
            System.err.println(e);
        }
        try{
           
           String requete= "select Nom from partenaire where Id_Partenaire='"+PP+"' ";
         stm=maConnexion.get_connexion().createStatement();
        rs=stm.executeQuery(requete);
        rs.first();
        String a =rs.getString("Nom");
        part_f.setText(a);
        }
       catch(SQLException e){
           System.err.println(e);
      } 
    }//GEN-LAST:event_facture_aMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if(f_vente.isSelected()==true && f_achat.isSelected()==false)
       {
           Supression_Vente();
       }
       else if(f_vente.isSelected()==false && f_achat.isSelected()==true)
       {
           Supression_Achat();
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       Remplir_TableFV();
       Remplir_TableFV();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void N_rgmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_N_rgmtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_N_rgmtActionPerformed

    private void date_facActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_date_facActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_date_facActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
       Remplir_TableFV();
       Remplir_TableFA();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void n_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_regActionPerformed
       if(n_reg.isSelected()==true)
      {
          txt_search.requestFocusInWindow();
        n_fact.setEnabled(false);
        date.setEnabled(false);
        mont.setEnabled(false);
        part.setEnabled(false);
      }
      else if(n_reg.isSelected()==false)
      {
        n_fact.setEnabled(true);   
        date.setEnabled(true);
        mont.setEnabled(true);
        part.setEnabled(true);
      }
    }//GEN-LAST:event_n_regActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameRechercheFactureModifié.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameRechercheFactureModifié.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameRechercheFactureModifié.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameRechercheFactureModifié.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameRechercheFactureModifié().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField N_rgmt;
    private javax.swing.JTextArea com;
    private javax.swing.JRadioButton date;
    private javax.swing.JTextField date_fac;
    private javax.swing.JTextField etat;
    private javax.swing.JCheckBox f_achat;
    private javax.swing.JCheckBox f_vente;
    private javax.swing.JTable facture_a;
    private javax.swing.JTable facture_v;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton mont;
    private javax.swing.JTextField mt;
    private javax.swing.JTextField n_fac;
    private javax.swing.JRadioButton n_fact;
    private javax.swing.JRadioButton n_reg;
    private javax.swing.JRadioButton part;
    private javax.swing.JTextField part_f;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
