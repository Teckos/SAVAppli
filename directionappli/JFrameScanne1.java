package directionappli;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import directionappli.connexion;
/**
 *
 * @author khaoula
 */
public class JFrameScanne1 extends javax.swing.JFrame {
      Statement stm;
      ResultSet rs;
    connexion maConnexion= new connexion();
    
    

public void Date_courante()
{
    Calendar cal = new GregorianCalendar();
    SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
    int annee = cal.get(Calendar.YEAR);
    int mois=cal.get(Calendar.MONTH); 
    int jour=cal.get(Calendar.DAY_OF_MONTH);
    date_r.setText(date_format.format(cal.getTime()));
           
}

  private void Remplir_ComboType(){
      ComboType.removeAllItems();
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
       ComboNom.removeAllItems();
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
        ComboCouleur.removeAllItems();
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
     private void Remplir_ComboPanneRéparé(){
         ComboPanne.removeAllItems();
          try{
              String sql="select distinct(type) from panne where Etat='Réparé'";
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
         private void Remplir_ComboPanneNonRéparé(){
             ComboPanne.removeAllItems();
          try{
              String sql="select distinct(type) from panne where Etat='Non Réparé'";
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
     
     private void Remplir_ComboMO(){
         ComboMO.removeAllItems();
          try{
              String sql="select distinct(Type_MO) from maindoeuvre where Id_MO!=1";
              stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
               while(rs.next())
                {
                  String name=rs.getString("Type_MO");
                  ComboMO.addItem(name);
                  }
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
    }
     
     private void Récupérer_Date(){
          try{
              String D_R = date_r.getText();
                String sql= "select min(Id_Materiel) as id from materiel M\n" +
                "where Nom='"+ComboNom.getSelectedItem()+"'\n" +
                "AND Type_Mat='"+ComboType.getSelectedItem()+"'\n" +
                "AND Couleur = '"+ComboCouleur.getSelectedItem()+"' \n" +
                "AND NOT EXISTS ( SELECT N_Serie FROM appareil A where M.Id_Materiel=A.`Id_Materiel`)" ;
              
              stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
              rs.first();
              
                 String id=rs.getString("id");
                  String requete= "UPDATE materiel SET Date_Utilisation= '"+D_R+"' WHERE Id_Materiel='id' ";
                   try{
                       stm=maConnexion.get_connexion().createStatement();
                       // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
                        stm.executeUpdate(requete); 
           
                         JOptionPane.showMessageDialog(null,"requête exécutée avec succés");
         
                      }
                      catch(SQLException e){
                       System.err.println(e);
                      JOptionPane.showMessageDialog(null,e);     
                      }
                
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
    }
     
     
     
     
    /**
     * Creates new form JFrameScanne
     */
    public JFrameScanne1() {
        initComponents();
        Date_courante();
       // Remplir_ComboType();
       // Remplir_ComboNom();
      //  Remplir_ComboCouleur();
        //Remplir_ComboPanne();
        //Remplir_ComboMO();
             ComboMO.setEnabled(false);
             jLabel12.setEnabled(false);
             CheckMO.setEnabled(false);
             CheckMU.setEnabled(false);
             ComboCouleur.setEnabled(false);
             ComboNom.setEnabled(false);
             ComboType.setEnabled(false);
             jLabel14.setEnabled(false);
             jLabel10.setEnabled(false);
             jLabel15.setEnabled(false);
        
        
        
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
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        n_serie = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        n_dossier = new javax.swing.JTextField();
        Combo_ty = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        date_r = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        date_s = new javax.swing.JTextField();
        date_e = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        desc = new javax.swing.JTextArea();
        ComboEtat = new javax.swing.JComboBox();
        ComboPanne = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        ComboType = new javax.swing.JComboBox();
        ComboNom = new javax.swing.JComboBox();
        ComboCouleur = new javax.swing.JComboBox();
        CheckMU = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        n_utili = new javax.swing.JPasswordField();
        jPanel7 = new javax.swing.JPanel();
        CheckMO = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        ComboMO = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Appareils de Contrat-Réparation");

        jToggleButton1.setText("Valider");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("information Appareil"));

        jLabel4.setText("N° de série :");

        n_serie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_serieActionPerformed(evt);
            }
        });

        jLabel3.setText("Type d'appareil :");

        jLabel5.setText("N° dossier :");

        n_dossier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_dossierActionPerformed(evt);
            }
        });

        Combo_ty.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Téléphone", "Tablette" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Combo_ty, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(n_serie, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(n_dossier, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(n_serie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(n_dossier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Combo_ty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Dates associées"));

        jLabel6.setText("Date d'entrée :");

        jLabel7.setText("Date de sortie :");

        date_r.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                date_rActionPerformed(evt);
            }
        });

        jLabel13.setText("Date de réparation :");

        date_s.setText("0000-00-00");
        date_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                date_sActionPerformed(evt);
            }
        });

        date_e.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date_e, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(date_r, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(date_s, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date_e, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date_r, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(date_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Intervention"));

        jLabel8.setText("Type de panne :");

        jLabel9.setText("Etat d'appareil :");

        jLabel11.setText("Description :");

        desc.setColumns(20);
        desc.setLineWrap(true);
        desc.setRows(5);
        jScrollPane1.setViewportView(desc);

        ComboEtat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Réparé", "Non Réparé" }));
        ComboEtat.setSelectedIndex(-1);
        ComboEtat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ComboEtat.setFocusTraversalPolicyProvider(true);
        ComboEtat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboEtatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ComboEtat, javax.swing.GroupLayout.Alignment.TRAILING, 0, 132, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(ComboPanne, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboEtat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboPanne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel10.setText("Nom :");

        jLabel14.setText("Type :");

        jLabel15.setText("Couleur :");

        ComboNom.setToolTipText("");
        ComboNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboNomActionPerformed(evt);
            }
        });

        CheckMU.setText("Matériel Utilisé  :");
        CheckMU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckMUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ComboNom, javax.swing.GroupLayout.Alignment.TRAILING, 0, 125, Short.MAX_VALUE)
                    .addComponent(ComboType, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboCouleur, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(CheckMU, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(CheckMU)
                .addGap(7, 7, 7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboCouleur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText("Utilisateur :");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(n_utili, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(n_utili, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        CheckMO.setText("Main d'Oeuvre  :");
        CheckMO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckMOActionPerformed(evt);
            }
        });

        jLabel12.setText("Type :");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(ComboMO, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(CheckMO)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(CheckMO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(ComboMO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 41, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(747, 610));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void n_serieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_serieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n_serieActionPerformed

    private void n_dossierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_dossierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n_dossierActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        String U = n_utili.getText();
         String N_S = n_serie.getText();
         //String T_A = type_app.getText();
         String N_D = n_dossier.getText();
         String D_E = ((JTextField)date_e.getDateEditor().getUiComponent()).getText();
         String D_R = date_r.getText();
         String D_S = date_s.getText();
         
         //String T_P = type_pa.getText();
         //String E = etat_app.getText();
         String D = desc.getText();
        // String N = nom_mat.getText();
        // String T_M = type_mat.getText();
        // String C = coul.getText();
        //la requête
         if(ComboEtat.getSelectedItem().equals("Réparé"))
         {
             //le cas ou on a utilisé du matériel plus la main d'oeuvre
             if(CheckMO.isSelected()==true && CheckMU.isSelected()==true)
             {
        String requete="INSERT INTO appareil(N_Serie,Date_E,Date_R,Date_S,N_Dossier,Type_App,Etat,Description,Id_Intervention,Id_Intervenant,Id_panne,Id_Materiel,Id_MO,N_BL)\n"+
                "VALUES ('"+N_S+"','"+D_E+"','"+D_R+"','"+D_S+"','"+N_D+"','"+Combo_ty.getSelectedItem()+"','"+ComboEtat.getSelectedItem()+"','"+D+"', \n"+
                "1,'"+U+"',\n"+
                "(select Id_panne from panne where type='"+ComboPanne.getSelectedItem()+"'),(select MIN(Id_Materiel) from materiel M\n" +
                
                "where Nom='"+ComboNom.getSelectedItem()+"'\n" +
                "AND Type_Mat='"+ComboType.getSelectedItem()+"'\n" +
                "AND Couleur = '"+ComboCouleur.getSelectedItem()+"' \n" +
                "AND Etat != 'Défectueux' AND Etat != 'Utilisé' ),(select Id_MO from maindoeuvre where Type_MO='"+ComboMO.getSelectedItem()+"'),1) " ;
        //Exécuter la requête
             

       try{
         stm=maConnexion.get_connexion().createStatement();
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
        stm.executeUpdate(requete); 
         Date_courante();
         JOptionPane.showMessageDialog(null,"requête exécutée avec succés");
         
       }
       catch(SQLException e){
           System.err.println(e);
           JOptionPane.showMessageDialog(null,e);
                   
       }
        try{
              
                String sql= "select min(Id_Materiel) as id from materiel M\n" +
                "where Nom='"+ComboNom.getSelectedItem()+"'\n" +
                "AND Type_Mat='"+ComboType.getSelectedItem()+"'\n" +
                "AND Couleur = '"+ComboCouleur.getSelectedItem()+"' \n" +
                "AND Etat != 'Défectueux' AND Etat != 'Utilisé'" ;
              
              stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
              rs.first();
               System.out.println(""+rs.getString("id")+"");
              
                  //String id_i=rs.getString("id");
                  String requete1= "UPDATE materiel SET Date_Utilisation= '"+D_R+"' WHERE Id_Materiel='"+rs.getString("id")+"' ";
                  String requete2= "UPDATE materiel SET Etat= 'Utilisé' WHERE Id_Materiel='"+rs.getString("id")+"' ";
                   try{
                       stm=maConnexion.get_connexion().createStatement();
                       // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
                        stm.executeUpdate(requete1); 
                        stm.executeUpdate(requete2); 
           
                         JOptionPane.showMessageDialog(null,"la date d'utilisation et l'état du matériel a été modifié");
         
                      }
                      catch(SQLException e){
                       System.err.println(e);
                      JOptionPane.showMessageDialog(null,e);     
                      }
                
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
             }//fermeture du if de if(CheckMO.isSelected() && CheckMU.isSelected())
             
           //Le cas ou on n'a utilisé que du matériel  
             else if(CheckMO.isSelected()==false && CheckMU.isSelected()==true)
             {
        String requete="INSERT INTO appareil(N_Serie,Date_E,Date_R,Date_S,N_Dossier,Type_App,Etat,Description,Id_Intervention,Id_Intervenant,Id_panne,Id_Materiel,Id_MO,N_BL)\n"+
                "VALUES ('"+N_S+"','"+D_E+"','"+D_R+"','"+D_S+"','"+N_D+"','"+Combo_ty.getSelectedItem()+"','"+ComboEtat.getSelectedItem()+"','"+D+"', \n"+
                "1,'"+U+"',\n"+
                "(select Id_panne from panne where type='"+ComboPanne.getSelectedItem()+"'),(select MIN(Id_Materiel) from materiel M\n" +
                
                "where Nom='"+ComboNom.getSelectedItem()+"'\n" +
                "AND Type_Mat='"+ComboType.getSelectedItem()+"'\n" +
                "AND Couleur = '"+ComboCouleur.getSelectedItem()+"' \n" +
                "AND Etat != 'Défectueux' AND Etat != 'Utilisé' ),1,1) " ;
        //Exécuter la requête
             

       try{
         stm=maConnexion.get_connexion().createStatement();
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
        stm.executeUpdate(requete); 
         Date_courante();
         JOptionPane.showMessageDialog(null,"requête exécutée avec succés");
         
       }
       catch(SQLException e){
           System.err.println(e);
           JOptionPane.showMessageDialog(null,e);
                   
       }
        try{
              
                String sql= "select min(Id_Materiel) as id from materiel M\n" +
                "where Nom='"+ComboNom.getSelectedItem()+"'\n" +
                "AND Type_Mat='"+ComboType.getSelectedItem()+"'\n" +
                "AND Couleur = '"+ComboCouleur.getSelectedItem()+"' \n" +
                "AND Etat != 'Défectueux' AND Etat != 'Utilisé'" ;
              
              stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
              rs.first();
               System.out.println(""+rs.getString("id")+"");
              
                  //String id_i=rs.getString("id");
                  String requete1= "UPDATE materiel SET Date_Utilisation= '"+D_R+"' WHERE Id_Materiel='"+rs.getString("id")+"' ";
                  String requete2= "UPDATE materiel SET Etat= 'Utilisé' WHERE Id_Materiel='"+rs.getString("id")+"' ";
                   try{
                       stm=maConnexion.get_connexion().createStatement();
                       // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
                        stm.executeUpdate(requete1); 
                        stm.executeUpdate(requete2); 
           
                         JOptionPane.showMessageDialog(null,"la date d'utilisation et l'état du matériel a été modifié");
         
                      }
                      catch(SQLException e){
                       System.err.println(e);
                      JOptionPane.showMessageDialog(null,e);     
                      }
                
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
             }//fermeture du if de if(CheckMO.isSelected() && CheckMU.isSelected())  
          //Le cas ou on n a utilisé que de la main d'eouvre    
             else if(CheckMO.isSelected()==true && CheckMU.isSelected()==false)
             {
        String requete="INSERT INTO appareil(N_Serie,Date_E,Date_R,Date_S,N_Dossier,Type_App,Etat,Description,Id_Intervention,Id_Intervenant,Id_panne,Id_Materiel,Id_MO,N_BL)\n"+
                "VALUES ('"+N_S+"','"+D_E+"','"+D_R+"','"+D_S+"','"+N_D+"','"+Combo_ty.getSelectedItem()+"','"+ComboEtat.getSelectedItem()+"','"+D+"', \n"+
                "1,'"+U+"',\n"+
                "(select Id_panne from panne where type='"+ComboPanne.getSelectedItem()+"'),1,(select Id_MO from maindoeuvre where Type_MO='"+ComboMO.getSelectedItem()+"'),1) " ;
        //Exécuter la requête
             

       try{
         stm=maConnexion.get_connexion().createStatement();
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
        stm.executeUpdate(requete); 
         Date_courante();
         JOptionPane.showMessageDialog(null,"requête exécutée avec succés");
         
       }
       catch(SQLException e){
           System.err.println(e);
           JOptionPane.showMessageDialog(null,e);
                   
       }
             }//fermeture du if de if(CheckMO.isSelected() && CheckMU.isSelected())
         
        
      
             
         }
         else if(ComboEtat.getSelectedItem().equals("Non Réparé"))
         {
             String requete="INSERT INTO appareil(N_Serie,Date_E,Date_R,Date_S,N_Dossier,Type_App,Etat,Description,Id_Intervention,Id_Intervenant,Id_panne,Id_Materiel,Id_MO,N_BL)\n"+
                "VALUES ('"+N_S+"','"+D_E+"','"+D_R+"','"+D_S+"','"+N_D+"','"+Combo_ty.getSelectedItem()+"','"+ComboEtat.getSelectedItem()+"','"+D+"', \n"+
                "1,'"+U+"',\n"+
                "(select Id_panne from panne where type='"+ComboPanne.getSelectedItem()+"'),1,1,1) " ;
        //Exécuter la requête
       try{
         stm=maConnexion.get_connexion().createStatement();
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
        stm.executeUpdate(requete); 
         Date_courante();
         JOptionPane.showMessageDialog(null,"requête exécutée avec succés");
         
       }
       catch(SQLException e){
           System.err.println(e);
           JOptionPane.showMessageDialog(null,e);     
       }
         }
        
          
          n_utili.setText("");
         n_serie.setText("");
         //type_app.setText("telephone");
         n_dossier.setText("");
        // date_e.setText("");
         ((JTextField)date_e.getDateEditor().getUiComponent()).setText("");
         Date_courante();
         //date_r.setText("annee+\"-\"+(mois+1)+\"-\"+jour");
        // date_s.setText("0000-00-00");
        // type_inter.setText("Réparation");
         //type_pa.setText("");
         //etat_app.setText("");
         desc.setText("");
        // nom_mat.setText("Ecran");
         //type_mat.setText("");
         //coul.setText("Noir");
         CheckMO.setSelected(false);
         CheckMU.setSelected(false);
         
         
             ComboMO.setEnabled(false);
             jLabel12.setEnabled(false);
             CheckMO.setEnabled(true);
             CheckMU.setEnabled(true);
             ComboCouleur.setEnabled(false);
             ComboNom.setEnabled(false);
             ComboType.setEnabled(false);
             jLabel14.setEnabled(false);
             jLabel10.setEnabled(false);
             jLabel15.setEnabled(false);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void date_rActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_date_rActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_date_rActionPerformed

    private void date_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_date_sActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_date_sActionPerformed

    private void CheckMOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckMOActionPerformed
       if(CheckMO.isSelected()==true)
       {
             ComboMO.setEnabled(true);
             jLabel12.setEnabled(true);
           Remplir_ComboMO();
       }
       /*else if(CheckMO.isSelected()==false)
       {
          ComboMO.setEnabled(false);
       
       }*/
    }//GEN-LAST:event_CheckMOActionPerformed

    private void ComboNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboNomActionPerformed

    private void CheckMUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckMUActionPerformed
        if(CheckMU.isSelected()==true)
       {
           
             ComboCouleur.setEnabled(true);
             ComboNom.setEnabled(true);
             ComboType.setEnabled(true);
             jLabel14.setEnabled(true);
             jLabel10.setEnabled(true);
             jLabel15.setEnabled(true);
           Remplir_ComboNom();
           Remplir_ComboType();
           Remplir_ComboCouleur();
       }
    }//GEN-LAST:event_CheckMUActionPerformed

    private void ComboEtatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboEtatActionPerformed
       if(ComboEtat.getSelectedItem().equals("Réparé"))
         {
             Remplir_ComboPanneRéparé();
             ComboEtat.setBackground(Color.GREEN);
             //ComboEtat.setBackground(Color.RED);
            // ComboMO.setEnabled(true);
             //jLabel12.setEnabled(true);
             CheckMO.setEnabled(true);
             CheckMU.setEnabled(true);
             //ComboCouleur.setEnabled(true);
            // ComboNom.setEnabled(true);
             //ComboType.setEnabled(true);
            // jLabel14.setEnabled(true);
            // jLabel10.setEnabled(true);
             //jLabel15.setEnabled(true);
         }
        else if(ComboEtat.getSelectedItem().equals("Non Réparé"))
        {
             Remplir_ComboPanneNonRéparé();
            ComboEtat.setBackground(Color.RED);
            /* ComboMO.setEnabled(false);
             jLabel12.setEnabled(false);
             CheckMO.setEnabled(false);
             CheckMU.setEnabled(false);
             ComboCouleur.setEnabled(false);
             ComboNom.setEnabled(false);
             ComboType.setEnabled(false);
             jLabel14.setEnabled(false);
             jLabel10.setEnabled(false);
             jLabel15.setEnabled(false);*/
             
             
        }
    }//GEN-LAST:event_ComboEtatActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameScanne1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameScanne1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameScanne1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameScanne1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameScanne1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckMO;
    private javax.swing.JCheckBox CheckMU;
    private javax.swing.JComboBox ComboCouleur;
    private javax.swing.JComboBox ComboEtat;
    private javax.swing.JComboBox ComboMO;
    private javax.swing.JComboBox ComboNom;
    private javax.swing.JComboBox ComboPanne;
    private javax.swing.JComboBox ComboType;
    private javax.swing.JComboBox Combo_ty;
    private com.toedter.calendar.JDateChooser date_e;
    private javax.swing.JTextField date_r;
    private javax.swing.JTextField date_s;
    private javax.swing.JTextArea desc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField n_dossier;
    private javax.swing.JTextField n_serie;
    private javax.swing.JPasswordField n_utili;
    // End of variables declaration//GEN-END:variables
}
