/**
 * Created by Mike Clarke on 30/08/14.
 *
 * Test class.
 */
public class BattleDotComTest {

    public static void main(String[] args){

        BattleDotCom battle = new BattleDotCom();

        int[] locations = {2,3, 4};
        battle.setLocationCells(locations);

        String userGuess = "2";
        String result = battle.checkYourself(userGuess);
    }
}
