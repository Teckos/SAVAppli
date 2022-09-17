/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package savappli;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author khaoula
 */
public class JFrameTableAppareilPret extends javax.swing.JFrame {
    
     Statement stm;
    private PreparedStatement pst;
    ResultSet rs,rs1;
    connexion maConnexion= new connexion();
    /**
     * Creates new form JFrameTableBL
     */
    void Remplir_TableTélephoneRéparé(){
          
              String sql="select  M.Type_Mat,M.Couleur,MO.Type_MO, Main_Oeuvre as Contrôle , count(N_Serie) as Nombre\n" +
"from appareil A,intervention I,materiel M,bonlivraison B, maindoeuvre MO\n" +
"where  A.Etat='Réparé'\n" +
"AND A.Type_App='Téléphone'\n" +
"AND type_In='Prêt'\n" +
"AND Id_Panne  in (select Id_panne from panne where type!='SAV')\n" +
"AND A.Id_Intervention=I.Id_Intervention\n" +
"AND A.Id_Materiel=M.Id_Materiel\n" +
"AND A.Id_MO = MO.Id_MO\n" +
"AND B.N_BL=A.N_BL\n" +
"AND A.`N_BL`='3'\n" +
"Group by M.Type_Mat,MO.`Type_MO`";
             
              String sql1="select  count(N_Serie) as T\n" +
"from appareil A,intervention I,materiel M,bonlivraison B, maindoeuvre MO\n" +
"where  A.Etat='Réparé'\n" +
"AND A.Type_App='Téléphone'\n" +
"AND type_In='Prêt'\n" +
"AND Id_Panne  in (select Id_panne from panne where type!='SAV')\n" +
"AND A.Id_Intervention=I.Id_Intervention\n" +
"AND A.Id_Materiel=M.Id_Materiel\n" +
"AND A.Id_MO = MO.Id_MO\n" +
"AND B.N_BL=A.N_BL\n" +
"AND A.`N_BL`='3'\n";
              try{
              stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
              TableTeleph.setModel(DbUtils.resultSetToTableModel(rs));
              
              rs1=stm.executeQuery(sql1);
              if(rs1.first())
                {
             int nb = rs1.getInt("T");
                
              String n=String.valueOf(nb);
               telRep.setText(n);}
              //TableProd.setModel(DbUtils.resultSetToTableModel(rs));
              }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
    }
    
    void Remplir_TableTabletteRéparé(){
          
              String sql="select  M.Type_Mat,M.Couleur,MO.Type_MO, Main_Oeuvre as Contrôle , count(N_Serie) as Nombre\n" +
"from appareil A,intervention I,materiel M,bonlivraison B, maindoeuvre MO\n" +
"where  A.Etat='Réparé'\n" +
"AND A.Type_App='Tablette'\n" +
"AND type_In='Prêt'\n" +
"AND Id_Panne  in (select Id_panne from panne where type!='SAV')\n" +
"AND A.Id_Intervention=I.Id_Intervention\n" +
"AND A.Id_Materiel=M.Id_Materiel\n" +
"AND A.Id_MO = MO.Id_MO\n" +
"AND B.N_BL=A.N_BL\n" +
"AND A.`N_BL`='3'\n" +
"Group by M.Type_Mat,MO.`Type_MO`";
               String sql1="select  count(N_Serie) as T\n" +
"from appareil A,intervention I,materiel M,bonlivraison B, maindoeuvre MO\n" +
"where  A.Etat='Réparé'\n" +
"AND A.Type_App='Tablette'\n" +
"AND type_In='Prêt'\n" +
"AND Id_Panne  in (select Id_panne from panne where type!='SAV')\n" +
"AND A.Id_Intervention=I.Id_Intervention\n" +
"AND A.Id_Materiel=M.Id_Materiel\n" +
"AND A.Id_MO = MO.Id_MO\n" +
"AND B.N_BL=A.N_BL\n" +
"AND A.`N_BL`='3'\n";
              try{
              stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
              TableTab.setModel(DbUtils.resultSetToTableModel(rs));
              rs1=stm.executeQuery(sql1);
              if(rs1.first())
                {
             int nb = rs1.getInt("T");
                
              String n=String.valueOf(nb);
               TabRep.setText(n);}
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
    }
    
    void Remplir_TableTelNonRéparé(){
          
              String sql="select type,count(N_Serie) as nombre\n" +
"from appareil A,panne P\n" +
"where A.Etat='Non Réparé'\n" +
"and A.id_panne = P.id_panne\n" +
"and A.Etat='Non Réparé'\n" +
"and A.Type_App='Téléphone'\n" +
"AND A.Id_Intervention='3'\n" +
"AND N_BL='3'\n" +
"group by P.type";
              String sql1="select count(N_Serie) as T\n" +
"from appareil A,panne P\n" +
"where A.Etat='Non Réparé'\n" +
"and A.id_panne = P.id_panne\n" +
"and A.Etat='Non Réparé'\n" +
"and A.Type_App='Téléphone'\n" +
"AND A.Id_Intervention='3'\n" +
"AND N_BL='3'\n" ;
              try{
              stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
              TableTelNn.setModel(DbUtils.resultSetToTableModel(rs));
              rs1=stm.executeQuery(sql1);
              if(rs1.first())
                {
             int nb = rs1.getInt("T");
                
              String n=String.valueOf(nb);
               TelNn.setText(n);}
               
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
    }
void Remplir_TableTabNonRéparé(){
          
              String sql="select type,count(N_Serie) as nombre\n" +
"from appareil A,panne P\n" +
"where A.Etat='Non Réparé'\n" +
"and A.id_panne = P.id_panne\n" +
"and A.Etat='Non Réparé'\n" +
"and A.Type_App='Tablette'\n" +
"AND A.Id_Intervention='3'\n" +
"AND N_BL='3'\n" +
"group by P.type";
              
              String sql1="select count(N_Serie) as T\n" +
"from appareil A,panne P\n" +
"where A.Etat='Non Réparé'\n" +
"and A.id_panne = P.id_panne\n" +
"and A.Etat='Non Réparé'\n" +
"and A.Type_App='Tablette'\n" +
"AND A.Id_Intervention='3'\n" +
"AND N_BL='3'\n";
              try{
              stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
              TableTabNn.setModel(DbUtils.resultSetToTableModel(rs));
              rs1=stm.executeQuery(sql1);
              if(rs1.first())
                {
             int nb = rs1.getInt("T");
                
              String n=String.valueOf(nb);
               TabNn.setText(n);}
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
    }
    
     void Remplir_TelSAV(){
          try{
              String sql="select type,count(N_Serie) as nombre\n" +
"from appareil A,panne P\n" +
"where A.Id_panne='5'\n" +
"AND A.Etat='Réparé'\n" +
"and A.Type_App='Téléphone'\n" +
"and A.id_panne = P.id_panne\n" +
"AND A.Id_Intervention='3'\n" +
"AND N_BL='3'\n" +
"group by P.type";
              pst=maConnexion.get_connexion().prepareStatement(sql);
              rs=pst.executeQuery();
              TelSav.setModel(DbUtils.resultSetToTableModel(rs));
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
    }
     
      void Remplir_TabSAV(){
          try{
              String sql="select type,count(N_Serie) as nombre\n" +
"from appareil A,panne P\n" +
"where A.Id_panne='5'\n" +
"AND A.Etat='Réparé'\n" +
"and A.Type_App='Tablette'\n" +
"and A.id_panne = P.id_panne\n" +
"AND A.Id_Intervention='3'\n" +
"AND N_BL='3'\n" +
"group by P.type";
              pst=maConnexion.get_connexion().prepareStatement(sql);
              rs=pst.executeQuery();
              TabSav.setModel(DbUtils.resultSetToTableModel(rs));
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
    }
      
  void Calcul_Total() 
  {
  
            try{
              String sql="select count(N_Serie) as T\n" +
"from appareil A\n" +
"where  A.Id_Intervention='3'\n" +
"AND N_BL='3'\n" ;
              stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
               if(rs.first())
                {
             int nb = rs.getInt("T");
                
              String n=String.valueOf(nb);
               T.setText(n);}
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
  
  }

    /**
     * Creates new form JFrameTableAppareil
     */
    public JFrameTableAppareilPret() {
        initComponents();
        Remplir_TableTélephoneRéparé();
        Remplir_TableTabletteRéparé();
        Remplir_TableTelNonRéparé();
        Remplir_TableTabNonRéparé();
        Remplir_TelSAV();
        Remplir_TabSAV();
        Calcul_Total();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TableTeleph = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableTab = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableTelNn = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TableTabNn = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TabSav = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        telRep = new javax.swing.JTextField();
        TabRep = new javax.swing.JTextField();
        TelNn = new javax.swing.JTextField();
        TabNn = new javax.swing.JTextField();
        T = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TelSav = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TableTeleph.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TableTeleph.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TableTeleph);

        TableTab.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TableTab.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(TableTab);

        jLabel2.setBackground(new java.awt.Color(204, 204, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tablettes Réparées  :");

        TableTelNn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TableTelNn.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(TableTelNn);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Télephones Non Réparés  :");

        TableTabNn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TableTabNn.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(TableTabNn);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Tablettes Non Réparées  :");

        TabSav.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TabSav.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(TabSav);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Tablettes SAV");

        telRep.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        telRep.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        TabRep.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TabRep.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        TelNn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TelNn.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        TabNn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TabNn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TabNn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TabNnActionPerformed(evt);
            }
        });

        T.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        T.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Total Appareils à livrer :");

        TelSav.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TelSav.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(TelSav);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("Télephones SAV");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TelNn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(121, 121, 121))
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(telRep, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TabRep, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TabNn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(54, 54, 54)
                .addComponent(T, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telRep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabRep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TelNn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TabNn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(T, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Télephones Réparés  :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(659, 659, 659))
        );

        setSize(new java.awt.Dimension(725, 784));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TabNnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TabNnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TabNnActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameTableAppareilPret.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameTableAppareilPret.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameTableAppareilPret.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameTableAppareilPret.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameTableAppareilPret().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField T;
    private javax.swing.JTextField TabNn;
    private javax.swing.JTextField TabRep;
    private javax.swing.JTable TabSav;
    private javax.swing.JTable TableTab;
    private javax.swing.JTable TableTabNn;
    private javax.swing.JTable TableTelNn;
    private javax.swing.JTable TableTeleph;
    private javax.swing.JTextField TelNn;
    private javax.swing.JTable TelSav;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField telRep;
    // End of variables declaration//GEN-END:variables
}
