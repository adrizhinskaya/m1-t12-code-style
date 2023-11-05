import java.util.Scanner;

public class DepositCalculator {
    Scanner scanner = new Scanner(System.in);

    double calculateComplexPercent(double depositAmount, double yearRate, int depositPeriod) {
        double capitalization = Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        double depositResult = depositAmount * capitalization;
        return round(depositResult, 2); //В методе лучше разделить объявление переменных с остальным кодом
    }

    double calculateSimplePercent(double depositAmount, double yearRate, int depositPeriod) {
        double income = depositAmount * yearRate * depositPeriod;
        return round(depositAmount + income, 2); //В методе лучше разделить объявление переменных с остальным кодом
    }

    double round(double value, int placesAfterComma) { //Перед раунд лучше поставить глагол, чтобы было понятно, что в методе
        double scale = Math.pow(10, placesAfterComma); // что-то вычисляется (например, calculateRound)
        return Math.round(value * scale) / scale; //В методе лучше разделить объявление переменных с остальным кодом
    }

    void calculateDepositResult() {
        int depositAmount;
        int depositPeriod;
        int depositType;
        double depositResult = 0;
        double yearRate = 0.06;

        System.out.println("Введите сумму вклада в рублях:");
        depositAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();

        if (depositType == 1) {
            depositResult = calculateSimplePercent(depositAmount, yearRate, depositPeriod);
        } else if (depositType == 2) {
            depositResult = calculateComplexPercent(depositAmount, yearRate, depositPeriod);
        }

        System.out.println("Результат вклада: " + depositAmount + " за " + depositPeriod + " лет превратятся в "
                + depositResult);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDepositResult();
    }
}
