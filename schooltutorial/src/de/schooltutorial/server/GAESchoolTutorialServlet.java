package de.schooltutorial.server;

import com.vaadin.terminal.gwt.server.GAEApplicationServlet;

@SuppressWarnings("serial")
public class GAESchoolTutorialServlet  extends GAEApplicationServlet{
	
	// Ableiten der GAEApplicationServlet und die Super aufrufen
	// Anbindung der Datenbank muss hier geschehen
	// Global Server Instanz die nur 1 mal beim Start der Anwendung aufgerufen wird
	
	public GAESchoolTutorialServlet() {
		super();
	}

}
