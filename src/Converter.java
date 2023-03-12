public class Converter {
    int convertToKm(int steps){
    int length = steps*75/100000;   // Расчет дистанции в из шагов в км
        return length;
    }
    int convertStepsToKilocalories(int steps){
        int weight = steps * 50 /1000;  // Расчет сожжённых килокалорий относительно шагов
    return weight;
    }

}

