import java.io.*;
import  java.util.*;
public class GameHelper {
    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int [] grid = new int[gridSize];
    private int comCount = 0;
    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader( new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine.toLowerCase();
    }
    public ArrayList<String> placeDotCom (int comSize) {
        ArrayList<String> alphaCells = new ArrayList<String>();
        String[] alphacoords = new String[comSize];  //Хранит коорды типа F6
        String temp = null;                           //Временная строка для конкатенации
        int[] coords = new int[comSize];            //Коорды текущего "Корабля"
        int attempts = 0;                             //Счётчик текущих попыток
        boolean success = false;                      //Нашли подходящее местоположение?
        int location = 0;                             //Текущее начальное местоположение

        comCount++;                                   //Энный "корабль" для размещения
        int incr = 1;                                 //Устанавливаем горизонтальный инкремент
        if ((comCount % 2) == 1) {                    //Если нечетный (размещаем вертикально)
            incr = gridLength;                        //Устанавливаем вертикальный инкремент
        }
        while (!success & attempts++ < 200) {        //Главный поисковый цикл (32)
            location = (int) (Math.random() * gridSize); //Получаем стартовую точку
            //System.out.print("пробуем" + location);
            int x = 0;                                //Энная позиция в "корабле" который нужно разместить
            success = true;                           //Предпологаем успешный код
            while (success && x < comSize) {          //Ищем соседнюю неиспользованную ячейку
                if (grid[location] == 0) {            //Если ещё не используется
                    coords[x++] = location;           //Сохраняем местоположение
                    location += incr;                 //Пробуем "Следующую" соседнюю ячейку
                    if (location >= gridSize) {       //Вышли за рамки - низ
                        success = false;              //Неудача
                    }
                } else {                                  //нашли уже использующееся местоположение
                    //System.out.print("Используется" + location);
                    success = false;                  //Неудача
                }
            }
        }                                                 //Конец While
        int x = 0;
        int row = 0;
        int column = 0;
        //System.out.println("\n");
        while (x < comSize) {
            grid[coords[x]] = 1;                      //Помечаем ячейки на главной сетке как "Использованные"
            row = (int) (coords[x] / gridLength);     //Получаем значение строки
            column = coords[x] % gridLength;          //Получаем числовое значение столбца
            temp = String.valueOf(alphabet.charAt(column)); //Преобразуем его в строковый символ

            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
            //System.out.print("  coord " +x+ " = " + alphaCells.get(x-1)); // <--- Где именно находится корабль
        }
        //System.out.println("\n");
        return  alphaCells;
    }
}