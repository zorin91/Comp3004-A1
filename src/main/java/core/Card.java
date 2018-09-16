package core;

public class Card {

	private String suit,rank;
	
	
	public Card(String suit,String rank)
	{
		this.suit = suit;
		this.rank = rank;
	}
	
	public String getSuit()
	{
		return this.suit;
	}
	public int getValue()
	{
		if(this.rank == "A")
		{
			return 11;
		}
		else if(this.rank == "J" ||this.rank == "Q" ||this.rank == "K")
		{
			return 10;
		}
		else
		{
			return Integer.parseInt(this.rank);
		}
	}
	
	public String toString()
	{
		return this.suit + this.rank;
	}
}
