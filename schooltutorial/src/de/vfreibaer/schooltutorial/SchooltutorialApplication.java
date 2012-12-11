package de.vfreibaer.schooltutorial;

import com.example.schooltutorial.LinkCurrentWindowExample;
import com.example.schooltutorial.TabSheetDisabled;
import com.vaadin.Application;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Window;

import de.vfreibaer.schooltutorial.content.LabelUeberschrift;

@SuppressWarnings("serial")
public class SchooltutorialApplication extends Application {
	
	
	@Override
	public void init() {
		buildMainLayout();
	}

	private void buildMainLayout() {
		Window mainWindow = new Window("Schooltutorial Application");
		mainWindow.setTheme("contacts");
		 // Needed because composites are full size
        mainWindow.getContent().setSizeFull();
        
        
        // Content der hinzugefuegt wird 
        LabelUeberschrift oUeberschrift = new LabelUeberschrift();
        mainWindow.addComponent(oUeberschrift); 
        
        // Content der hinzugefuegt wird 
        TabSheetDisabled oTabSheet = new TabSheetDisabled();
        mainWindow.addComponent(oTabSheet); 
       
        // Beispiel fuer Links
        LinkCurrentWindowExample mycomposite2= new LinkCurrentWindowExample();
        mainWindow.addComponent(mycomposite2); 
        
        new ThemeResource("../runo/icons/16/ok.png");
//		mainWindow.addComponent(label);
		setMainWindow(mainWindow);
	}

}
