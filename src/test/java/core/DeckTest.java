package core;

import junit.framework.TestCase;
import static org.junit.Assert.assertNotEquals;

public class DeckTest extends TestCase {

	public void testDraw()
	{
		Deck deck1 = new Deck();
		Card card1 = deck1.pop();
		Card card2 = deck1.pop();
		Card card3 = deck1.pop();
		assertEquals("SA",card1.toString());
		assertEquals("SK",card2.toString());
		assertEquals("SQ",card3.toString());
	}
	
	public void testgetSize()
	{
		Deck deck1 = new Deck();
		assertEquals(52,deck1.getSize());
	}
	
	public void testShuffle()
	{
		Deck deck1 = new Deck();
		deck1.shuffle();
		assertEquals(52,deck1.getSize());
		Card card1 = deck1.pop();
		Card card2 = deck1.pop();
		assertNotEquals("SA",card1.toString());
		assertNotEquals("SK",card2.toString());
	}
}
