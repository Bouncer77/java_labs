package com.java_labs.lab3;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        // Расскоментировать для автоматического тестирования на примерах ниже
        solutionQuadraticEquation(1, 2, -3); // Решите уравнение x2 + 2x – 3 = 0. Ответ. 1, −3.
        solutionQuadraticEquation(1, 6, 9); // Решите уравнение x2 + 6x + 9 = 0. Ответ. x = –3
        solutionQuadraticEquation(1, 2, 17); // Решите уравнение x2 + 2x + 17 = 0. действительных корней не имеет.
        System.exit(0); // Завершение программы

        // Ввод коэффицентов уравнения вручную
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("Введите целочисленные коэффиценты квадратного уравнения:\n" +
                    "ax^2 + bx + c = 0");
            System.out.print("Введите значение a -> ");
            int a = s.nextInt();
            System.out.print("Введите значение b -> ");
            int b = s.nextInt();
            System.out.print("Введите значение c -> ");
            int c = s.nextInt();
            solutionQuadraticEquation(a, b, c);
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Ошибка - введен неверный формат числа!" +
                    "Перезапустите программу.");
            System.exit(1);
        }
    }

    // Метод выводит в стандартный поток вывода действительные корни квадратного уравнения
    // ax^2+bx+c=0
    private static void solutionQuadraticEquation(int a, int b, int c) {

        System.out.printf("%dx^2 + %dx + %d = 0\n", a, b, c);
        // при a = 0 уравнение вырождается в линейное
        if (a == 0) {
            if (b == 0) {
                System.out.println("Уравнение — это равенство, содержащее букву, значение которой надо найти.");
                return;
            }
            // bx + c = 0 => x = -c / b
            System.out.println("X = " + (double) (-c) / b);
            return;
        }

        double x1, x2; // корни квадратного уравнения

        /*  Особые случаи
         * Неполное квадратное уравнение: */
        // 1. ax^2 = 0 (b = 0, c = 0)
        if (b == 0 && c ==0) {
            // ax^2 = 0 (b = 0, c = 0)
            System.out.println("X1 = 0\nX2 = 0");
            return;
            // 2. ax^2 + c = 0 (b = 0)
        } else if (b == 0) {
            // ax^2 + c = 0
            x1 = Math.sqrt((double) (-c) / a);
            if (Double.isNaN(x1)) { // Not-a-Number (NaN) получается при попытке взять корень из отрицательного числа
                System.out.println("Ответ: нет решения");
                return;
            }
            x2 = -x1;
            System.out.println("x1 = " + x1 + "\nx2 = " + x2);
            return;
            // 3. ax^2 + bx = 0 (c = 0)
        } else if (c == 0) {
            // ax^2 + bx = 0 => x * (ax + b) = 0
            // ax + b = 0
            System.out.println("x1 = 0\nx2 = " + (double)(-b) / a);
            return;
        }

        double d = Math.pow(b, 2) - 4 * a * c;

        if (d == 0) {
            // Если d=0, то уравнение имеет один корень, который находится по формуле x = -b / 2a
            x1 = (double) (-b) / (2 * a);
            System.out.println("x = " + x1);
        } else if (d > 0) {
            // Если d>0, то уравнение имеет два корня, которые находятся по формулам
            double sqrtD = Math.sqrt(d);
            x1 = (-b + Math.sqrt(d)) / (2 * a);
            x2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println("x1 = " + x1 + "\nx2 = " + x2);
        } else {
            System.out.println("Уравнение не имеет решения");
        }
        System.out.println();
    }
}
