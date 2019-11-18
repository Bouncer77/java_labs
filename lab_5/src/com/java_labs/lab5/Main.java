package com.java_labs.lab5;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ReadFile readFile = new ReadFile();
        ArrayList<String> st = readFile.readWar();
        for (String str : st) {
            System.out.print(str);
        }
    }
}

