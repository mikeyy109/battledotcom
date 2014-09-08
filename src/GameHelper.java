import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Mike Clarke on 08/09/14.
 */
public class GameHelper {

    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int[] grid = new int[gridSize];
    private int comCount = 0;

    public String getUserInput(String promt){
        String inputLine = null;
        System.out.println(promt + " ");
        try{
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if(inputLine.length() == 0){
                return null;
            }
        }catch(IOException e){
            System.out.println("IOException: "+e);
        }
        
        return inputLine.toLowerCase();
    }

    public ArrayList<String> placeDotCom(int comSize){
        ArrayList<String> alphaCells = new ArrayList<String>();
        String[] alphaCoords = new String[comSize]; //Holds f6 type coords
        String temp = null; //Temp string for concat
        int[] coords = new int[comSize]; //Current candidate coords
        int attempts = 0; //Current attempts
        boolean success = false;
        int location = 0; //Starting location

        comCount++;
        int incr = 1; //Set horizontal increment
        if((comCount % 2) == 1){
            incr = gridLength;
        }

        while(!success & attempts++ < 200) { //Main search loop
            location = (int) (Math.random() * gridSize); //Get random starting point
            //System.out.println(" Try " + location);
            int x = 0;
            success = true; //Assume success
            while (success && x < comSize) { //Look for unused spots
                if (grid[location] == 0) { //If not already used
                    coords[x++] = location; //Save location
                    location += incr; //Try next
                    if (location >= gridSize) { //Out of bounds 'bottom'
                        success = false;
                    }
                    if (x > 0 && (location % gridLength == 0)) { //Out of bounds right edge
                        success = false;
                    } else { //Found already used location
                        success = false;
                    }
                }
            }
        }

        int x = 0; //Turn location into alpha coords
        int row = 0;
        int column = 0;
        while(x < comSize){
            grid[coords[x]] = 1; //Mark master grid as used
            row = (int) (coords[x] / gridLength); //Get row value
            column = coords[x] % gridLength; //Get column value
            temp = String.valueOf(alphabet.charAt(column)); //Convert to alpha

            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;

//            System.out.println("  coord "+x+" = "+alphaCells.get(x-1)); //Tells you where dotcom is located
        }

        return alphaCells;
    }
}
