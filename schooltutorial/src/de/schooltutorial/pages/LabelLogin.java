package de.schooltutorial.pages;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PopupView;

import de.schooltutorial.login.TextFieldSecretLogin;

@SuppressWarnings("serial")
public class LabelLogin  extends HorizontalLayout  {

	public LabelLogin(ITabSheetMenu oTabSheet) {
	        PopupView  popup = new PopupView("Login", new TextFieldSecretLogin(oTabSheet));
	        popup.setDescription("Click to login");
	        popup.setHideOnMouseOut(false);
	        addComponent(popup);
	        setComponentAlignment(popup, Alignment.BOTTOM_RIGHT);
	}
}
