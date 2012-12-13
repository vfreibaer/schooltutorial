package de.schooltutorial.pages;

import com.vaadin.demo.sampler.features.embedded.FlashEmbedExample;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class TabSheetMenu extends VerticalLayout implements
        TabSheet.SelectedTabChangeListener, Button.ClickListener {

    private TabSheet oTab;
    private Button toggleEnabled;
    private Button toggleVisible;
    private VerticalLayout oLayer1;
    private VerticalLayout oLayer2;
    private VerticalLayout oLayer3;
    @SuppressWarnings("unused")
    private Tab oTab1, oTab2, oTab3;

    public TabSheetMenu() {
        setSpacing(true);

        // Tab 1 content
        oLayer1 = new VerticalLayout();
        oLayer1.setMargin(true);
        oLayer1.addComponent(new PanelEinleitung());
        // Tab 2 content
        oLayer2 = new VerticalLayout();
        oLayer2.setMargin(true);
        oLayer2.addComponent(new PanelInfoBoard());
        // Tab 3 content
        oLayer3 = new VerticalLayout();
        oLayer3.setMargin(true);
        oLayer3.addComponent(new FlashEmbedExample());

        oTab = new TabSheet();
        oTab.setHeight("650px");
        oTab.setWidth("100%");
        oTab1 = oTab.addTab(oLayer1, "Was das ganze hier soll ???", null);
        oTab2 = oTab.addTab(oLayer2, "Info Board", null);
        oTab3 = oTab.addTab(oLayer3, "Class Room", null);
        oTab.addListener(this);

        toggleEnabled = new Button("Disable 'Notes' tab");
        toggleEnabled.addListener(this);

        toggleVisible = new Button("Hide 'Issues' tab");
        toggleVisible.addListener(this);

        HorizontalLayout hl = new HorizontalLayout();
        hl.setSpacing(true);
        hl.addComponent(toggleEnabled);
        hl.addComponent(toggleVisible);

        addComponent(oTab);
        addComponent(hl);
    }

    public void selectedTabChange(SelectedTabChangeEvent event) {
        String c = oTab.getTab(event.getTabSheet().getSelectedTab()).getCaption();
        getWindow().showNotification("Selected tab: " + c);
        oTab.requestRepaint();
    }

    public void buttonClick(ClickEvent event) {
        if (toggleEnabled.equals(event.getButton())) {
            // toggleEnabled clicked
            oTab2.setEnabled(!oTab2.isEnabled());
            toggleEnabled.setCaption((oTab2.isEnabled() ? "Disable" : "Enable")
                    + " 'Notes' tab");

        } else {
            // toggleVisible clicked
            oTab3.setVisible(!oTab3.isVisible());
            toggleVisible.setCaption((oTab3.isVisible() ? "Hide" : "Show")
                    + " 'Issues' tab");

        }
        oTab.requestRepaint();
    }
}