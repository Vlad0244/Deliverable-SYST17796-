/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * General card class for Blackjack. contains cardValue for blackjack, and suit and rank enumerator values.
 * 
 * @author dancye
 * @author Volodymyr Suprun April 2022
 * @author Adarshpreet Singh April 2022
 * @author Maryam Khatibzadeh Azad April 2022
 */
public class Card {
    //default modifier for child classes
    private final Suit suit;
    private final Rank rank;
    private final int value;
    
    public Card(Suit suit, Rank rank) {
        this.rank = rank;
        this.suit = suit;
        this.value = cardValue(rank);
    }
    
    /**
     * @return a String representation of a card. depends on the enumeration classes what it outputs.
     */
    @Override
    public String toString() {
        return this.rank.toString() + " of " + this.suit.toString();
    }
    
    public Rank getRank() {
        return rank;
    }
    
    public Suit getSuit() {
        return suit;
    }
    
    public int getValue() {
        return value;
    }
    
    private int cardValue(Rank rank) {
        switch(rank) {
            
            case TWO: {
                return 2;
            }
            
            case THREE: {
                return 3;
            }
            
            case FOUR: {
                return 4;
            }
            
            case FIVE: {
                return 5;
            }
            
            case SIX: {
                return 6;
            }
            
            case SEVEN: {
                return 7;
            }
            
            case EIGHT: {
                return 8;
            }
            
            case NINE: {
                return 9;
            }
            
            case TEN: {
                return 10;
            }
            
            case JACK: {
                return 10;
            }
            
            case QUEEN: {
                return 10;
            }
            
            case KING: {
                return 10;
            }
            //This will be what ACE defaults to as it requires player or dealer choice to set.
            default: {
                return 0;
            }
        }
    }
}
