import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Add documentation to pass checkstyle

/**
 * Tests SlotMachine class
 * @author Suzanne Balik
 * @author Jake Patterson
 */
public class SlotMachineTest {

    /**
    * Slot machine
    */
    private SlotMachine sm;

    /**
    * sets up slot machine
    */
    @BeforeEach
    public void setUp() {
        sm = new SlotMachine(0);
    }

    /**
    * tests that required constant is defined and specified
    */
    @Test
    public void testConstant() {
        // The following test tests that required constant is defined as specified
        assertEquals(5, SlotMachine.BET_AMOUNT, "BET_AMOUNT");
    }

    /**
    * tests constructor
    */
    @Test
    public void testConstructor() {
      assertEquals(50, sm.getNumberOfTokens());
      assertEquals(0, sm.getCurrentIndexOfReel(0));
      assertEquals("Pull lever to begin", sm.getStatus());
        // write test case here. HINT: Use the getter methods of the SlotMachine
        // class to validate that the state of the SlotMachine is correct when it is
        // initially created.
    }

    /**
    * tests making a single bet
    */
    @Test
    public void testMakeBetSingleBet() {
        sm.makeBet();
        assertEquals(45, sm.getNumberOfTokens(), "Initial bet");
    }

    /**
    * tests making 3 bets
    */
    @Test
    public void testMakeBetThreeBets() {
        sm.makeBet();
        sm.makeBet();
        sm.makeBet();
        assertEquals(35, sm.getNumberOfTokens(), "Initial bet");
    }

    /**
    * Tests that exception is thrown for makeBet when no tokens are left
    */
    @Test
    public void testMakeBetException() {
        for (int i = 1; i <= 10; i++) {
            sm.makeBet();
        }

        Exception exception = assertThrows(IllegalStateException.class, () -> sm.makeBet(),
                                           "Not enough tokens for bet");
        assertEquals("Not enough tokens for bet", exception.getMessage(),
                     "Not enough tokens for bet - exception message");
    }

    /**
    * tests turning the reel once
    */
    @Test
    public void testTurnReelOnce() {
        sm.turnReel(); // Turns reel at index 0
        assertEquals(1, sm.getCurrentIndexOfReel(0), "Reel 0");
        assertEquals(0, sm.getCurrentIndexOfReel(1), "Reel 1");
        assertEquals(0, sm.getCurrentIndexOfReel(2), "Reel 2");
    }

    // Write test case here for additional turns. Test should be in its own
    // method.
    /**
    * tests determining outcome method
    */
    @Test
    public void testDetermineOutcomeOnce() {
        sm.determineOutcome();
        assertEquals(100, sm.getNumberOfTokens(), "Tokens");
        assertEquals("3 State Symbols! 50 Tokens!", sm.getStatus(), "Status");
    }

    /**
    * tests determining outcome twice method
    */
    @Test
    public void testDetermineOutcomeTwice() {
        sm.determineOutcome();
        sm.determineOutcome();
        assertEquals(175, sm.getNumberOfTokens(), "Tokens");
        assertEquals("3 Hearts! 125 Tokens!", sm.getStatus(), "Status");
        assertEquals(250, sm.getNumberOfTokens(), "Tokens");
        assertEquals("2 Sevens! 200 Tokens!", sm.getStatus(), "Status");
    }
}
