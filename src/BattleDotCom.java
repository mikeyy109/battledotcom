import java.util.ArrayList;

/**
 * Created by Mike Clarke on 30/08/14.
 */
public class BattleDotCom {

    private ArrayList<String> locationCells;

    public void setLocationCells(ArrayList<String> locs){
        this.locationCells = locs;
    }

    public String checkYourself(String userInput){
        String result = "miss";

        int index = locationCells.indexOf(userInput);

        if(index >= 0){
            locationCells.remove(index);

            if(locationCells.isEmpty()){
                result = "kill";
            }else{
                result = "hit";
            }
        }
        System.out.println(result);
        return result;
    }
}
