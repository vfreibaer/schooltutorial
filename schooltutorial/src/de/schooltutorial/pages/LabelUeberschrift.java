package de.schooltutorial.pages;
import org.vaadin.simplelayout.SimpleLayout;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class LabelUeberschrift extends VerticalLayout  {
    private Label label;

    public LabelUeberschrift() {
    	SimpleLayout sl = new SimpleLayout(true);

        label = new Label(
                "School-Tutorials");
        label.setStyleName("uberschrift_div"); // benutzt die style.css im theme schooltutorials und dazu die angegebene Klasse
        sl.setStyleName("ueberschrift"); // wie oben
        sl.addComponent(label);
        addComponent(sl);
    }

}