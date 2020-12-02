package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.Main;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ListStore;

public class AddGameController implements Initializable
{
	private ListStore listStore;

	@FXML
	private ChoiceBox<String> listChoicebox;

	@FXML
	TextField gameTextField;

	public void addGameButtonClicked()
	{
		String list = listChoicebox.getValue();
		if(list==null||list.equals(""))
		{
			gameTextField.setText("Make sure to choose a list.");
			return;
		}
		listStore.addGame(list, gameTextField.getText());
		Stage stage = (Stage) gameTextField.getScene().getWindow();
		stage.close();
	}

	public void cancelButtonClicked(ActionEvent e) throws IOException
	{
		Stage stage = (Stage) gameTextField.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listStore = Main.getLists();
		listChoicebox.setItems(FXCollections.observableArrayList(listStore.getLists()));
	}

}
