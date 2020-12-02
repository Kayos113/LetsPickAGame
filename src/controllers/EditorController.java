package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.Main;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.ListStore;

public class EditorController implements Initializable
{
	private ListStore listStore;
	private CheckBox[] gameBoxes;

	@FXML
	private AnchorPane gamePane;

	@FXML
	private ChoiceBox<String> listChoicebox;

	@FXML
	private TextField gameTitleTextField;

	private void populateCheckBoxes()
	{
		gamePane.getChildren().clear();
		String list = listChoicebox.getValue();
		if(list.equals("")||list==null)
		{
			return;
		}
		String[] gameTitles = listStore.getList(list);
		gameBoxes = new CheckBox[gameTitles.length];
		VBox vbox = new VBox();
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(20));
		for(int i=0; i<gameBoxes.length; i++)
		{
			gameBoxes[i] = new CheckBox(gameTitles[i]);
			vbox.getChildren().add(gameBoxes[i]);
		}
		gamePane.getChildren().add(vbox);
	}

	@FXML
	public void exitEditorButtonPressed() throws IOException
	{
		Parent secondRoot = FXMLLoader.load(getClass().getResource("/fxml/RandomizerFXML.fxml"));
		Scene secondScene = new Scene(secondRoot);
		Stage stage = (Stage) listChoicebox.getScene().getWindow();
        stage.setScene(secondScene);
        stage.show();
	}

	@FXML
	public void deleteListButtonPressed()
	{
		String key = listChoicebox.getValue();
		listStore.deleteList(key);
		int compendium = listChoicebox.getItems().indexOf("Master List");
		listChoicebox.setValue(listChoicebox.getItems().get(compendium));
	}

	@FXML
	public void deleteGamesButtonPressed()
	{
		String list = listChoicebox.getValue();
		for(CheckBox i : gameBoxes)
		{
			if(i.isSelected())
			{
				listStore.deleteGame(list, i.getText());
			}
		}
		populateCheckBoxes();
	}

	@FXML
	public void addGameButtonPressed()
	{
		String list = listChoicebox.getValue();
		String game = gameTitleTextField.getText();
		gameTitleTextField.clear();
		listStore.addGame(list, game);
		populateCheckBoxes();
	}

	@FXML
	public void newMenuItemClicked()
	{
		Main.serialize((Stage) listChoicebox.getScene().getWindow());
		Main.newList();
		listStore = Main.getLists();
		listChoicebox.setItems(FXCollections.observableArrayList(listStore.getLists()));
		int compendium = listChoicebox.getItems().indexOf("Master List");
		listChoicebox.setValue(listChoicebox.getItems().get(compendium));
		populateCheckBoxes();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		listStore = Main.getLists();
		listChoicebox.setItems(FXCollections.observableArrayList(listStore.getLists()));
		int compendium = listChoicebox.getItems().indexOf("Master List");
		listChoicebox.setValue(listChoicebox.getItems().get(compendium));
		listChoicebox.setOnAction(e ->{
			populateCheckBoxes();
		});
		populateCheckBoxes();
	}

	@FXML
	public void serialize()
	{
		Main.serialize((Stage) listChoicebox.getScene().getWindow());
		listStore = Main.getLists();
		listChoicebox.setItems(FXCollections.observableArrayList(listStore.getLists()));
		int compendium = listChoicebox.getItems().indexOf("Master List");
		listChoicebox.setValue(listChoicebox.getItems().get(compendium));
	}

	@FXML
	public void serializeToLocation()
	{
		Main.serializeToLocation((Stage) gameTitleTextField.getScene().getWindow());
		listStore = Main.getLists();
		listChoicebox.setItems(FXCollections.observableArrayList(listStore.getLists()));
		int compendium = listChoicebox.getItems().indexOf("Master List");
		listChoicebox.setValue(listChoicebox.getItems().get(compendium));
	}

	@FXML
	public void deserialize()
	{
		Main.deserialize((Stage) listChoicebox.getScene().getWindow());
		listStore = Main.getLists();
		listChoicebox.setItems(FXCollections.observableArrayList(listStore.getLists()));
		int compendium = listChoicebox.getItems().indexOf("Master List");
		listChoicebox.setValue(listChoicebox.getItems().get(compendium));
		populateCheckBoxes();
	}
}
