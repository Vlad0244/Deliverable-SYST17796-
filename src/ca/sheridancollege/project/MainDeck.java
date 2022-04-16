package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Acts as the deck of cards of all the potential unique cards in the two enumerators.
 *
 * @author Volodymyr Suprun April 2022
 * @author Adarshpreet Singh April 2022
 * @author Maryam Khatibzadeh Azad April 2022
 */
public class MainDeck {
    
    //The group of cards, stored in an ArrayList
    protected ArrayList<Card> cards = new ArrayList<>();
    protected int card = 0;

    public MainDeck() {
        for(Suit suit: Suit.values()) {
            for(Rank rank: Rank.values()) {
                this.cards.add(new Card(suit, rank));            
            }
        }
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }
    
    //shuffles the deck and resets card int value
    public void shuffle() {
        Collections.shuffle(cards);
        this.card = 0;
    }

    //removes and returns a card from the top of the deck
    public Card giveCard() {
        Card returnCard = cards.get(card);
        card++;
        return returnCard;
    }
}
