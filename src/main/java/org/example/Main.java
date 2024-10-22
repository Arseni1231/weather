package org.example;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int[][] temperatures = new int[12][];
        Random random = new Random();

        for (int i = 0; i < 12; i++) {
            temperatures[i] = new int[daysInMonth[i]];
            for (int j = 0; j < daysInMonth[i]; j++) {
                if (i < 2 || i == 11) {
                    temperatures[i][j] = random.nextInt(31) - 20; /
                } else if (i >= 2 && i <= 4) {
                    temperatures[i][j] = random.nextInt(26) - 5;
                } else if (i >= 5 && i <= 7) {
                    temperatures[i][j] = random.nextInt(21) + 10;
                } else {
                    temperatures[i][j] = random.nextInt(31) - 10;
                }
            }
        }

        Scanner scanner = new Scanner(System.in);


        System.out.print("Введите номер месяца: ");
        int month = scanner.nextInt() - 1;
        System.out.print("Введите день месяца: ");
        int day = scanner.nextInt() - 1;

        if (month >= 0 && month < 12 && day >= 0 && day < daysInMonth[month]) {
            System.out.println("Температура на " + (month + 1) + "/" + (day + 1) + " составляет: " + temperatures[month][day] + "°C");
        } else {
            System.out.println("Некорректная дата.");
        }

        // 2. Поиск самого холодного и самого теплого дня
        int maxTemp = Integer.MIN_VALUE, minTemp = Integer.MAX_VALUE;
        String hottestDay = "", coldestDay = "";

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < daysInMonth[i]; j++) {
                if (temperatures[i][j] > maxTemp) {
                    maxTemp = temperatures[i][j];
                    hottestDay = "Месяц: " + (i + 1) + ", День: " + (j + 1);
                }
                if (temperatures[i][j] < minTemp) {
                    minTemp = temperatures[i][j];
                    coldestDay = "Месяц: " + (i + 1) + ", День: " + (j + 1);
                }
            }
        }

        System.out.println("Самый теплый день: " + hottestDay + ", Температура: " + maxTemp + "°C");
        System.out.println("Самый холодный день: " + coldestDay + ", Температура: " + minTemp + "°C");

        // 3. Средняя температура по каждому месяцу
        for (int i = 0; i < 12; i++) {
            int sum = 0;
            for (int j = 0; j < daysInMonth[i]; j++) {
                sum += temperatures[i][j];
            }
            double average = sum / (double) daysInMonth[i];
            System.out.printf("Средняя температура в месяце %d: %.2f°C\n", (i + 1), average);
        }


    }
}


