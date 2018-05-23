package com.vaiss.edl.task7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;

/*
7.	Написать программу, которая рандомно генерирует массив 2-ух значных чисел длины N (вводится вручную) и
выводит наименьшее и наибольшее число из списка.
 */
public class Solution {
    public static void main(String[] args) {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        boolean isInputValid;

        int input = 0;

        do {
            System.out.println("Введите количество чисел, которые надо сгенерировать:");
            isInputValid = true;

            try {

                input = Integer.parseInt(consoleReader.readLine());

                if (input < 0) {
                    throw new InvalidInputException();
                }

            } catch (NumberFormatException | InvalidInputException e) {
                //to ensure correct formatting of integer value into scientific
                // notation has to multiply integer by 1.0
                System.out.println(String.format("Ошибка! Введенное число должно быть натуральным числом не более %6.3e!", Integer.MAX_VALUE * 1.0));

                isInputValid = false;
            } catch (IOException e) {
                System.out.println("УПС! Непредвиденная ошибка! Попробуйте запустить программу еще раз!");
            }

        } while (!isInputValid);

        if (input == 0) {
            System.out.println("Завершение программы.");
            return;
        }

        Integer[] arr = new Integer[input];//use type Integer instead of int to be able to pass the array to Arrays.asList()

        SecureRandom rnd = new SecureRandom();
        for (int i = 0; i < arr.length; i++) {
            //generate integers from min=10 to max=99
            arr[i] = rnd.nextInt(99 - 10 + 1) + 10;
            //System.out.println(arr[i]);
        }

        int maxVal = Collections.max(Arrays.asList(arr));
        int minVal = Collections.min(Arrays.asList(arr));

        System.out.println(String.format("Максимальное число из списка: %d",maxVal));
        System.out.println(String.format("Минимальное число из списка: %d",minVal));
    }

    static class InvalidInputException extends Exception {

    }
}
