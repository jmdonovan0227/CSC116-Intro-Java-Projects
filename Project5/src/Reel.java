
/**
* class represents a reel that contains Symbols
* @author Jake Patterson
*/
public class Reel {

    /**
    * starts the program
    * @param args command line arguments
    */
    public static void main(String [] args){
    }

    /**
    * The number four
    */
    public static final int FOUR = 4;

    /**
    * the number of symbols
    */
    public static final int NUMBER_OF_SYMBOLS = 5;

    /**
    * the symbol names
    */
    public static final String[] SYMBOL_NAMES = {"State Symbols", "Hearts", "Bars",
                                                 "Cherries", "Sevens"};

    /**
    * the symbol values
    */
    public static final int[] SYMBOL_VALUES = {10, 25, 50, 75, 100};

    /**
    * an array of symbols
    */
    private Symbol[] symbols;

    /**
    * the current index of the reel
    */
    private int currentIndex;

    /**
    * the direction of reel
    */
    private int direction;

    /**
    * constructor method of reel
    * @param direction the direction of the reel
    */
    public Reel(int direction){
        this.direction = direction;
        this.symbols = symbols;
        this.currentIndex = currentIndex;

        symbols = new Symbol[NUMBER_OF_SYMBOLS];

        if(direction != 1 && direction != -1){
            throw new IllegalArgumentException("Illegal direction");
        }

        for(int i = 0; i < symbols.length; i++){
            symbols[i] = new Symbol(SYMBOL_NAMES[i], SYMBOL_VALUES[i]);
        }
        currentIndex = 0;
    }

    /**
    * gets current symbol in reel
    * @return symbols the current symbol
    */
    public Symbol getCurrentSymbol(){
        return symbols[currentIndex];
    }

    /**
    * gets current index of reel
    * @return currentIndex the current index of the reel
    */
    public int getCurrentIndex(){
        return currentIndex;
    }

    /**
    * method that deals with turning the reel
    */
    public void turn(){
      // Direction of -1 = upward, Direction of 1 = downward
        if(direction == -1){
            if(currentIndex > 0 && currentIndex <= FOUR){
                currentIndex--;
            }
        }
        if(direction == -1){
            if(currentIndex == 0){
                currentIndex = FOUR;
            }
        }
        if(direction == 1){
            if(currentIndex >= 0 && currentIndex < FOUR){
                currentIndex++;
            }
        }
        if(direction == 1){
            if(currentIndex == FOUR){
                currentIndex = 0;
            }
        }
    }

    /**
    * method converts class result into string
    * @return reelClassToString the result of the reel class as a string
    */
    public String toString(){
        String returnS = "";
        for(int i = 0; i < symbols.length; i++){
            returnS += ("Symbol " + i + ": " + symbols[i] + "\n");
        }
        return "Current index: " + currentIndex + "\n" +
            "Current symbol: " + SYMBOL_NAMES[currentIndex] + "\n"
            + returnS;
    }
}
