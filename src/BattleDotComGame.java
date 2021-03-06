import java.util.ArrayList;

/**
 * Created by Mike Clarke on 30/08/14.
 */
public class BattleDotComGame {

    private GameHelper gameHelper = new GameHelper();
    private ArrayList<BattleDotCom> dotComsList = new ArrayList<BattleDotCom>();
    private int numOfGuesses = 0;

    public void setupGame(){
        BattleDotCom one = new BattleDotCom();
        one.setName("google.com");
        BattleDotCom two = new BattleDotCom();
        two.setName("github.com");
        BattleDotCom three = new BattleDotCom();
        three.setName("reddit.com");

        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("Your mission is to sink all 3 dot coms.");
        System.out.println("| google.com | github.com | reddit.com |");
        System.out.println("Try to sink with the fewest guesses!");

        for(BattleDotCom dotComToSet:dotComsList){
            ArrayList<String> newLocation = gameHelper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }

    public void startPlaying(){
        while(!dotComsList.isEmpty()){
            String userGuess = gameHelper.getUserInput("Enter a location: ");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess){
        numOfGuesses++;
        String result = "Miss";

        for(BattleDotCom dotComToTest:dotComsList){
            result = dotComToTest.checkYourself(userGuess);
            if(result.equals("Hit")){
                break;
            }
            if(result.equals("Kill")){
                dotComsList.remove(dotComToTest);
                break;
            }
        }

        System.out.println(result);
    }

    private void finishGame(){
        System.out.println("All dot coms are dead! Well done.");

        if(numOfGuesses <= 18){
            System.out.println("It only took you "+numOfGuesses+" guesses.");
            System.out.println("Not bad..");
        }else{
            System.out.println("Took you long enough!");
            System.out.println(numOfGuesses+" guesses? You can do better than that!");
        }
    }

    public static void main(String[] args){
        BattleDotComGame game = new BattleDotComGame();
        game.setupGame();
        game.startPlaying();
    }
}
