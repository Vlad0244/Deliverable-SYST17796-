package ca.sheridancollege.project;

/**
 * extension of the player class. Contains the behaviour of the dealer during a game of blackjack.
 *
 * @author Volodymyr Suprun April 2022
 * @author Adarshpreet Singh April 2022
 * @author Maryam Khatibzadeh Azad April 2022
 */
public class Dealer extends Player {

    public Dealer(String name) {
        super(name);
    }
    
    //The dealer automatically stops playing when 17>= point total. 
    @Override
    public void stay() {
        if (getValueOfDeck() >= 17) {
            setContinueToPlayRound(false);
        }
    }
    
    //In a blackjack the dealer hides the first card until the player decides to stop. Its simplified in this to show
    //the card upon the dealer's point total reaching 17 or greater.
    @Override
    public void showHand() {
        String dealersHand = "";
        if (((getValueOfDeck() >= 17) && (getValueOfDeck() <= 21)) || getValueOfDeck() > 21) {
            for (Card card : this.hand) {
                dealersHand += card.toString() + "\n";
            }
            System.out.println("Dealer's Revealed Hand:");
            System.out.println(dealersHand);
        }
        else {
            String dealersHiddenHand = "\nFACE-DOWN CARD\n";
            for (int i = 1; i < this.hand.size(); i++) {
                dealersHiddenHand += hand.get(i).toString() + "\n";
            }
            System.out.print("Dealer's Hand is (FACE-DOWN Card Revealed when 17>=):");
            System.out.println(dealersHiddenHand);
        }
    }
}
