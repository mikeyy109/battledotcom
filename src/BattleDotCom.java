import java.util.ArrayList;

/**
 * Created by Mike Clarke on 30/08/14.
 */
public class BattleDotCom {

    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> locs){
        this.locationCells = locs;
    }

    public void setName(String n){
        name = n;
    }

    public String checkYourself(String userInput){
        String result = "Miss";
        int index = locationCells.indexOf(userInput);
        if(index >= 0){
            locationCells.remove(index);

            if(locationCells.isEmpty()){
                result = "Kill";
                System.out.println("Ouch, you sunk "+name);
            }else{
                result = "Hit";
            }
        }
        System.out.println(result);
        return result;
    }
}
