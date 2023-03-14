import java.util.Scanner;
public class StepTracker {

   // Поля класса
    Scanner scanner;
    int goalByStepsPerDay = 10000; // Цель шагов по умолчанию
    MonthData [] monthToData = new MonthData[12];
    Converter conv = new Converter();

    //Конструктор
    StepTracker(Scanner scan){
        scanner = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
}
   // Методы класса
    void addNewNumberStepsPerDay(){  // Заполнение данных с пройденными шагами
       System.out.println("Введите номер месяца от 1 до 12 (включительно)");
       int month = scanner.nextInt();
       if(month > 12 || month < 1){
           System.out.println("Такого месяца не существует");
           return;
       }

       System.out.println("Введите день от 1 до 30 (включительно)");
       int day = scanner.nextInt();
       if(day > 30 || day < 1){
           System.out.println("Такого дня не существует.");
           return;
       }
       System.out.println("Введите количество пройденных шагов.");
       int step = scanner.nextInt();
       if(step<1){
           System.out.println("Количество шагов должно быть положительным.");
           return;
       }

       MonthData monthData = monthToData[month-1];
       monthData.days[day-1] = step;
    }

    void changeStepGoal(){  // Изменение цели шагов
        System.out.println("Введите новую цель по количеству шагов: ");
        goalByStepsPerDay = scanner.nextInt();
        if (goalByStepsPerDay<=0){
            System.out.println("Количество шагов должно быть больше 0.");
        }else{
            System.out.println("Теперь цель шагов составляет: "+goalByStepsPerDay);
        }
    }
    void printStatistic() { //Статистика
        System.out.println("Введите число месяца: ");
        int numMonth = scanner.nextInt();

        if (numMonth>0 && numMonth<13){
        System.out.println("Пройденные шаги в месяце: ");
        System.out.println();


        // Пройденные шаги за каждый день в течении месяца
        monthToData[numMonth-1].printDaysAndStepsFromMonth();
        System.out.println();

        // Сумма пройденных шагов за месяц
        int sumStep = monthToData[numMonth-1].sumStepsFromMonth();
        System.out.println("Общее количество шагов за месяц: " + sumStep);
        System.out.println();

        // Максимальный элемент массива
        System.out.println("Максимальное пройденное количество шагов в месяце: " + monthToData[numMonth-1].maxSteps());
        System.out.println();

        // Cреднее количество шагов
        System.out.println("Cреднее количество шагов: " + monthToData[numMonth-1].averageNumStep());
        System.out.println();

        // Пройденная дистанция (в км)
        System.out.println("Пройденная дистанция: "+conv.convertToKm(sumStep)+" км.");
        System.out.println();

        // Количество сожжённых килокалорий
        System.out.println("В этом месяце вы сожгли: " + conv.convertStepsToKilocalories(sumStep)+"ккал");
        System.out.println();

        // Максимальное количество подряд идущих дней
        System.out.println("Количество дней лучшей серии: " + monthToData[numMonth-1].bestSeries(goalByStepsPerDay));
        System.out.println();
        }else{
            System.out.println("Произошла ошибка. Такого месяца не существует.");
            return;
        }
}
}