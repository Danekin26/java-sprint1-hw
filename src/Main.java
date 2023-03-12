import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        System.out.println("v 1.0");
        System.out.println("Добро пожаловать :)");
        System.out.println("Выберите пункт от 1 до 4");
        Scanner scanner = new Scanner(System.in);   // Объявление переменной scanner
        StepTracker stepTracker = new StepTracker(scanner);


        while (true){     // Бесконечный цикл

            printMenu();      // Вызов пунктов меню
        int numberMenu = scanner.nextInt();  // Присваивание значение переменной с клавиатуры

        if(numberMenu == 1){
            stepTracker.addNewNumberStepsPerDay();
        }else if (numberMenu == 2){
            stepTracker.changeStepGoal();
        }else if(numberMenu == 3){
            stepTracker.printStatistic();
        }else if (numberMenu == 4){
            System.out.println("До новых встреч :)");
            return;
        }else{
            System.out.println("Такого пункта меню, к сожалению, еще не существует :(");
            System.out.println("Повторите попытку.");
        }
        }
    }
    static void printMenu(){    // Все пункты меню в одном классе
        System.out.println("1 - ввести количество шагов за определённый день");
        System.out.println("2 - изменить цель по количеству шагов в день");
        System.out.println("3 - напечатать статистику за определённый месяц");
        System.out.println("4 - выйти из приложения");

    }
}


