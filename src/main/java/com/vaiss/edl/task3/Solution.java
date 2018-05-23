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

            System.out.println("Введите слово или предложение: ");

            try {

                input = consoleReader.readLine();

            } catch (IOException e) {
                System.out.println("УПС! Непредвиденная ошибка! Попробуйте запустить программу еще раз!");
            }

        //enable case insensitive palindrome check for words and space-separated sentences
        String adaptedInput = input.toLowerCase().replaceAll(" ","");

        int len = adaptedInput.length();

        String leftPart = adaptedInput.substring(0, len / 2);
        String rightPart = new StringBuilder(adaptedInput.substring(len - len / 2)).reverse().toString();

        if (leftPart.equals(rightPart)) {
            System.out.printf("%s - это палиндром",input);
        } else {
            System.out.printf("%s - это не палиндром", input);
        }

    }
}
