package core;

import java.util.Collections;
import java.util.Stack;

public class Deck {
	private Stack<Card> deck;
	private int size;
	
	String[] suitList = {"H","D","C","S"};
	String[] rankList = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	
	
	public Deck()
	{
		size = 0;
		deck = new Stack<Card>();
		for (int i = 0; i<4;i++)
		{
			for(int n = 0; n < 13;n++)
			{
				deck.push(new Card(suitList[i],rankList[n]));
				size++;
			}
		}
	}
	
	public int getSize()
	{
		return this.size;
	}

	public void shuffle()
	{
		Collections.shuffle(this.deck);
	}
	public Card pop()
	{
		return deck.pop();
	}
}
