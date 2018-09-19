package core;

import java.util.ArrayList;

public class Player {
	private ArrayList<Card> hand;
	private int handSize;
	private boolean hasAce;

	public Player()
	{
		hand = new ArrayList<Card>();
		this.handSize = 0;
		this.hasAce = false;
	}
	
	public String drawCard(Card card)
	{
		if(card.getValue() == 11)
		{
			hasAce = true;
		}
		hand.add(card);
		handSize++;
		return card.toString();
	}
	
	public Card getCardInHandAt(int i)
	{
		return hand.get(i);
	}
	
	public int getHandSize()
	{
		return this.handSize;
	}
	
	public int getHandValue()
	{
		int result = 0;
		for (Card temp:hand)
		{
			result+= temp.getValue();
		}
		if(hasAce && result > 21)
		{
			result -= 10;
		}
		return result;
	}
	
}
