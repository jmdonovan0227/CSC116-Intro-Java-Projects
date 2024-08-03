import java.util.Random;
/**
* class represents as three Reel objects that each contain five Symbols
* @author Jake Patterson
*/

public class SlotMachine {

    /**
    * starts the program
    * @param args command line arguments
    */
    public static void main(String [] args){

    }

    /**
    * The bet amount
    */
    public static final int BET_AMOUNT = 5;

    /**
    * an array of three reel objects representing different reels in machine
    */
    private Reel[] reels;

    /**
    * the number of tokens held by player
    */
    private int numberOfTokens;

    /**
    * the status of the game
    */
    private String status;

    /**
    * a random class reference
    */
    private Random rand;

    /**
    * the constructor method of this Class
    * @param seed the seed value of the slot machine
    */
    public SlotMachine(int seed){
        this.numberOfTokens = numberOfTokens;
        numberOfTokens = 50;
        this.status = status;
        this.rand = rand;
        this.reels = reels;
        status = "Pull lever to begin";

        if(seed < 0){
            rand = new Random();
        }
        if(seed >= 0){
            rand = new Random(seed);
        }
        reels = new Reel[3];

        for(int i = 0; i < reels.length; i++){
            reels[i] = new Reel(1);
        }
    }
    /**
    * method simulates inserting tokens into machine to play game
    */
    public void makeBet(){
        if(numberOfTokens < BET_AMOUNT){
            throw new IllegalStateException("Not enough tokens for bet");
        }

        if(numberOfTokens >= BET_AMOUNT){
            numberOfTokens -= BET_AMOUNT;
        }
    }

    /**
    * returns the number of tokens a player has
    * @numTokens the number of tokens the player has
    * @return numTokens the number of tokens the player has
    */
    public int getNumberOfTokens(){
        return numberOfTokens;
    }

    /**
    * gets the status of the game
    * @return status the status of the game
    */
    public String getStatus(){
        return status;
    }

    /**
    * returns the current index of the reel
    * @param index the index of the reel
    * @return reelIndex the index of the reel
    */
    public int getCurrentIndexOfReel(int index){
        int reelIndex = index;
        return reelIndex;
    }

    /**
    * method turns slot machine reels
    */
    public void turnReel(){
        reels[rand.nextInt(3)].turn();
    }

    /**
    * method determines outcome after reels have stopped spinning
    */
    public void determineOutcome(){
    }
}
