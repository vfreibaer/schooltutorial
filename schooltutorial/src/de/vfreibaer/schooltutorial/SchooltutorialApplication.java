package de.vfreibaer.schooltutorial;

import com.example.schooltutorial.LinkCurrentWindowExample;
import com.example.schooltutorial.TabSheetDisabledExample;
import com.vaadin.Application;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

public class SchooltutorialApplication extends Application {
	@Override
	public void init() {
		Window mainWindow = new Window("Schooltutorial Application");
		
		mainWindow.setTheme("contacts");
		Label label = new Label("VITUS ist der allerbeste");
		
		
		 // Needed because composites are full size
        mainWindow.getContent().setSizeFull();
        
        TabSheetDisabledExample myComposite = new TabSheetDisabledExample();
        mainWindow.addComponent(myComposite); 
        LinkCurrentWindowExample mycomposite2= new LinkCurrentWindowExample();
        
        mainWindow.addComponent(mycomposite2); 
        
        new ThemeResource("../runo/icons/16/ok.png");
		mainWindow.addComponent(label);
		setMainWindow(mainWindow);
	}

}
