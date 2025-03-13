package Gui;


import Gui.models.Person;
import Gui.models.Portfolio;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
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
	private static Person selectedPerson;

	private static ListView<Portfolio> portfolioListView = new ListView<>();

	private void initContent() {
		personComboBox.getItems().setAll(Storage.getPersonArrayList());
		this.add(personComboBox, 0, 0);
		personComboBox.setOnAction(event -> {
			selectedPerson = personComboBox.getValue();
			updatePortfolio();
		});
		this.add(portfolioListView, 0, 1);
	}

	private void updatePortfolio() {
		portfolioListView.getItems().setAll(selectedPerson.getPortfolioArrayList());
	}


}
