package de.vfreibaer.schooltutorial.content;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class TabSheetDisabled extends VerticalLayout implements
        TabSheet.SelectedTabChangeListener, Button.ClickListener {

    private TabSheet t;
    private Button toggleEnabled;
    private Button toggleVisible;
    private VerticalLayout l1;
    private VerticalLayout l2;
    private VerticalLayout l3;
    @SuppressWarnings("unused")
    private Tab t1, t2, t3;

    public TabSheetDisabled() {
        setSpacing(true);

        // Tab 1 content
        l1 = new VerticalLayout();
        l1.setMargin(true);
        l1.addComponent(new PanelBasicExample());
        // Tab 2 content
        l2 = new VerticalLayout();
        l2.setMargin(true);
        l2.addComponent(new Label("There are no saved notes."));
        // Tab 3 content
        l3 = new VerticalLayout();
        l3.setMargin(true);
        l3.addComponent(new Label("There are currently no issues."));

        t = new TabSheet();
        t.setHeight("650px");
        t.setWidth("100%");
        t1 = t.addTab(l1, "Was das ganze hier soll ???", null);
        t2 = t.addTab(l2, "Info Board", null);
        t3 = t.addTab(l3, "Class Room", null);
        t.addListener(this);

        toggleEnabled = new Button("Disable 'Notes' tab");
        toggleEnabled.addListener(this);

        toggleVisible = new Button("Hide 'Issues' tab");
        toggleVisible.addListener(this);

        HorizontalLayout hl = new HorizontalLayout();
        hl.setSpacing(true);
        hl.addComponent(toggleEnabled);
        hl.addComponent(toggleVisible);

        addComponent(t);
        addComponent(hl);
    }

    public void selectedTabChange(SelectedTabChangeEvent event) {
        String c = t.getTab(event.getTabSheet().getSelectedTab()).getCaption();
        getWindow().showNotification("Selected tab: " + c);
    }

    public void buttonClick(ClickEvent event) {
        if (toggleEnabled.equals(event.getButton())) {
            // toggleEnabled clicked
            t2.setEnabled(!t2.isEnabled());
            toggleEnabled.setCaption((t2.isEnabled() ? "Disable" : "Enable")
                    + " 'Notes' tab");

        } else {
            // toggleVisible clicked
            t3.setVisible(!t3.isVisible());
            toggleVisible.setCaption((t3.isVisible() ? "Hide" : "Show")
                    + " 'Issues' tab");

        }
        t.requestRepaint();
    }
}