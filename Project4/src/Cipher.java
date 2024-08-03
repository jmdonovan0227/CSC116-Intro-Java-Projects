import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

/**
* A program that uses various operations to encrypt and decrypt files.
* @author Jake Patterson.
*/
public class Cipher {

    /**
    * Number of letters in the alphabet
    */
    public static final int NUM_LETTERS = 26;

    /**
    * Number 25
    */
    public static final int TWENTY_FIVE = 25;

    /**
    * Number 1
    */
    public static final int ONE = 1;

    /**
    * Starts the Program.
    * @param args command line arguments.
    */
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        String inputFileScanner = ""; // input file scanner result from method
        String inputFile = ""; // input file
        String outputFile = ""; // output file
        String option = ""; // input whether the user wants to overwrite the file or not
        String result = ""; // result from userinterface

        if(args.length != 2){ // checks if there is two arguments in command line.
            System.out.println("Usage: -cp bin Cipher infile outfile");
            System.exit(1);
        }
        if(args.length == 2){ // assigns files to input and output
            inputFile = args[0];
            outputFile = args[1];
        }

        Path inputFilePath = Path.of(inputFile); // checks path of input file
        Path outputFilePath = Path.of(outputFile); // checks path of output file

        if(Files.exists(inputFilePath)){ // passes input file to process input files method
            processInputFile(inputFile); // get result of method
        }

        if(!Files.exists(inputFilePath)){ // if no input file exit
            System.out.print("No input file");
            System.exit(1);
        }

        if(Files.exists(outputFilePath)){
            System.out.println();
            System.out.print("test-files/" + outputFile + " exists - OK to overwrite (y,n): ");
            option = scan.next().substring(0).toUpperCase();
        }

        if(!Files.exists(outputFilePath)){
            System.out.println("No output file");
            System.exit(1);
        }

        if(option.equals("Y")){ // if user wishes to overwrite file, call userInterface method
            result = userInterface();
            processFile(result, processInputFile(inputFile), outputFile);
        }

        if(option.equals("N")){ // is user says no, exit program
            System.exit(1);
        }

    }

    /**
    * processes input file
    * @param inputFile the input file
    * @return result a scanner
    */
    public static Scanner processInputFile(String inputFile){
        Scanner result = null;
        while(result == null){
            try {
                FileInputStream openInputFile = new FileInputStream(inputFile);
                result = new Scanner(openInputFile);
            }
            catch (FileNotFoundException e){
                System.out.println("Cannot process input file");
                System.exit(1);
            }
        }
        return result;
    }

    /**
    * handles user userinterface
    * @return type the user's option
    */
    public static String userInterface(){
        Scanner scnr = new Scanner(System.in);
        System.out.println();
        System.out.println("Cipher - Please enter an operation below.");
        System.out.println();
        System.out.println("R - Reverse all lines");
        System.out.println("F - Shift all letters forwards");
        System.out.println("B - Shift all letters backward");
        System.out.println("Q - Quit");
        System.out.println();
        System.out.print("Operation: ");
        String type = scnr.next().substring(0, 1).toUpperCase();
        String checker = type.substring(0, 1);

        if(type.equals("Q")){
            System.exit(1);
        }

        if(!type.equals("R") && !type.equals("F")
            && !type.equals("B") && !type.equals("Q") || !checker.equals(type)){
            System.out.println("Invalid operation");
        }
        return type;
    }

    /**
    * processes file
    * @param option the user's selected option
    * @param input the information from the input file scanner
    * @param outputFile the output file as a String
    */
    public static void processFile(String option, Scanner input, String outputFile){
        Scanner a = new Scanner(System.in);
        PrintWriter writeToFile = null;
        String bob = ""; // amount to shift as String
        int amount = 0; // amount to shift as int
        String line = "";
        try {
            FileOutputStream openOutput = new FileOutputStream(outputFile);
            writeToFile = new PrintWriter(openOutput);
        }
        catch (FileNotFoundException e){
            System.out.println("Cannot process files");
            System.exit(1);
        }
        if(option.equals("R")){
            while(input.hasNextLine()){
                line = input.nextLine();
                String reverse = reverseLine(line);
                writeToFile.print(reverse);
            }
            input.close();
            writeToFile.close();
        }
        if(option.equals("F")){
            System.out.print("Amount: ");
            bob = a.next();
            for(int i = 0; i < bob.length(); i++){
                if(Character.isDigit(bob.charAt(i))){
                    amount = Integer.parseInt(bob);
                }
                if(!Character.isDigit(bob.charAt(i))){
                    System.out.println("Invalid amount");
                    System.exit(1);
                }
            }
            while(input.hasNextLine()){
                line = input.nextLine();
                shiftLineLettersForward(line, amount);
                writeToFile.print(shiftLineLettersForward(line, amount));
            }

            writeToFile.close();
        }
        if(option.equals("B")){
            System.out.print("Amount: ");
            bob = a.next();
            for(int i = 0; i < bob.length(); i++){
                if(Character.isDigit(bob.charAt(i))){
                    amount = Integer.parseInt(bob);
                }
                if(!Character.isDigit(bob.charAt(0))){
                    System.out.println("Invalid amount");
                    System.exit(1);
                }
            }
            while(input.hasNextLine()){
                line = input.nextLine();
                shiftLineLettersBackward(line, amount);
            }
            input.close();
        }
    }

    //Throws an IllegalArgumentException with the message "Invalid line"
    //if line is null
    //Creates and returns a copy of the String line with the characters in the reverse order
    /**
    * Reverses Line.
    * @param line userInput String.
    * @return reverse the reverse version of the line parameter.
    */
    public static String reverseLine(String line) {
        String rLine = ""; // reverse line
        if(line == null){
            throw new IllegalArgumentException("Invalid line");
        }
        for(int i = line.length() - 1; i >= 0; i--){
            rLine += line.charAt(i);
        }

        return rLine;
    }

    //Throws an IllegalArgumentException with the message "Invalid line"
    //if line is null
    //Throws an IllegalArgumentException with the message "Invalid amount"
    //if amount is less than 1 or greater than 25
    //NOTE: You must check for invalid parameters (arguments) in the order given above.
    //Creates and returns a copy of the String line such that each letter
    //has been replaced by the letter "amount" characters later in the
    //alphabet, wrapping around to the beginning of the alphabet, if necessary,
    //and preserving case
    /**
    * Shifts line's letters forward.
    * @param line userInput String.
    * @param amount user specified amount for line to be shifted.
    * @return forwards the result of the shift line letters forward method.
    * @throws IllegalArgumentException if line is null
    * @throws IllegalArgumentException if amount is less than one or greater than 25
    */
    public static String shiftLineLettersForward(String line, int amount) {
        if(line == null){
            throw new IllegalArgumentException("Invalid line");
        }
        if(amount < ONE && amount > TWENTY_FIVE){
            throw new IllegalArgumentException("Invalid amount");
        }
        String forwards = "";
        char alphabet [] = {'a','b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        for(int i = 0; i < alphabet.length; i++){
            for(int j = 0; j < line.length(); j++){
                if(Character.toUpperCase(alphabet[j]) == line.charAt(i)){
                    forwards += line.charAt(i + amount);
                }
                if(Character.toLowerCase(alphabet[j]) == line.charAt(i)){
                    forwards += line.charAt(i + amount);
                }
                if(i + amount > NUM_LETTERS){
                    forwards += line.charAt(i + amount - NUM_LETTERS);
                }
            }
        }
        return forwards;
    }

    //Throws an IllegalArgumentException with the message "Invalid line"
    //if line is null
    //Throws an IllegalArgumentException with the message "Invalid amount"
    //if amount is less than 1 or greater than 25
    //NOTE: You must check for invalid parameters (arguments) in the order given above.
    //Creates and returns a copy of the String line such that each letter
    //has been replaced by the letter "amount" characters earlier in the
    //alphabet, wrapping around to the end of the alphabet, if necessary,
    //and preserving case
    /**
    * Shifts line's letters backwards.
    * @param line userInput String.
    * @param amount user specified amount for line to be shifted.
    * @return backwards the result of the shift line letters backwards method.
    * @throws IllegalArgumentException if line is null
    * @throws IllegalArgumentException if amount is less than 1 or greater than 25
    */
    public static String shiftLineLettersBackward(String line, int amount) {
        if(line == null){
            throw new IllegalArgumentException("Invalid line");
        }

        if(amount < ONE && amount > TWENTY_FIVE){
            throw new IllegalArgumentException("Invalid amount");
        }
        String backwards = "";
        char alphabet1 [] = {'a','b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        for(int i = 0; i < line.length(); i++){
            for(int j = 0; j < alphabet1.length; j++){
                if(Character.toUpperCase(alphabet1[j]) == line.charAt(i)){
                    backwards += line.charAt(i - amount);
                }
                if(Character.toLowerCase(alphabet1[j]) == line.charAt(i)){
                    backwards += line.charAt(i - amount);
                }

                if(i - amount < 0){
                    backwards += line.charAt(i + amount + NUM_LETTERS);
                }
            }
        }
        return backwards;
    }
}
