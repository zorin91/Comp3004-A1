package core;

import junit.framework.TestCase;

public class CardTest extends TestCase 
{

	public void testGetSuit() 
	{
		Card card1 = new Card("C","2");
		Card card2 = new Card("D","A");
		Card card3 = new Card("S","J");
		
		assertEquals("C",card1.getSuit());
		assertEquals("D",card2.getSuit());
		assertEquals("S",card3.getSuit());
	}
	public void testGetValue()
	{
		Card card1 = new Card("C","2");
		Card card2 = new Card("D","A");
		Card card3 = new Card("S","J");
		
		assertEquals(2,card1.getValue());
		assertEquals(11,card2.getValue());
		assertEquals(10,card3.getValue());
	}
}
