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
	view.displayDealerHand(dealer);
	
	if(checkFor21())
	{
		view.gameWin();
		return true;
	}
	
	playerChoice = getPlayerChoice();
	if(playerChoice.equals("H"))
	{
		player1.drawCard(deck.pop());
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
		keyboard.close();
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
		bj.getFileInput("testInput.txt");
		
		System.out.println(bj.getPlayerChoice());
	}
	
}
