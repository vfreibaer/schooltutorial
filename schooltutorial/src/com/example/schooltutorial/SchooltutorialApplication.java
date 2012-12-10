package com.example.schooltutorial;

import com.vaadin.Application;
import com.vaadin.ui.*;

public class SchooltutorialApplication extends Application {
	@Override
	public void init() {
		Window mainWindow = new Window("Schooltutorial Application");
		Label label = new Label("Hello Vaadin user");
		mainWindow.addComponent(label);
		setMainWindow(mainWindow);
	}

}
