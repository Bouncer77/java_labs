package com.java_labs.lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {

    private static File file = new File("war.txt");
    private static ArrayList<String> strings = new ArrayList<String>();
    private static Scanner sc;

    public static ArrayList<String> readWar() {
        System.out.println("Hi");

        try {
            sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim(); //.trim() осуществляет обрезание пробелов
                strings.add(line);
                System.out.println(line); //печать строки в стандартный вывод
            }

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //String []stringsArray = (String []) strings.toArray();


        for (String str : strings) {
            System.out.print(str);
        }
        return strings;
    }
}
