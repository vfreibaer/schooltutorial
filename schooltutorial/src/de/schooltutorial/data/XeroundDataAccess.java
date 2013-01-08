package de.schooltutorial.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("serial")
public class XeroundDataAccess {

        public Connection oConnection = null;
        
        public XeroundDataAccess() {
                oConnection = getConnection();
        }
        
        public Connection getConnection() {

                try {
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        Connection con = DriverManager
            					.getConnection("jdbc:mysql://instance34453.db.xeround.com:3028/db_schooltutorial?"
            							+ "user=admin&password=schooltutorial");

                        System.out.println("Xeround connected to the database");
                        return con;
                } catch (InstantiationException e) {
                        e.printStackTrace();
                } catch (IllegalAccessException e) {
                        e.printStackTrace();
                } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                } catch (SQLException e) {
                        e.printStackTrace();
                }
                return null;
        }

        public void getResults() {
                Statement dbStatement;
                try {
                        dbStatement = oConnection.createStatement();
                        String queryString = "select UserName from users";
                        ResultSet rs = dbStatement.executeQuery(queryString);
//                        while (rs.next()) {
//                                System.out.println(rs.getString(2)) ;
//                        }
//                        rs.close();
                        
//                        String Url = "your_url";
//
//                        System.out.println( DigestUtils.md5Hex( Url ) );
                } catch (SQLException e) {
                        shutdown();
                        e.printStackTrace();
                }

        }
        
        public int getRows(ResultSet res){
            int totalRows = 0;
            try    {
                  res.last();
                  totalRows = res.getRow();
                  res.beforeFirst();
                   } catch(Exception ex)  {
                     return 0;
                   }
                  return totalRows ;    
        }

        public void insert(String word, String usage, String meaning) {

                Statement dbStatement = null;
                try {
                        dbStatement = oConnection.createStatement();
                        String queryString = "insert into words.wordlist values (0, '"
                                        + word + "','" + meaning + "','" + usage + "')";
                        int updateQuery = dbStatement.executeUpdate(queryString);
                        if (updateQuery != 0) {
                                System.out.println("Database table successfully updated");
                        }
                } catch (SQLException e) {
                        shutdown();
                        e.printStackTrace();
                }

        }
        
        public void shutdown() {
                try {
                        oConnection.close();
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
}