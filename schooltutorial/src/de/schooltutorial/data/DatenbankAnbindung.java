package de.schooltutorial.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatenbankAnbindung {

	Connection con = null;

	public DatenbankAnbindung() {

		try {
			con = DriverManager
					.getConnection("jdbc:mysql://instance34453.db.xeround.com:3028/mydb?"
							+ "user=admin&password=schooltutorial");

			// rest of the code . . .
		} catch (SQLException ex) {
			// handle any errors
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}