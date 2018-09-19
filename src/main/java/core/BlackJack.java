package core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


public class BlackJack {
	Deck deck;
	Player player1;
	Dealer dealer;
	boolean isFileInput;
	String fileContents;
	String playerChoice;
	View view;
	
	public BlackJack()
	{
		deck = new Deck();
		deck.shuffle();
		player1 = new Player();
		dealer = new Dealer();
		view = new View();
		isFileInput = false;
		fileContents = "";
		playerChoice = "";
	}
	
	//console
	public boolean playMatch()
	{
	player1.drawCard(deck.pop());
	player1.drawCard(deck.pop());
	
	dealer.drawCard(deck.pop());
	dealer.drawCard(deck.pop());
	
	view.displayPlayerHand(player1);
	view.displayDealerHand(dealer,false);
	
	//checks if either player or dealer hands are 21 in which case the game ends at this point
	if(checkFor21() && !checkFor21(dealer))
	{
		view.gameWin();
		view.displayPlayerHand(player1);
		view.displayDealerHand(dealer,true);
		return true;
	}
	else if(checkFor21(dealer))
	{
		view.gameOver();
		view.displayPlayerHand(player1);
		view.displayDealerHand(dealer,true);
		return false;
	}
	
	//game continues here, player is given a choice to stand or hit
	else
	{
	view.askForPlayerChoice();
	playerChoice = getPlayerChoice();
	while (!playerChoice.equals("S"))
	{
		
	if(playerChoice.equals("H"))
	{
		view.playerHit();
		player1.drawCard(deck.pop());
		if(checkForBust(player1))
		{
			view.gameOver();
			view.displayPlayerHand(player1);
			view.displayDealerHand(dealer,true);
			return false;
		}
		view.displayPlayerHand(player1);
		view.displayDealerHand(dealer,false);
		
		view.askForPlayerChoice();
		playerChoice = getPlayerChoice();
	}
	else if(playerChoice.equals("D"))
	{
		//Todo: split method
	}
	else if(playerChoice.equals("S"))
	{
		break;
	}
	else
	{
		view.wrongInputMessage();
		break;
	}
	}
	view.playerStand();
	
	//player controlled part of the game has ended
	while(dealer.dealerDecision())
	{
		view.dealerHit();
		dealer.drawCard(deck.pop());
		
		view.displayPlayerHand(player1);
		view.displayDealerHand(dealer,true);
		if(checkForBust(dealer))
		{
			view.gameWin();
			return true;
		}
	}
	view.dealerStand();
	//end of dealer controlled part of the game
	
	view.displayPlayerHand(player1);
	view.displayDealerHand(dealer,true);
	//final comparison of hands to determine winner
	if(compareHands())
	{
		view.gameWin();
		return true;
	}
	else
	{
		view.gameOver();
		return false;
	}
	}	
	}
	
	public String getFileContents()
	{
		return this.fileContents;
	}
	
	public boolean checkFor21()
	{
		if(player1.getHandValue() == 21)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean checkFor21(Dealer d)
	{
		if(dealer.getHandValue() == 21)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean checkForBust(Player p)
	{
		if(p.getHandValue() > 21)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean checkForBust(Dealer d)
	{
		if(d.getHandValue() > 21)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean compareHands()
	{
		if(player1.getHandValue() > dealer.getHandValue() && player1.getHandValue() < 22)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	public void getFileInput(String fName)
	{
		//getFileInput() based on code from http://www.java2s.com/Tutorials/Java/java.nio.file/Files/Java_Files_readAllBytes_Path_path_.htm
		try {
		fileContents = new String(Files.readAllBytes(Paths.get("src/main/resources/" + fName)));
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	
	public String getPlayerChoice()
	{
		String choice;
		Scanner keyboard = new Scanner(System.in);
		choice = keyboard.next();
		if(choice.equals("h") || choice.equals("H"))
		{
			return "H";
		}
		else if(choice.equals("s") || choice.equals("S"))
		{
			return "S";
		}
		else if((choice.equals("d") || choice.equals("D")) && (player1.getCardInHandAt(0).getRank() == player1.getCardInHandAt(0).getRank()) )
		{
			return "D";
		}
		else 
		{
			return "X";
		}
	}
	
	public static void main(String[] args) {
		BlackJack bj = new BlackJack();
		boolean result = bj.playMatch();
	}
	
}
