import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Program to test BankCalculator methods
 * @author Suzanne Balik
 * @author
 */
public class BankCalculatorTest {

    /** Used to compare double values in tests */
    public static final double DELTA = 0.005;

    /** tests calculate payment */
    @Test
    public void testCalculatePayment1() {

        assertEquals(64.24, BankCalculator.calculatePayment(2020,9,36), DELTA,
                     "BankCalculator.calculatePayment(2020,9,36)");
    }

    /** tests calculate payment */
    @Test
    public void testCalculatePayment2() {

        assertEquals(56.99, BankCalculator.calculatePayment(2380,7,48), DELTA,
                     "BankCalculator.calculatePayment(2380,7,48)");
    }

    /** tests calculate payment */
    @Test
    public void testCalculatePayment3() {

        assertEquals(2.96, BankCalculator.calculatePayment(146,8,60), DELTA,
                     "BankCalculator.calculatePayment(146,8,60)");
    }

    /** tests calculate payment */
    @Test
    public void testCalculatePayment4() {

        assertEquals(16.12, BankCalculator.calculatePayment(1001,5,72), DELTA,
                     "BankCalculator.calculatePayment(1001,5,72)");
    }

    /** tests calculate no compounding */
    @Test
    public void testCalculateAmountNoCompounding1() {

        assertEquals(215.04, BankCalculator.calculateAmountNoCompounding(192,3,4), DELTA,
                     "BankCalculator.calculateAmountNoCompounding(192,3,4)");
    }

    /** tests calculate no compounding */
    @Test
    public void testCalculateAmountNoCompounding2() {

        assertEquals(6390.00, BankCalculator.calculateAmountNoCompounding(4500,6,7), DELTA,
                     "BankCalculator.calculateAmountNoCompounding(4500,6,7)");
    }

    /** tests calculate no compounding */
    @Test
    public void testCalculateAmountNoCompounding3() {

        assertEquals(8418.36, BankCalculator.calculateAmountNoCompounding(6789,4,6), DELTA,
                     "BankCalculator.calculateAmountNoCompounding(6789,4,6)");
    }

    /** tests calculate no compounding */
    @Test
    public void testCalculateAmountNoCompounding4() {

        assertEquals(1789.30, BankCalculator.calculateAmountNoCompounding(1234,5,9), DELTA,
                     "BankCalculator.calculateAmountNoCompounding(1234,5,9)");
    }

    /** tests calculate monthly compounding */
    @Test
    public void testCalculateAmountMonthlyCompounding1() {

        assertEquals(152173.69, BankCalculator.calculateAmountMonthlyCompounding(56098,5,20), DELTA,
                     "BankCalculator.calculateAmountMonthlyCompounding(56098,5,20)");
    }

    /** tests calculate monthly compounding */
    @Test
    public void testCalculateAmountMonthlyCompounding2() {

        assertEquals(82947.45, BankCalculator.calculateAmountMonthlyCompounding(43454,13,5), DELTA,
                     "BankCalculator.calculateAmountMonthlyCompounding(43454,5,13)");
    }

    /** tests calculate monthly compounding */
    @Test
    public void testCalculateAmountMonthlyCompounding3() {

        assertEquals(38280.24, BankCalculator.calculateAmountMonthlyCompounding(27856,16,2), DELTA,
                     "BankCalculator.calculateAmountMonthlyCompounding(27856,2,16)");
    }

    /** tests calculate monthly compounding */
    @Test
    public void testCalculateAmountMonthlyCompounding4() {

        assertEquals(69774.68, BankCalculator.calculateAmountMonthlyCompounding(12345,25,7), DELTA,
                     "BankCalculator.calculateAmountMonthlyCompounding(12345,7,25)");
    }

    /** tests calculate continuous compounding */
    @Test
    public void testCalculateAmountContinuousCompounding1() {

        assertEquals(2875.68, BankCalculator.calculateAmountContinuousCompounding(2500,2,7), DELTA,
                     "BankCalculator.calculateAmountContinuousCompounding(2500,2,7)");
    }

    /** tests calculate continuous compounding */
    @Test
    public void testCalculateAmountContinuousCompounding2() {

        assertEquals(4115.36, BankCalculator.calculateAmountContinuousCompounding(3650,4,3), DELTA,
                     "BankCalculator.calculateAmountContinuousCompounding(3650,4,3)");
    }

    /** tests calculate continuous compounding */
    @Test
    public void testCalculateAmountContinuousCompounding3() {

        assertEquals(1776.31, BankCalculator.calculateAmountContinuousCompounding(1356,3,9), DELTA,
                     "BankCalculator.calculateAmountContinuousCompounding(1356,3,9)");
    }

    /** tests calculate continuous compounding */
    @Test
    public void testCalculateAmountContinuousCompounding4() {

        assertEquals(1595.07, BankCalculator.calculateAmountContinuousCompounding(987,6,8), DELTA,
                     "BankCalculator.calculateAmountContinuousCompounding(987,6,8)");
    }

    /**
     * Test the BankCalculator methods with invalid values
     */
    @Test
    public void testInvalidMethods() {

        // Invalid test cases are provided for you below - You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!

        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> BankCalculator.calculatePayment(0,2,10),
                                           "BankCalculator.calculatePayment(0,2,10)");
        assertEquals("Invalid loan amount", exception.getMessage(),
                     "Testing BankCalculator.calculatePayment(0,2,10) - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> BankCalculator.calculatePayment(5000,-2,10),
                                           "BankCalculator.calculatePayment(5000,-2,10)");
        assertEquals("Invalid interest rate", exception.getMessage(),
                     "Testing BankCalculator.calculatePayment(5000,-2,10) - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> BankCalculator.calculatePayment(1000,2,-1),
                                           "BankCalculator.calculatePayment(1000,2,-1)");
        assertEquals("Invalid number of months", exception.getMessage(),
                     "Testing BankCalculator.calculatePayment(1000,2,-1) - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> BankCalculator.calculateAmountNoCompounding(0,2,10),
                                           "BankCalculator.calculateAmountNoCompounding(0,2,10)");
        assertEquals("Invalid deposit amount", exception.getMessage(),
                     "Testing BankCalculator.calculateAmountNoCompounding(0,2,10)" +
                     " - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> BankCalculator.calculateAmountNoCompounding(5000,-2,10),
                    "BankCalculator.calculateAmountNoCompounding(5000,-2,10)");
        assertEquals("Invalid interest rate", exception.getMessage(),
                     "Testing BankCalculator.calculateAmountNoCompounding(5000,-2,10)" +
                     " - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> BankCalculator.calculateAmountNoCompounding(1000,2,-1),
                    "BankCalculator.calculateAmountNoCompounding(1000,2,-1)");
        assertEquals("Invalid number of years", exception.getMessage(),
                     "Testing BankCalculator.calculateAmountNoCompounding(1000,2,-1)" +
                     " - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> BankCalculator.calculateAmountMonthlyCompounding(0,2,10),
                    "BankCalculator.calculateAmountMonthlyCompounding(0,2,10)");
        assertEquals("Invalid deposit amount", exception.getMessage(),
                     "Testing BankCalculator.calculateAmountMonthlyCompounding(0,2,10)" +
                     " - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> BankCalculator.calculateAmountMonthlyCompounding(5000,-2,10),
                    "BankCalculator.calculateAmountMonthlyCompounding(5000,-2,10)");
        assertEquals("Invalid interest rate", exception.getMessage(),
                     "Testing BankCalculator.calculateAmountMonthlyCompounding(5000,-2,10)" +
                     " - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> BankCalculator.calculateAmountMonthlyCompounding(1000,2,-1),
                    "BankCalculator.calculateAmountMonthlyCompounding(1000,2,-1)");
        assertEquals("Invalid number of years", exception.getMessage(),
                     "Testing BankCalculator.calculateAmountMonthlyCompounding(1000,2,-1)" +
                     " - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> BankCalculator.calculateAmountContinuousCompounding(0,2,10),
                    "BankCalculator.calculateAmountContinuousCompounding(0,2,10)");
        assertEquals("Invalid deposit amount", exception.getMessage(),
                     "Testing BankCalculator.calculateAmountContinuousCompounding(0,2,10)" +
                     " - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> BankCalculator.calculateAmountContinuousCompounding(5000,-2,10),
                    "BankCalculator.calculateAmountContinuousCompounding(5000,-2,10)");
        assertEquals("Invalid interest rate", exception.getMessage(),
                     "Testing BankCalculator.calculateAmountContinuousCompounding(5000,-2,10)" +
                     " - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> BankCalculator.calculateAmountContinuousCompounding(1000,2,-1),
                    "BankCalculator.calculateAmountContinuousCompounding(1000,2,-1)");
        assertEquals("Invalid number of years", exception.getMessage(),
                     "Testing BankCalculator.calculateAmountContinuousCompounding(1000,2,-1)" +
                     " - exception message");




    }
}
