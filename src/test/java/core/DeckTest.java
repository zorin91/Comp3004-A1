package core;

import junit.framework.TestCase;

public class DeckTest extends TestCase {

	public void testPop()
	{
		Deck deck1 = new Deck();
		Card card1 = deck1.pop();
		Card card2 = deck1.pop();
		Card card3 = deck1.pop();
		assertEquals("H2",card1.toString());
		assertEquals("H3",card2.toString());
		assertEquals("H4",card3.toString());
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
		assertThat(card1.toString(),is(not(equalTo("H2"))));
		assertThat(card1.toString(),is(not(equalTo("H3"))));
	}
}
