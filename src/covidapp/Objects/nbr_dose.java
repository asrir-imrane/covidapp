package covidapp.Objects;

import java.sql.*;
import javax.swing.JOptionPane;

public class nbr_dose{






    public static int NbrDose1(){
        try {
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3300/chaiame";
            Class.forName(myDriver);

            Connection conn = DriverManager.getConnection(myUrl, "imrane", "1234");

            Statement stmt = conn.createStatement();


            String sql = "SELECT COUNT(*) AS nbdose1 FROM  student WHERE nbr_dose = 1;";
            ResultSet rs = stmt.executeQuery(sql);

            rs.next();
            int nbdose1 = rs.getInt("nbdose1");
            conn.close();
            return nbdose1;
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null,e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
   ////////////
     public static int NbrDose2(){
        try {
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3300/chaiame";
            Class.forName(myDriver);

            Connection conn = DriverManager.getConnection(myUrl, "imrane", "1234");

            Statement stmt = conn.createStatement();


            String sql = "SELECT COUNT(*) AS nbdose2 FROM  student WHERE nbr_dose = 2;";
            ResultSet rs = stmt.executeQuery(sql);

            rs.next();
            int nbdose2 = rs.getInt("nbdose2");
            conn.close();
            return nbdose2;
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null,e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
         return 0;
    }
   /////////////
    
    
  public static int NbrDose3(){
        try {
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3300/chaiame";
            Class.forName(myDriver);

            Connection conn = DriverManager.getConnection(myUrl, "imrane", "1234");

            Statement stmt = conn.createStatement();


            String sql = "SELECT COUNT(*) AS nbdose3 FROM  student WHERE nbr_dose = 3;";
            ResultSet rs = stmt.executeQuery(sql);

            rs.next();
            int nbdose3 = rs.getInt("nbdose3");
            conn.close();
            return nbdose3;
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null,e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
      return 0;
    }   
}