package de.schooltutorial.app;

import com.vaadin.Application;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Window;

import de.schooltutorial.pages.LabelLogin;
import de.schooltutorial.pages.LabelUeberschrift;
import de.schooltutorial.pages.PopupViewImpressum;
import de.schooltutorial.pages.TabSheetMenu;

@SuppressWarnings("serial")
public class SchooltutorialApplication extends Application {

	@Override
	public void init() {
		buildMainLayout();
	}

	private void buildMainLayout() {
		Window mainWindow = new Window("Schooltutorial Application");
		mainWindow.setTheme("schooltutorials");
		// Needed because composites are full size
		mainWindow.getContent().setSizeFull();

		// Create a grid layout
		final GridLayout grid = new GridLayout(3, 3);
//			grid.addComponent(ELEMENT , Column, ROW);
		grid.setSpacing(true);
		grid.setWidth("100%");
		grid.setHeight("100%");

		 // Impressum und Datenschutz Schrott
		PopupViewImpressum oImpressum = new PopupViewImpressum();
		 grid.addComponent(oImpressum, 2, 2);
		 grid.setComponentAlignment(oImpressum, Alignment.TOP_RIGHT);

		// Ueberschrift
		LabelUeberschrift oUeberschrift = new LabelUeberschrift();
		grid.addComponent(oUeberschrift, 1, 0);
		grid.setComponentAlignment(oUeberschrift, Alignment.TOP_CENTER);
		
		// Content der hinzugefuegt wird
		TabSheetMenu oTabSheet = new TabSheetMenu();
		grid.addComponent(oTabSheet, 0, 1, 2, 1);
		grid.setComponentAlignment(oTabSheet, Alignment.MIDDLE_CENTER);
		
		// Login
		LabelLogin oLabelLogin = new LabelLogin(oTabSheet);
		grid.addComponent(oLabelLogin, 2, 0);
		grid.setComponentAlignment(oLabelLogin, Alignment.TOP_RIGHT);

//		Button bottomleft = new Button("Bottom right");
//		grid.addComponent(bottomleft, 2, 2);
//		grid.setComponentAlignment(bottomleft, Alignment.BOTTOM_LEFT);
//
//		Button bottomcenter = new Button("Bottom Center");
//		grid.addComponent(bottomcenter, 1, 2);




		// Add the layout to the containing layout.
		mainWindow.addComponent(grid);

		//
		// // Content der hinzugefuegt wird
		// GridLayoutBasicExample oGridLayoutBasicExample = new
		// GridLayoutBasicExample();
		// mainWindow.addComponent(oGridLayoutBasicExample);
		//
		// // Content der hinzugefuegt wird
		// TabSheetDisabled oTabSheet = new TabSheetDisabled();
		// mainWindow.addComponent(oTabSheet);
		//
		// // Beispiel fuer Links
		// LinkCurrentWindowExample mycomposite2= new
		// LinkCurrentWindowExample();
		// mainWindow.addComponent(mycomposite2);

		setMainWindow(mainWindow);
	}

}
