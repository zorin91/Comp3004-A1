package core;

import junit.framework.TestCase;
import java.util.Scanner;

public class BlackJackTest extends TestCase{
	
	public void testCheckFor21()
	{
		BlackJack bj = new BlackJack();
		BlackJack bj2 = new BlackJack();
		BlackJack bj3 = new BlackJack();
		Card card1 = new Card("H","A");
		Card card2 = new Card("H","Q");
		Card card3 = new Card("C","6");
		Card card4 = new Card("S","4");
		
		bj.player1.drawCard(card1);
		bj.player1.drawCard(card2);
		assertEquals(true,bj.checkFor21());
		bj2.player1.drawCard(card1);
		bj2.player1.drawCard(card3);
		bj2.player1.drawCard(card2);
		bj2.player1.drawCard(card4);
		assertEquals(true,bj2.checkFor21());
		bj3.player1.drawCard(card2);
		bj3.player1.drawCard(card4);
		assertEquals(false,bj3.checkFor21());
		
		bj.dealer.drawCard(card1);
		bj.dealer.drawCard(card2);
		assertEquals(true,bj.checkFor21(bj.dealer));
		bj2.dealer.drawCard(card1);
		bj2.dealer.drawCard(card3);
		bj2.dealer.drawCard(card2);
		bj2.dealer.drawCard(card4);
		assertEquals(true,bj2.checkFor21(bj2.dealer));
		bj3.dealer.drawCard(card2);
		bj3.dealer.drawCard(card4);
		assertEquals(false,bj3.checkFor21(bj3.dealer));
	}
	

	public void testCheckForBust()
	{
		BlackJack bj1 = new BlackJack();
		BlackJack bj2 = new BlackJack();
		
		Card card1 = new Card("C","8");
		Card card2 = new Card("H","9");
		Card card3 = new Card("C","J");
		
		bj1.player1.drawCard(card1);
		bj1.player1.drawCard(card2);
		assertEquals(false,bj1.checkForBust(bj1.player1));
		bj2.player1.drawCard(card1);
		bj2.player1.drawCard(card2);
		bj2.player1.drawCard(card3);
		assertEquals(true,bj2.checkForBust(bj2.player1));
		
		bj1.dealer.drawCard(card1);
		bj1.dealer.drawCard(card2);
		assertEquals(false,bj1.checkForBust(bj1.dealer));
		bj2.dealer.drawCard(card1);
		bj2.dealer.drawCard(card2);
		bj2.dealer.drawCard(card3);
		assertEquals(true,bj2.checkForBust(bj2.dealer));
		
	}
	
	
	public void testCompareHands()
	{
		BlackJack bj1 = new BlackJack();
		BlackJack bj2 = new BlackJack();
		BlackJack bj3 = new BlackJack();
		
		Card card1 = new Card("C","A");
		Card card2 = new Card("H","A");
		Card card3 = new Card("C","J");
		Card card4 = new Card("S","Q");
		Card card5 = new Card("H","10");
		Card card6 = new Card("D","3");
		Card card7 = new Card("C","6");
		Card card8 = new Card("S","4");
		
		bj1.player1.drawCard(card1);
		bj1.player1.drawCard(card3);
		bj1.dealer.drawCard(card2);
		bj1.dealer.drawCard(card4);
		assertEquals(false,bj1.compareHands());
		
		bj2.player1.drawCard(card5);
		bj2.player1.drawCard(card7);
		bj2.player1.drawCard(card8);
		bj2.dealer.drawCard(card4);
		bj2.dealer.drawCard(card7);
		assertEquals(true,bj2.compareHands());
		
		bj3.player1.drawCard(card6);
		bj3.player1.drawCard(card7);
		bj3.dealer.drawCard(card3);
		bj3.dealer.drawCard(card5);
		assertEquals(false,bj3.compareHands());
	}
	
	
	public void testGetFileInput()
	{
		BlackJack bj = new BlackJack();
		BlackJack bj2 = new BlackJack();
		bj.getFileInput("test1.txt");
		bj2.getFileInput("test2.txt");
		
		assertEquals("H2 S7 CA C8 H DA",bj.fileContents);
		assertEquals("",bj2.fileContents);
	}
	
	public void testplayMatch()
	{
		BlackJack bj = new BlackJack();
		BlackJack bj2 = new BlackJack();
		BlackJack bj3 = new BlackJack();
		BlackJack bj4 = new BlackJack();
		BlackJack bj5 = new BlackJack();
		BlackJack bj6 = new BlackJack();
		BlackJack bj7 = new BlackJack();
		//BlackJack bj8 = new BlackJack();
		
		
		assertEquals(true,bj.playMatch("gameTest1.txt"));//instant win off blackjack for player
		assertEquals(false,bj2.playMatch("gameTest2.txt"));//tie loss off blackjack for both
		assertEquals(true,bj3.playMatch("gameTest3.txt"));//win from dealer busting
		assertEquals(true,bj4.playMatch("gameTest4.txt"));//win from player higher hand
		assertEquals(false,bj5.playMatch("gameTest5.txt"));//loss from player busting
		assertEquals(false,bj6.playMatch("gameTest6.txt"));//loss from dealer higher hand
		assertEquals(true,bj7.playMatch("gameTest7.txt"));//test case 3 from pdf file
		//assertEquals(false,bj8.playMatch("gameTest8.txt"));//test case 4 from pdf file


	}
	
	public void testsplit()
	{
		
	}
	

}
