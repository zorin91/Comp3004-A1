package core;

import junit.framework.TestCase;

public class DealerTest extends TestCase{
	
	public void testDrawCard()
	{
		Dealer dealer1 = new Dealer();
		Deck deck = new Deck();
		
		assertEquals("SA",dealer1.drawCard(deck.pop()));
		assertEquals("SK",dealer1.drawCard(deck.pop()));
		assertEquals("SQ",dealer1.drawCard(deck.pop()));
	}
	
	public void testGetHandSize()
	{
		Dealer dealer1 = new Dealer();
		Deck deck = new Deck();
		
		assertEquals(0,dealer1.getHandSize());
		dealer1.drawCard(deck.pop());
		dealer1.drawCard(deck.pop());
		assertEquals(2,dealer1.getHandSize());
		dealer1.drawCard(deck.pop());
		dealer1.drawCard(deck.pop());
		dealer1.drawCard(deck.pop());
		dealer1.drawCard(deck.pop());
		assertEquals(6,dealer1.getHandSize());
	}
	
	public void testGetHandValue()
	{
		Dealer dealer1 = new Dealer();
		Card card1 = new Card("S","2");
		Card card2 = new Card("S","A");
		Card card3 = new Card("S","5");
		Card card4 = new Card("S","9");
		
		assertEquals(0,dealer1.getHandValue());
		dealer1.drawCard(card1);
		assertEquals(2,dealer1.getHandValue());
		dealer1.drawCard(card2);
		assertEquals(13,dealer1.getHandValue());
		dealer1.drawCard(card3);
		assertEquals(18,dealer1.getHandValue());
		dealer1.drawCard(card4);
		assertEquals(17,dealer1.getHandValue());
	}
	
	public void testDealerDecision()
	{
		Dealer dealer1 = new Dealer();
		Dealer dealer2 = new Dealer();
		Dealer dealer3 = new Dealer();
		Dealer dealer4 = new Dealer();
		Card card1 = new Card("H","9");
		Card card2 = new Card("C","J");
		Card card3 = new Card("S","6");
		Card card4 = new Card("D","10");
		Card card5 = new Card("C","A");
		Card card6 = new Card("S","6");
		Card card7 = new Card("H","K");
		Card card8 = new Card("C","A");
		Card card9 = new Card("D","6");
		
		dealer1.drawCard(card1);
		dealer1.drawCard(card2);
		assertEquals(false,dealer1.dealerDecision());
		dealer2.drawCard(card3);
		dealer2.drawCard(card4);
		assertEquals(true,dealer2.dealerDecision());
		dealer3.drawCard(card5);
		dealer3.drawCard(card6);
		assertEquals(true,dealer3.dealerDecision());
		dealer4.drawCard(card7);
		dealer4.drawCard(card8);
		dealer4.drawCard(card9);
		assertEquals(false,dealer4.dealerDecision());
	}

}