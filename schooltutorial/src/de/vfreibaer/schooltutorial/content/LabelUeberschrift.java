package de.vfreibaer.schooltutorial.content;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class LabelUeberschrift extends VerticalLayout  {
    private Label label;

    public LabelUeberschrift() {
    	
        setSpacing(true);
        HorizontalLayout layout = new HorizontalLayout(); // 100% default width
        label = new Label(
                "School-Tutorials");
        label.setStyleName("super"); // benutzt die style.css im theme schooltutorials und dazu die angegebene Klasse
        layout.setStyleName("ueberschrift"); // wie oben
        layout.addComponent(label);
        layout.setComponentAlignment(label, Alignment.MIDDLE_CENTER);
        addComponent(layout);
    }

}