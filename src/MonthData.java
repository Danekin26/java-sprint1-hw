public class MonthData {
    int[] days = new int [30]; // Объявляем массив, содержащий количество дней в месяце

    void printDaysAndStepsFromMonth(){  // Вывод всех значений массива days
        for (int i = 0; i < days.length; i++) {
            int x = i+1;
            System.out.println(x + " день: " + days[i]);
        }
    }
     int sumStepsFromMonth() {  // Сумма всех элементов массива days
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps = sumSteps + days[i];
        }
        return sumSteps;
    }
    int maxSteps(){  // Поиск максимального значения в массиве days
        int maxSteps = 0;
        for (int i = 0; i< days.length;i++){
            if (maxSteps<days[i]){
                maxSteps = days[i];
            }
        }return maxSteps;
    }
    int bestSeries(int goalByStepsPerDay){ // Поиск максимального количества подряд идущих элементов
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < days.length; i++) {
            if(goalByStepsPerDay <= days[i] && goalByStepsPerDay !=0){
                currentSeries += 1;
                if(finalSeries < currentSeries){
                    finalSeries = currentSeries;
                }
            }else{
                currentSeries = 0;
            }
        }
        return finalSeries;
    }
    int averageNumStep(){ // Расчет среднего количества пройденных шагов
        int step = 0;
        for(int i =0; i < days.length; i++){
            step += days[i];
        }
        int average = step/days.length;
        return average;
    }
}
