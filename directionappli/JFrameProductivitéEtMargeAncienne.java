/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package directionappli;

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
import directionappli.connexion;

/**
 *
 * @author khaoula
 */
public class JFrameProductivitéEtMargeAncienne extends javax.swing.JFrame {
    Statement stm;
    ResultSet rs,rs1,rs2,rs3;
    DefaultTableModel dt;
    connexion maConnexion=new connexion();
    

    /**
     * Creates new form JFrameProductivitéPersonnelle
     */
    
     private void Remplir_ComboIntervention(){
         
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
    
     
private void Remplir_ComboIntervenants(){
         
          try{
              String sql="select distinct(Nom) from intervenant ";
              stm=maConnexion.get_connexion().createStatement();
              rs=stm.executeQuery(sql);
               while(rs.next())
                {
                  String name=rs.getString("Nom");
                  ComboUtil.addItem(name);
                  }
               }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
              }
    } 

private void Fonction_Tous_Tous(){
         String D_R = ((JTextField)date_r.getDateEditor().getUiComponent()).getText();
       try{
             
              String sql="select A.N_Serie,A.N_Dossier,A.Date_E as Date_Entrée,A.Date_R as 'Date Réparation',A.Heure_R as 'Heure Réparation',A.Type_App ,I.type_In AS Intervention,A.Etat,P.type as Panne,A.Description,MO.Type_MO as Main_oeuvre,MA.Nom as Façade,MA.Type_Mat as Appareil,MA.Couleur,II.Nom\n" +
                         "from appareil A,materiel MA,intervention I,panne P,maindoeuvre MO,intervenant II\n" +
                         "where MA.`Id_Materiel`=A.`Id_Materiel`\n" +
                         "AND II.`Id_Intervenant`=A.`Id_Intervenant`\n" +
                         "AND I.`Id_Intervention`=A.`Id_Intervention`\n" +
                         "AND P.`Id_panne`=A.`Id_panne`\n" +
                         "AND MO.`Id_MO`=A.`Id_MO`\n" +
                         "AND II.`Id_Intervenant`=A.`Id_Intervenant`\n" +
                         " AND A.Date_R='"+D_R+"' ORDER BY A.Etat,P.type,A.Heure_R,MO.Main_Oeuvre,Façade";
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
                         " AND A.Date_R='"+D_R+"' AND A.Etat='Réparé'";
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
                         " AND A.Date_R='"+D_R+"' AND A.Etat='Non Réparé'";
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
                          "AND A.Date_R='"+D_R+"' ";
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
       
       String M_B=marge_b.getText();
       int p_a=0,p_v=0,m=0;
       String sql1="select sum(Prix_Achat) as a\n" +
                          "from materiel\n" +
                          "where Date_Utilisation='"+D_R+"' ";
       String sql2="select sum(Prix_Vente) as v\n" +
                          "from materiel\n" +
                          "where Date_Utilisation='"+D_R+"' ";
       String sql3="SELECT sum(Prix_MO)as m_o from maindoeuvre MO,appareil A where MO.Id_MO=A.Id_MO\n"+
                   "AND A.Date_R='"+D_R+"'";
       try{
         stm=maConnexion.get_connexion().createStatement();
         rs1=stm.executeQuery(sql1);
            if(rs1.first())
                {
                p_a = rs1.getInt("a");
                System.out.println(p_a);
                }  
            }
        catch(SQLException e){
           System.err.println(e);    
           }
       
       try{
            stm=maConnexion.get_connexion().createStatement();
            rs2=stm.executeQuery(sql2);  
             if(rs2.first())
                {
               p_v = rs2.getInt("v");
               System.out.println(p_v);
                }
             }
        catch(SQLException e){
           System.err.println(e);    
    }
       try{
            stm=maConnexion.get_connexion().createStatement();
            rs3=stm.executeQuery(sql3);  
             if(rs3.first())
                {
               m = rs3.getInt("m_o");
               System.out.println(m);
                }
             }
        catch(SQLException e){
           System.err.println(e);    
    }
               float s=0;
               s=(p_v+m)-p_a;
               String n=String.valueOf(s);
               marge_b.setText(n);

    
     }


//************************************************************************************************************//

private void Fonction_Tous_Util(){
         String D_R = ((JTextField)date_r.getDateEditor().getUiComponent()).getText();
       try{
             
              String sql="select A.N_Serie,A.N_Dossier,A.Date_E as Date_Entrée,A.Date_R as 'Date Réparation',A.Heure_R as 'Heure Réparation',A.Type_App ,I.type_In AS Intervention,A.Etat,P.type as Panne,A.Description,MO.Main_Oeuvre,MA.Nom as Façade,MA.Type_Mat as Appareil,MA.Couleur,II.Nom\n" +
                         "from appareil A,materiel MA,intervention I,panne P,maindoeuvre MO,intervenant II\n" +
                         "where MA.`Id_Materiel`=A.`Id_Materiel`\n" +
                         "AND II.`Id_Intervenant`=A.`Id_Intervenant`\n" +
                         "AND I.`Id_Intervention`=A.`Id_Intervention`\n" +
                         "AND P.`Id_panne`=A.`Id_panne`\n" +
                         "AND MO.`Id_MO`=A.`Id_MO`\n" +
                         "AND II.`Id_Intervenant`=A.`Id_Intervenant`\n" +
                         " AND A.Date_R='"+D_R+"' AND A.Id_Intervenant=(select Id_Intervenant from intervenant where Nom='"+ComboUtil.getSelectedItem()+"') "+
                         "ORDER BY A.Etat,A.Heure_R,MO.Main_Oeuvre,Façade";
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
                         " AND A.Date_R='"+D_R+"' AND A.Id_Intervenant=(select Id_Intervenant from intervenant where Nom='"+ComboUtil.getSelectedItem()+"')"
                      + " AND A.Etat='Réparé'";
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
                         " AND A.Date_R='"+D_R+"' AND A.Id_Intervenant=(select Id_Intervenant from intervenant where Nom='"+ComboUtil.getSelectedItem()+"')"
                      + "AND A.Etat='Non Réparé'";
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
                          "AND A.Date_R='"+D_R+"' AND A.Id_Intervenant=(select Id_Intervenant from intervenant where Nom='"+ComboUtil.getSelectedItem()+"')"
                      + "";
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
       
       String M_B=marge_b.getText();
       int p_a=0,p_v=0,m=0;
       String sql1="select sum(Prix_Achat) as a\n" +
                          "from materiel M,appareil A\n" +
                          "where M.Id_Materiel=A.Id_Materiel\n"+
                          "AND A.Date_R='"+D_R+"' AND A.Id_Intervenant=(select Id_Intervenant from intervenant where Nom='"+ComboUtil.getSelectedItem()+"')";
       String sql2="select sum(Prix_Vente) as v\n" +
                          "from materiel M,appareil A\n" +
                          "where M.Id_Materiel=A.Id_Materiel\n"+
                          "AND A.Date_R='"+D_R+"' AND A.Id_Intervenant=(select Id_Intervenant from intervenant where Nom='"+ComboUtil.getSelectedItem()+"')";
        String sql3="SELECT sum(Prix_MO)as m_o from maindoeuvre MO,appareil A where MO.Id_MO=A.Id_MO\n"+
                   "AND A.Date_R='"+D_R+"' AND A.Id_Intervenant=(select Id_Intervenant from intervenant where Nom='"+ComboUtil.getSelectedItem()+"') \n" +
                   "";
       try{
         stm=maConnexion.get_connexion().createStatement();
         rs1=stm.executeQuery(sql1);
            if(rs1.first())
                {
                p_a = rs1.getInt("a");
                System.out.println(p_a);
                }  
            }
        catch(SQLException e){
           System.err.println(e);    
           }
       
       try{
            stm=maConnexion.get_connexion().createStatement();
            rs2=stm.executeQuery(sql2);  
             if(rs2.first())
                {
               p_v = rs2.getInt("v");
               System.out.println(p_v);
                }
             }
        catch(SQLException e){
           System.err.println(e);    
    }
       try{
            stm=maConnexion.get_connexion().createStatement();
            rs3=stm.executeQuery(sql3);  
             if(rs3.first())
                {
               m = rs3.getInt("m_o");
               System.out.println(m);
                }
             }
        catch(SQLException e){
           System.err.println(e);    
    }
               float s=0;
               s=(p_v+m)-p_a;
               String n=String.valueOf(s);
               marge_b.setText(n);

    
     }

//////////////**********************************************//////////////////////////////////

private void Fonction_Interv_Tous()
{
String D_R = ((JTextField)date_r.getDateEditor().getUiComponent()).getText();
       try{
             
              String sql="select A.N_Serie,A.N_Dossier,A.Date_E as Date_Entrée,A.Date_R as 'Date Réparation',A.Heure_R as 'Heure Réparation',A.Type_App ,I.type_In AS Intervention,A.Etat,P.type as Panne,A.Description,MO.Main_Oeuvre,MA.Nom as Façade,MA.Type_Mat as Appareil,MA.Couleur,II.Nom\n" +
                         "from appareil A,materiel MA,intervention I,panne P,maindoeuvre MO,intervenant II\n" +
                         "where MA.`Id_Materiel`=A.`Id_Materiel`\n" +
                         "AND II.`Id_Intervenant`=A.`Id_Intervenant`\n" +
                         "AND I.`Id_Intervention`=A.`Id_Intervention`\n" +
                         "AND P.`Id_panne`=A.`Id_panne`\n" +
                         "AND MO.`Id_MO`=A.`Id_MO`\n" +
                         "AND II.`Id_Intervenant`=A.`Id_Intervenant`\n" +
                         " AND A.Date_R='"+D_R+"' AND A.Id_Intervention=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"') "+
                         "ORDER BY A.Etat,A.Heure_R,MO.Main_Oeuvre,Façade";
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
                         " AND A.Date_R='"+D_R+"' AND A.Id_Intervention=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"') "+
                         " AND A.Etat='Réparé'";
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
                         " AND A.Date_R='"+D_R+"' AND A.Id_Intervention=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"') "
                      + "AND A.Etat='Non Réparé'";
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
                          "AND A.Date_R='"+D_R+"' AND A.Id_Intervention=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"') "
                      + "";
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
       
       String M_B=marge_b.getText();
       int p_a=0,p_v=0,m=0;
       String sql1="select sum(Prix_Achat) as a\n" +
                          "from materiel M,appareil A\n" +
                          "where M.Id_Materiel=A.Id_Materiel\n"+
                          "AND A.Date_R='"+D_R+"' AND A.Id_Intervention=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"') ";
       String sql2="select sum(Prix_Vente) as v\n" +
                          "from materiel M,appareil A\n" +
                          "where M.Id_Materiel=A.Id_Materiel\n"+
                          "AND A.Date_R='"+D_R+"' AND A.Id_Intervention=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"') ";
        String sql3="SELECT sum(Prix_MO)as m_o from maindoeuvre MO,appareil A where MO.Id_MO=A.Id_MO\n"+
                   "AND A.Date_R='"+D_R+"'  \n" +
                   "AND A.Id_Intervention=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"')";
       try{
         stm=maConnexion.get_connexion().createStatement();
         rs1=stm.executeQuery(sql1);
            if(rs1.first())
                {
                p_a = rs1.getInt("a");
                System.out.println(p_a);
                }  
            }
        catch(SQLException e){
           System.err.println(e);    
           }
       
       try{
            stm=maConnexion.get_connexion().createStatement();
            rs2=stm.executeQuery(sql2);  
             if(rs2.first())
                {
               p_v = rs2.getInt("v");
               System.out.println(p_v);
                }
             }
        catch(SQLException e){
           System.err.println(e);    
    }
       try{
            stm=maConnexion.get_connexion().createStatement();
            rs3=stm.executeQuery(sql3);  
             if(rs3.first())
                {
               m = rs3.getInt("m_o");
               System.out.println(m);
                }
             }
        catch(SQLException e){
           System.err.println(e);    
    }
               float s=0;
               s=(p_v+m)-p_a;
               String n=String.valueOf(s);
               marge_b.setText(n);

}

///////////////////////********************************//////////////////////////////////////////////////
private void Fonction_Interv_Util(){
    
    String D_R = ((JTextField)date_r.getDateEditor().getUiComponent()).getText();
       try{
             
              String sql="select A.N_Serie,A.N_Dossier,A.Date_E as Date_Entrée,A.Date_R as 'Date Réparation',A.Heure_R as 'Heure Réparation',A.Type_App ,I.type_In AS Intervention,A.Etat,P.type as Panne,A.Description,MO.Main_Oeuvre,MA.Nom as Façade,MA.Type_Mat as Appareil,MA.Couleur,II.Nom\n" +
                         "from appareil A,materiel MA,intervention I,panne P,maindoeuvre MO,intervenant II\n" +
                         "where MA.`Id_Materiel`=A.`Id_Materiel`\n" +
                         "AND II.`Id_Intervenant`=A.`Id_Intervenant`\n" +
                         "AND I.`Id_Intervention`=A.`Id_Intervention`\n" +
                         "AND P.`Id_panne`=A.`Id_panne`\n" +
                         "AND MO.`Id_MO`=A.`Id_MO`\n" +
                         "AND II.`Id_Intervenant`=A.`Id_Intervenant`\n" +
                         " AND A.Date_R='"+D_R+"' AND A.Id_Intervention=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"') "+
                         "AND A.Id_Intervenant=(select Id_Intervenant from intervenant where Nom='"+ComboUtil.getSelectedItem()+"')"+
                         "ORDER BY A.Etat,A.Heure_R,MO.Main_Oeuvre,Façade";
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
                         " AND A.Date_R='"+D_R+"' AND A.Id_Intervention=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"') "+
                         " AND A.Id_Intervenant=(select Id_Intervenant from intervenant where Nom='"+ComboUtil.getSelectedItem()+"') AND A.Etat='Réparé'";
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
                         " AND A.Date_R='"+D_R+"' AND A.Id_Intervention=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"') "
                      + "AND A.Id_Intervenant=(select Id_Intervenant from intervenant where Nom='"+ComboUtil.getSelectedItem()+"') AND A.Etat='Non Réparé'";
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
                          "AND A.Date_R='"+D_R+"' AND A.Id_Intervenant=(select Id_Intervenant from intervenant where Nom='"+ComboUtil.getSelectedItem()+"') AND A.Id_Intervention=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"') "
                      + "";
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
       
       String M_B=marge_b.getText();
       int p_a=0,p_v=0,m=0;
       String sql1="select sum(Prix_Achat) as a\n" +
                          "from materiel M,appareil A\n" +
                          "where M.Id_Materiel=A.Id_Materiel\n"+
                          "AND A.Date_R='"+D_R+"' AND A.Id_Intervenant=(select Id_Intervenant from intervenant where Nom='"+ComboUtil.getSelectedItem()+"')"
               + "AND A.Id_Intervention=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"') ";
       String sql2="select sum(Prix_Vente) as v\n" +
                          "from materiel M,appareil A\n" +
                          "where M.Id_Materiel=A.Id_Materiel\n"+
                          "AND A.Date_R='"+D_R+"' AND A.Id_Intervenant=(select Id_Intervenant from intervenant where Nom='"+ComboUtil.getSelectedItem()+"') "
               + "AND A.Id_Intervention=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"') ";
       
       String sql3="SELECT sum(Prix_MO)as m_o from maindoeuvre MO,appareil A where MO.Id_MO=A.Id_MO\n"+
                   "AND A.Date_R='"+D_R+"' AND A.Id_Intervenant=(select Id_Intervenant from intervenant where Nom='"+ComboUtil.getSelectedItem()+"') \n" +
                   "AND A.Id_Intervention=(select Id_Intervention from intervention where type_In='"+ComboIntervention.getSelectedItem()+"')";
       try{
         stm=maConnexion.get_connexion().createStatement();
         rs1=stm.executeQuery(sql1);
            if(rs1.first())
                {
                p_a = rs1.getInt("a");
                System.out.println(p_a);
                }  
            }
        catch(SQLException e){
           System.err.println(e);    
           }
       
       try{
            stm=maConnexion.get_connexion().createStatement();
            rs2=stm.executeQuery(sql2);  
             if(rs2.first())
                {
               p_v = rs2.getInt("v");
               System.out.println(p_v);
                }
             }
        catch(SQLException e){
           System.err.println(e);    
    }
       try{
            stm=maConnexion.get_connexion().createStatement();
            rs3=stm.executeQuery(sql3);  
             if(rs3.first())
                {
               m = rs3.getInt("m_o");
               System.out.println(m);
                }
             }
        catch(SQLException e){
           System.err.println(e);    
    }
               float s=0;
               s=(p_v+m)-p_a;
               String n=String.valueOf(s);
               marge_b.setText(n);


}

    
    public JFrameProductivitéEtMargeAncienne() {
        initComponents();
        Remplir_ComboIntervention();
        Remplir_ComboIntervenants();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TableProd = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nb_rep = new javax.swing.JTextField();
        nb_nn = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ComboIntervention = new javax.swing.JComboBox();
        ComboUtil = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        date_r = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        marge_b = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Productivité");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Utilisateur :");

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
        jScrollPane1.setViewportView(TableProd);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 102));
        jLabel3.setText("Nombre d'Appareils Réparés  :");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Nombre d'Appareils Non Réparés   :");

        nb_rep.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nb_rep.setForeground(new java.awt.Color(0, 204, 102));

        nb_nn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nb_nn.setForeground(new java.awt.Color(255, 0, 0));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Total  :");

        total.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Type Intervention :");

        ComboIntervention.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ComboIntervention.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tous" }));
        ComboIntervention.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboInterventionActionPerformed(evt);
            }
        });

        ComboUtil.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ComboUtil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tous" }));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Date Réparation :");

        date_r.setDateFormatString("yyyy-MM-dd");
        date_r.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        date_r.setInheritsPopupMenu(true);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Marge Brute :");

        marge_b.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        marge_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marge_bActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setText("Chercher");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(93, 93, 93)
                                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nb_rep, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nb_nn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(marge_b, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboIntervention, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboUtil, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date_r, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(280, 280, 280)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(date_r, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboIntervention, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(ComboUtil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addComponent(jButton2))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nb_rep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nb_nn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(marge_b, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(944, 616));
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
       if(ComboIntervention.getSelectedItem().equals("Tous")) 
         {
             if(ComboUtil.getSelectedItem().equals("Tous"))
             {
               Fonction_Tous_Tous();  
             }
             else Fonction_Tous_Util();
         }
       else{
           if(ComboUtil.getSelectedItem().equals("Tous"))
             {
               Fonction_Interv_Tous();  
             }
            else  Fonction_Interv_Util();
    
       }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void marge_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marge_bActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_marge_bActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameProductivitéEtMargeAncienne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameProductivitéEtMargeAncienne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameProductivitéEtMargeAncienne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameProductivitéEtMargeAncienne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameProductivitéEtMargeAncienne().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboIntervention;
    private javax.swing.JComboBox ComboUtil;
    private javax.swing.JTable TableProd;
    private com.toedter.calendar.JDateChooser date_r;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField marge_b;
    private javax.swing.JTextField nb_nn;
    private javax.swing.JTextField nb_rep;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
