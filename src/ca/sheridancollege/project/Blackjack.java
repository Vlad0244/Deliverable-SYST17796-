package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Blackjack class that runs the the game. 
 * @author Volodymyr Suprun April 2022
 * @author Adarshpreet Singh April 2022
 * @author Maryam Khatibzadeh Azad April 2022
 */
public class Blackjack extends Game{
    //keeps score of each player
    private int scoreUser = 0;
    private int scoreDealer = 0;
    private final String dealerName = "Dealer";
    private String userName;

    public Blackjack(String string) {
        super(string);
    }
    
    //main play method method. plays continuous turns until the player decides to exit.
    @Override
    public void play() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Blackjack! Please enter your name.");
        String usersName = input.nextLine();
        ArrayList<Player> arr = new ArrayList<>();
        arr.add(0, new User(usersName));
        arr.add(1, new Dealer(dealerName));
        setPlayers(arr);
        Player user = players.get(0);
        Player dealer = players.get(1);
        this.userName = usersName;
        MainDeck playingDeck = new MainDeck();
        setUserPlaying(Boolean.TRUE);
        //while this is true, the user and dealer will continue to play rounds.
        while (userPlaying) {
            
            //only time the arraylist of players is used. resets their hands and sets their rounds to play again.
            for (Player player : players) {
                player.returnAllCards();
                player.setContinueToPlayRound(Boolean.TRUE);
            }
            
            //shuffles the 52 card deck the players play out of. shuffle() resets card iterator that "gives" players their cards.
            playingDeck.shuffle();
            
            //the following uses of hit() give both user and dealer their starting hand.
            int cardsToStart = 2;
            for (int i = 0; i < cardsToStart; i++) {
                dealer.hit(playingDeck.giveCard());
            }
            user.hit(playingDeck.giveCard());
            
            //New or First round starts
            System.out.println("\n\n\n##Beginning New Round!##");
            
            //ends when both players have reached the conditions to stop playing.
            while (user.getContinueToPlayRound() || dealer.getContinueToPlayRound()) {
                String response = "";
                
                //the dealer stay() checks if points are 17 or above. If they are continueToPlayRound equals false.
                dealer.stay();
                System.out.println("Current Round Win Score Is: YOUR SCORE: " + scoreUser + " DEALER SCORE: " + scoreDealer);
                user.showHand();
                dealer.showHand();
                
                //enters the users options and input
                if (user.getContinueToPlayRound()) {
                    //do loop to make sure user input is hit, stay, or exit ignoring case.
                    do {                        
                        System.out.println("What would you like to do? (Write either hit, stay, or exit. Exit leaves the game.)");
                        response = input.nextLine();
                    } while (!(response.equalsIgnoreCase("exit") || (response.equalsIgnoreCase("hit")) || (response.equalsIgnoreCase("stay"))));
                    //exit input causes final scoring in declareWinner(). Current round is not counted when exiting.
                    if (response.equalsIgnoreCase("exit")) {
                        System.out.println("The user chooses to exit! The game is over!");
                        System.out.println("Round Win Score Is: YOUR SCORE: " + scoreUser + " DEALER SCORE: " + scoreDealer + "\n");
                        user.setContinueToPlayRound(Boolean.FALSE);
                        dealer.setContinueToPlayRound(Boolean.FALSE);                        
                        declareWinner();
                        break;
                    }
                    //calls hit() for the user which adds a card to the users hand. getting 21 or higher instantly gets results of round
                    else if (response.equalsIgnoreCase("hit")) {
                        System.out.println("##YOU CHOOSE TO HIT##");
                        user.hit(playingDeck.giveCard());
                        user.showHand();
                        if ((user.getValueOfDeck()) == 21 || (user.getValueOfDeck() > 21)) {
                            user.setContinueToPlayRound(Boolean.FALSE);
                            dealer.setContinueToPlayRound(Boolean.FALSE);
                        }
                        
                    }
                    //stops any player descisions for the round, leaving you with the same cards for the round end.
                    else if (response.equalsIgnoreCase("stay")) {
                        user.stay();
                        System.out.println("##YOU CHOOSE TO STAY##");
                        user.showHand();
                        user.setContinueToPlayRound(Boolean.FALSE);
                    }
                }
                //dealers conditionals for moves. 
                dealer.stay();
                if (dealer.getContinueToPlayRound()) {
                    dealer.hit(playingDeck.giveCard());
                    dealer.stay();
                    System.out.println("Dealer chooses to hit!\nThese are the dealer's new cards:");
                    dealer.showHand();
                    if (dealer.getValueOfDeck() > 21 || dealer.getValueOfDeck() == 21) {
                        dealer.setContinueToPlayRound(Boolean.FALSE);
                        user.setContinueToPlayRound(Boolean.FALSE);
                    }
                }
                //this only runs when the dealer is no longer playing the round, which happens when dealer.stay() succeeds.
                else if (dealer.getValueOfDeck() <= 21){
                    System.out.println("The dealer stays!");
                    dealer.showHand();
                }
                
                //if both players are no longr playing it begins the round-over portion that checks who won the round
                if (!(user.getContinueToPlayRound()) && !(dealer.getContinueToPlayRound())) {
                    System.out.println("ROUND OVER");
                    int u = user.getValueOfDeck();
                    int d = dealer.getValueOfDeck();                    
                    if (u > 21 && d > 21) {
                        System.out.println("No one wins!");
                    }
                    else if ((u == d) && (u <= 21)) {
                        System.out.println("ITS A TIE! Both of you get a point!");
                        scoreDealer++;
                        scoreUser++;
                    }
                    else if (u > 21) {
                        System.out.println("THE ROUND WINNER IS: " + this.dealerName);
                        System.out.println("YOU GOT MORE THAN 21! BUSTED!");
                        System.out.println("YOUR CARD POINT TOTAL: " + u + "\nTHE DEALER'S CARD POINT TOTAL: " + d);
                        scoreDealer++;
                    }
                    else if (d > 21) {
                        System.out.println("THE ROUND WINNER IS: " + this.userName);
                        System.out.println("DEALER GOT MORE THAN 21! BUSTED!");
                        System.out.println("YOUR CARD POINT TOTAL: " + u + "\nTHE DEALER'S CARD POINT TOTAL: " + d);
                        scoreUser++;
                    }
                    else if (d > u) {
                        System.out.println("THE ROUND WINNER IS: " + this.dealerName);
                        System.out.println("THE DEALER GOT MORE POINTS!");
                        System.out.println("YOUR CARD POINT TOTAL: " + u + "\nTHE DEALER'S CARD POINT TOTAL: " + d);
                        scoreDealer++;
                    }
                    else if (u > d) {
                        System.out.println("THE ROUND WINNER IS: " + this.userName);
                        System.out.println("YOU GOT MORE POINTS!");
                        System.out.println("YOUR CARD POINT TOTAL: " + u + "\nTHE DEALER'S CARD POINT TOTAL: " + d);
                        scoreUser++;
                    }
                    System.out.println("Round Win Score Is:\nYOUR SCORE: " + scoreUser + " DEALER SCORE: " + scoreDealer);
                }
            }
        }
    }
    
    //declares the winner between who got more round wins and ends the program by setting userPlaying to false.
    @Override
    public void declareWinner() {
        if (scoreUser > scoreDealer) {
            System.out.println("The winner is: " + userName);            
        }
        else if (scoreUser < scoreDealer) {
            System.out.println("The winner is: The Dealer!");
        }
        else {
            System.out.println("You and the Dealer have tied!");
        } 
        setUserPlaying(Boolean.FALSE);
    }
}