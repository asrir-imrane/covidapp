/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package covidapp.Objects;


import java.awt.HeadlessException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JFrame;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class adminClass {
    
   public static int nbr_ligne_chercher;
    adminClass(){
       Connection conn=null;  
        PreparedStatement stmt=null;
    }
    
    
    
 ///////////////////::
    public static String[][] FindStudent(String Value) {
        String[][] data = new String[nbr_eleve()][8];
        try {
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3300/chaiame";
            Class.forName(myDriver);

            Connection conn = DriverManager.getConnection(myUrl, "imrane", "1234");
            String sql = "SELECT  * FROM student WHERE cne ='" + Value + "' OR prenom = '" + Value + "'OR nom ='" + Value + "'OR departement ='" + Value + "'OR filiere ='" + Value + "'OR vac ='" + Value + "' ;";
            PreparedStatement  stmt=conn.prepareStatement(sql);
            //stmt.setString(1,Value);
            ResultSet res = stmt.executeQuery(sql);
            int i = 0;
            while (res.next()) {
                String cne = res.getString("cne");
                String prenom = res.getString("prenom");
                String nom = res.getString("nom");
                String dep = res.getString("departement");
                String filiere = res.getString("filiere");
                String vac = res.getString("vac");
                String type_vac = res.getString("type_vac");
                String nbr = res.getString("nbr_dose");

                //data[i][]={cne,prenom,nom,dep,filiere,vac,type_vac,nbr};
                data[i][0] = cne;
                data[i][1] = prenom;
                data[i][2] = nom;
                data[i][3] = dep;
                data[i][4] = filiere;
                data[i][5] = vac;
                data[i][6] = type_vac;
                data[i][7] = nbr;

                i++;
            }
            nbr_ligne_chercher=i;
            return data;


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
            return data;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

 /////////////////////////
 public static String[][] cas_covid(){
      
       try {
           String myDriver = "com.mysql.cj.jdbc.Driver";
           String myUrl = "jdbc:mysql://localhost:3300/chaiame";
           Class.forName(myDriver);

           Connection conn = DriverManager.getConnection(myUrl, "imrane", "1234");
            Statement stmt = (Statement) conn.createStatement();
            String query="SELECT * FROM chaiame.cascovid;";
            ResultSet rs = stmt.executeQuery(query);
            String data[][]= new String[nbr_eleve()][4];
            int i=0;
            while (rs.next()) {
                String pr = rs.getString("m_prenom");
                String nom = rs.getString("m_nom");
                String comnt = rs.getString("comm");
                String d = rs.getString("d_date");
                
                data[i][0]=pr;
                data[i][1]=nom;
                data[i][2]=comnt;
                data[i][3]=d;

                i++;
                }
                return data;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            return null;
        }  
        }    
/////////////////::
public static int nbr_eleve(){
    try {

        String myDriver = "com.mysql.cj.jdbc.Driver";
        String myUrl = "jdbc:mysql://localhost:3300/chaiame";
        Class.forName(myDriver);

        Connection conn = DriverManager.getConnection(myUrl, "imrane", "1234");
            Statement stmt = (Statement) conn.createStatement();
            String query="SELECT COUNT(*) AS nbr_ligne FROM chaiame.student;";
            ResultSet rs = stmt.executeQuery(query);
            int n= 0;
            rs.next();
            n=rs.getInt("nbr_ligne");
            return n;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }   
    return 0;
}   
/////////////////

///////////////////:
 public static String[][] afficher(){
      
       try {
           String myDriver = "com.mysql.cj.jdbc.Driver";
           String myUrl = "jdbc:mysql://localhost:3300/chaiame";
           Class.forName(myDriver);

           Connection conn = DriverManager.getConnection(myUrl, "imrane", "1234");
            Statement stmt = (Statement) conn.createStatement();
            String query="SELECT * FROM chaiame.student;";
            ResultSet rs = stmt.executeQuery(query);
            int nbr_eleve= nbr_eleve();
            String data[][]= new String[nbr_eleve][8];
            int i=0;
            while (rs.next()) {
                String cne = rs.getString("cne");
                String prenom = rs.getString("prenom");
                String nom = rs.getString("nom");
                String dep = rs.getString("departement");
                String filiere = rs.getString("filiere");
                String vac = rs.getString("vac");
                String type_vac = rs.getString("type_vac");
                String nbr = rs.getString("nbr_dose");
                
                //data[i][]={cne,prenom,nom,dep,filiere,vac,type_vac,nbr};
                data[i][0]=cne;
                data[i][1]=prenom;
                data[i][2]=nom;
                data[i][3]=dep;
                data[i][4]=filiere;
                data[i][5]=vac;
                data[i][6]=type_vac;
                data[i][7]=nbr;

                i++;
                }
                return data;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
             return null;
        }
    }
    
            
    
    public static void modifier(String cne,String prenom,String nom,String depart,String filiere,String vac,String type_vac,String nb_dose){
       try{
           String myDriver = "com.mysql.cj.jdbc.Driver";
           String myUrl = "jdbc:mysql://localhost:3300/chaiame";
           Class.forName(myDriver);

           Connection conn = DriverManager.getConnection(myUrl, "imrane", "1234");

            String query="UPDATE student  SET prenom ='"+prenom+"',nom='"+nom+"',departement= '"+depart+"' ,filiere= '"+filiere+"',vac='"+vac+"',type_vac ='" + type_vac  +"',nbr_dose ='" + nb_dose+ "' WHERE cne = '" +cne +"' ;" ;
            


            PreparedStatement stmt = conn.prepareStatement(query);
           

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Mis à jour avec succès...");

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public static void supprimer(String cne){
        try{

            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3300/chaiame";
            Class.forName(myDriver);

            Connection conn = DriverManager.getConnection(myUrl, "imrane", "1234");

            String query="DELETE FROM student WHERE cne = '" +cne +"' ;" ;
            

            PreparedStatement stmt = conn.prepareStatement(query);
           

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"élève supprimé avec succès...");

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public static void ajouter(String cne,String prenom,String nom,String depart,String filiere,String vac,String type_vac,String nb_dose) {
        
      try{
          String myDriver = "com.mysql.cj.jdbc.Driver";
          String myUrl = "jdbc:mysql://localhost:3300/chaiame";
          Class.forName(myDriver);

          Connection conn = DriverManager.getConnection(myUrl, "imrane", "1234");

            String query="INSERT into student values(?,?,?,?,?,?,?,?)";



            PreparedStatement  stmt=conn.prepareStatement(query);
            stmt.setString(1,cne);
            stmt.setString(2, prenom);
            stmt.setString(3, nom);
            stmt.setString(4, depart);
            stmt.setString(5, filiere);
            stmt.setString(6, vac);
            stmt.setString(7, type_vac);
            stmt.setString(8, nb_dose);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"élève enregistré avec succès..");
      }
       catch(Exception i){
            JOptionPane.showMessageDialog(null,i);
        }
        
        
    }
    public static void declarer(String prenom,String nom,String comm,String date){
        try{

            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3300/chaiame";
            Class.forName(myDriver);

            Connection conn = DriverManager.getConnection(myUrl, "imrane", "1234");

            String query="INSERT into casCovid values(?,?,?,?)";
            

            PreparedStatement stmt = conn.prepareStatement(query);
             stmt.setString(1,prenom);
            stmt.setString(2, nom);
            stmt.setString(3, comm);
            stmt.setString(4, date);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Merci pour votre reclamation");

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
}
