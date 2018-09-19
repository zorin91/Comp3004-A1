package core;

public class Card {

	private String suit,rank;
	
	
	public Card(String suit,String rank)
	{
		this.suit = suit;
		if(rank.equals("T"))
		{
			this.rank = "10";
		}
		else
		{
		this.rank = rank;
		}
	}
	
	public String getSuit()
	{
		return this.suit;
	}
	
	public String getRank()
	{
		return this.rank;
	}
	
	public int getValue()
	{
		if(this.rank.equals("A"))
		{
			return 11;
		}
		else if(this.rank.equals("J") ||this.rank.equals("Q") ||this.rank.equals("K"))
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
