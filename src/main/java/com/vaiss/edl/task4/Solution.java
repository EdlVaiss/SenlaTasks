package com.vaiss.edl.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
4.	Создать программу, которая будет подсчитывать количество слов в предложении и выводить их в отсортированном виде.
Предложение вводится вручную. (Разделители пробел (“ ”) и запятая (“,”)).
 */
public class Solution {
    public static void main(String[] args) {


        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        System.out.println("Введите предложение: ");

        try {

            input = consoleReader.readLine();

        } catch (IOException e) {
            System.out.println("УПС! Непредвиденная ошибка! Попробуйте запустить программу еще раз!");
        }

        /*
        task doesn't imply that user can not use digits to form words, so numbers are considered as words.
        Allowed separators (" " and ",") make decimal numbers (e.g. 123,35) to be treated as separate words ("123" and "35")
         */
        //task doesn't imply that words sort must be case insensitive
        String adaptedInput = input.replaceAll(",", " ")//change comas to spaces
                                    .replaceAll(" +", " ");//change multiple spaces to a single space

        String[] outputArr = adaptedInput.split(" ");
        Arrays.sort(outputArr);

        System.out.println(String.format("Количество слов в предложении: %d", outputArr.length));
        System.out.println();
        System.out.println("Предложение состоит из следующих слов:");
        for (int i = 0; i < outputArr.length; i++) {
            System.out.println(outputArr[i]);
        }

    }
}
