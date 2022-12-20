
package casino;

/**
 * A stack of more than one deck used in a casino game
 *
 */
public class DeckStack {
	
	//An array of decks of cards that comprise this multi-deck.
	private Deck[] decks;
	public Card topCard;
	// you may need other instance variables here
	//Constructor: instantiates the number of decks specified and
	//adds them to the list of decks
	public DeckStack(int numDecks) {
		decks = new Deck[numDecks];
		for (int c = 0; c < numDecks; c ++) {
			decks[c] = new Deck();
		}
	}
	//Deals the top card from the stack of decks and returns that Card.
	//You can implement this several ways, as long as it correctly
	//deals a card from one of the decks.  
	//Important: if you’ve dealt the last card in all the decks, you’ll want 
	//to reshuffle all the decks and start over again
	public Card dealTopCard() {
		for(int c = 0; c < decks.length; c++) {
			if(decks[c].cardsLeft() == 0) {
				decks[c].restockDeck();
			}	
			Card newTopCard = decks[c].dealTopCard();
			return newTopCard;
		}
		return null;
	}
	//Reshuffles all of the decks.
	protected void restoreDecks() {
		for(int c = 0 ; c < decks.length; c++) {
			decks[c].restockDeck();
		}
	}
//returns the number of cards left to be dealt in the entire stack of cards.
	public int cardsLeft() {
		int sumleft = 0;
		for(int c = 0; c < decks.length; c ++) {
			sumleft = decks[c].cardsLeft() + sumleft;
		}
		return sumleft;
	}
}