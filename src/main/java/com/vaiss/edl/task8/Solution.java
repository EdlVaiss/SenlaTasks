package com.vaiss.edl.task8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
8.	Написать программу, которая в последовательности от 0 до N, находит все числа-палиндромы (зеркальное значение равно
оригинальному). Длина последовательности вводится вручную и не должна превышать 100.
 */
public class Solution {
    public static void main(String[] args) {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        boolean isInputValid;

        int input = 0;

        do {
            System.out.println("Введите длину последовательности (число от 0 до 100):");
            isInputValid = true;

            try {

                input = Integer.parseInt(consoleReader.readLine());

                if (input < 0 || input > 100) {
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

        int counter = 0;

        for (int i = 0; i < input; i++) {
            String iStr = String.valueOf(i);
            String iStrReverse = new StringBuilder(iStr).reverse().toString();

            if (iStr.equals(iStrReverse)) {
                System.out.printf("%d ",i);
                counter++;
            }

        }

        System.out.println();
        System.out.println(String.format("Найдено %d чисел палиндромов",counter));


    }

    static class InvalidInputException extends Exception {

    }
}
