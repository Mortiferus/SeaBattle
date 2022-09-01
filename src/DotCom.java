import java.util.ArrayList;
public class DotCom {
    private ArrayList<String> locationCells;
    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }
    public String checkYourself(String userInput) {
        String result = "Past";
        int index = locationCells.indexOf(userInput);
        if (index >=0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "Sank";
            } else {
                result= "Got";
            }
        }
        return result;
    }
}