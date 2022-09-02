import java.util.*;
public class DotComBust {
      //Объявляем и инициализируем переменные, которые нам понадобятся
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    private void setUpGame() {
            // Создадим несколько "кораблей" и присвоим им адреса
                 // Создаём три объекта DotCom, даём им имена и помещаем в ArrayList
        DotCom one = new DotCom();
        one.setName = ("Avrora");
        DotCom two = new DotCom();
        two.setName = ("Titanik");
        DotCom three = new DotCom();
        three.setName = ("Olimpic");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);
            // Выводим краткие инструкции пользователя
        System.out.println("Your goal is to sink three 'Ships'.");
        System.out.println("Avrora, Titanik, Olimpic.");
        System.out.println("Try to sink them in the minimum number of moves!");

           // Повтораяем с каждым объектом DotCom в списке
        for (DotCom dotComToSet : dotComsList) {
               //Запрашиваем у вспомогательногго объекта адрес "корабля"
            ArrayList<String> newLocation = helper.placeDotCom(3);
                  //Вызываем сеттер из объекта DotCom, чтобы передать ему местоположение,
                 //которое только что получили от вспомогательного объекста.
            dotComToSet.setLocationCells(newLocation);
        }
    }
    private void startPlaying() {
          //До тех пор пока список объектов DotCom не станет пустым
        while(!dotComsList.isEmpty()) {
              //получаем пользовательский ввод
            String userGuess = helper.getUserInput("Make a move");
               //Вызываем наш метод CheckUserGuess
            chechUserGuess(userGuess);
        }
          //Вызываем наш медо finishGame
        finishGame();
    }
    private void checkUserGuess (String userGuess) {
          //Инкрементируем количество попыток, которые сделал пользователь
        numOfGuesses++;
          // Подразумеваем промах, пока не выяснили обратного
        String result = "Past";
          //Повторяем это для всех объектов DotCom в списке.
        for (DotCom dotComToTest : dotComsList) {
             //Просим DotCom проверить ход пользователя, ищем попадание(или потопление)
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("Hit")) {
                  //Выбираемся из цикла раньше времени, нет смысла проверять другие "корабли"
                break;
            }
            if (result.equals("Sunk")) {
                 //Ему пришел конец, так что удаляем его из списка "кораблей" и выходим из цикла
                dotComToTest.remove(ditComToTest);
                break;
            }
        }
        System.out.println(result);
    }
    private void finishGame() {
          //выводим сообщения о том, как пользователь прошел игру
        System.out.println("All ships went down! Your shares are now worth nothing.");
        if (numOfGuesses <= 18) {
            System.out.println("It took you everything" + numOfGuesses + "attempts.");
            System.out.println("You managed to get out before your investments sank.");
        } else {
            System.out.println("It took you quite some time..." + numOfGuesses + "attempts.");
            System.out.println("Fish dance around your enclosure.");
        }
    }
    public static void main(String[] args) {
          //Создаём игровой объект
        DotComBust game = new DotComBust();
          // Говорит объекту подготовить игру
        game.setUpGame();
          // Говорим игровому объекту начать главный игровой цикл (повторяем запрашивать пользовательский
          //                                                          ввод и проверять полученные данные )
        game.startPlaying();
    }
}
