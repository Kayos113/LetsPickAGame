package v1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class GUI extends Application
{

	Label announcement;
	Button randomizeAll, randComp, randSwish, randRemote;
	Font norm, joke, button;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		announcement = new Label("Hit a button to get a randomized game.");
		randomizeAll = new Button("Everything");
		randomizeAll.setOnAction(e -> {
			changeLabel(randomGame());
		});
		randComp = new Button("Non-Switch");
		randComp.setOnAction(e -> {
			changeLabel(randomCompGame());
		});
		randSwish = new Button("Switch");
		randSwish.setOnAction(e -> {
			changeLabel(randomSwitchGame());
		});
		randRemote = new Button("Remote");
		randRemote.setOnAction(e -> {
			changeLabel(randomRemoteGame());
		});
		randomizeAll.setPrefSize(300, 30);
		randComp.setPrefSize(300, 30);
		randSwish.setPrefSize(300, 30);
		randRemote.setPrefSize(300, 30);

		button = Font.font("Courier New", FontWeight.LIGHT, 16);
		norm = Font.font("Courier New", FontWeight.NORMAL, 24);
		joke = Font.font("Nosifer", FontWeight.BLACK, 72);
		announcement.setFont(norm);
		randomizeAll.setFont(button);
		randComp.setFont(button);
		randSwish.setFont(button);
		randRemote.setFont(button);

		VBox vbox = new VBox(announcement, randomizeAll, randComp, randSwish, randRemote);
		vbox.setPadding(new Insets(10));
		vbox.setSpacing(5);
		vbox.setAlignment(Pos.CENTER);
		Scene scene = new Scene(vbox, 750, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	public String randomGame()
	{
		String[] games = {
				"Swish", "Overcooked", "Monop", "Risk", "Triv", "Mur Purt","Monstah Pram", "Relax", "Party Panic", "Oh Sir", "Muddledash",
				"BFF", "Battleblock", "Jump Stars", "Wokstars", "Quoridors", "Gloom", "Once Upon A Story", "Mind","Fugitive", "Toes", "Meth",
				"Kinky Sex", "Ticket", "Clue", "Wizards Tourney", "Pummel Party", "Battlesaur Island"};

			int pick = (int)(Math.random()*games.length);

			return games[pick];
	}

	public String randomCompGame()
	{
		String[] games = {
				"Monstah Pram", "Relax", "Party Panic", "Oh Sir", "Muddledash", "BFF", "Battleblock",
				"Jump Stars", "Wokstars", "Quoridors", "Gloom", "Toes", "Meth", "Pummel Party", 
				"Fugitive", "Kinky Sex", "Dino Board Game", "The Mind", "Story Game"};

			int pick = (int)(Math.random()*games.length);

			return games[pick];
	}

	public String randomSwitchGame()
	{
		String[] games = {
				"Swish", "Overcooked", "Monop", "Risk", "Triv", "Mur Purt", "Meth"
				};


			int pick = (int)(Math.random()*games.length);

			return games[pick];
	}

	public String randomRemoteGame()
	{
		String[] games = {
				"Monstah Pram", "Relax", "Party Panic", "Pummel Party", "Oh Sir",  "BFF",
				"Jump Stars", "Gloom", "Meth", "Ticket", "Risk", "Clue", "Mysterium", "Risk",
				"ToonTown", "Stardew Valley", "Kinky Sex", "Wizard Tourney", "Life"};
			/*	String[] games = {
						"5 minute dungeon", "Fugitive", "Meeseeks", "Pram",
						"relax", "Kinky Sex", "Meth", "Party Panic", 
						"Pummel Party", "Oh Sir", "Gloom", "Once upon a Stroy"}; */
			int pick = (int)(Math.random()*games.length);

			return games[pick];
	}

	public void changeLabel(String gameName)
	{
		if(announcement.getText().equals("Meth")||announcement.getText().equals("Kinky Sex"))
		{
			announcement.setFont(norm);
			announcement.setTextFill(Color.BLACK);
		}
		if(gameName.equals("Meth")||gameName.equals("Kinky Sex"))
		{
			announcement.setFont(joke);
			announcement.setTextFill(Color.DARKRED);
		}
		announcement.setText(gameName);
	}
}
