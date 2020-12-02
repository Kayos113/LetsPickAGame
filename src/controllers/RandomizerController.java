package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.Main;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.ListStore;

public class RandomizerController implements Initializable
{
	private ListStore listStore;

	@FXML
	private TextField titleTextField;

	@FXML
	private ChoiceBox<String> listChoicebox;

	@FXML
	public void getAGameButtonClicked(ActionEvent e)
	{
		String list = listChoicebox.getValue();
		if(list.equals("")||list==null)
		{
			titleTextField.setText("Select a list first.");
			return;
		}
		String gamePicked = listStore.randomGame(list);
		titleTextField.setText(gamePicked);
	}

	@FXML
	public void newListButtonClicked(ActionEvent e) throws IOException
	{
		Parent secondRoot = FXMLLoader.load(getClass().getResource("/fxml/NewListFXML.fxml"));
		Scene secondScene = new Scene(secondRoot);
		Stage popUp = new Stage();
        popUp.initModality(Modality.APPLICATION_MODAL);
        popUp.setScene(secondScene);
        popUp.showAndWait();
        listChoicebox.setItems(FXCollections.observableArrayList(listStore.getLists()));
	}

	@FXML
	public void addGameButtonClicked(ActionEvent e) throws IOException
	{
		Parent secondRoot = FXMLLoader.load(getClass().getResource("/fxml/AddGameFXML.fxml"));
		Scene secondScene = new Scene(secondRoot);
		Stage popUp = new Stage();
        popUp.initModality(Modality.APPLICATION_MODAL);
        popUp.setScene(secondScene);
        popUp.showAndWait();
	}

	@FXML
	public void editListsMenuItemClicked(ActionEvent e) throws IOException
	{
		Parent secondRoot = FXMLLoader.load(getClass().getResource("/fxml/EditorFXML.fxml"));
		Scene secondScene = new Scene(secondRoot);
		Stage stage = (Stage) titleTextField.getScene().getWindow();
        stage.setScene(secondScene);
        stage.show();
	}

	@FXML
	public void close(ActionEvent e)
	{
		Stage stage = (Stage) titleTextField.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listStore = Main.getLists();
		listChoicebox.setItems(FXCollections.observableArrayList(listStore.getLists()));
		int compendium = listChoicebox.getItems().indexOf("Master List");
		listChoicebox.setValue(listChoicebox.getItems().get(compendium));
	}

	@FXML
	public void newMenuItemClicked()
	{
		Main.serialize((Stage) titleTextField.getScene().getWindow());
		Main.newList();
		listStore = Main.getLists();
		listChoicebox.setItems(FXCollections.observableArrayList(listStore.getLists()));
		int compendium = listChoicebox.getItems().indexOf("Master List");
		listChoicebox.setValue(listChoicebox.getItems().get(compendium));
		titleTextField.clear();
	}

	@FXML
	public void aboutMenuItemClicked() throws IOException
	{
		Parent secondRoot = FXMLLoader.load(getClass().getResource("/fxml/RandomizerAboutFXML.fxml"));
		Scene secondScene = new Scene(secondRoot);
		Stage popUp = new Stage();
        popUp.initModality(Modality.APPLICATION_MODAL);
        popUp.setScene(secondScene);
        popUp.showAndWait();
	}

	@FXML
	public void serialize()
	{
		Main.serialize((Stage) titleTextField.getScene().getWindow());
		listStore = Main.getLists();
		listChoicebox.setItems(FXCollections.observableArrayList(listStore.getLists()));
		int compendium = listChoicebox.getItems().indexOf("Master List");
		listChoicebox.setValue(listChoicebox.getItems().get(compendium));
	}

	@FXML
	public void serializeToLocation()
	{
		Main.serializeToLocation((Stage) titleTextField.getScene().getWindow());
		listStore = Main.getLists();
		listChoicebox.setItems(FXCollections.observableArrayList(listStore.getLists()));
		int compendium = listChoicebox.getItems().indexOf("Master List");
		listChoicebox.setValue(listChoicebox.getItems().get(compendium));
	}

	@FXML
	public void deserialize()
	{
		Main.deserialize((Stage) titleTextField.getScene().getWindow());
		listStore = Main.getLists();
		listChoicebox.setItems(FXCollections.observableArrayList(listStore.getLists()));
		int compendium = listChoicebox.getItems().indexOf("Master List");
		listChoicebox.setValue(listChoicebox.getItems().get(compendium));
	}
}
