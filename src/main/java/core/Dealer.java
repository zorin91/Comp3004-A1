package core;

import java.util.ArrayList;

public class Dealer {
	private ArrayList<Card> hand;
	private int handSize;
	private boolean hasAce;
	private boolean hasSmallAce;

	public Dealer()
	{
		hand = new ArrayList<Card>();
		this.handSize = 0;
		this.hasAce = false;
		this.hasSmallAce = false;
	}
	
	public ArrayList<Card> getHand()
	{
		return hand;
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
			hasSmallAce = true;
		}
		return result;
	}
	
	public boolean dealerDecision()
	{
		if(this.getHandValue() <= 16)
		{
			return true;
		}
		else if(this.getHandValue() == 17 && !this.hasSmallAce)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
