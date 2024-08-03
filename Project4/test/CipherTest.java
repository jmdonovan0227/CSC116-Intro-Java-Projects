import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Program to test Cipher methods
 *
 * @author Suzanne Balik
 * @author Jake Patterson
 */
public class CipherTest {


    /** Alphabet */
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    /** Alphabet reversed */
    public static final String ALPHABET_REVERSED = "zyxwvutsrqponmlkjihgfedcba";

    /** One uppercase word */
    public static final String UPPERCASE_WORD = "COMPUTER";

    /** One uppercase word shifted forward 2 with no wraparound */
    public static final String UPPERCASE_WORD_SHIFT_FORWARD_NO_WRAPAROUND = "EQORWVGT";

    /**
     * Test reversing null string
     */
    @Test
    public void testReverseLine0() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> Cipher.reverseLine(null),
                "line is null");
        assertEquals("Invalid line", exception.getMessage(),
                "line is null - exception message");
    }

    /**
     * Test reversing entire alphabet
     */
    @Test
    public void testReverseLine1() {
        String description = "Reverse Line 1: alphabet";
        String actual = Cipher.reverseLine(ALPHABET);
        assertEquals(ALPHABET_REVERSED, actual, description);
    }

    /**
     * Test reversing word hello
     */
    @Test
    public void testReverseLine2() {
        String description = "Reverse Line 2: hello";
        String actual = Cipher.reverseLine("hello");
        assertEquals("olleh", actual, description);
    }

    /**
     * Test reversing name Jacob
     */
    @Test
    public void testReverseLine3() {
        String description = "Reverse Line 3: Jacob";
        String actual = Cipher.reverseLine("Jacob");
        assertEquals("bocaJ", actual, description);
    }



    /**
     * Test shifting null string forward
     */
    @Test
    public void testShiftLineLettersForward0() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> Cipher.shiftLineLettersForward(null, 1),
                "line is null");
        assertEquals("Invalid line", exception.getMessage(),
                "line is null - exception message");
    }

    /**
     * Test shifting string forward with invalid shift amount
     */
    @Test
    public void testShiftLineLettersForward1() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> Cipher.shiftLineLettersForward(ALPHABET, -1),
                "shift amount is negative");
        assertEquals("Invalid amount", exception.getMessage(),
                "shift amount is negative - exception message");
    }

    /**
     * Test one shifting one word forward 2 with no wraparound
     */
    @Test
    public void testShiftLineLettersForward2() {
        String description = "Shift uppercase word forward 2 with no wraparound";
        String actual = Cipher.shiftLineLettersForward(UPPERCASE_WORD, 2);
        assertEquals(UPPERCASE_WORD_SHIFT_FORWARD_NO_WRAPAROUND, actual, description);
    }

    /**
     * Test one shifting one word forward 3 with no wraparound
     */
    @Test
    public void testShiftLineLettersForward3() {
        String description = "Shift  lower case word forward 3 with no wraparound";
        String actual = Cipher.shiftLineLettersForward("ki", 3);
        assertEquals("kl", actual, description);
    }

    /**
     * Test one shifting one word forward 4 with no wraparound
     */
    @Test
    public void testShiftLineLettersForward4() {
        String description = "Shift uppercase word forward 4 with no wraparound";
        String actual = Cipher.shiftLineLettersForward("BOAR", 4);
        assertEquals("FSEV", actual, description);
    }

    /**
     * Test one shifting one word forward 5 with no wraparound
     */
    @Test
    public void testShiftLineLettersForward5() {
        String description = "Shift lowercase word forward 5 with no wraparound";
        String actual = Cipher.shiftLineLettersForward("goku", 5);
        assertEquals("ltpz", actual, description);
    }

    /**
     * Test one shifting one word forward 6 with a wraparound
     */
    @Test
    public void testShiftLineLettersForward6() {
        String description = "Shift uppercase word forward 6 with a wraparound";
        String actual = Cipher.shiftLineLettersForward("MOVE", 6);
        assertEquals("SUBK", actual, description);
    }

    /**
     * Test one shifting one word forward 6 with a wraparound
     */
    @Test
    public void testShiftLineLettersForward7() {
        String description = "Shift uppercase word forward 7 with no wraparound";
        String actual = Cipher.shiftLineLettersForward("ABE", 7);
        assertEquals("HIL", actual, description);
    }

    /**
     * Test shifting null string backward
     */
    @Test
    public void testShiftLineLettersBackward0() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> Cipher.shiftLineLettersBackward(null, 1),
                "line is null");
        assertEquals("Invalid line", exception.getMessage(),
                "line is null - exception message");
    }

    /**
     * Test shifting string backward with invalid shift amount
     */
    @Test
    public void testShiftLineLettersBackward1() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> Cipher.shiftLineLettersBackward(ALPHABET, 26),
                "shift amount is negative");
        assertEquals("Invalid amount", exception.getMessage(),
                "shift amount is negative - exception message");
    }

    /**
     * Test one shifting one word backward
     */
    @Test
    public void testShiftLineLettersBackward2() {
        String description = "Shift uppercase word backward 2 with no wraparound";
        String actual = Cipher.shiftLineLettersBackward(UPPERCASE_WORD_SHIFT_FORWARD_NO_WRAPAROUND, 3);
        assertEquals(UPPERCASE_WORD, actual, description);
    }

    /**
     * Test two shifting one word backward
     */
    @Test
    public void testShiftLineLettersBackward3() {
        String description = "Shift lowercase word backward 3 with a wraparound";
        String actual = Cipher.shiftLineLettersBackward("bob", 3);
        assertEquals("yly", actual, description);
    }

    /**
     * Test three shifting one word backward
     */
    @Test
    public void testShiftLineLettersBackward4() {
        String description = "Shift uppercase word backward 4 with a wraparound";
        String actual = Cipher.shiftLineLettersBackward("JAKE", 4);
        assertEquals("FWGA", actual, description);
    }

    /**
     * Test four shifting one word backward
     */
    @Test
    public void testShiftLineLettersBackward5() {
        String description = "Shift lowercase word backward 5 with no wraparound";
        String actual = Cipher.shiftLineLettersBackward("foot", 5);
        assertEquals("ajjo", actual, description);
    }

    /**
     * Test five shifting one word backward
     */
    @Test
    public void testShiftLineLettersBackward6() {
        String description = "Shift uppercase word backward 6 with no wraparound";
        String actual = Cipher.shiftLineLettersBackward("TOM", 6);
        assertEquals("NKG", actual, description);
    }

    /**
     * Test six shifting one word backward
     */
    @Test
    public void testShiftLineLettersBackward7() {
        String description = "Shift uppercase word backward 7 with a wraparound";
        String actual = Cipher.shiftLineLettersBackward("BOO", 7);
        assertEquals("VKK", actual, description);
    }

    /**
     * Test seven shifting one word backward
     */
    @Test
    public void testShiftLineLettersBackward8() {
        String description = "Shift lowercase word backward 8 with a wraparound";
        String actual = Cipher.shiftLineLettersBackward("drag", 8);
        assertEquals("vjgy", actual, description);
    }
}
