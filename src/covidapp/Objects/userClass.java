/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package covidapp;


import java.awt.HeadlessException;
import java.sql.*;

import javax.swing.JOptionPane;

public class userClass {
    
    userClass(){
       Connection conn=null;  
        PreparedStatement stmt=null;
    }
    
    
    
    public static void modifier(String cne,String vac,String type_vac,String nb_dose){
       try{

           String myDriver = "com.mysql.cj.jdbc.Driver";
           String myUrl = "jdbc:mysql://localhost:3300/chaiame";
           Class.forName(myDriver);

           Connection conn = DriverManager.getConnection(myUrl, "imrane", "1234");
            String query="UPDATE student  SET vac ='"+ vac+"',type_vac ='" + type_vac  +"',nbr_dose ='" + nb_dose+ "' WHERE cne = '" +cne +"' ;" ;



            PreparedStatement stmt = conn.prepareStatement(query);
           

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Mis à jour avec succès...");

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public static void ajouter(String cne,String prenom,String nom,String depart,String filiere,String vac,String type_vac,String nb_dose) {
        
      try{      
            String url = "jdbc:mysql://localhost:3306/covidEnsem";
            String uname="root";
            String password="itseasy123";

            String query="INSERT into student values(?,?,?,?,?,?,?,?)";

            Connection conn = DriverManager.getConnection(url,uname,password);

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
            JOptionPane.showMessageDialog(null,"Registration successful..");
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
