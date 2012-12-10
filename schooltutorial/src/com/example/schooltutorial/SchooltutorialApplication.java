package com.example.schooltutorial;

import com.vaadin.Application;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

public class SchooltutorialApplication extends Application {
	@Override
	public void init() {
		Window mainWindow = new Window("Schooltutorial Application");
		Label label = new Label("VITUS ist der allerbeste");
		
		
		 // Needed because composites are full size
        mainWindow.getContent().setSizeFull();
        
        TabSheetDisabledExample myComposite = new TabSheetDisabledExample();
        mainWindow.addComponent(myComposite); 
        
        
		mainWindow.addComponent(label);
		setMainWindow(mainWindow);
	}

}
