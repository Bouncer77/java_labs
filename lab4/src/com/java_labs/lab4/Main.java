/*
 * Лабораторная работа #4
 * "Реализовать цикл, который будет 100 раз вызывать созданный вами метод fifo и будет передавать ему в аргументы
 * целочисленное случайное число в интервале от 0 до 9 включительно. Метод fifo должен реализовать добавление элементов
 * в буфер длиной 8 элементов. При достижении длины буфера заданного значения новые числа должны вытеснять самые старые
 * числа. После каждого вызова метода fifo требуется распечатать в одной строке текущее содержимое буфера,
 * отсортированное по возрастанию содержимое а также медианное значение.
 * Ожидаемый результат в консоли:
 * [1,2,3,4,2,3,7,3] -> [1,2,2,3,3,3,4,7] -> [3]
 * [2,3,4,2,3,7,3,0] -> [0,2,2,3,3,3,4,7] -> [3]
 * [3,4,2,3,7,3,0,9] -> [0,2,3,3,3,4,7,9] -> [3]
 *[4,2,3,7,3,0,9,9] -> [0,2,3,3,4,7,9,9] -> [3.5]"
 * */


package com.java_labs.lab4;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Main {

    private static final int RANDOM_MIN = 0; // Начальное значение диапазона - "от"
    private static final int RANDOM_MAX = 9; // Конечное значение диапазона - "до"

    private static final int MAX_SIZE_BUF = 8;

    //реализует интерфейсы List, Dequeue, Queue.
    private static LinkedList<Integer> bufList = new LinkedList<>();

    private static int sizeBufList = 0;
    // private static int current = 0; // 0 - (MAX_SIZE_BUF - 1)

    public static void main(String[] args) {

        //for (int i = 0; i < MAX_SIZE_BUF; ++i, buf_list.add(0));

        for (int i = 0; i < 100; ++i) {
            // 0.0 <= Math.random() < 1.0
            int random = RANDOM_MIN + (int) (Math.random() * RANDOM_MAX);
            // System.out.print(i + "   " + random);
            fifo(random);
            System.out.println();
        }

    }

    /**@param num случайное число в интервале от 0 до 9*/
    private static void fifo(int num) {

        if (sizeBufList >= MAX_SIZE_BUF) {
            bufList.removeFirst();
            bufList.addLast(num);

            // Вытеснение курильщика
            //bufList.set(current++, num);
            //current %= MAX_SIZE_BUF;
        } else {
            bufList.addLast(num); // new Integer(num) is depricated
            ++sizeBufList;
        }
        showLinkedList(bufList);
        // System.out.print(bufList); // выводит пробелы после каждой запятой (не по ТЗ)
        LinkedList<Integer> secBufList = (LinkedList<Integer>) bufList.clone();
        Collections.sort(secBufList, (o1, o2) -> {
            if (o1 < o2) {
                return -1;
            } else if (o1 > o2) {
                return 1;
            }
            return 0;
        });
        showLinkedList(secBufList);
        double median = 0;
        int median_index = 0;
        if (secBufList.size() % 2 == 0) {
            median_index = secBufList.size() / 2; // 8 / 2 = 4
            median = (double)(secBufList.get(median_index) + secBufList.get(median_index - 1)) / 2;
        } else {
            median_index = (secBufList.size() - 1) / 2;
            median = secBufList.get(median_index);
        }

        // Убираем нули после плавующей точки
        // Java.math.BigDecimal.stripTrailingZeros () возвращает BigDecimal, который численно равен этому,
        // но с любыми конечными нулями, удаленными из представления.
        // toPlainString() //Output : Plain string value of 1.23E+7 is 12300000
        System.out.print("[");
        System.out.print((new BigDecimal(Double.toString(median)).stripTrailingZeros().toPlainString()));
        System.out.print("]");
    }


    private static void showLinkedList(LinkedList<Integer> linkedList) {

        int n = 0;
        System.out.print("[");
        for (Integer num : linkedList) {
            n++;
            if (n == 8) {
                System.out.print(num);
                break;
            }
            System.out.print(num + ",");
        }
        System.out.print("] -> ");
    }

}

