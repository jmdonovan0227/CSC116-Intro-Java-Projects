import java.util.Scanner;

/**
* This program takes user input values and is able to calculate and output
* a table of monthly payment amounts for loans based on loan amounts, interest
* rate, and term of loan.
* This program can also calculate and output a table of final amounts for deposits
* based on deposit amount, interest rate, and whether the interest is compounded,
* not compounded, compounded monthly, or continuously compounded.
* @author Jake Patterson
*/

public class BankCalculator {

    /**
    * variable is equal to one year = 12 months
    */
    public static final int ONE_YEAR = 12;

    /**
    * variable is equal to two years = 24 months
    */
    public static final int TWO_YEARS = 24;

    /**
    * variable is equal to three years = 36 months
    */
    public static final int THREE_YEARS = 36;

    /**
    * variable is equal to four years = 48 months
    */
    public static final int FOUR_YEARS = 48;

    /**
    * variable is equal to five years = 60 months
    */
    public static final int FIVE_YEARS = 60;

    /**
    * variable is equal to six years = 72 months
    */
    public static final int SIX_YEARS = 72;

    /**
    * Starts the program
    * @param args command line arguments
    */
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        String minRate = ""; // min interest rate(string)
        String maxRate = ""; // max interest rate (string)
        String l = ""; // Loan amount
        int loanP = 0; // Going to be integer version of String L
        int rate1 = 0; // minRate in int form
        int rate2 = 0; // maxRate in int form
        String t = ""; // number of years (term)
        int year = 0; // number of years (int form)
        String p = ""; // deposit amount
        int deposit = 0; // int version of string P

        Boolean isValidRate1 = false;
        Boolean isValidRate2 = false;
        Boolean isValidYear = false;
        Boolean isDigit1 = false;
        Boolean isDigit2 = false;

        System.out.println("Bank Calulator - Please choose an option.");
        System.out.println();
        System.out.println("L - Loan");
        System.out.println("D - Deposit");
        System.out.println("Q - Quit");
        System.out.println();

        System.out.print("Option: ");
        String option = scan.next().substring(0).toUpperCase();
        String checker = option.substring(0, 1);


        if(!(checker.equals(option))){
            System.out.println("Invalid option");
            System.out.println();
            main(null);
        }

        if(!(option.equals("L")) && !(option.equals("D")) && !(option.equals("Q"))){
            System.out.println("Invalid option");
            System.out.println();
            main(null);
        }

        while(option.equals("Q")){ // If user enters Q, program exits
            System.exit(1);
        }


        // Statements below are triggered if user enters the letter L (single letter)

        if(option.equals("L")){
            System.out.print("Amount: ");
            l = scan.next();

            for(int i = 0; i < l.length(); i++){
                if(Character.isDigit(l.charAt(i))){
                    isDigit1 = true;
                }
                else if(!Character.isDigit(l.charAt(i))){
                    isDigit1 = false;
                    System.out.println("Invalid amount");
                    System.out.println();
                    main(null);
                }
            }

            if(isDigit1 == true){
                loanP = Integer.parseInt(l);
            }

            if(loanP <= 0){
                System.out.println("Invalid value");
                System.out.println();
                main(null);
            }

            if(option.equals("L") && loanP > 0){
                System.out.print("Minimum interest rate: ");
                minRate = scan.next();
            }

            for(int j = 0; j < minRate.length(); j++){
                if(Character.isDigit(minRate.charAt(j))){
                    isValidRate1 = true;
                }
                else if(!Character.isDigit(minRate.charAt(j))){
                    isValidRate1 = false;
                    System.out.println("Invalid amount");
                    System.out.println();
                    main(null);
                }
            }

            if(isValidRate1 == true){
                rate1 = Integer.parseInt(minRate);
            }

            if(rate1 <= 0){
                System.out.println("Invalid value");
                System.out.println();
                main(null);
            }

            if(option.equals("L") && rate1 > 0){
                System.out.print("Maximum interest rate: ");
                maxRate = scan.next();
            }

            for(int k = 0; k < maxRate.length(); k++){
                if(Character.isDigit(maxRate.charAt(k))){
                    isValidRate2 = true;
                }
                else if(!Character.isDigit(maxRate.charAt(k))){
                    isValidRate2 = false;
                    System.out.println("Invalid amount");
                    System.out.println();
                    main(null);
                }
            }
            if(isValidRate2 == true){
                rate2 = Integer.parseInt(maxRate);
            }

            if(rate2 <= 0){
                System.out.println("Invalid value");
                System.out.println();
                main(null);
            }
            if(rate2 < rate1){
                System.out.println("Invalid value");
                System.out.println();
                main(null);
            }
            System.out.println();
            System.out.println("                     Monthly Payment");
            System.out.println();
            System.out.print("Interest  " + "12 mos  " + "24 mos  " + "36 mos" + "  48 mos  ");
            System.out.println("60 mos" + "  72 mos");
            System.out.print("--------" + "  ------" + "  ------" + "  ------" + "  ------");
            System.out.println("  ------" + "  ------");

            for(int i = rate1; i <= rate2; i++){
                System.out.printf("%4d%%" +  "%11.2f" + "%8.2f" + "%8.2f" +
                    "%8.2f" +   "%8.2f" +   "%8.2f\n", i, calculatePayment(loanP, i, ONE_YEAR),
                    calculatePayment(loanP, i, TWO_YEARS), calculatePayment(loanP, i, THREE_YEARS),
                    calculatePayment(loanP, i, FOUR_YEARS), calculatePayment(loanP, i, FIVE_YEARS),
                    calculatePayment(loanP, i, SIX_YEARS));
            }
            System.out.println();
            main(null);
        }


        // Statements below are triggered if user enters the letter D (single letter)

        if(option.equals("D")){
            System.out.print("Amount: ");
            p = scan.next();

            for(int i = 0; i < p.length(); i++){
                if(Character.isDigit(p.charAt(i))){
                    isDigit2 = true;
                }
                else if(!Character.isDigit(p.charAt(i))){
                    isDigit2 = false;
                    System.out.println("Invalid amount");
                    System.out.println();
                    main(null);
                }
            }

            if(isDigit2 == true){
                deposit = Integer.parseInt(p);
            }

            if(deposit <= 0){
                System.out.println("Invalid value");
                System.out.println();
                main(null);
            }

            if (option.equals("D") && deposit > 0){
                System.out.print("Years: ");
                t = scan.next();
            }

            for(int i = 0; i < t.length(); i++){
                if(Character.isDigit(t.charAt(i))){
                    isValidYear = true;
                }
                else if(!Character.isDigit(t.charAt(i))){
                    isValidYear = false;
                    System.out.println("Invalid amount");
                    System.out.println();
                    main(null);
                }
            }

            if(isValidYear == true){
                year = Integer.parseInt(t);
            }

            if(year <= 0){
                System.out.println("Invalid years");
                System.out.println();
                main(null);
            }

            if (option.equals("D") && year > 0){
                System.out.print("Minimum interest rate: ");
                minRate = scan.next();
            }

            for(int j = 0; j < minRate.length(); j++){
                if(Character.isDigit(minRate.charAt(j))){
                    isValidRate1 = true;
                }
                else if(!Character.isDigit(minRate.charAt(j))){
                    isValidRate1 = false;
                    System.out.println("Invalid amount");
                    System.out.println();
                    main(null);
                }
            }

            if(isValidRate1 == true){
                rate1 = Integer.parseInt(minRate);
            }

            if(rate1 <= 0){
                System.out.println("Invalid value");
                System.out.println();
                main(null);
            }

            if(option.equals("D") && rate1 > 0){
                System.out.print("Maximum interest rate: ");
                maxRate = scan.next();
            }

            for(int k = 0; k < maxRate.length(); k++){
                if(Character.isDigit(maxRate.charAt(k))){
                    isValidRate2 = true;
                }
                else if(!Character.isDigit(maxRate.charAt(k))){
                    isValidRate2 = false;
                    System.out.println("Invalid amount");
                    System.out.println();
                    main(null);
                }
            }
            if(isValidRate2 == true){
                rate2 = Integer.parseInt(maxRate);
            }

            if(rate2 <= 0){
                System.out.println("Invalid value");
                System.out.println();
                main(null);
            }

            if(rate2 < rate1){
                System.out.println("Invalid value");
                System.out.println();
                main(null);
            }
            System.out.println();
            System.out.println("                  Final Amount");
            System.out.println();
            System.out.println("          " + "    No     " + "    Monthly" + "     Continuous");
            System.out.println("Interest  " + "Compounding" + "  Compounding" + "  Compounding");
            System.out.println("--------  " + "-----------" + "  -----------" + "  -----------");

            for(int i = rate1; i <= rate2; i++){
                System.out.printf("%4d%%" +  "%16.2f" + "%13.2f" + "%13.2f\n", i,
                    calculateAmountNoCompounding(deposit, i, year),
                    calculateAmountMonthlyCompounding(deposit, i, year),
                    calculateAmountContinuousCompounding(deposit, i, year));
            }
            System.out.println();
            main(null);
        // add another conditional to trigger next method here.
        }
    }

  /**
  * This method calculates payment
  * @param loanAmount loan amount
  * @param annualInterestRate annual interest rate
  * @param numberOfMonths number of months
  * @return totalPay total payment
  * @throws IllegalArgumentException if loanAmount <= 0
  * @throws IllegalArgumentException if annualInterestRate <= 0
  * @throws IllegalArgumentException if numberOfMonths <= 0
  */
    public static double calculatePayment(int loanAmount,
                                        int annualInterestRate,
                                        int numberOfMonths) {
        if(loanAmount <= 0){
            throw new IllegalArgumentException("Invalid loan amount");
        }

        if(annualInterestRate <= 0){
            throw new IllegalArgumentException("Invalid interest rate");
        }

        if(numberOfMonths <= 0){
            throw new IllegalArgumentException("Invalid number of months");
        }
        double l = (double)loanAmount;
        double c = (double)annualInterestRate;
        double n = (double)numberOfMonths;
        final double oneYear = 12;
        double x = c / (100.0 * oneYear);
        double totalPay = l * ((x * Math.pow((1 + x), n)) / (Math.pow((1 + x), n) - 1));

        return totalPay;
    }

  /**
  * This method calculates amount with no compounding
  * @param depositAmount deposit amount
  * @param annualInterestRate annual interest rate
  * @param numberOfYears number of years
  * @return totalComp total compounding
  * @throws IllegalArgumentException if depositAmounts <= 0
  * @throws IllegalArgumentException if annualInterestRate <= 0
  * @throws IllegalArgumentException if numberOfYears <= 0
  */
    public static double calculateAmountNoCompounding(int depositAmount,
                                                    int annualInterestRate,
                                                    int numberOfYears) {

        if(depositAmount <= 0){
            throw new IllegalArgumentException("Invalid deposit amount");
        }

        if(annualInterestRate <= 0){
            throw new IllegalArgumentException("Invalid interest rate");
        }

        if(numberOfYears <= 0){
            throw new IllegalArgumentException("Invalid number of years");
        }
        double p = (double)depositAmount;
        double r = (double)(annualInterestRate);
        double rate = (r / 100.0);
        double t = (double)numberOfYears;
        double totalComp = p * (1 + rate * t);

        return totalComp;
    }

  /**
  * This method calculates amount with monthly compounding
  * @param depositAmount deposit amount
  * @param annualInterestRate annual interest rate
  * @param numberOfYears number of years
  * @return aMonthly monthly compounding total cost
  * @throws IllegalArgumentException if depositAmounts <= 0
  * @throws IllegalArgumentException if annualInterestRate <= 0
  * @throws IllegalArgumentException if numberOfYears <= 0
  */
    public static double calculateAmountMonthlyCompounding(int depositAmount,
                                                         int annualInterestRate,
                                                         int numberOfYears) {
        if(depositAmount <= 0){
            throw new IllegalArgumentException("Invalid deposit amount");
        }

        if(annualInterestRate <= 0){
            throw new IllegalArgumentException("Invalid interest rate");
        }

        if(numberOfYears <= 0){
            throw new IllegalArgumentException("Invalid number of years");
        }
        double p = (double)depositAmount;
        double r = (double)annualInterestRate;
        double rate = (r / 100.0);
        double t = (double)numberOfYears;
        final double comp = 12.0;
        double aMonthly = p * Math.pow(1 + rate / comp, comp * t);
        return aMonthly;
    }

 /**
 * This method returns amount with continuous compounding
 * @param depositAmount deposit amount
 * @param annualInterestRate annual interest rate
 * @param numberOfYears number of years
 * @return totalConC total amount with continuous compounding
 * @throws IllegalArgumentException if depositAmounts <= 0
 * @throws IllegalArgumentException if annualInterestRate <= 0
 * @throws IllegalArgumentException if numberOfYears <= 0
 */
    public static double calculateAmountContinuousCompounding(int depositAmount,
                                                          int annualInterestRate,
                                                          int numberOfYears) {
        if(depositAmount <= 0){
            throw new IllegalArgumentException("Invalid deposit amount");
        }

        if(annualInterestRate <= 0){
            throw new IllegalArgumentException("Invalid interest rate");
        }

        if(numberOfYears <= 0){
            throw new IllegalArgumentException("Invalid number of years");
        }
        double p = (double)depositAmount;
        double r = (double)annualInterestRate;
        double t = (double)numberOfYears;
        double rate = (r / 100.0);
        double totalConC = p * Math.exp(rate * t);

        return totalConC;
    }
}
