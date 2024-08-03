import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Program to test SandwichShop methods
 * @author Suzanne Balik
 * @author Michelle Glatz
 * @author
 */
public class SandwichShopTest {

    /**
    * tests isValidTime
    */
    @Test
    public void testIsValidTimeAfternoonValid() {

        assertTrue(SandwichShop.isValidTime(2, 20), "SandwichShop.isValidTime(2, 20)");

    }
    /**
    * tests isValidTime
    */
    @Test
    public void testIsValidTimeEveningInvalid() {

        assertFalse(SandwichShop.isValidTime(7, 4), "SandwichShop.isValidTime(7, 4)");

    }

    /**
    * tests isValidTime
    */
    @Test
    public void testIsValidTimeMorningBorderValid() {

        assertTrue(SandwichShop.isValidTime(11, 15), "SandwichShop.isValidTime(11, 15)");

    }
    /**
    * tests isValidTime
    */
    @Test
    public void testIsValidTimeMorningBorderInvalid() {

      assertFalse(SandwichShop.isValidTime(10, 30), "SandwichShop.isValidTime(10, 30)");

    }
    /**
    * tests isValidTime
    */
    @Test
    public void testIsValidTimeNegativeMinute() {

      assertFalse(SandwichShop.isValidTime(1, -15), "SandwichShop.isValidTime(1, -15)");


    }

    /**
    * tests isValidDate
    */
    @Test
    public void testIsValidDateMarchValid() {

        assertTrue(SandwichShop.isValidDate(3, 20), "SandwichShop.isValidDate(3, 20)");

    }
    /**
    * tests isValidDate
    */
    @Test
    public void testIsValidDateDecember() {

        assertFalse(SandwichShop.isValidDate(12, 4), "SandwichShop.isValidDate(12, 4)");

    }

    /**
    * tests isValidDate
    */
    @Test
    public void testIsValidDateMarchInvalid() {

      assertFalse(SandwichShop.isValidDate(3, 14), "SandwichShop.isValidDate(3, 14)");

    }
    /**
    * tests isValidDate
    */
    @Test
    public void testIsValidDateMayBorderValid() {

      assertTrue(SandwichShop.isValidDate(5, 31), "SandwichShop.isValidDate(5, 31)");


    }
    /**
    * tests isValidDate
    */
    @Test
    public void testIsValidDateAprilInvalidDay() {

    assertFalse(SandwichShop.isValidDate(4, 31), "SandwichShop.isValidDate(4, 31)");

    }
    /**
    * tests isWeekDay
    */
    @Test
    public void testIsWeekDayMayThursday() {

        assertTrue(SandwichShop.isWeekDay(5, 6), "SandwichShop.isWeekday(5, 6)");

    }
    /**
    * tests isWeekDay
    */
    @Test
    public void testIsWeekDayMarchSaturday() {

        assertFalse(SandwichShop.isWeekDay(3, 27), "SandwichShop.isWeekday(3, 27)");

    }

    /**
    * tests isWeekDay
    */
    @Test
    public void testIsWeekdayAprilFriday() {
      assertFalse(SandwichShop.isWeekDay(3, 26), "SandwichShop.isWeekday(3, 26)");
    }
    /**
    * tests isWeekDay
    */
    @Test
    public void testIsWeekdayAprilMonday() {

      assertTrue(SandwichShop.isWeekDay(4, 5), "SandwichShop.isWeekday(4, 5)");


    }
    /**
    * tests isWeekDay
    */
    @Test
    public void testIsWeekdayMaySundayValid() {

      assertFalse(SandwichShop.isWeekDay(5, 9), "SandwichShop.isWeekday(5, 9)");


    }
    /**
    * tests getOrderCost
    */
    @Test
    public void testGetOrderCostOneChicken() {
        assertEquals(450, SandwichShop.getOrderCost(1, 0, 0, 0, 0, 0),
                     "SandwichShop.getOrderCost(1, 0, 0, 0, 0, 0)");

    }

    /**
    * tests getOrderCost
    */
    @Test
    public void testGetOrderCostTwoBurgers() {
      assertEquals(950, SandwichShop.getOrderCost(0, 2, 0, 0, 0, 0),
                   "SandwichShop.getOrderCost(0, 2, 0, 0, 0, 0)");
    }
    /**
    * tests getOrderCost
    */
    @Test
    public void testGetOrderCostOneVeggieOneWater() {

      assertEquals(520, SandwichShop.getOrderCost(0, 0, 1, 1, 0, 0),
                   "SandwichShop.getOrderCost(0, 0, 0, 1, 1, 0)");

    }
    /**
    * tests getOrderCost
    */
    @Test
    public void testGetOrderCostThreeCoffees() {

      assertEquals(585, SandwichShop.getOrderCost(0, 0, 0, 0, 3, 0),
                   "SandwichShop.getOrderCost(0, 0, 0, 0, 3, 0)");

    }

    /**
    * tests getOrderCost
    */
    @Test
    public void testGetOrderCostOneShake() {

      assertEquals(255, SandwichShop.getOrderCost(0, 0, 0, 0, 0, 1),
                   "SandwichShop.getOrderCost(0, 0, 0, 0, 0, 1)");

    }
    /**
    * tests getOrderCost
    */
    @Test
    public void testGetOrderCostNothing() {

      assertEquals(0, SandwichShop.getOrderCost(0, 0, 0, 0, 0, 0),
                   "SandwichShop.getOrderCost(0, 0, 0, 0, 0, 0)");

    }
    /**
    * tests getOrderCost
    */
    @Test
    public void testGetOrderCostOneOfEverything() {

      assertEquals(1895, SandwichShop.getOrderCost(1, 1, 1, 1, 1, 1),
                   "SandwichShop.getOrderCost(1, 1, 1, 1, 1, 1)");

    }
    /**
    * tests getPickupTime
    */
    @Test
    public void testGetPickupTimeWeekdayEvening() {

        assertEquals("6:20", SandwichShop.getPickupTime(3, 23, 6, 5),
                     "SandwichShop.getPickupTime(3, 23, 6, 5)");

    }

    /**
    * tests getPickupTime
    */
    @Test
    public void testGetPickupTimeWeekdayLatestOrderTime() {

      assertEquals("6:59", SandwichShop.getPickupTime(3, 15, 6, 44),
                   "SandwichShop.getPickupTime(3, 15, 6, 44)");

    }
    /**
    * tests getPickupTime
    */
    @Test
    public void testGetPickupTimeWeekendTwelveThirtyOrderTime() {

      assertEquals("1:00", SandwichShop.getPickupTime(5, 8, 12, 30),
                   "SandwichShop.getPickupTime(5, 8, 12, 30)");

    }
    /**
    * tests getPickupTime
    */
    @Test
    public void testGetPickupTimeWeekendMorning() {

      assertEquals("11:45", SandwichShop.getPickupTime(5, 16, 11, 15),
                   "SandwichShop.getPickupTime(5, 16, 11, 15)");

    }

    /**
    * tests getPickupTime
    */
    @Test
    public void testGetPickupTimeWeekdayTwoFiftyTwoOrderTime() {

      assertEquals("3:07", SandwichShop.getPickupTime(4, 5, 2, 52),
                   "SandwichShop.getPickupTime(3, 23, 6, 5)");

    }
    /**
    * tests getPickupTime
    */
    @Test
    public void testGetPickupTimeWeekendSixThirtyOrderTime() {

      assertEquals("Invalid pickup time", SandwichShop.getPickupTime(4, 10, 6, 30),
                   "SandwichShop.getPickupTime(4, 10, 6, 30)");

    }


    /**
     * Test the SandwichShop methods with invalid values
     */
    @Test
    public void testInvalidMethods() {

        // Invalid test cases are provided for you below - You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!

        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> SandwichShop.isWeekDay(2, 27),
                                 "SandwichShop.isWeekday(2, 27)");
        assertEquals("Invalid date", exception.getMessage(),
                     "Testing SandwichShop.isWeekday(2, 27) - " +
                     "exception message");
        exception = assertThrows(IllegalArgumentException.class,
            () -> SandwichShop.getOrderCost(-1, 2, 3, 4, 0, 1),
                                           "SandwichShop.getOrderCost(-1, 2, 3, 4, 0, 1)");
        assertEquals("Invalid amount", exception.getMessage(),
                     "Testing SandwichShop.getOrderCost(-1, 2, 3, 4, 0, 1) - exception message");


        exception = assertThrows(IllegalArgumentException.class,
            () -> SandwichShop.getOrderCost(2, -2, 3, 4, 0, 1),
                                 "SandwichShop.getOrderCost(2, -2, 3, 4, 0, 1)");
        assertEquals("Invalid amount", exception.getMessage(),
                     "Testing SandwichShop.getOrderCost(2, -2, 3, 4, 0, 1) - exception message");


        exception = assertThrows(IllegalArgumentException.class,
            () -> SandwichShop.getOrderCost(0, 2, -3, 4, 0, 1),
                                 "SandwichShop.getOrderCost(0, 2, -3, 4, 0, 1)");
        assertEquals("Invalid amount", exception.getMessage(),
                     "Testing SandwichShop.getOrderCost(0, 2, -3, 4, 0, 1) - exception message");


        exception = assertThrows(IllegalArgumentException.class,
            () -> SandwichShop.getOrderCost(1, 2, 3, -3, 0, 1),
                                 "SandwichShop.getOrderCost(1, 2, 3, -3, 0, 1)");
        assertEquals("Invalid amount", exception.getMessage(),
                     "Testing SandwichShop.getOrderCost(1, 2, 3, -3, 0, 1) - " +
                     "exception message");


        exception = assertThrows(IllegalArgumentException.class,
            () -> SandwichShop.getOrderCost(1, 2, 3, 4, -1, 1),
                                 "SandwichShop.getOrderCost(1, 2, 3, 4, -1, 1)");
        assertEquals("Invalid amount", exception.getMessage(),
                     "Testing SandwichShop.getOrderCost(1, 2, 3, 4, -1, 1) - " +
                     "exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> SandwichShop.getOrderCost(1, 2, 3, 4, 1, -3),
                                 "SandwichShop.getOrderCost(1, 2, 3, 4, 1, -3)");
        assertEquals("Invalid amount", exception.getMessage(),
                     "Testing SandwichShop.getOrderCost(1, 2, 3, 4, 1, -3) - " +
                     "exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> SandwichShop.getPickupTime(1, 15, 3, 20),
                                 "SandwichShop.getPickupTime(1, 15, 3, 20)");
        assertEquals("Invalid date", exception.getMessage(),
                     "Testing SandwichShop.getPickupTime(1, 15, 3, 20) - " +
                     "exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> SandwichShop.getPickupTime(4, 10, 8, 30),
                                 "SandwichShop.getPickupTime(4, 10, 8, 30)");
        assertEquals("Invalid time", exception.getMessage(),
                     "Testing SandwichShop.getPickupTime(4, 10, 8, 30) - " +
                     "exception message");


    }
}
