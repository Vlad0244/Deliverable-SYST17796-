/**
 * SYST 17796 Project code.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Volodymyr Suprun April 2022
 * @author Adarshpreet Singh April 2022
 * @author Maryam Khatibzadeh Azad April 2022
 */
public abstract class Player {
    protected ArrayList<Card> hand = new ArrayList<>();
    private String name; //the unique name for this player
    protected boolean continueToPlayRound = true; //decides whether a player will play a round

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }
    
    public boolean getContinueToPlayRound() {
        return this.continueToPlayRound;
    }
    
    public void setContinueToPlayRound(boolean bool) {
        this.continueToPlayRound = bool;
    }
    /**
     * @param name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    //gives the player a card
    public void hit(Card card) {
        hand.add(card);
    }
    
    //used to empty the hand during round start
    public void returnAllCards() {
        if(!hand.isEmpty()) {
            hand.removeAll(hand);
        }
    }
    
    //adds up the value of the cards based on blackjack point-values. Value of an ace is decided upon whether or not you 
    //are at or greater than 11 points total already.
    public int getValueOfDeck() {
        int valueOfDeck = 0;
        int aces = 0;
        for (Card card : this.hand) {
            if (card.getRank() == Rank.ACE) {
                aces++;
            }
            valueOfDeck += card.getValue();                
        }
        for (int i = 0; i < aces; i++) {
            if (valueOfDeck >= 11) {
                valueOfDeck += 1;
            }
            else {
                valueOfDeck += 11;
            }
        }
        return valueOfDeck;
    }
    /**
     * The method to be overridden when you subclass the Player class with your specific type of Player and filled in
     * with logic to play your game.
     */
    public abstract void stay();
    public abstract void showHand();

}
