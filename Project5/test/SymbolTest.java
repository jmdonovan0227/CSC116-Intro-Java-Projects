import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Add documentation to pass checkstyle

/**
 * Tests Symbol class
 * @author Suzanne Balik
 * @author Jake Patterson
 */
public class SymbolTest {

    /** Mr. Wuf symbol */
    private Symbol wuf;
    // Add another Symbol field

    /**
     * Creates fields before each test case is executed
     */
    @BeforeEach
    public void setUp() {
        wuf = new Symbol("Mr. Wuf", 100);
        // Construct added Symbol
    }

    /**
     * Test getName for Mr. Wuf
     */
    @Test
    public void testGetNameWuf() {
        assertEquals("Mr. Wuf", wuf.getName(), "Test getName for Mr. Wuf");
    }

    // Test getName for added Symbol. Test should be in its own method.

    /**
     * Test getValue for Mr. Wuf
     */
    @Test
    public void testGetValueWuf() {
        assertEquals(100, wuf.getValue(), "Test getValue for Mr. Wuf");
    }

    // Test getValue for added Symbol. Test should be in its own method.

    /**
     * Test toString for Mr. Wuf
     */
    @Test
    public void testToStringWuf() {
        assertEquals("Mr. Wuf 100", wuf.toString(), "Test toString for Mr. Wuf" );
    }

    // Test toString for added Symbol. Test should be in its own method.

    /**
     * Test equals for Mr. Wuf
     */
    @Test
    public void testEqualsWuf() {
        assertTrue(wuf.equals(wuf), "wuf equals with same instance");
        assertTrue(wuf.equals(new Symbol("Mr. Wuf", 100)), "wuf equals with different instances");
        assertFalse(wuf.equals(new Symbol("Mr. wuf", 100)), "wuf with different name");
        assertFalse(wuf.equals(new Symbol("Mr. Wuf", 101)), "wuf with different value");
        assertFalse(wuf.equals(new Symbol("Mr. wuf", 101)), "wuf with different name and value");
        assertFalse(wuf.equals(null), "wuf compared to null object");
        assertFalse(wuf.equals("Mr. Wuf"), "wuf compared to String");
    }

    // Test equals for added Symbol. Test should be in its own method.

}
