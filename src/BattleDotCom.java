/**
 * Created by Mike Clarke on 30/08/14.
 */
public class BattleDotCom {

    int[] locationCells;
    int numOfHits = 0;

    public void setLocationCells(int[] locs){
        this.locationCells = locs;
    }

    public String checkYourself(String stringGuess){
        int guess = Integer.parseInt(stringGuess);
        String result = "miss";

        for(int cell : locationCells){
            if(guess == cell){
                result = "hit";
                numOfHits++;
                break;
            }
        }

        if(numOfHits == locationCells.length){
            result = "kill";
        }

        System.out.println(result);
        return result;
    }
}
