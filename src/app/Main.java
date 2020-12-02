package app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.ListStore;

public class Main extends Application
{
	private static ListStore listStore;
	private static File myLocation;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		listStore = new ListStore();
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/RandomizerFXML.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static ListStore getLists()
	{
		return listStore;
	}

	public static void serialize(Stage stage) {
		try
		{
			// Serialize data object to a file
			if(myLocation==null || !myLocation.exists()) //check if there is a default file location, if not, launch FileChooser
			{
				FileChooser fileChooser = new FileChooser();
				fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Game Randomizer", "*.ser"));
				myLocation = fileChooser.showSaveDialog(stage);
			}
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(myLocation));
			out.writeObject(listStore);
			out.close();
		}
		catch (IOException e)
		{

		}
	}

	public static void serializeToLocation(Stage stage) {
		try
		{
			// Serialize data object to a file
			FileChooser fileChooser = new FileChooser();
			fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Game Randomizer", "*.ser"));
			myLocation = fileChooser.showSaveDialog(stage);
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(myLocation));
			out.writeObject(listStore);
			out.close();
		}
		catch (IOException e)
		{

		}
	}

	public static void deserialize(Stage stage)
	{
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Game Randomizer", "*.ser"));
		Stage popUp = new Stage();
		popUp.initModality(Modality.APPLICATION_MODAL);
		File pullFrom = fileChooser.showOpenDialog(popUp);
		myLocation = pullFrom;

		try
		{
			ObjectInputStream reader = new ObjectInputStream(new FileInputStream(pullFrom));
			listStore = (ListStore) reader.readObject();
			reader.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

	}

	public static void newList()
	{
		listStore = new ListStore();
	}
}
