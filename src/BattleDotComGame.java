/**
 * Created by Mike Clarke on 30/08/14.
 */
public class BattleDotComGame {

    public static void main(String[] args){

        int numOfGuesses = 0;

        GameHelper gameHelper = new GameHelper();

        BattleDotCom battleDot = new BattleDotCom();

        int randNum = (int) (Math.random() * 5);

        int[] locations = {randNum, randNum+1,randNum+2};
        battleDot.setLocationCells(locations);

        boolean isAlive = true;
        while(isAlive){
            String guess = gameHelper.getUserInput("Enter a number: ");
            String result = battleDot.checkYourself(guess);
            numOfGuesses++;
            if(result.equals("kill")){
                isAlive = false;
                System.out.println("You took " + numOfGuesses + " guesses.");
            }
        }
    }
}
