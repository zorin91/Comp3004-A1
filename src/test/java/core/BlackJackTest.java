package core;

import junit.framework.TestCase;
import java.util.Scanner;

public class BlackJackTest extends TestCase{
	
	public void testCheckFor21()
	{
		Player player1 = new Player();
		Player player2 = new Player();
		Player player3 = new Player();
		Card card1 = new Card("H","A");
		Card card2 = new Card("H","Q");
		Card card3 = new Card("C","6");
		Card card4 = new Card("S","4");
		
		player1.drawCard(card1);
		player1.drawCard(card2);
		assertEquals(true,checkFor21(player1));
		player2.drawCard(card1);
		player2.drawCard(card3);
		player2.drawCard(card2);
		player2.drawCard(card4);
		assertEquals(true,checkFor21(player2));
		player1.drawCard(card2);
		player1.drawCard(card4);
		assertEquals(false,checkFor21(player3));
	}
	
	public void testCompareHands()
	{
		Player player1 = new Player();
		Player player2 = new Player();
		Player player3 = new Player();
		
		Dealer dealer1 = new Dealer();
		Dealer dealer2 = new Dealer();
		Dealer dealer3 = new Dealer();
		
		Card card1 = new Card("C","A");
		Card card2 = new Card("H","A");
		Card card3 = new Card("C","J");
		Card card4 = new Card("S","Q");
		Card card5 = new Card("H","10");
		Card card6 = new Card("D","3");
		Card card7 = new Card("C","6");
		Card card8 = new Card("S","4");
		
		player1.drawCard(card1);
		player1.drawCard(card3);
		dealer1.drawCard(card2);
		dealer1.drawCard(card4);
		assertEquals(false,compareHands(player1,dealer1));
		
		player2.drawCard(card5);
		player2.drawCard(card7);
		player2.drawCard(card8);
		dealer2.drawCard(card4);
		dealer2.drawCard(card7);
		assertEquals(true,compareHands(player2,dealer2));
		
		player3.drawCard(card6);
		player3.drawCard(card7);
		dealer3.drawCard(card3);
		dealer3.drawCard(card5);
		assertEquals(false,compareHands(player3,dealer3));
	}
	
	public void testGetPlayerChoice()
	{
		Player player1 = new Player();
		String choice;
		Scanner keyboard = new Scanner(System.in);
		
		assertEquals("H",player1.getPlayerChoice(keyboard.nextLine()));
		assertEquals("S",player1.getPlayerChoice(keyboard.nextLine()));
		assertEquals("D",player1.getPlayerChoice(keyboard.nextLine()));
		assertEquals("S",player1.getPlayerChoice(keyboard.nextLine()));
	}
	
	public void testGetFileInput()
	{
		BlackJack bj = new BlackJack();
		assertEquals("H2 S7 CA C8 H DA",bj.getFileInput("test1.txt"));
		assertEquals("",bj.getFileInput("test2.txt"));
	}
	
	public void testplayMatch()
	{
		
	}
	
	public void testsplit()
	{
		
	}
	

}
