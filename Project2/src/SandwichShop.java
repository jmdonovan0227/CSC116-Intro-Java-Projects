import java.util.Scanner;
/** Program takes userInput and determines totalCost and pickup time for a customer
* that is shopping at Wolfpack Sandwich Shop.
* @author Jake Patterson
*/

public class SandwichShop {
  public static final int CHICKEN_COST = 450;
  public static final int BURGER_COST = 475;
  public static final int VEGGIE_COST = 395;
  public static final int WATER_COST = 125;
  public static final int COFFEE_COST = 195;
  public static final int CSHAKE_COST = 255;

  /**
  * Starts Program
  * @param command line arguments
  */
  public static void main(String[] args){
    Scanner scnr = new Scanner(System.in);
    System.out.println("                 Welcome to the Wolfpack Sandwich Shop!");
    System.out.println("Orders must be placed between 11:00 AM and 6:59 PM on March 15 - May 31.");
    System.out.print("When prompted, please enter the time and date.");
    System.out.println(" You will then be asked to");
    System.out.println("enter the number of each sandwich/beverage you would like to purchase - ");
    System.out.println("Chicken Supreme, Burger Bonanza, Veggie Delite, Water, Coffee, Chocolate");
    System.out.println("Shake. Your order cost and estimated pickup time will then be output.");
    System.out.println();
    System.out.print("Please enter time (hour min, eg. 4 59): "); // time input
    int hour = scnr.nextInt();
    int min = scnr.nextInt();

    boolean time = isValidTime(hour, min); // checks hours and mins

    if(isValidTime(hour, min) == false){
      System.out.println("Invalid time");
      System.exit(1);
    }

    System.out.print("Please enter date (month day, eg. 3 25): "); // date input
    int month = scnr.nextInt();
    int day = scnr.nextInt();

    boolean date = isValidDate(month, day); // checks month and day

    if(isValidDate(month, day) == false){
      System.out.println("Invalid date");
      System.exit(1);
    }
    else {
    boolean weekDay = isWeekDay(month, day); // checks if input is valid and is a weekday.
  }

    System.out.println();

    System.out.println("Please enter the number of sandwich/beverage that you would like to purchase:");

    System.out.print("Chicken Supreme: ");
    int chickenI = scnr.nextInt();

    if (chickenI < 0){
      System.out.println("Invalid amount");
      System.exit(1);
    }

    System.out.print("Burger Bonanza: ");
    int burgerI = scnr.nextInt();

    if(burgerI < 0){
      System.out.println("Invalid amount");
      System.exit(1);
    }

    System.out.print("Veggie Delite: ");
    int veggieI = scnr.nextInt();

    if(veggieI < 0){
      System.out.println("Invalid amount");
      System.exit(1);
    }

    System.out.print("Water: ");
    int waterI = scnr.nextInt();

    if(waterI < 0){
      System.out.println("Invalid amount");
      System.exit(1);
    }

    System.out.print("Coffee: ");
    int coffeeI = scnr.nextInt();

    if(coffeeI < 0){
      System.out.println("Invalid amount");
      System.exit(1);
    }

    System.out.print("Chocolate Shake: ");
    int shakeI = scnr.nextInt();

    if(shakeI < 0){
      System.out.println("Invalid amount");
      System.exit(1);
    }

    int orderC = getOrderCost(chickenI, burgerI, veggieI, waterI, coffeeI, shakeI);
    String pickupT = getPickupTime(month, day, hour, min);

    System.out.println();

    double orderCFormat = orderC / 100.0;

    System.out.print("Cost of Order: $");
    System.out.printf("%.2f", orderCFormat);
    System.out.println();
    if(orderCFormat == 0){
      System.exit(1);
    }
      System.out.println("Estimated Pickup Time: " + pickupT);
    }
    /**
    * Checks if user has entered a valid time (between 11:00 AM and 6:59 PM).
    *@param hour and min, which are values recieved from user input.
    *@return isTrue, which is equal to true or false based on if the user's Time
    * is valid.
    */

  public static boolean isValidTime(int hour, int min){
    boolean isValidH = false;
    boolean isValidM = false;
    boolean isTrue = false;
      if(hour == 11 || hour == 12 || hour == 1 || hour == 2 || hour == 3){
        isValidH = true;
      }

      else if(hour == 4 || hour == 5 || hour == 6){
        isValidH = true;
      }

      else {
        isValidH = false;
      }

      if(min >= 0 && min <= 59){
        isValidM = true;
      }

      else {
        isValidM = false;
      }

      if(isValidH == true && isValidM == true){
        isTrue = true;
      }
      else {
        isTrue = false;
      }
      return isTrue;
    }
    /**
    * Checks if user has entered a valid date
    * @param month, day, which are the user entered month and day
    * @return isValidDate, which is true or false based on user input
    */
  public static boolean isValidDate(int month, int day){
    boolean isValidMonth = false;
    boolean isValidDay = false;
    boolean isValidDate = false;
    if(month >= 3 && month <= 5){
      isValidMonth = true;
    }
    else {
      isValidMonth = false;
      isValidDate = false;
    }
    if(month == 3 && (day >= 15 && day <= 31)){
      isValidMonth = true;
      isValidDay = true;
    }

    else if(month == 3 && !(day >= 15 && day <= 31)){
      isValidMonth = true;
      isValidDay = false;
    }

    if(month == 4 && (day > 0 && day <= 30)){
      isValidMonth = true;
      isValidDay = true;
    }
    else if (month == 4 && !(day >= 15 && day <= 30)){
      isValidMonth = true;
      isValidDay = false;
    }

    if(month == 5 && (day > 0 && day <= 31)){
      isValidMonth = true;
      isValidDay = true;
    }

    else if (month == 5 && !(day > 0 && day <= 31)){
      isValidMonth = true;
      isValidDay = false;
    }

    if(isValidMonth == true && isValidDay == true){
      isValidDate = true;
    }
    else if (isValidMonth == false || isValidDay == false){
      isValidDate = false;
    }
    return isValidDate;
    }
  /**
  * checks whether user date is a weekday
  * @param month, day, which are gained from user user user input
  * @return isWeekDay, which is true or false based on user input
  */
  public static boolean isWeekDay(int month, int day){
    boolean isWeekDay = false;
    int dayOfWeek = 0;

    if(isValidDate(month, day) == false){
      throw new IllegalArgumentException("Invalid date");
    }

    else if(isValidDate(month, day) == true){
    int year = 2021;
    int m = month;
    int d = day;

    int week = year - (14 - m) / 12;

    int x = week + week / 4 - week / 100 + week / 400;

    int z = m +  12 * ((14 - m) / 12) - 2;

    dayOfWeek = (d + x + (31 * z) / 12) % 7;
  }

  if(dayOfWeek == 1 || dayOfWeek == 2 || dayOfWeek == 3 || dayOfWeek == 4){
    isWeekDay = true;
  }
  else{
    isWeekDay = false;
  }
  return isWeekDay;
   }
   /**
   * gets order cost based on user input
   * @param chicken, burger, veggie, water, coffee, shake, which are gained from
   * user input
   * @return totalCost, which is the total cost of the user's items.
   */
public static int getOrderCost(int chicken, int burger, int veggie,
  int water, int coffee, int shake){
    int totalCost = 0;

    if(chicken < 0 || burger < 0 || veggie < 0){
      throw new IllegalArgumentException("Invalid amount");
    }
    else if(water < 0 || coffee < 0 || shake < 0){
      throw new IllegalArgumentException("Invalid amount");
    }
    else {
    int C = (chicken * CHICKEN_COST);
    int B = (burger * BURGER_COST);
    int V = (veggie * VEGGIE_COST);
    int W = (water * WATER_COST);
    int F = (coffee * COFFEE_COST);
    int S = (shake * CSHAKE_COST);
    totalCost = C + B + V + W + F + S;
    }
    return totalCost;
  }
  /**
  * checks whether user has entered a valid pickup time and returns the Time
  * if it is valid.
  * @param month, day, hour, min, which are gained from user input
  * @return convertH, convertM, colon, colon is a string, convertH and convertM
  * are integers that were changed to strings and returned to the program
  */
public static String getPickupTime(int month, int day, int hour, int min){
  int weekdayTime = 15;
  int weekendTime = 30;
  int convertHours = hour * 60;
  String convertH = "";
  String convertM = "";
  String colon = ":";
  if(isValidTime(hour, min) == false){
    throw new IllegalArgumentException("Invalid time");
  }

  if(isValidDate(month, day) == false){
    throw new IllegalArgumentException("Invalid date");
  }
  if (isValidDate(month, day) == true && isWeekDay(month, day) == true){
    hour = ((convertHours) + (min + weekdayTime)) / 60;
    min = ((convertHours) + (min + weekdayTime)) % 60;
    if(hour > 12){
      hour = hour - 12;
    }
    convertH = Integer.toString(hour);
    convertM = Integer.toString(min);
    if(min >= 0 && min <= 9){
      convertM = "0" + convertM;
    }
    if(hour == 7 || hour == 8 || hour == 9 || hour == 10){
      convertH = "Invalid pickup time";
      convertM = "";
      colon = "";
    }
  }

  if (isValidDate(month, day) == true && isWeekDay(month, day) == false){
    hour = ((convertHours) + (min + weekendTime)) / 60;
    min = ((convertHours) + (min + weekendTime)) % 60;
    if(hour > 12){
      hour = hour - 12;
    }
    convertH = Integer.toString(hour);
    convertM = Integer.toString(min);
    if(min >= 0 && min <= 9){
      convertM = "0" + convertM;
    }
    if(hour == 7 || hour == 8 || hour == 9 || hour == 10){
      convertH = "Invalid pickup time";
      convertM = "";
      colon = "";
    }
  }
  return convertH + colon + convertM;
  }
}
