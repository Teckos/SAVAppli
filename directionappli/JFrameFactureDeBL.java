/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package directionappli;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author khaoula
 */
public class JFrameFactureDeBL extends javax.swing.JFrame {
    
    Statement stm;
    ResultSet rs;
    DefaultTableModel dt;
    connexion maConnexion=new connexion();
    
    public void Facture_Vente()
    {
         Calendar cal = new GregorianCalendar();
         SimpleDateFormat date_format = new SimpleDateFormat("yyyyMMdd");
         int annee = cal.get(Calendar.YEAR);
         int mois=cal.get(Calendar.MONTH); 
         int jour=cal.get(Calendar.DAY_OF_MONTH);
         n_facture.setText("F"+date_format.format(cal.getTime())+"A");
     // n_bl.setText(date_format.format(cal.getTime()));     
    }
        public void Date_courante()
{
    Calendar cal = new GregorianCalendar();
    SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");

    int annee = cal.get(Calendar.YEAR);
    int mois=cal.get(Calendar.MONTH); 
    int jour=cal.get(Calendar.DAY_OF_MONTH);
    date_f.setText(date_format.format(cal.getTime()));
    // System.out.println(date_format.format(cal.getTime()));      
}

    void Remplir_ComboPart(){
          try{
              String sql="select Nom from partenaire where Désignation='Client'";
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
    
   /* void Remplir_ComboType(){
          try{
              String sql="select Type from gratification";
              stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
               while(rs.next())
                {
                  String name=rs.getString("Type");
                  ComboTypeGR.addItem(name);
                  }
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
    }*/
    /*
     void Remplir_ComboTarif(){
          try{
              String sql="select distinct(Date) from gratification";
              stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
               while(rs.next())
                {
                  String name=rs.getString("Date");
                  ComboTarif.addItem(name);
                  }
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
    }*/
     void Remplir_TableBl(){
          try{
              String sql="select N_BL,Date_BL,Etat_BL from bonlivraison where \n"+
                      "N_BL NOT IN (select N_BL from bonlivraison where Date_BL='0000-00-00')\n"+
                      "AND N_Facture_V='1'";
             stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
              TableBl.setModel(DbUtils.resultSetToTableModel(rs));
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
    }
    
   /* void Remplir_TableBl(){
        dt=(DefaultTableModel)TableBl.getModel();
          try{
              String sql="select N_BL,Date_BL,Etat_BL from bonlivraison where \n"+
                      "N_BL NOT IN (select N_BL from bonlivraison where Date_BL='0000-00-00')\n"+
                      "AND N_Facture_V='1'";
             stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
              TableBl.se
              .setModel(DbUtils.resultSetToTableModel(rs));
              DbUtils.resultSetToTableModel(rs)
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
    }*/
     
     void Remplir_TableF(){
          try{
             // dt.setRowCount(0);
              
              String sql="select N_Facture_V,Date_Facture from facture where N_Facture_V NOT IN (select N_Facture_V from facture where Date_Facture='0000-00-00')";
             stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
              TableF.setModel(DbUtils.resultSetToTableModel(rs));
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
    }
     
     void Remplir_TableType(){
          /*try{
             // dt.setRowCount(0);
              String sql="select Type_Mat \n" +
              "from materiel M,appareil A,bonlivraison B,facture F\n" +
              "where M.`Id_Materiel`=A.`Id_Materiel`\n" +
              "and A.`N_BL`=B.`N_BL`\n" +
              "and B.`N_Facture_V`=F.`N_Facture_V`\n" +
              "and F.N_Facture_V='"+n_facture.getText()+"'";
             stm=maConnexion.get_connexion().createStatement();
             rs=stm.executeQuery(sql);
             TableType.setModel(DbUtils.resultSetToTableModel(rs));
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }*/
    }
     
     void Fonction_Selection_Multiple(){
      try{
           int[] rows = TableBl.getSelectedRows();
           for(int i=0;i<rows.length;i++)
           { 
           System.out.println(rows[i]);
           
          String t = (TableBl.getModel().getValueAt(rows[i], 0).toString());
          String requete= "UPDATE bonlivraison SET N_Facture_V= '"+n_facture.getText()+"',Etat_BL='Facturé' \n"+
                   "where N_BL='"+t+"'";
        stm=maConnexion.get_connexion().createStatement();
      //  stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
        stm.executeUpdate(requete); 
           }
        JOptionPane.showMessageDialog(null,"Ce Bon de livraison est ajouté à la Facture");
       }
       catch(SQLException e){
           System.err.println(e);
      }
        Remplir_TableBl();
     }
        
    /**
     * Creates new form JFrameFacture
     */
    public JFrameFactureDeBL() {
        initComponents();
        //dt=(DefaultTableModel)TableBl.getModel();
        Facture_Vente();
        Date_courante();
        Remplir_ComboPart();
        Remplir_TableBl();
        Remplir_TableF();
      //  Remplir_TableType();
        //Remplir_ComboTarif();
       // Remplir_ComboType();
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
        n_facture = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        date_f = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        n_reg = new javax.swing.JTextField();
        tva = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        ComboPart = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        montant_f = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableBl = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableF = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        com = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        adresse = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" Ajout de la Facture :");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("N° de Facture :");

        n_facture.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        n_facture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_factureActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Date de Facture :");

        date_f.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("N° de Règlement :");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Partenaire");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("TVA  :");

        n_reg.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        tva.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setText("Valider");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ComboPart.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ComboPart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboPartActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Montant de Facture :");

        montant_f.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        montant_f.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                montant_fActionPerformed(evt);
            }
        });

        TableBl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "Title 2", "Title 3", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableBl.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        TableBl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableBlMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableBl);

        TableF.setModel(new javax.swing.table.DefaultTableModel(
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
        TableF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableFMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableF);

        jButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton3.setText("Créer Facture");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton4.setText("Calculer le Montant de la facture");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setText("Affecter ces BL à cette Facture");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Commentaire :");

        com.setColumns(20);
        com.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        com.setRows(5);
        jScrollPane3.setViewportView(com);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("1-");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("2-");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("3-");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("4-");

        adresse.setColumns(20);
        adresse.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        adresse.setRows(5);
        jScrollPane4.setViewportView(adresse);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Adresse Facture :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(51, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(28, 28, 28)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(n_facture, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(date_f, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(n_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ComboPart, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tva, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(30, 30, 30)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(22, 22, 22)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(91, 91, 91)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(221, 221, 221)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(370, 370, 370)
                                        .addComponent(jLabel10)
                                        .addGap(10, 10, 10)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(jLabel12)
                                .addGap(39, 39, 39)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(montant_f, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(n_facture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(date_f, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(n_reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ComboPart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel10))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(montant_f, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jLabel11))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel12))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(923, 719));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void n_factureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_factureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n_factureActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String N_F = n_facture.getText();
        String M_F = montant_f.getText();
         
       try{
        //la requête
        String requete= "UPDATE facture SET Montant_F= '"+M_F+"' WHERE N_Facture_V='"+N_F+"' ";
          //Exécuter la requête
       stm=maConnexion.get_connexion().createStatement();
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
        stm.executeUpdate(requete); 
        Remplir_TableBl();
         JOptionPane.showMessageDialog(null,"requête exécutée avec succés");
       }
        
       catch(SQLException e){
           System.err.println(e);    
    }                                        
     
   // TableF.setModel(dt);
      String Adresse = adresse.getText();
    try{
      
      String RAPPORT = "C:\\DirectionAppli\\src\\directionappli\\Facture_V.jrxml";
      
      //JasperDesign jasperDesign = JRXmlLoader.load(RAPPORT);
      JasperReport jr = JasperCompileManager.compileReport(RAPPORT);
      
      Map param = new HashMap();
      param.put("numFac",new String(N_F));
      param.put("addrDes",new String (Adresse));
      JasperPrint jp = JasperFillManager.fillReport(jr,param, maConnexion.get_connexion());
      JasperExportManager.exportReportToPdfFile(jp, "C:\\directionappli\\"+N_F+".pdf");
      JasperViewer.viewReport(jp,false);
        }
        catch(Exception e){
            System.out.print(e);
        }  
    
    n_facture.setText("");
     date_f.setText("");
     n_reg.setText("");
     //etat.setText("");
     montant_f.setText("");
     tva.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TableBlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableBlMouseClicked
/*        // TODO add your handling code here:
        
        try{
           int row = TableBl.getSelectedRow();
           String t = (TableBl.getModel().getValueAt(row, 0).toString());
           String requete= "UPDATE bonlivraison SET N_Facture_V= '"+n_facture.getText()+"',Etat_BL='Facturé' \n"+
                   "where N_BL='"+t+"'";
         stm=maConnexion.get_connexion().createStatement();
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
        stm.executeUpdate(requete); 
        JOptionPane.showMessageDialog(null,"Ce Bon de livraison est ajouté à la Facture");
       }
       catch(SQLException e){
           System.err.println(e);
      }
        Remplir_TableBl();*/
    }//GEN-LAST:event_TableBlMouseClicked

    private void TableFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableFMouseClicked
        // TODO add your handling code here:
        try{
           int row = TableF.getSelectedRow();
           String t = (TableF.getModel().getValueAt(row, 0).toString());
           String requete= "select * from facture where N_Facture_V='"+t+"'";
         stm=maConnexion.get_connexion().createStatement();
        rs=stm.executeQuery(requete); //ne passe pas pour l'insertion dans mysql
        //stm.executeUpdate(requete); 
        if(rs.next())
        {
            String add1 =rs.getString("N_Facture_V");
            n_facture.setText(add1);
            String add2 =rs.getString("Date_Facture");
            date_f.setText(add2);
            String add4 =rs.getString("N_Réglement");
            n_reg.setText(add4);
            String add5 =rs.getString("TVA_V");
            tva.setText(add5);
        }
     
       // JOptionPane.showMessageDialog(null,"le nouveau Bon de livraison est ajouté");
       }
       catch(SQLException e){
           System.err.println(e);
      } 
        Remplir_TableType();
    }//GEN-LAST:event_TableFMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String N_F = n_facture.getText();
        String D_F = date_f.getText();
        String N_R = n_reg.getText();
        String TVA = tva.getText();
        //String E = etat.getText();
        String C = com.getText();
      //  String M_F = montant_f.getText();
         
       try{
        //la requête
        String requete="INSERT INTO facture(N_Facture_V,Date_Facture,N_Réglement,TVA_V,Etat_F,Montant_F,Id_Partenaire,Commentaire)\n"+
                "VALUES ('"+N_F+"','"+D_F+"','"+N_R+"','"+TVA+"','Non Payée','0',\n"+
                "(select Id_Partenaire from partenaire where Nom='"+ComboPart.getSelectedItem()+"' AND Désignation='Client'),'"+C+"') " ;
       //Exécuter la requête
       stm=maConnexion.get_connexion().createStatement();
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
        stm.executeUpdate(requete); 
        Remplir_TableBl();
         JOptionPane.showMessageDialog(null,"requête exécutée avec succés");
       }
        
       catch(SQLException e){
           System.err.println(e);    
    }                                        
     n_facture.setText("");
     date_f.setText("");
     n_reg.setText("");
     //etat.setText("");
     montant_f.setText("");
     tva.setText("");  
     Remplir_TableF();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       float s=0,s1=0,s2=0;
          int nb=0,nb1=0;
          int pr=0,pr1=0;
          float resultat=0,resultat1=0;
        
        try{
            
   String sql=" select count(M.`Id_Materiel`) as nbr,Prix_Vente\n"+
              "from materiel M,appareil A,bonlivraison B,facture F\n"+
              "where M.`Id_Materiel`=A.`Id_Materiel`\n"+
              "and A.`N_BL`=B.`N_BL`\n"+
              "and B.`N_Facture_V`=F.`N_Facture_V`\n"+
              "and A.`Id_panne`!='5'\n"+
              "and F.N_Facture_V='"+n_facture.getText()+"' GROUP BY Prix_Vente";
         stm=maConnexion.get_connexion().createStatement();
         rs=stm.executeQuery(sql);
         
        // int[]t  ;
         //t=new int[50] ;
        // int Tab [] =new int[50];
        /* if(rs.first())
         {
        int nb = rs.getInt("nbr");
        int pr = rs.getInt("Prix_Vente");
        int resultat=nb*pr;
         //int[] t = {resultat};
          System.out.println(resultat);
          int s=0;
          s=resultat;
         }*/
      
          //while(rs.next())
         //{
          
              for(int i=1;i<1000;i++)
             {
                 if(rs.absolute(i))
                 {
                 nb = rs.getInt("nbr");
                 pr = rs.getInt("Prix_Vente");
                 resultat=nb*pr;
                  System.out.println(resultat);
                  s+=resultat;
                 }
            
              }
          /*  System.out.println(s);
            String m=String.valueOf(s);
            montant_f.setText(m);*/
            }
        catch(SQLException e){
           System.err.println(e);    
    }   
            
        
             try{
            
   String sql=" select count(M.`Id_MO`) as nbr,Prix_MO\n"+
              "from maindoeuvre M,appareil A,bonlivraison B,facture F\n"+
              "where M.`Id_MO`=A.`Id_MO`\n"+
              "and A.`N_BL`=B.`N_BL`\n"+
              "and B.`N_Facture_V`=F.`N_Facture_V`\n"+
              "and F.N_Facture_V='"+n_facture.getText()+"' GROUP BY Prix_MO";
         stm=maConnexion.get_connexion().createStatement();
         rs=stm.executeQuery(sql);
         
              for(int i=1;i<1000;i++)
             {
                 if(rs.absolute(i))
                 {
                 nb1 = rs.getInt("nbr");
                 pr1 = rs.getInt("Prix_MO");
                 resultat1=nb1*pr1;
                  System.out.println(resultat1);
                  s1+=resultat1;
                 }
            
              }
         /*   System.out.println(s);
            String m=String.valueOf(s);
            montant_f.setText(m);*/
  
    }
        catch(SQLException e){
           System.err.println(e);    
    }  
             s2=s+s1;
            System.out.println(s2);
            String m=String.valueOf(s2);
            montant_f.setText(m);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
/*     try{
           int row = TableBl.getSelectedRow();
           String t = (TableBl.getModel().getValueAt(row, 0).toString());
           String requete= "UPDATE bonlivraison SET N_Facture_V= '"+n_facture.getText()+"',Etat_BL='Facturé' \n"+
                   "where N_BL='"+t+"'";
         stm=maConnexion.get_connexion().createStatement();
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
        stm.executeUpdate(requete); 
        JOptionPane.showMessageDialog(null,"Ce Bon de livraison est ajouté à la Facture");
       }
       catch(SQLException e){
           System.err.println(e);
      }
        Remplir_TableBl();*/
        Fonction_Selection_Multiple();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ComboPartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboPartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboPartActionPerformed

    private void montant_fActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_montant_fActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_montant_fActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameFactureDeBL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameFactureDeBL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameFactureDeBL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameFactureDeBL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameFactureDeBL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboPart;
    private javax.swing.JTable TableBl;
    private javax.swing.JTable TableF;
    private javax.swing.JTextArea adresse;
    private javax.swing.JTextArea com;
    private javax.swing.JTextField date_f;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField montant_f;
    private javax.swing.JTextField n_facture;
    private javax.swing.JTextField n_reg;
    private javax.swing.JTextField tva;
    // End of variables declaration//GEN-END:variables
}
