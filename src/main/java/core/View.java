package core;

public class View {
	
	public View()
	{
		
	}
	
	public void gameWin()
	{
		System.out.println("You won!");
	}
	
	public void gameOver()
	{
		System.out.println("You lost!");
	}
	
	public void displayPlayerHand(Player p)
	{
		System.out.print("Your hand: ");
		for(Card temp:p.getHand())
		{
			System.out.print(temp.toString());
			System.out.print(" ");
		}
		System.out.println("");
	}
	
	public void displayDealerHand(Dealer d,boolean b)
	{
		if(b)
		{
			System.out.print("Dealer hand: ");
			for(Card temp:d.getHand())
			{
				System.out.print(temp.toString());
				System.out.print(" ");
			}
			System.out.println("");
		}
		else
		{
			System.out.print("Dealer hand: ");
			System.out.print(d.getHand().get(0).toString());
			System.out.print(" ??");
			System.out.println("");
		}
	}

	public void askForPlayerChoice()
	{
		System.out.println("Type 'S' stand or 'H' to hit:");
	}
	public void wrongInputMessage()
	{
		System.out.println("You have selected the wrong input... standing by default");
	}
	
	public void playerHit()
	{
		System.out.println("You hit.");
	}
	
	public void dealerHit()
	{
		System.out.println("Dealer hits.");
	}
	
	public void playerStand()
	{
		System.out.println("You stand.");
	}
	
	public void dealerStand()
	{
		System.out.println("Dealer stands.");
	}
}
