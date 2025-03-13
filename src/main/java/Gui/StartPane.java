package Gui;


import Gui.models.Person;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import storage.Storage;


public class StartPane extends GridPane {


	public StartPane() {

		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);
		initContent();
	}

	private static ComboBox<Person> personComboBox = new ComboBox<Person>();
	private void initContent() {
		personComboBox.getItems().setAll(Storage.getPersonArrayList());
		this.add(personComboBox, 0, 0);
	}


}
