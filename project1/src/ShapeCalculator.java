import java.util.Scanner;
  /**
  * Program checks userInput and determines the surface area and or the Volume
  * for spheres, cylinders, and cubes.
  * @author Jake Patterson.
  */

public class ShapeCalculator {
  /**
  * Starts the program.
  * @param args command line arguments.
  */
    public static void main(String[] args){
        calcShape();
    }
/**
* Checks userInput and calculates surfaceArea or volume of shapes.
*/

    public static void calcShape(){
        Scanner scnr = new Scanner(System.in);
        final double saD = (4.0 / 3.0);
        final int sphereCoSA = 4;
        final int cubeCoSA = 6;
        String userInput = "";
        String userInputCalc = "";
        int cubeInput = 0;
        int sphereInput = 0;
        int cylInput = 0;
        double cylH = 1;
        double cylHeight = 0;

        // Code below checks whether user has entered a valid shape.


        System.out.print("Enter type of shape (C = Cube, S = Sphere, Y = Cylinder): ");
        userInput = scnr.next().substring(0).toUpperCase();
        String isAWord = userInput.substring(0, 1);

        if(!(isAWord.equals(userInput))){
            System.out.println("Invalid Shape");
            System.exit(1);
        }

        if(userInput.equals("C")){
            System.out.print("Enter type of calculation (S = Surface Area, V = Volume): ");
            userInputCalc = scnr.next().substring(0).toUpperCase();
        }
        else if (userInput.equals("S")){
            System.out.print("Enter type of calculation (S = Surface Area, V = Volume): ");
            userInputCalc = scnr.next().substring(0).toUpperCase();
        }
        else if (userInput.equals("Y")){
            System.out.print("Enter type of calculation (S = Surface Area, V = Volume): ");
            userInputCalc = scnr.next().substring(0).toUpperCase();
        }
        else {
            System.out.println("Invalid Shape");
            System.exit(1);
        }

        //Code Below checks if user is entering a valid shape
        //and a valid calculation.

        String isAWord2 = userInputCalc.substring(0,1);
        if(!(isAWord2.equals(userInputCalc))){
            System.out.println("Invalid Option");
            System.exit(1);
        }

        if (userInput.equals("C") && userInputCalc.equals("S")){
            System.out.print("Side Length: ");
            cubeInput = scnr.nextInt();
        }
        else if (userInput.equals("C") && userInputCalc.equals("V")){
            System.out.print("Side Length: ");
            cubeInput = scnr.nextInt();
        }
        else if(userInput.equals("S") && userInputCalc.equals("S")){
            System.out.print("Radius: ");
            sphereInput = scnr.nextInt();
        }
        else if(userInput.equals("S") && userInputCalc.equals("V")){
            System.out.print("Radius: ");
            sphereInput = scnr.nextInt();
        }
        else if(userInput.equals("Y") && userInputCalc.equals("S")){
            System.out.print("Radius: ");
            cylInput = scnr.nextInt();
        }
        else if (userInput.equals("Y") && userInputCalc.equals("V")){
            System.out.print("Radius: ");
            cylInput = scnr.nextInt();
        }
        else {
            System.out.println("Invalid Option");
            System.exit(1);
        }

        // Code below checks whether userInput value is valid and determines correct calculation.

        if(cubeInput > 0 && userInputCalc.equals("S")){
            double cubeL = (double)cubeInput;
            double cubeSA = cubeCoSA * Math.pow(cubeL, 2);
            System.out.printf("Cube Surface Area: ");
            System.out.printf("%.2f", cubeSA);
        }
        else if (cubeInput > 0 && userInputCalc.equals("V")){
            double cubeL = (double)cubeInput;
            double cubeV = Math.pow(cubeL, 3);
            System.out.printf("Cube Volume: ");
            System.out.printf("%.2f", cubeV);
        }
        else if (sphereInput > 0 && userInputCalc.equals("S")){
            double sphereR = (double)sphereInput;
            double sphereSA = sphereCoSA * Math.PI * Math.pow(sphereR, 2);
            System.out.printf("Sphere Surface Area: ");
            System.out.printf("%.2f", sphereSA);
        }
        else if (sphereInput > 0 && userInputCalc.equals("V")){
            double sphereR = (double)sphereInput;
            double sphereV = saD * Math.PI * Math.pow(sphereR, 3);
            System.out.printf("Sphere Volume: ");
            System.out.printf("%.2f", sphereV);
        }


        if (cylInput > 0 && userInputCalc.equals("S")){
            double cylR = (double)cylInput;
            System.out.print("Height: ");
            cylH = scnr.nextInt();
            if(cylH > 0){
                double height = (double)cylH;
                double cylSA = 2 * Math.PI * (cylR) * (height) + 2 * Math.PI * Math.pow(cylR, 2);
                System.out.printf("Cylinder Surface Area: ");
                System.out.printf("%.2f", cylSA);
            }
        }
        if (cylInput > 0 && userInputCalc.equals("V")){
            double cylR = (double)cylInput;
            System.out.print("Height: ");
            cylH = scnr.nextInt();
            if(cylH > 0){
                double height = (double)cylH;
                double cylV = Math.PI * Math.pow(cylR, 2) * (height);
                System.out.printf("Cylinder Volume: ");
                System.out.printf("%.2f", cylV);
            }
        }
        if (cylInput <= 0 && sphereInput <= 0 && cubeInput <= 0) {
            System.out.println("Invalid Value");
            System.exit(1);
        }
        else if (cylH <= 0){
            System.out.println("Invalid Value");
            System.exit(1);
        }
    }
}
