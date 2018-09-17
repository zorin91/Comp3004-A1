package core;

import junit.framework.TestCase;

public class PlayerTest extends TestCase{
	
	public void testDrawCard()
	{
		Player player1 = new Player();
		Deck deck = new Deck();
		
		assertEquals("SA",player1.drawCard(deck.pop()));
		assertEquals("SK",player1.drawCard(deck.pop()));
		assertEquals("SQ",player1.drawCard(deck.pop()));
	}
	
	public void testGetHandSize()
	{
		Player player1 = new Player();
		Deck deck = new Deck();
		
		assertEquals(0,player1.getHandSize());
		player1.drawCard(deck.pop());
		player1.drawCard(deck.pop());
		assertEquals(2,player1.getHandSize());
		player1.drawCard(deck.pop());
		player1.drawCard(deck.pop());
		player1.drawCard(deck.pop());
		player1.drawCard(deck.pop());
		assertEquals(6,player1.getHandSize());
	}
	
	public void testGetHandValue()
	{
		Player player1 = new Player();
		Card card1 = new Card("S","2");
		Card card2 = new Card("S","A");
		Card card3 = new Card("S","5");
		Card card4 = new Card("S","9");
		
		assertEquals(0,player1.getHandValue());
		player1.drawCard(card1);
		assertEquals(2,player1.getHandValue());
		player1.drawCard(card2);
		assertEquals(13,player1.getHandValue());
		player1.drawCard(card3);
		assertEquals(18,player1.getHandValue());
		player1.drawCard(card4);
		assertEquals(17,player1.getHandValue());
	}

}
