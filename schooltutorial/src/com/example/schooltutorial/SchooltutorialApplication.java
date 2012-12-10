package com.example.schooltutorial;

import com.vaadin.Application;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

public class SchooltutorialApplication extends Application {
	@Override
	public void init() {
		Window mainWindow = new Window("Schooltutorial Application");
		Label label = new Label("VITUS ist der allerbeste");
		mainWindow.addComponent(label);
		setMainWindow(mainWindow);
	}

}
