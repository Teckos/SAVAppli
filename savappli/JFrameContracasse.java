package savappli;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static savappli.JFrameScanne.newPolicy;
import savappli.connexion;
/**
 *
 * @author khaoula
 */
public class JFrameContracasse extends javax.swing.JFrame {
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
    //date_r.setText(date_format.format(cal.getTime()));
    //date_e.setText(date_format.format(cal.getTime()));
           
}

public void Date_Hier()
{
Calendar cal = new GregorianCalendar();
    SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
    int annee = cal.get(Calendar.YEAR);
    int mois=cal.get(Calendar.MONTH); 
   // cal.set(Calendar.ad,-1);
    cal.add(Calendar.DAY_OF_MONTH, -1);
    // jour=cal.get(Calendar.DAY_OF_MONTH);
    //String D=annee+"-"+(mois+1)+"-"+(jour-1);
   
    //date_e.setText(date_format.format(cal.getTime()));
}
public void Date_Lundi()
{
Calendar cal = new GregorianCalendar();
    SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
    int annee = cal.get(Calendar.YEAR);
    int mois=cal.get(Calendar.MONTH); 
   // cal.set(Calendar.ad,-1);
    cal.add(Calendar.DAY_OF_MONTH, -3);
    // jour=cal.get(Calendar.DAY_OF_MONTH);
    //String D=annee+"-"+(mois+1)+"-"+(jour-1);
   
    //date_e.setText(date_format.format(cal.getTime()));
}

  private void Remplir_ComboTypeTel(){
      ComboType.removeAllItems();
          try{
              String sql="select distinct(Type_Mat) from materiel where Id_Materiel!=1 AND Type_App='T??l??phone'";
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
  private void Remplir_ComboTypeTab(){
      ComboType.removeAllItems();
          try{
              String sql="select distinct(Type_Mat) from materiel where Id_Materiel!=1 AND Type_App='Tablette'";
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
  
   private void Remplir_ComboNomTel(){
       ComboNom.removeAllItems();
          try{
              String sql="select distinct(Nom) from materiel where Id_Materiel!=1 AND Type_App='T??l??phone'";
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
   
   private void Remplir_ComboNomTab(){
       ComboNom.removeAllItems();
          try{
              String sql="select distinct(Nom) from materiel where Id_Materiel!=1 AND Type_App='Tablette'";
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
   
    private void Remplir_ComboCouleurTel(){
        ComboCouleur.removeAllItems();
          try{
              String sql="select distinct(Couleur) from materiel where Id_Materiel!=1 AND Type_App='T??l??phone'";
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
    
     private void Remplir_ComboCouleurTab(){
        ComboCouleur.removeAllItems();
          try{
              String sql="select distinct(Couleur) from materiel where Id_Materiel!=1 AND Type_App='Tablette'";
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
     private void Remplir_ComboPanneR??par??(){
         ComboPanne.removeAllItems();
          try{
              String sql="select distinct(type) from panne where Etat='R??par??'";
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
         private void Remplir_ComboPanneNonR??par??(){
             ComboPanne.removeAllItems();
          try{
              String sql="select distinct(type) from panne where Etat='Non R??par??'";
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
     
     private void Remplir_ComboMOTel(){
         ComboMO.removeAllItems();
          try{
              String sql="select distinct(Type_MO) from maindoeuvre where Id_MO!=1 AND Type_App='T??l??phone'";
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
     
     private void Remplir_ComboMOTab(){
         ComboMO.removeAllItems();
          try{
              String sql="select distinct(Type_MO) from maindoeuvre where Id_MO!=1 AND Type_App='Tablette'";
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
     
     
     
     private void Remplir_ComboIntervention(){
         ComboIntervention.removeAllItems();
          try{
              String sql="select distinct(type_In) from intervention where Id_Intervention!=1";
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
     
      private void Initialiser()
     {
      n_utili.setText("");
          n_utili.requestFocusInWindow();
         n_serie.setText("");
         //type_app.setText("telephone");
         n_dossier.setText("");
        // date_e.setText("");
         ((JTextField)date_e.getDateEditor().getUiComponent()).setText("");
         Date_courante();
         //date_r.setText("annee+\"-\"+(mois+1)+\"-\"+jour");
        // date_s.setText("0000-00-00");
        // type_inter.setText("R??paration");
         //type_pa.setText("");
         //etat_app.setText("");
         desc.setText("");
        // nom_mat.setText("Ecran");
         //type_mat.setText("");
         //coul.setText("Noir");
         if(ComboEtat.getSelectedItem().equals("R??par??"))
         {
             Remplir_ComboPanneR??par??();
             ComboEtat.setBackground(Color.GREEN);
             //ComboEtat.setBackground(Color.RED);
            // ComboMO.setEnabled(true);
             //jLabel12.setEnabled(true);
             CheckMO.setEnabled(true);
             CheckMU.setEnabled(true);
             CheckMU.setSelected(false);
             CheckMO.setSelected(false);
             ComboCouleur.setEnabled(false);
             ComboNom.setEnabled(false);
             ComboType.setEnabled(false);
             ComboMO.setEnabled(false);
            jLabel14.setEnabled(false);
            jLabel10.setEnabled(false);
             jLabel15.setEnabled(false);
             jLabel12.setEnabled(false);
             
         }
        else if(ComboEtat.getSelectedItem().equals("Non R??par??"))
        {
             Remplir_ComboPanneNonR??par??();
            ComboEtat.setBackground(Color.RED);
            //CheckMU.isSelected(false);
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
             
             if(Combo_ty.getSelectedItem().equals("T??l??phone"))
         {
             Remplir_ComboNomTel();
             Remplir_ComboTypeTel();
             Remplir_ComboCouleurTel();
             Remplir_ComboMOTel();
         }
        else if(Combo_ty.getSelectedItem().equals("Tablette"))
        {
             Remplir_ComboNomTab();
             Remplir_ComboTypeTab();
             Remplir_ComboCouleurTab();
             Remplir_ComboMOTab();
        }
     }
     
     
    /**
     * Creates new form JFrameScanne
     */
    public JFrameContracasse() {
        initComponents();
         
       Date_courante();
       Remplir_ComboIntervention();
        
       // Remplir_ComboType();
       // Remplir_ComboNom();
      //  Remplir_ComboCouleur();
        //Remplir_ComboPanne();
        //Remplir_ComboMO();
       
             Remplir_ComboNomTel();
             Remplir_ComboTypeTel();
             Remplir_ComboCouleurTel();
             Remplir_ComboMOTel();
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
              if(Combo_ty.getSelectedItem().equals("T??l??phone"))
         {
             ImageIcon icone =  new ImageIcon("C:\\SAVappli\\src\\savappli\\port.jpg");
 
             lab.setIcon(icone);
             Remplir_ComboNomTel();
             Remplir_ComboTypeTel();
             Remplir_ComboCouleurTel();
             Remplir_ComboMOTel();
         }
        else if(Combo_ty.getSelectedItem().equals("Tablette"))
        {
            ImageIcon icone =  new ImageIcon("C:\\SAVappli\\src\\savappli\\tabl.jpg");
 
             lab.setIcon(icone);
             Remplir_ComboNomTab();
             Remplir_ComboTypeTab();
             Remplir_ComboCouleurTab();
             Remplir_ComboMOTab();
        }
        
        
        
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
        jToggleButton1 = new javax.swing.JToggleButton();
        pan2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        n_serie = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        n_dossier = new javax.swing.JTextField();
        Combo_ty = new javax.swing.JComboBox();
        lab = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        date_e = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        desc = new javax.swing.JTextArea();
        ComboEtat = new javax.swing.JComboBox();
        ComboPanne = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        ComboIntervention = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        ComboType = new javax.swing.JComboBox();
        ComboNom = new javax.swing.JComboBox();
        ComboCouleur = new javax.swing.JComboBox();
        CheckMU = new javax.swing.JCheckBox();
        pan1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        n_utili = new javax.swing.JPasswordField();
        jPanel7 = new javax.swing.JPanel();
        CheckMO = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        ComboMO = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jToggleButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jToggleButton1.setText("Valider");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        pan2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "information Appareil", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("N?? de s??rie :");

        n_serie.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        n_serie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_serieActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Type d'appareil :");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("N?? dossier :");

        n_dossier.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        n_dossier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_dossierActionPerformed(evt);
            }
        });

        Combo_ty.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Combo_ty.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tablette", "T??l??phone" }));
        Combo_ty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_tyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pan2Layout = new javax.swing.GroupLayout(pan2);
        pan2.setLayout(pan2Layout);
        pan2Layout.setHorizontalGroup(
            pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Combo_ty, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pan2Layout.createSequentialGroup()
                        .addGroup(pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pan2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)))
                        .addGap(11, 11, 11)
                        .addGroup(pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(n_dossier, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(n_serie))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lab, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pan2Layout.setVerticalGroup(
            pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan2Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(n_serie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(n_dossier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Combo_ty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lab, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dates associ??es", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Date d'entr??e :");

        date_e.setDateFormatString("yyyy-MM-dd");
        date_e.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(date_e, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(date_e, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Intervention", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 153, 153))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Type de panne :");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Etat d'appareil :");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Description :");

        desc.setColumns(20);
        desc.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        desc.setLineWrap(true);
        desc.setRows(5);
        desc.setWrapStyleWord(true);
        desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                descKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(desc);

        ComboEtat.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ComboEtat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "R??par??", "Non R??par??" }));
        ComboEtat.setSelectedIndex(-1);
        ComboEtat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ComboEtat.setFocusTraversalPolicyProvider(true);
        ComboEtat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboEtatActionPerformed(evt);
            }
        });

        ComboPanne.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("Type Intervention :");

        ComboIntervention.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ComboEtat, 0, 141, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addComponent(ComboIntervention, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(ComboPanne, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(ComboIntervention, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboEtat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(ComboPanne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1)))
                .addGap(19, 19, 19))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Nom :");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("Type :");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("Couleur :");

        ComboType.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        ComboNom.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ComboNom.setToolTipText("");
        ComboNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboNomActionPerformed(evt);
            }
        });

        ComboCouleur.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        CheckMU.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        CheckMU.setText("Mat??riel Utilis??  :");
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
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ComboType, javax.swing.GroupLayout.Alignment.LEADING, 0, 124, Short.MAX_VALUE)
                    .addComponent(ComboNom, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboCouleur, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(CheckMU, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 77, Short.MAX_VALUE))
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
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pan1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Utilisateur :");

        n_utili.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        n_utili.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        n_utili.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_utiliActionPerformed(evt);
            }
        });
        n_utili.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                n_utiliFocusGained(evt);
            }
        });
        n_utili.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                n_utiliAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        n_utili.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                n_utiliKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pan1Layout = new javax.swing.GroupLayout(pan1);
        pan1.setLayout(pan1Layout);
        pan1Layout.setHorizontalGroup(
            pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(n_utili, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        pan1Layout.setVerticalGroup(
            pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pan1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(n_utili, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        CheckMO.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        CheckMO.setText("Main d'Oeuvre  :");
        CheckMO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckMOActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Type :");

        ComboMO.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(CheckMO)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(ComboMO, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(CheckMO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addGap(30, 30, 30)
                .addComponent(ComboMO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Appareils de Contrat-Casse et Autres Interventions");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(364, 364, 364)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(pan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(36, 36, 36)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 48, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1004, 712));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void n_serieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_serieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n_serieActionPerformed

    private void n_dossierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_dossierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n_dossierActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
    Calendar cal = new GregorianCalendar();
    SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd"); 
    SimpleDateFormat heure_format = new SimpleDateFormat("HH:mm:ss");     
        String U = n_utili.getText();
         String N_S = n_serie.getText();
         //String T_A = type_app.getText();
         String N_D = n_dossier.getText();
        // String D_E = ((JTextField)date_e.getDateEditor().getUiComponent()).getText();
         //String D_E = date_e.getText();
         String D_E = ((JTextField)date_e.getDateEditor().getUiComponent()).getText();
         String D_R = date_format.format(cal.getTime());
         String H_R = heure_format.format(cal.getTime());
         String D_S = "0000-00-00";
         
         //String T_P = type_pa.getText();
         //String E = etat_app.getText();
         //String D = desc.getText();
         String D = desc.getText().replaceAll("\n", " ");
         //String C = (String) ComboCouleur.getSelectedItem();
        // String N = nom_mat.getText();
        // String T_M = type_mat.getText();
        // String C = coul.getText();
        //la requ??te
         
         //JFrameScanne f= new JFrameScanne();
         //f.setVisible(true);
        //n_utili.setText("U");

         if(ComboEtat.getSelectedItem().equals("R??par??"))
         {
             //le cas ou on a utilis?? du mat??riel plus la main d'oeuvre
             if(CheckMO.isSelected()==true && CheckMU.isSelected()==true)
             {
        String requete="INSERT INTO appareil(N_Serie,Date_E,Date_R,Heure_R,Date_S,N_Dossier,Type_App,Etat,Description,Id_Intervention,Id_Intervenant,Id_panne,Id_Materiel,Id_MO,N_BL)\n"+
                "VALUES ('"+N_S+"','"+D_E+"','"+D_R+"','"+H_R+"','"+D_S+"','"+N_D+"','"+Combo_ty.getSelectedItem()+"','"+ComboEtat.getSelectedItem()+"','"+D+"', \n"+
                "(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"'),'"+U+"',\n"+
                "(select Id_panne from panne where type='"+ComboPanne.getSelectedItem()+"'),(select MIN(Id_Materiel) from materiel M\n" +
                
                "where Nom='"+ComboNom.getSelectedItem()+"'\n" +
                "AND Type_Mat='"+ComboType.getSelectedItem()+"'\n" +
                "AND Couleur = '"+ComboCouleur.getSelectedItem()+"' \n" +
                "AND Etat != 'D??fectueux' AND Etat != 'Utilis??' ),(select Id_MO from maindoeuvre where Type_MO='"+ComboMO.getSelectedItem()+"' AND Type_App='"+Combo_ty.getSelectedItem()+"'),(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"')) " ;
        //Ex??cuter la requ??te
         String sql= "select min(Id_Materiel) as id from materiel M\n" +
                "where Nom='"+ComboNom.getSelectedItem()+"'\n" +
                "AND Type_Mat='"+ComboType.getSelectedItem()+"'\n" +
                "AND Couleur = '"+ComboCouleur.getSelectedItem()+"' \n" +
                "AND Etat != 'D??fectueux' AND Etat != 'Utilis??'" ;
         
              JOptionPane optianpane=new JOptionPane();
          String msgB="<html><BODY><FONT size=4 face=Times New Roman >  N_Serie :   "+N_S+"</FONT><br>"
                + "<FONT size=4 face=Times New Roman > N_Dossier :   "+N_D+" </FONT> <br>"
                + "<FONT size=4 face=Times New Roman > Date_Entr??e :   "+D_E+"</FONT><br>"
                  
                + "<FONT size=4 face=Times New Roman > Intervention : </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+ComboIntervention.getSelectedItem()+"</b></FONT><br>"
                + "<FONT size=4 face=Times New Roman > Type Appareil : </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+Combo_ty.getSelectedItem()+"</b></FONT><br>"
                + "<FONT size=4 face=Times New Roman >Etat :   </FONT>"+"<FONT size=5 face=Times New Roman color=#00ff00><b>"+ComboEtat.getSelectedItem()+"</b></FONT><br>"
                + "<FONT size=4 face=Times New Roman >Panne :   </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+ComboPanne.getSelectedItem()+" </b></FONT><br><br><br>"
                
                + "<FONT size=4 face=Times New Roman > Description :   </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+D+"</b></FONT><br>"
                + "<FONT size=4 face=Times New Roman > Main d'Oeuvre :   </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+ComboMO.getSelectedItem()+" </b></FONT><br>"
                + "<FONT size=4 face=Times New Roman >Nom :   </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+ComboNom.getSelectedItem()+" </b></FONT><br>"
                + "<FONT size=4 face=Times New Roman >Type :   </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+ComboType.getSelectedItem()+" </b></FONT><br>"
                + "<FONT size=5 face=Times New Roman color=#FFFFFF ><b> _____________   </b><br></FONT>" 
                + "<FONT size=5 face=Times New Roman color=#FFFFFF ><b> Couleur :   "+ComboCouleur.getSelectedItem()+"</b><br></FONT>"
                + "<FONT size=5 face=Times New Roman color=#FFFFFF ><b> ??????????????????????????  </b><br></FONT>"
                  
                  + "<FONT size=4 face=Times New Roman color=#ff0000 ><b> Vous Voulez bien enregistrer ces informations ?<br></BODY> </html>";
          
          String msg="<html><BODY><FONT size=4 face=Times New Roman >  N_Serie :   "+N_S+"</FONT><br>"
                + "<FONT size=4 face=Times New Roman > N_Dossier :   "+N_D+" </FONT> <br>"
                + "<FONT size=4 face=Times New Roman > Date_Entr??e :   "+D_E+"</FONT><br>"
                  
                + "<FONT size=4 face=Times New Roman > Intervention : </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+ComboIntervention.getSelectedItem()+"</b></FONT><br>"
                + "<FONT size=4 face=Times New Roman > Type Appareil : </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+Combo_ty.getSelectedItem()+"</b></FONT><br>"
                + "<FONT size=4 face=Times New Roman >Etat :   </FONT>"+"<FONT size=5 face=Times New Roman color=#00ff00><b>"+ComboEtat.getSelectedItem()+"</b></FONT><br>"
                + "<FONT size=4 face=Times New Roman >Panne :   </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+ComboPanne.getSelectedItem()+" </b></FONT><br><br><br>"
                
                + "<FONT size=4 face=Times New Roman > Description :   </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+D+"</b></FONT><br>"
                + "<FONT size=4 face=Times New Roman > Main d'Oeuvre :   </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+ComboMO.getSelectedItem()+" </b></FONT><br>"
                + "<FONT size=4 face=Times New Roman >Nom :   </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+ComboNom.getSelectedItem()+" </b></FONT><br>"
                + "<FONT size=4 face=Times New Roman >Type :   </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+ComboType.getSelectedItem()+" </b></FONT><br>"
                + "<FONT size=5 face=Times New Roman ><b> ____________   </b><br></FONT>"  
                + "<FONT size=5 face=Times New Roman ><b> Couleur :   "+ComboCouleur.getSelectedItem()+"</b><br></FONT>"
                + "<FONT size=5 face=Times New Roman ><b> ????????????????????????  </b><br></FONT>"
                  
                  + "<FONT size=4 face=Times New Roman color=#ff0000 ><b> Vous Voulez bien enregistrer ces informations ?<br></BODY> </html>";
         int p = 0;
          if(ComboCouleur.getSelectedItem().equals("blanc"))
          {optianpane.setMessage(msgB);
         p= JOptionPane.showConfirmDialog((Component)null, msgB, "Informations saisies", JOptionPane.OK_OPTION);
          }else if(ComboCouleur.getSelectedItem().equals("noir"))
          {
              optianpane.setMessage(msg);
              p= JOptionPane.showConfirmDialog((Component)null, msg, "Informations saisies", JOptionPane.OK_OPTION);}    
if (p==0)
{

       try{
         stm=maConnexion.get_connexion().createStatement();
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
        stm.executeUpdate(requete);
       
        
        //JOptionPane.showMessageDialog(null,"requ??te ex??cut??e avec succ??s");
        System.out.println("ok");
        rs=stm.executeQuery(sql);
        rs.first();
        System.out.println(""+rs.getString("id")+"");
        String requete1= "UPDATE materiel SET Date_Utilisation= '"+D_R+"' WHERE Id_Materiel='"+rs.getString("id")+"' ";
        String requete2= "UPDATE materiel SET Etat= 'Utilis??' WHERE Id_Materiel='"+rs.getString("id")+"' ";
        
        stm.executeUpdate(requete1); 
        stm.executeUpdate(requete2); 
       // JOptionPane.showMessageDialog(null,"la date d'utilisation et l'??tat du mat??riel a ??t?? modifi??");
         Date_courante(); 
         Initialiser();
       }
       catch(SQLException e){
           System.err.println(e);
           JOptionPane.showMessageDialog(null,e);
                   
       }
        
}   
                  
             }//fermeture du if de if(CheckMO.isSelected() && CheckMU.isSelected())
             
           //Le cas ou on n'a utilis?? que du mat??riel  
             else if(CheckMO.isSelected()==false && CheckMU.isSelected()==true)
             {
        String requete="INSERT INTO appareil(N_Serie,Date_E,Date_R,Heure_R,Date_S,N_Dossier,Type_App,Etat,Description,Id_Intervention,Id_Intervenant,Id_panne,Id_Materiel,Id_MO,N_BL)\n"+
                "VALUES ('"+N_S+"','"+D_E+"','"+D_R+"','"+H_R+"','"+D_S+"','"+N_D+"','"+Combo_ty.getSelectedItem()+"','"+ComboEtat.getSelectedItem()+"','"+D+"', \n"+
                "(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"'),'"+U+"',\n"+
                "(select Id_panne from panne where type='"+ComboPanne.getSelectedItem()+"'),(select MIN(Id_Materiel) from materiel M\n" +
                
                "where Nom='"+ComboNom.getSelectedItem()+"'\n" +
                "AND Type_Mat='"+ComboType.getSelectedItem()+"'\n" +
                "AND Couleur = '"+ComboCouleur.getSelectedItem()+"' \n" +
                "AND Etat != 'D??fectueux' AND Etat != 'Utilis??' ),1,(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"')) " ;
        //Ex??cuter la requ??te
         String sql= "select min(Id_Materiel) as id from materiel M\n" +
                "where Nom='"+ComboNom.getSelectedItem()+"'\n" +
                "AND Type_Mat='"+ComboType.getSelectedItem()+"'\n" +
                "AND Couleur = '"+ComboCouleur.getSelectedItem()+"' \n" +
                "AND Etat != 'D??fectueux' AND Etat != 'Utilis??'" ;    
 JOptionPane optianpane=new JOptionPane();
         String msg="<html><BODY> <FONT size=4 face=Times New Roman >N_Serie :  "+N_S+" </FONT><br>"
                + "<FONT size=4 face=Times New Roman >N_Dossier :  "+N_D+" </FONT><br>"
                + "<FONT size=4 face=Times New Roman >Date_Entr??e :   "+D_E+"  </FONT><br>"
                + "<FONT size=4 face=Times New Roman > Type Appareil : </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+Combo_ty.getSelectedItem()+"</b></FONT><br>"
                 
                + "<FONT size=4 face=Times New Roman > Intervention : </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+ComboIntervention.getSelectedItem()+"</b></FONT><br>"
                 
                + "<FONT size=4 face=Times New Roman >Etat :   </FONT>"+"<FONT size=5 face=Times New Roman color=#00ff00><b>"+ComboEtat.getSelectedItem()+"</b></FONT><br>"
                + "<FONT size=4 face=Times New Roman >Panne :   </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+ComboPanne.getSelectedItem()+" </b></FONT><br><br><br>"
                + "<FONT size=4 face=Times New Roman > Description :   </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+D+"</b></FONT><br>"
                + "<FONT size=4 face=Times New Roman >Nom :   </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+ComboNom.getSelectedItem()+" </b></FONT><br>"
                + "<FONT size=4 face=Times New Roman >Type :   </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+ComboType.getSelectedItem()+" </b></FONT><br>"
                + "<FONT size=5 face=Times New Roman ><b> ____________   </b><br></FONT>"  
                + "<FONT size=5 face=Times New Roman ><b> Couleur :   "+ComboCouleur.getSelectedItem()+"</b><br></FONT>"
                + "<FONT size=5 face=Times New Roman ><b> ????????????????????????  </b><br></FONT>"
                 
                + "<FONT size=4 face=Times New Roman color=#ff0000 ><b> Vous Voulez bien enregistrer ces informations ?<br></BODY> </html>";

         String msgB="<html><BODY> <FONT size=4 face=Times New Roman >N_Serie :  "+N_S+" </FONT><br>"
                + "<FONT size=4 face=Times New Roman >N_Dossier :  "+N_D+" </FONT><br>"
                + "<FONT size=4 face=Times New Roman >Date_Entr??e :   "+D_E+"  </FONT><br>"
                + "<FONT size=4 face=Times New Roman > Type Appareil : </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+Combo_ty.getSelectedItem()+"</b></FONT><br>"
                 
                + "<FONT size=4 face=Times New Roman > Intervention : </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+ComboIntervention.getSelectedItem()+"</b></FONT><br>"
                 
                + "<FONT size=4 face=Times New Roman >Etat :   </FONT>"+"<FONT size=5 face=Times New Roman color=#00ff00><b>"+ComboEtat.getSelectedItem()+"</b></FONT><br>"
                + "<FONT size=4 face=Times New Roman >Panne :   </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+ComboPanne.getSelectedItem()+" </b></FONT><br><br><br>"
                + "<FONT size=4 face=Times New Roman > Description :   </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+D+"</b></FONT><br>"
                + "<FONT size=4 face=Times New Roman >Nom :   </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+ComboNom.getSelectedItem()+" </b></FONT><br>"
                + "<FONT size=4 face=Times New Roman >Type :   </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+ComboType.getSelectedItem()+" </b></FONT><br>"
                + "<FONT size=5 face=Times New Roman color=#FFFFFF ><b> _____________   </b><br></FONT>" 
                + "<FONT size=5 face=Times New Roman color=#FFFFFF ><b> Couleur :   "+ComboCouleur.getSelectedItem()+"</b><br></FONT>"
                + "<FONT size=5 face=Times New Roman color=#FFFFFF ><b> ??????????????????????????  </b><br></FONT>"
                 
                + "<FONT size=4 face=Times New Roman color=#ff0000 ><b> Vous Voulez bien enregistrer ces informations ?<br></BODY> </html>";
         
               int p = 0;
          if(ComboCouleur.getSelectedItem().equals("blanc"))
          {optianpane.setMessage(msgB);
         p= JOptionPane.showConfirmDialog((Component)null, msgB, "Informations saisies", JOptionPane.OK_OPTION);
          }else if(ComboCouleur.getSelectedItem().equals("noir"))
          {
              optianpane.setMessage(msg);
              p= JOptionPane.showConfirmDialog((Component)null, msg, "Informations saisies", JOptionPane.OK_OPTION);}        
  
if (p==0)
{
       try{
         stm=maConnexion.get_connexion().createStatement();
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
        stm.executeUpdate(requete); 
      //  JOptionPane.showMessageDialog(null,"requ??te ex??cut??e avec succ??s");
        System.out.println("ok");
        rs=stm.executeQuery(sql);
        rs.first();
        System.out.println(""+rs.getString("id")+"");
        String requete1= "UPDATE materiel SET Date_Utilisation= '"+D_R+"' WHERE Id_Materiel='"+rs.getString("id")+"' ";
        String requete2= "UPDATE materiel SET Etat= 'Utilis??' WHERE Id_Materiel='"+rs.getString("id")+"' ";
        
        stm.executeUpdate(requete1); 
        stm.executeUpdate(requete2); 
        //JOptionPane.showMessageDialog(null,"la date d'utilisation et l'??tat du mat??riel a ??t?? modifi??");
         Date_courante();
         Initialiser();
       }
       catch(SQLException e){
           System.err.println(e);
           JOptionPane.showMessageDialog(null,e);
                   
       }
}
     }//fermeture du if de if(CheckMO.isSelected() && CheckMU.isSelected())  
          //Le cas ou on n a utilis?? que de la main d'eouvre    
             else if(CheckMO.isSelected()==true && CheckMU.isSelected()==false)
             {
        String requete="INSERT INTO appareil(N_Serie,Date_E,Date_R,Heure_R,Date_S,N_Dossier,Type_App,Etat,Description,Id_Intervention,Id_Intervenant,Id_panne,Id_Materiel,Id_MO,N_BL)\n"+
                "VALUES ('"+N_S+"','"+D_E+"','"+D_R+"','"+H_R+"','"+D_S+"','"+N_D+"','"+Combo_ty.getSelectedItem()+"','"+ComboEtat.getSelectedItem()+"','"+D+"', \n"+
                "(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"'),'"+U+"',\n"+
                "(select Id_panne from panne where type='"+ComboPanne.getSelectedItem()+"'),1,(select Id_MO from maindoeuvre where Type_MO='"+ComboMO.getSelectedItem()+"' AND Type_App='"+Combo_ty.getSelectedItem()+"'),(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"')) " ;
        //Ex??cuter la requ??te
          JOptionPane optianpane=new JOptionPane();
         String msg="<HTML><BODY><FONT size=4 face=Times New Roman > N_Serie :  "+N_S+"<br> </FONT>"
                + "<FONT size=4 face=Times New Roman > N_Dossier :'"+N_D+" </FONT><br>"
                + "<FONT size=4 face=Times New Roman > Date_Entr??e :'"+D_E+" </FONT><br>"
                 
                + "<FONT size=4 face=Times New Roman > Type Appareil : </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+Combo_ty.getSelectedItem()+"</b></FONT><br>"
                + "<FONT size=4 face=Times New Roman > Intervention : </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+ComboIntervention.getSelectedItem()+"</b></FONT><br>"
                
                + "<FONT size=4 face=Times New Roman >Etat :   </FONT>"+"<FONT size=5 face=Times New Roman color=#00ff00><b>"+ComboEtat.getSelectedItem()+"</b></FONT><br>"
                + "<FONT size=4 face=Times New Roman >Panne :   </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+ComboPanne.getSelectedItem()+" </b></FONT><br><br><br>"
                 
                + "<FONT size=4 face=Times New Roman > Description :   </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+D+"</b></FONT><br>"
                + "<FONT size=4 face=Times New Roman > Main d'Oeuvre :   </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+ComboMO.getSelectedItem()+" </b></FONT><br>"
                 
                + "<FONT size=4 face=Times New Roman color=#ff0000 ><b> Vous Voulez bien enregistrer ces informations ?</FONT> </BODY></html>";
         
         String msgB="<HTML><BODY><FONT size=4 face=Times New Roman > N_Serie :  "+N_S+"<br> </FONT>"
                + "<FONT size=4 face=Times New Roman > N_Dossier :'"+N_D+" </FONT><br>"
                + "<FONT size=4 face=Times New Roman > Date_Entr??e :'"+D_E+" </FONT><br>"
               + "<FONT size=4 face=Times New Roman > Type Appareil : "+Combo_ty.getSelectedItem()+"</FONT><br>"
                 + "<FONT size=4 face=Times New Roman >Intervention : "+ComboIntervention.getSelectedItem()+"</FONT><br>"
                + "<FONT size=4 face=Times New Roman > Etat :'"+ComboEtat.getSelectedItem()+" </FONT><br>"
                + "<FONT size=4 face=Times New Roman > Panne :'"+ComboPanne.getSelectedItem()+"</FONT><br><br><br>"
                 + "<FONT size=4 face=Times New Roman ><b> Description :   "+D+"</b></FONT><br>"
                 + "<FONT size=4 face=Times New Roman color=#FFFFFF ><b> Type_MO='"+ComboMO.getSelectedItem()+" </b></FONT><br>"
                 + "<FONT size=4 face=Times New Roman color=#ff0000 ><b> Vous Voulez bien enregistrer ces informations ?</FONT> </BODY></html>";

         int p = 0;
          if(ComboCouleur.getSelectedItem().equals("blanc"))
          {optianpane.setMessage(msgB);
         p= JOptionPane.showConfirmDialog((Component)null, msgB, "Informations saisies", JOptionPane.OK_OPTION);
          }else if(ComboCouleur.getSelectedItem().equals("noir"))
          {
              optianpane.setMessage(msg);
              p= JOptionPane.showConfirmDialog((Component)null, msg, "Informations saisies", JOptionPane.OK_OPTION);}        
if (p==0)
{
       try{
         stm=maConnexion.get_connexion().createStatement();
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
        stm.executeUpdate(requete); 
         Date_courante();
         Initialiser();
         JOptionPane.showMessageDialog(null,"requ??te ex??cut??e avec succ??s");
         
       }
       catch(SQLException e){
           System.err.println(e);
           JOptionPane.showMessageDialog(null,e);
                   
       }
}
             }//fermeture du if de if(CheckMO.isSelected() && CheckMU.isSelected())
         
        
      
             
         }
         else if(ComboEtat.getSelectedItem().equals("Non R??par??"))
         {
             String requete="INSERT INTO appareil(N_Serie,Date_E,Date_R,Heure_R,Date_S,N_Dossier,Type_App,Etat,Description,Id_Intervention,Id_Intervenant,Id_panne,Id_Materiel,Id_MO,N_BL)\n"+
                "VALUES ('"+N_S+"','"+D_E+"','"+D_R+"','"+H_R+"','"+D_S+"','"+N_D+"','"+Combo_ty.getSelectedItem()+"','"+ComboEtat.getSelectedItem()+"','"+D+"', \n"+
                "(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"'),'"+U+"',\n"+
                "(select Id_panne from panne where type='"+ComboPanne.getSelectedItem()+"'),1,1,(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"')) " ;
        //Ex??cuter la requ??te
         JOptionPane optianpane=new JOptionPane();
         String msg= "<html> <BODY><FONT size=4 face=Times New Roman > N_Serie :  "+N_S+" </FONT><br>"
                + "<FONT size=4 face=Times New Roman >N_Dossier :   "+N_D+"</FONT><br>"
                + "<FONT size=4 face=Times New Roman >Date_Entr??e :  "+D_E+" </FONT><br>"
                 
                + "<FONT size=4 face=Times New Roman > Type Appareil : </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+Combo_ty.getSelectedItem()+"</b></FONT><br>"
                + "<FONT size=4 face=Times New Roman > Intervention : </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+ComboIntervention.getSelectedItem()+"</b></FONT><br>"
                 
                + "<FONT size=4 face=Times New Roman >Etat :   </FONT>"+"<FONT size=5 face=Times New Roman color=#ff0000><b>"+ComboEtat.getSelectedItem()+"</b></FONT><br>"
                + "<FONT size=4 face=Times New Roman >Panne :   </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+ComboPanne.getSelectedItem()+" </b></FONT><br><br><br>"
                + "<FONT size=4 face=Times New Roman > Description :   </FONT>"+"<FONT size=5 face=Times New Roman ><b>"+D+"</b></FONT><br>"
                + "<FONT size=4 face=Times New Roman color=#ff0000 ><b> ??tes-vous s??r de vouloir enregistrer ces informations ?</FONT> </BODY> </html>";
         
         String msgB= "<html> <BODY><FONT size=4 face=Times New Roman > N_Serie :  "+N_S+" </FONT><br>"
                + "<FONT size=4 face=Times New Roman >N_Dossier :   "+N_D+"</FONT><br>"
                + "<FONT size=4 face=Times New Roman >Date_Entr??e :  "+D_E+" </FONT><br>"
                 + "<FONT size=4 face=Times New Roman > Type Appareil : "+Combo_ty.getSelectedItem()+"</FONT><br>"
                 + "<FONT size=4 face=Times New Roman > Intervention : "+ComboIntervention.getSelectedItem()+"</FONT><br>"
                + "<FONT size=4 face=Times New Roman >Etat :   "+ComboEtat.getSelectedItem()+"</FONT><br>"
                + "<FONT size=4 face=Times New Roman >Panne :   "+ComboPanne.getSelectedItem()+" </FONT><br><br><br>"
                + "<FONT size=4 face=Times New Roman color=#FFFFFF ><b> Description :   "+D+"</b></FONT><br>"
                 + "<FONT size=4 face=Times New Roman color=#ff0000 ><b> Vous Voulez bien enregistrer ces informations ?</FONT> </BODY> </html>";
         int p = 0;
          if(ComboCouleur.getSelectedItem().equals("blanc"))
          {optianpane.setMessage(msgB);
         p= JOptionPane.showConfirmDialog((Component)null, msgB, "Informations saisies", JOptionPane.OK_OPTION);
          }else if(ComboCouleur.getSelectedItem().equals("noir"))
          {
              optianpane.setMessage(msg);
              p= JOptionPane.showConfirmDialog((Component)null, msg, "Informations saisies", JOptionPane.OK_OPTION);}       
      if(p==0)
      {
           try{
         stm=maConnexion.get_connexion().createStatement();
        // stm.executeQuery(requete); ne passe pas pour l'insertion dans mysql
        stm.executeUpdate(requete); 
       
          
         Date_courante();
         Initialiser();
        // JOptionPane.showMessageDialog(null,"requ??te ex??cut??e avec succ??s");
         
       }
       catch(SQLException e){
           System.err.println(e);
           JOptionPane.showMessageDialog(null,e);     
       }}
         }
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void CheckMOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckMOActionPerformed
       if(CheckMO.isSelected()==true)
       {
             ComboMO.setEnabled(true);
             jLabel12.setEnabled(true);
           //Remplir_ComboMO();
       }
       else if(CheckMO.isSelected()==false)
       {
          ComboMO.setEnabled(false);
          jLabel12.setEnabled(false);
       
       }
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
           //Remplir_ComboNom();
           //Remplir_ComboType();
           //Remplir_ComboCouleur();
       }
        else if(CheckMU.isSelected()==false)
        {
           ComboCouleur.setEnabled(false);
             ComboNom.setEnabled(false);
             ComboType.setEnabled(false);
             jLabel14.setEnabled(false);
             jLabel10.setEnabled(false);
             jLabel15.setEnabled(false);
        }
    }//GEN-LAST:event_CheckMUActionPerformed

    private void ComboEtatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboEtatActionPerformed
       if(ComboEtat.getSelectedItem().equals("R??par??"))
         {
             Remplir_ComboPanneR??par??();
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
        else if(ComboEtat.getSelectedItem().equals("Non R??par??"))
        {
             Remplir_ComboPanneNonR??par??();
            ComboEtat.setBackground(Color.RED);
            //CheckMU.isSelected(false);
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
    }//GEN-LAST:event_ComboEtatActionPerformed

    private void descKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descKeyPressed
      desc.setText(desc.getText().replaceAll("\t", System.lineSeparator()));
    }//GEN-LAST:event_descKeyPressed

    private void n_utiliFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_n_utiliFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_n_utiliFocusGained

    private void n_utiliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_utiliActionPerformed
        n_serie.requestFocus();
    }//GEN-LAST:event_n_utiliActionPerformed

    private void n_utiliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_n_utiliKeyPressed
       n_utili.requestFocus();
    }//GEN-LAST:event_n_utiliKeyPressed

    private void n_utiliAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_n_utiliAncestorAdded
     // TODO add your handling code here:
    }//GEN-LAST:event_n_utiliAncestorAdded

    private void Combo_tyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_tyActionPerformed
        if(Combo_ty.getSelectedItem().equals("T??l??phone"))
         {
          ImageIcon icone =  new ImageIcon("C:\\SAVappli\\src\\savappli\\port.jpg");
 
             lab.setIcon(icone);
             Remplir_ComboNomTel();
             Remplir_ComboTypeTel();
             Remplir_ComboCouleurTel();
             Remplir_ComboMOTel();
         }
        else if(Combo_ty.getSelectedItem().equals("Tablette"))
        {
            ImageIcon icone =  new ImageIcon("C:\\SAVappli\\src\\savappli\\tabl.jpg");
 
             lab.setIcon(icone);
             Remplir_ComboNomTab();
             Remplir_ComboTypeTab();
             Remplir_ComboCouleurTab();
             Remplir_ComboMOTab();
        }
    }//GEN-LAST:event_Combo_tyActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameContracasse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameContracasse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameContracasse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameContracasse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 new JFrameContracasse().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckMO;
    private javax.swing.JCheckBox CheckMU;
    private javax.swing.JComboBox ComboCouleur;
    private javax.swing.JComboBox ComboEtat;
    private javax.swing.JComboBox ComboIntervention;
    private javax.swing.JComboBox ComboMO;
    private javax.swing.JComboBox ComboNom;
    private javax.swing.JComboBox ComboPanne;
    private javax.swing.JComboBox ComboType;
    private javax.swing.JComboBox Combo_ty;
    private com.toedter.calendar.JDateChooser date_e;
    private javax.swing.JTextArea desc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lab;
    private javax.swing.JTextField n_dossier;
    private javax.swing.JTextField n_serie;
    private javax.swing.JPasswordField n_utili;
    private javax.swing.JPanel pan1;
    private javax.swing.JPanel pan2;
    // End of variables declaration//GEN-END:variables
}
