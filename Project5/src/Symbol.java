
/**
* Class represents a single symbol used in slot machine reel
* @author Jake Patterson
*/
public class Symbol {

    /**
    * starts the program
    * @param args command line arguments
    */
    public static void main(String [] args){

    }

    /**
    * The name of the symbol
    */
    private String name;

    /**
    * The value of the symbol
    */
    private int value;

    /**
    * constructor method of Symbol
    * @param name the name of the symbol
    * @param value the value of the symbol
    */
    public Symbol(String name, int value){
        this.name = name;
        this.value = value;
    }

    /**
    * gets name
    * @return name the name
    */
    public String getName(){
        return name;
    }

    /**
    * gets value
    * @return value the value
    */
    public int getValue(){
        return value;
    }

    /**
    * Checks whether object is equal to a valid symbol
    * @param o the Object
    * @return isValidSymbol boolean that returns false or true based on if symbol is valid
    */
    public boolean equals(Object o){
        if(o instanceof Symbol){
            Symbol that = (Symbol) o;
            return this.name.equals(that.getName()) && this.value == that.getValue();
        }
        else {
            return false;
        }
    }

    /**
    * converts result of this class to a String
    * @return asString the class information converted to a string
    */
    public String toString(){
        return name + " " + value;
    }
}
