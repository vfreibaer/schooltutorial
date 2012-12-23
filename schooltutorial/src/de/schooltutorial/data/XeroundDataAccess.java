package de.schooltutorial.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

                        System.out.println("Connected to the database");
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
                        String queryString = "select * from users";
                        ResultSet rs = dbStatement.executeQuery(queryString);
                        while (rs.next()) {
                                System.out.println(rs.getString(2) + " , " + rs.getString(3)
                                                + " , " + rs.getString(4));
                        }
                        rs.close();
                } catch (SQLException e) {
                        shutdown();
                        e.printStackTrace();
                }

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