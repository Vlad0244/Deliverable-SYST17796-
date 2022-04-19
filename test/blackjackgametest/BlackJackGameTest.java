package blackjackgametest;

import org.junit.Test;
import static org.junit.Assert.*;
import ca.sheridancollege.project.*;
/**
 * This class tests some of the methods of the Blackjack game.
 *
 * @author Volodymyr Suprun April 2022
 * @author Adarshpreet Singh April 2022
 * @author Maryam Khatibzadeh Azad April 2022
 */
public class BlackJackGameTest {
    
    /**
     * Testing that the player's deck is updated after a card is added. Would be the same for the dealer
     * since hit() is a method of Player.
     */
    @Test
    public void testPlayerDrawsCard() {
        System.out.println("checkHit");
        Player playerOne = new User("PlayerOne");        
        // Check that initially playerOne has no cards
        assertEquals(playerOne.getValueOfDeck(), 0);                
        playerOne.hit(new Card(Suit.DIAMONDS, Rank.TWO)); 
        int result = playerOne.getValueOfDeck();
        //asserts result is equals to the value of the two of diamonds card, which is 2.
        assertEquals(result, 2);
        
    }
    
    /**
     * Testing that the dealer stays when above 17 points.
     */
    @Test
    public void testDealerStayGood() {
        System.out.println("checkDealerStayGood");
        Player dealer = new Dealer("DealerOne");        
        // Initially dealer will continue to play
        assertEquals(dealer.getContinueToPlayRound(), true);        
        //these cards have the value of 20
        dealer.hit(new Card(Suit.CLUBS, Rank.JACK));
        dealer.hit(new Card(Suit.CLUBS, Rank.JACK));
        dealer.stay();
        // Confirm that dealer stops playing after the value of deck is greater than 17 (two Jacks is 20)
        assertEquals(dealer.getContinueToPlayRound(), false);       
    }
    
    /**
     * Testing that the dealer stays when at 17 points.
     */
    @Test
    public void testDealerStayBoundary() {
        System.out.println("checkDealerStayBoundary");
        Player dealer = new Dealer("DealerOne");        
        // Initially dealer will continue to play
        assertEquals(dealer.getContinueToPlayRound(), true);        
        //these cards have the value of 17
        dealer.hit(new Card(Suit.CLUBS, Rank.JACK));
        dealer.hit(new Card(Suit.CLUBS, Rank.SEVEN));
        dealer.stay();
        // Confirm that dealer stops playing after the value of deck is equal to 17.
        assertEquals(dealer.getContinueToPlayRound(), false); 
    }
    
    /**
     * Testing that the dealer continues playing when below 17.
     */
    @Test
    public void testDealerStaysBelowSeventeen() {
        System.out.println("checkDealerStayBelowSeventeen");
        Player dealer = new Dealer("DealerOne");        
        // Initially dealer will continue to play
        assertEquals(dealer.getContinueToPlayRound(), true);        
        //this card has the value of 10
        dealer.hit(new Card(Suit.CLUBS, Rank.JACK));
        dealer.stay();
        // Confirm that dealer stops playing after the value of deck is below 17 (one Jack is 10)
        assertEquals(dealer.getContinueToPlayRound(), true); 
    }
    
    /**
     * Testing that the user stops playing.
     */
    @Test
    public void testUserStay() {
        System.out.println("checkUserStay");
        Player user = new User("UserOne");        
        // Initially user will continue to play
        assertEquals(user.getContinueToPlayRound(), true);        
        user.stay();
        // Confirm that user stops playing.
        assertEquals(user.getContinueToPlayRound(), false); 
    }
    
        /**
     * Testing that the user is no longer playing the game.
     */
    
    @Test
    public void testUserNotPlaying() {
        System.out.println("checkUserExit");      
        Game blackjack = new Blackjack("blackjack");
        blackjack.declareWinner();
        assertEquals(blackjack.getUserPlaying(), false);        
    }
    
    /**
     * Testing all card values using getValueOfDeck and all cards from MainDeck.
     */
    @Test
    public void testValueOfDeck() {
        System.out.println("checkValueOfDeck");
        Player user = new User("UserOne"); 
        MainDeck deck = new MainDeck();
        for (Card card : deck.getCards()) {
            user.hit(card);
        }
        // The user should now have all 52 possible cards in his hand.
        assertEquals(user.getHand().size(), 52);        
        //A full deck equals 340 points. With all ACES being equal to 1.
        assertEquals(user.getValueOfDeck(), 340); 
    }
    
    /**
     * Testing value of Two ACE cards.
     */
    @Test
    public void testValueOfTwoAces() {
        System.out.println("checkValueOfTwoAces");
        Player dealer = new Dealer("DealerOne");               
        //these cards equal to 12 (first ace is 11, second is 1)
        dealer.hit(new Card(Suit.CLUBS, Rank.ACE));
        dealer.hit(new Card(Suit.HEARTS, Rank.ACE));
        //First it counts ACE1 as 11 then ACE2 as 1 since it pushes point total over 11, thus being 12.
        assertEquals(dealer.getValueOfDeck(), 12); 
    }
}
