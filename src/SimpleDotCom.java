public class SimpleDotCom {
    int[] locationCells;
    int numOfHits = 0;
    public void setLocationCells (int[] locs) {
        locationCells = locs;
    }
    public String checkYourself(String stringGuess) {
        int guess = Integer.parseInt(stringGuess);
        String result = "Past";
        for (int cell : locationCells){
            if (guess == cell) {
                result = "Got";
                numOfHits++;
                break;
            }
        }
        if (numOfHits == locationCells.length) {
            result = "Sunk";
        }
        System.out.println(result);
        return result;
    }
}