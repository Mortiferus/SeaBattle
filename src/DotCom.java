import java.util.ArrayList;
public class DotCom {
       // Перевенные экземпляра класса, ArrayList с ячейками описывающими - сайта
    private ArrayList<String> locationCells;
    private String name;
       //Сеттер, который обновляет местоположение "корабля"(случайный адрес, пред.методом placeDotCom()
       //                                                                         из класса GameHelper)
    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }
    public void setName(String n) {
        name = n;
    }
    public String checkYourself(String userInput) {
        String result = "Past";
        int index = locationCells.indexOf(userInput);
        if (index >=0) {
            locationCells.remove(index);
              //Используем метод isEmpty(), чтобы проверить, все ли адреса были разгаданы.
            if (locationCells.isEmpty()) {
                result = "Sank";
                System.out.println("Ouch! you sunk" + name + "  : ( ");
            } else {
                result= "Got";
            }
        }
        return result;
    }
}