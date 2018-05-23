package com.vaiss.edl.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
3.	Необходимо написать программу, которая проверяет слово на "палиндромность". Слово для проверки вводится вручную
во время выполнения программы.
 */
public class Solution {
    public static void main(String[] args) {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

            System.out.println("Введите слово: ");

            try {

                input = consoleReader.readLine();

            } catch (IOException e) {
                System.out.println("УПС! Непредвиденная ошибка! Попробуйте запустить программу еще раз!");
            }


    }
}
