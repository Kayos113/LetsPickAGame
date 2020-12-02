package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ListStore;

public class NewListController implements Initializable
{
	private ListStore listStore;

	@FXML
	private TextField listNameTextField;

	public void newListButtonClicked(ActionEvent e) throws IOException
	{
		listStore.newList(listNameTextField.getText());
		System.out.println("New List added");
		Stage stage = (Stage) listNameTextField.getScene().getWindow();
		stage.close();
	}

	public void cancelButtonClicked(ActionEvent e) throws IOException
	{
		Stage stage = (Stage) listNameTextField.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listStore = Main.getLists();
	}

}
