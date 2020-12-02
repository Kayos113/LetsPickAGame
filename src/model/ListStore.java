package model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeMap;

public class ListStore implements Serializable
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private TreeMap<String, GameStore> listStore;

	public ListStore()
	{
		listStore = new TreeMap<String, GameStore>();
		firstEntry();
	}

	private void firstEntry()
	{
		GameStore firstStore = new GameStore();
		listStore.put("Master List", firstStore);
	}

	public void newList(String listName)
	{
		GameStore newList = new GameStore();
		listStore.put(listName, newList);
	}

	public void addGame(String listName, String gameName)
	{
		if(!listName.equals("Master List"))
		{
			listStore.get("Master List").addGame(gameName);
		}
		GameStore targetStore = listStore.get(listName);
		if(targetStore==null)
		{
			newList(listName);
			targetStore = listStore.get(listName);
		}
		targetStore.addGame(gameName);
	}

	public String randomGame(String listName)
	{
		GameStore targetStore = listStore.get(listName);
		if(targetStore==null)
			return "List not found. Try again.";
		return targetStore.randomGame();
	}

	public String[] getList(String list)
	{
		return listStore.get(list).getList();
	}

	public String[] getLists()
	{
		return listStore.keySet().toArray(new String[0]);
	}

	public void deleteList(String list)
	{
		listStore.remove(list);
	}

	public void deleteGame(String list, String game)
	{
		System.out.println("Deleting " + game + " from " + list);
		if(list.equals("Master List"))
		{
			NavigableSet<String> keySet = listStore.navigableKeySet();
			Iterator<String> iter = keySet.iterator();
			String temp = "";
			while(iter.hasNext())
			{
				temp = iter.next();
				if(listStore.get(temp).contains(game))
				{
					System.out.println("Deleting from " + temp);
					listStore.get(temp).removeGame(game);
				}
			}
			return;
		}
		listStore.get(list).removeGame(game);
	}
}
