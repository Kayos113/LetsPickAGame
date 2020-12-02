package v1;

import java.util.Scanner;

public class Simple {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		while(true)
		{
			System.out.println("\nType New Game to get a randomized pick, type exit to quit");
			if(scan.nextLine().charAt(0)!='e')
				randomGame();
			else
				break;
		}
		scan.close();
	}


	public static void randomGame()
	{
		String[] games = {
				"Swish", "Overcooked", "Monop", "Risk", "Triv", "Mur Purt","Monstah Pram", "Relax", "party paniuc", "Oh sir", "muddledash",
				"BFF", "Battleblock", "Jump Stars", "wokstars", "quoridors", "gloom", "once", "Mind","Fugitive","Meth"};

			int pick = (int)(Math.random()*games.length);

			System.out.println(games[pick]);
	}
}
