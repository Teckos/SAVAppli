/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package savappli;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import savappli.connexion;

/**
 *
 * @author khaoula
 */
public class JFrameRechercherParCritère extends javax.swing.JFrame {
    Statement stm;
    ResultSet rs,rs1,rs2,rs3;
    DefaultTableModel dt;
    connexion maConnexion=new connexion();
    

    /**
     * Creates new form JFrameProductivitéPersonnelle
     */
    
     private void Remplir_ComboIntervention(){
         ComboIntervention.removeAllItems();
          try{
              String sql="select distinct(type_In) from intervention ";
              stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
               while(rs.next())
                {
                  String name=rs.getString("type_In");
                  ComboIntervention.addItem(name);
                  }
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
    } 
    
     
private void Remplir_ComboAppareil(){
         ComboApp.removeAllItems();
          try{
              String sql="select distinct(Type_Mat) from materiel where Id_Materiel!='1' ";
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

private void Remplir_ComboPanne(){
         ComboPanne.removeAllItems();
          try{
              String sql="select distinct(type) from panne ";
              stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
               while(rs.next())
                {
                  String name=rs.getString("type");
                  ComboPanne.addItem(name);
                  }
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
    } 

private void Fonction_Interv_App()
{
try{
             
              String sql="select A.N_Serie,A.N_Dossier,A.Date_E as Date_Entrée,A.Date_R as Date_Réparation,A.Type_App ,I.type_In AS Intervention,A.Etat,P.type as Panne,A.Description,MO.Type_MO as Main_Oeuvre,MA.Nom as Façade,MA.Type_Mat as Appareil,MA.Couleur,II.Nom\n" +
                         "from appareil A,materiel MA,intervention I,panne P,maindoeuvre MO,intervenant II\n" +
                         "where MA.`Id_Materiel`=A.`Id_Materiel`\n" +
                         "AND II.`Id_Intervenant`=A.`Id_Intervenant`\n" +
                         "AND I.`Id_Intervention`=A.`Id_Intervention`\n" +
                         "AND P.`Id_panne`=A.`Id_panne`\n" +
                         "AND MO.`Id_MO`=A.`Id_MO`\n" +
                         "AND II.`Id_Intervenant`=A.`Id_Intervenant`\n" +
                         "AND A.N_BL=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"' )\n" +
                         "AND A.Id_Intervention=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"' )\n" +
                         "AND A.Id_Materiel IN (select Id_Materiel from materiel where Type_Mat='"+ComboApp.getSelectedItem()+"') ORDER BY A.Etat,P.type,MO.Main_Oeuvre,Façade";
               stm=maConnexion.get_connexion().createStatement();
               rs=stm.executeQuery(sql);
               TableProd.setModel(DbUtils.resultSetToTableModel(rs));
           }
        catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
         String N_R=nb_rep.getText();
       try{
             // dt.setRowCount(0);
              String sql="select count(A.N_Serie) as nbr_rep\n" +
                         "from appareil A,materiel MA,intervention I,panne P,maindoeuvre MO,intervenant II\n" +
                         "where MA.`Id_Materiel`=A.`Id_Materiel`\n" +
                         "AND I.`Id_Intervention`=A.`Id_Intervention`\n" +
                         "AND P.`Id_panne`=A.`Id_panne`\n" +
                         "AND MO.`Id_MO`=A.`Id_MO`\n" +
                         "AND II.`Id_Intervenant`=A.`Id_Intervenant`\n" +
                         "AND A.N_BL=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"' )\n" +
                         "AND A.Id_Intervention=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"' )\n" +
                         "AND A.Id_Materiel IN (select Id_Materiel from materiel where Type_Mat='"+ComboApp.getSelectedItem()+"') AND A.Etat='Réparé'";
              stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
              if(rs.first())
                {
                 int nb = rs.getInt("nbr_rep");
                 String n=String.valueOf(nb);
                 nb_rep.setText(n);}
                 }
       catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
         
          String N_N=nb_nn.getText();
       try{
             // dt.setRowCount(0);
              String sql="select count(A.N_Serie) as nbr_nn\n" +
                         "from appareil A,materiel MA,intervention I,panne P,maindoeuvre MO,intervenant II\n" +
                         "where MA.`Id_Materiel`=A.`Id_Materiel`\n" +
                         "AND I.`Id_Intervention`=A.`Id_Intervention`\n" +
                         "AND P.`Id_panne`=A.`Id_panne`\n" +
                         "AND MO.`Id_MO`=A.`Id_MO`\n" +
                         "AND II.`Id_Intervenant`=A.`Id_Intervenant`\n" +
                         "AND A.N_BL=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"' )\n" +
                          "AND A.Id_Intervention=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"' )\n" +
                          "AND A.Id_Materiel IN (select Id_Materiel from materiel where Type_Mat='"+ComboApp.getSelectedItem()+"') AND A.Etat='Non Réparé'";
             stm=maConnexion.get_connexion().createStatement();
             rs=stm.executeQuery(sql);
             if(rs.first())
                {
                  int nb = rs.getInt("nbr_nn");
                  String n=String.valueOf(nb);
                  nb_nn.setText(n);}
                }
       catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
         
          String T=total.getText();
       try{
             // dt.setRowCount(0);
              String sql="select count(A.N_Serie) as nbr\n" +
                          "from appareil A,materiel MA,intervention I,panne P,maindoeuvre MO,intervenant II\n" +
                          "where MA.`Id_Materiel`=A.`Id_Materiel`\n" +
                          "AND I.`Id_Intervention`=A.`Id_Intervention`\n" +
                          "AND P.`Id_panne`=A.`Id_panne`\n" +
                          "AND MO.`Id_MO`=A.`Id_MO`\n" +
                          "AND II.`Id_Intervenant`=A.`Id_Intervenant`\n" +
                          "AND A.N_BL=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"' )\n" +
                          "AND A.Id_Intervention=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"' )\n" +
                          "AND A.Id_Materiel IN (select Id_Materiel from materiel where Type_Mat='"+ComboApp.getSelectedItem()+"')";
             stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
               if(rs.first())
                {
             int nb = rs.getInt("nbr");
              String n=String.valueOf(nb);
              total.setText(n);}
                 }
        catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }

}


//************************************************************************************************************//


private void Fonction_Interv_Panne()
{
try{
             
              String sql="select A.N_Serie,A.N_Dossier,A.Date_E as Date_Entrée,A.Date_R as Date_Réparation,A.Type_App ,I.type_In AS Intervention,A.Etat,P.type as Panne,A.Description,MO.Type_MO as Main_Oeuvre,MA.Nom as Façade,MA.Type_Mat as Appareil,MA.Couleur,II.Nom\n" +
                         "from appareil A,materiel MA,intervention I,panne P,maindoeuvre MO,intervenant II\n" +
                         "where MA.`Id_Materiel`=A.`Id_Materiel`\n" +
                         "AND II.`Id_Intervenant`=A.`Id_Intervenant`\n" +
                         "AND I.`Id_Intervention`=A.`Id_Intervention`\n" +
                         "AND P.`Id_panne`=A.`Id_panne`\n" +
                         "AND MO.`Id_MO`=A.`Id_MO`\n" +
                         "AND II.`Id_Intervenant`=A.`Id_Intervenant`\n" +
                         "AND A.N_BL=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"' )\n" +
                         "AND A.Id_Intervention=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"' )\n" +
                         "AND A.Id_panne=(select Id_panne from panne where type='"+ComboPanne.getSelectedItem()+"') ORDER BY A.Etat,P.type,MO.Main_Oeuvre,Façade";
               stm=maConnexion.get_connexion().createStatement();
               rs=stm.executeQuery(sql);
               TableProd.setModel(DbUtils.resultSetToTableModel(rs));
           }
        catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
         String N_R=nb_rep.getText();
       try{
             // dt.setRowCount(0);
              String sql="select count(A.N_Serie) as nbr_rep\n" +
                         "from appareil A,materiel MA,intervention I,panne P,maindoeuvre MO,intervenant II\n" +
                         "where MA.`Id_Materiel`=A.`Id_Materiel`\n" +
                         "AND I.`Id_Intervention`=A.`Id_Intervention`\n" +
                         "AND P.`Id_panne`=A.`Id_panne`\n" +
                         "AND MO.`Id_MO`=A.`Id_MO`\n" +
                         "AND II.`Id_Intervenant`=A.`Id_Intervenant`\n" +
                         "AND A.N_BL=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"' )\n" +
                         "AND A.Id_Intervention=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"' )\n" +
                         "AND A.Id_panne=(select Id_panne from panne where type='"+ComboPanne.getSelectedItem()+"') AND A.Etat='Réparé'";
              stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
              if(rs.first())
                {
                 int nb = rs.getInt("nbr_rep");
                 String n=String.valueOf(nb);
                 nb_rep.setText(n);}
                 }
       catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
         
          String N_N=nb_nn.getText();
       try{
             // dt.setRowCount(0);
              String sql="select count(A.N_Serie) as nbr_nn\n" +
                         "from appareil A,materiel MA,intervention I,panne P,maindoeuvre MO,intervenant II\n" +
                         "where MA.`Id_Materiel`=A.`Id_Materiel`\n" +
                         "AND I.`Id_Intervention`=A.`Id_Intervention`\n" +
                         "AND P.`Id_panne`=A.`Id_panne`\n" +
                         "AND MO.`Id_MO`=A.`Id_MO`\n" +
                         "AND II.`Id_Intervenant`=A.`Id_Intervenant`\n" +
                         "AND A.N_BL=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"' )\n" +
                         "AND A.Id_Intervention=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"' )\n" +
                         "AND A.Id_panne=(select Id_panne from panne where type='"+ComboPanne.getSelectedItem()+"') AND A.Etat='Non Réparé'";
             stm=maConnexion.get_connexion().createStatement();
             rs=stm.executeQuery(sql);
             if(rs.first())
                {
                  int nb = rs.getInt("nbr_nn");
                  String n=String.valueOf(nb);
                  nb_nn.setText(n);}
                }
       catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
         
          String T=total.getText();
       try{
             // dt.setRowCount(0);
              String sql="select count(A.N_Serie) as nbr\n" +
                          "from appareil A,materiel MA,intervention I,panne P,maindoeuvre MO,intervenant II\n" +
                          "where MA.`Id_Materiel`=A.`Id_Materiel`\n" +
                          "AND I.`Id_Intervention`=A.`Id_Intervention`\n" +
                          "AND P.`Id_panne`=A.`Id_panne`\n" +
                          "AND MO.`Id_MO`=A.`Id_MO`\n" +
                          "AND II.`Id_Intervenant`=A.`Id_Intervenant`\n" +
                          "AND A.N_BL=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"' )\n" +
                          "AND A.Id_Intervention=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"' )\n" +
                          "AND A.Id_panne=(select Id_panne from panne where type='"+ComboPanne.getSelectedItem()+"')";
             stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
               if(rs.first())
                {
             int nb = rs.getInt("nbr");
              String n=String.valueOf(nb);
              total.setText(n);}
                 }
        catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }

}

//////////////**********************************************//////////////////////////////////



///////////////////////********************************//////////////////////////////////////////////////

    
    public JFrameRechercherParCritère() {
        initComponents();
        Remplir_ComboIntervention();
        ComboApp.setEnabled(true);
        ComboPanne.setEnabled(true);
        
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
        nb_rep = new javax.swing.JTextField();
        nb_nn = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ComboIntervention = new javax.swing.JComboBox();
        ComboApp = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        ComboPanne = new javax.swing.JComboBox();
        type_app = new javax.swing.JRadioButton();
        type_pan = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableProd = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Récapitulatif    Du   Jour");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 102));
        jLabel3.setText("Nombre d'Appareils Réparés  :");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Nombre d'Appareil Non Réparés   :");

        nb_rep.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        nb_rep.setForeground(new java.awt.Color(0, 204, 102));

        nb_nn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        nb_nn.setForeground(new java.awt.Color(255, 0, 0));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Total  :");

        total.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Type Intervention :");

        ComboIntervention.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ComboIntervention.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboInterventionActionPerformed(evt);
            }
        });

        ComboApp.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setText("Chercher");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        ComboPanne.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        type_app.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        type_app.setText("Type Appareil :");
        type_app.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type_appActionPerformed(evt);
            }
        });

        type_pan.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        type_pan.setText("Type Panne :");
        type_pan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type_panActionPerformed(evt);
            }
        });

        TableProd.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
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
        jScrollPane2.setViewportView(TableProd);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nb_rep, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nb_nn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(8, 8, 8)
                        .addComponent(ComboIntervention, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(type_pan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(27, 27, 27)
                                .addComponent(ComboPanne, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(type_app, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(ComboApp, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(83, 83, 83)
                        .addComponent(jButton2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboIntervention, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(type_app))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(6, 6, 6)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboPanne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(type_pan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nb_rep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nb_nn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(883, 715));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ComboInterventionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboInterventionActionPerformed
        if(ComboIntervention.getSelectedItem().equals("Tous"))
         {
             
         }
        else 
        {
            
             
        }
    }//GEN-LAST:event_ComboInterventionActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      if(type_app.isSelected()==true && type_pan.isSelected()==false)
        {
          Fonction_Interv_App();  
        }  
      else if(type_app.isSelected()==false && type_pan.isSelected()==true)
        {
         Fonction_Interv_Panne();  
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void type_appActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type_appActionPerformed
      
      if(type_app.isSelected()==true)
      {
        ComboApp.setEnabled(true);
        Remplir_ComboAppareil();
        type_pan.setEnabled(false);
        ComboPanne.setEnabled(false);
      }
      else if(type_app.isSelected()==false)
      {
        ComboPanne.setEnabled(false);  
        Remplir_ComboPanne();  
        type_pan.setEnabled(true);
        ComboApp.setEnabled(false);
      }
    }//GEN-LAST:event_type_appActionPerformed

    private void type_panActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type_panActionPerformed
        if(type_pan.isSelected()==true)
      {
        ComboPanne.setEnabled(true);
        Remplir_ComboPanne();
        type_app.setEnabled(false);
        ComboApp.setEnabled(false);
      }
      else if(type_pan.isSelected()==false)
      {
        ComboApp.setEnabled(false);
        Remplir_ComboAppareil();  
        type_app.setEnabled(true);
        ComboPanne.setEnabled(false);
      }
    }//GEN-LAST:event_type_panActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameRechercherParCritère.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameRechercherParCritère.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameRechercherParCritère.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameRechercherParCritère.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameRechercherParCritère().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboApp;
    private javax.swing.JComboBox ComboIntervention;
    private javax.swing.JComboBox ComboPanne;
    private javax.swing.JTable TableProd;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nb_nn;
    private javax.swing.JTextField nb_rep;
    private javax.swing.JTextField total;
    private javax.swing.JRadioButton type_app;
    private javax.swing.JRadioButton type_pan;
    // End of variables declaration//GEN-END:variables
}
