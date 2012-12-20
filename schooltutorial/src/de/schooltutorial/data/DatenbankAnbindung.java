package de.schooltutorial.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class DatenbankAnbindung {

	Connection con = null;
	  private final LocalServiceTestHelper helper =
		        new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

	  
	public DatenbankAnbindung() {
		 helper.setUp();
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
//		Key employeeKey = KeyFactory.stringToKey("Person");
//		try {
//			datastore.get(employeeKey);
//			System.out.println(datastore.get(employeeKey));
//		} catch (EntityNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		helper.tearDown();
		
		Entity person = new Entity("Person", "tom");

		Entity weddingPhoto = new Entity("Photo", person.getKey());
		weddingPhoto.setProperty("imageUrl",
		    "http://domain.com/some/path/to/wedding_photo.jpg");

		Entity weddingVideo = new Entity("Video", person.getKey());
		weddingVideo.setProperty("videoUrl",
		    "http://domain.com/some/path/to/wedding.avi");

		datastore.put(Arrays.asList(person, weddingPhoto, weddingVideo));
		

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