package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class RandomizerAboutController implements Initializable
{

	@FXML
	private TextArea aboutTextArea;

	private final String aboutMsg =
	 "Hi, and thank you for using What to do? Game Edition\n\n"
	+"This product is designed for gamers who have so many games to choose from, that sometimes they don’t know what game they want to play. This product maintains various lists of all of your games, separated into whatever qualifiers you wish. You can choose to have one list for each console, or perhaps a list for various genres of games. However you wish to organize your game."
	+"\n\nThe page you are currently on is the Randomizer page."
	+"\n\nHere you can choose one off your lists, or the all encompassing Master List by clicking on the drop down menu. Whichever list is showing is the list that is currently selected."
	+"\n\nThe Get a Game button gets a randomly selected game from whichever list is currently selected."
	+"\n\nThe New List button opens a pop up window where you can start a new list. All newly created lists are empty until something is added."
	+"\n\nThe Add Game button opens a pop up window where you can quickly add a single game to a selected list via the drop box and text field in the pop up window."
	+"\n\nIn the menu:"
	+"\nFile:"
	+"\n\tNew: Starts a new list set. Automatically saves the list set closed if a file location is set. It will prompt you for a file location if a default is not set."
	+"\n\tOpen: Opens a File Chooser window to allow you to load a previously saved list set."
	+"\n\tSave: Saves the list set to a default file location if it is set. If there is no default set, a File Chooser will prompt you to select a new location."
	+"\n\tClose: Closes the program."
	+"\n\nEdit:"
	+"\n\tEdit Lists: Switch to a list editor window where you can add games quickly in bulk, delete games and delete entire lists."
	+"\n\nHelp:"
	+"\n\tAbout: Brings you here.."
	+"\n\nIf you have any questions or concerns, you can contact the creator at:"
	+"\n\n [github link here]";

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		aboutTextArea.setText(aboutMsg);

		// Eventually put the final String into a .txt file to be read to a String here
	}

}
