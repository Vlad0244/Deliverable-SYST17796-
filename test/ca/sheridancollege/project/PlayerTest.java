
package ca.sheridancollege.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Maryam
 */
public class PlayerTest {
    
    public PlayerTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }

    /**
     * Test of getName method, of class Player.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Player instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContinueToPlayRound method, of class Player.
     */
    @Test
    public void testGetContinueToPlayRound() {
        System.out.println("getContinueToPlayRound");
        Player instance = null;
        boolean expResult = false;
        boolean result = instance.getContinueToPlayRound();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContinueToPlayRound method, of class Player.
     */
    @Test
    public void testSetContinueToPlayRound() {
        System.out.println("setContinueToPlayRound");
        boolean bool = false;
        Player instance = null;
        instance.setContinueToPlayRound(bool);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Player.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Player instance = null;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hit method, of class Player.
     */
    @Test
    public void testHit() {
        System.out.println("hit");
        Card card = null;
        Player instance = null;
        instance.hit(card);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnAllCards method, of class Player.
     */
    @Test
    public void testReturnAllCards() {
        System.out.println("returnAllCards");
        Player instance = null;
        instance.returnAllCards();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueOfDeck method, of class Player.
     */
    @Test
    public void testGetValueOfDeck() {
        System.out.println("getValueOfDeck");
        Player instance = null;
        int expResult = 0;
        int result = instance.getValueOfDeck();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stay method, of class Player.
     */
    @Test
    public void testStay() {
        System.out.println("stay");
        Player instance = null;
        instance.stay();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showHand method, of class Player.
     */
    @Test
    public void testShowHand() {
        System.out.println("showHand");
        Player instance = null;
        instance.showHand();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class PlayerImpl extends Player {

        public PlayerImpl() {
            super("");
        }

        public void stay() {
        }

        public void showHand() {
        }
    }
    
}
