package de.vfreibaer.schooltutorial.content;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class LabelUeberschrift extends VerticalLayout implements ClickListener {

    private Button b;
    private Label label;

    private final RichTextArea editor = new RichTextArea();

    public LabelUeberschrift() {
    	
        setSpacing(true);
        HorizontalLayout layout = new HorizontalLayout(); // 100% default width
        label = new Label(
                "School-Tutorials");
//                        + "<p>The <b>quick</b> brown fox jumps <sup>over</sup> the <b>lazy</b> dog.</p>"
//                        + "<p>This text can be edited with the <i>Edit</i> -button</p>");
        layout.setSizeUndefined();
        layout.addComponent(label);
        layout.setComponentAlignment(label, Alignment.MIDDLE_CENTER);
        
        addComponent(layout);
        
//        b = new Button("Edit");
//        b.addListener(this);
//        addComponent(b);

//        editor.setWidth("100%");
    }

    public void buttonClick(ClickEvent event) {
        if (getComponentIterator().next() == label) {
            editor.setValue(label.getValue());
            replaceComponent(label, editor);
            b.setCaption("Apply");
        } else {
        	label.setValue(editor.getValue());
            replaceComponent(editor, label);
            b.setCaption("Edit");
        }
    }

}