package model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public class GameStore implements Serializable
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private LinkedList<String> gameList;
	private int nElems;

	public GameStore()
	{
		gameList = new LinkedList<String>();
		nElems = 0;
	}

	public GameStore(Collection<String> gameCollection)
	{
		gameList = new LinkedList<String>(gameCollection);
		nElems = gameList.size();
	}

	public boolean contains(String gameTitle)
	{
		return gameList.contains(gameTitle);
	}

	public boolean addGame(String gameTitle)
	{
		if(gameList.contains(gameTitle))
		{
			return false;
		}
		gameList.add(gameTitle);
		nElems++;
		return true;
	}

	public String[] getList()
	{
		String[] returnable = new String[gameList.size()];
		gameList.toArray(returnable);
		Arrays.sort(returnable);
		return returnable;
	}

	public String randomGame()
	{
		int rand = ((int)(Math.random()*nElems));
		return gameList.get(rand);
	}

	public void removeGame(String game)
	{
		gameList.remove(game);
	}
}
