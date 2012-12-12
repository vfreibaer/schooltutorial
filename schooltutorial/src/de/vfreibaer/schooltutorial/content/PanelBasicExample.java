package de.vfreibaer.schooltutorial.content;

import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class PanelBasicExample extends VerticalLayout
//implements ClickListener 
{

    private Panel panel;

    public PanelBasicExample() {
        setSpacing(true);

        // Panel 1 - with caption
        panel = new Panel("Arbeitsvorlage");
        panel.setHeight("560px"); // we want scrollbars

        // let's adjust the panels default layout (a VerticalLayout)
        VerticalLayout layout = (VerticalLayout) panel.getContent();
        layout.setMargin(true); // we want a margin
        layout.setSpacing(true); // and spacing between components
        addComponent(panel);

        // Let's add a few rows to provoke scrollbars:
        for (int i = 0; i < 20; i++) {
            panel.addComponent(new Label(
                    "Wir dachten uns wir brauchen Inhalt und ne Einleitung."));
        }
        
        panel.addComponent(new Label(
                "Was wollen Sie schreiben?."));
        
        panel.addComponent(new Label(
                "Bevor Sie einen Text schreiben, egal wie wichtig oder wie umfangreich er werden soll, " +
                "bedenken Sie zunächst, warum und wofür Sie diesen Text schreiben. " +
                "Denn jeder Text, den Sie schreiben, soll ja auch gelesen werden. " +
                "Dafür brauchen der Schreiber und der Leser Zeit. Stellen Sie sicher, dass Ihr Text diese Zeit wert ist."+
                "Sie brauchen diese Arbeitsvorlage nicht täglich fürs Schreiben aller Ihrer Texte." +
                " Sie soll vielmehr Anregungen und Hinweise geben, " +
                "an was Sie grundsätzlich immer denken sollten – und wenn es vor dem Schreiben nur wenige Sekunden sind."));

        // Caption toggle:
//        Button b = new Button("Toggle caption");
//        b.addListener(this);
//        addComponent(b);

    }

//    public void buttonClick(ClickEvent event) {
//        if (panel.getCaption().equals("")) {
//            panel.setCaption("This is a standard Panel");
//        } else {
//            panel.setCaption("ggggg");
//        }
//    }
}