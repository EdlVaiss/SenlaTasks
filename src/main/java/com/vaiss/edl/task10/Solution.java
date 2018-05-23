package com.vaiss.edl.task10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
10.	Написать программу, составляющую всевозможные комбинации 3-х значных чисел из 3-х введенных пользователем цифр.
Цифры вводятся вручную.
 */
public class Solution {
    public static void main(String[] args) {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        boolean isInputValid;

        int num1 = 0;
        int num2 = 0;
        int num3 = 0;

        do {

            isInputValid = true;

            try {
                System.out.println("Введите первое число:");
                num1 = Integer.parseInt(consoleReader.readLine());

                if (num1 < 0 && num1 > 9) {
                    throw new InvalidInputException();
                }

                System.out.println("Введите второе чсило:");
                num2 = Integer.parseInt(consoleReader.readLine());

                if (num2 < 0 && num2 > 9) {
                    throw new InvalidInputException();
                }

                System.out.println("Введите третье число:");
                num3 = Integer.parseInt(consoleReader.readLine());

                if (num3 < 0 && num3 > 9) {
                    throw new InvalidInputException();
                }

                if (num1 == 0 && num2 == 0 && num3 == 0) {
                    throw new InvalidInputException();
                }

            } catch (NumberFormatException | InvalidInputException e) {

                System.out.println("Ошибка! Все введенные данные должны быть цифрами от 0 до 9! Все три цифры не должны быть равны 0!");

                isInputValid = false;
            } catch (IOException e) {
                System.out.println("УПС! Непредвиденная ошибка! Попробуйте запустить программу еще раз!");
            }

        } while (!isInputValid);



    }

    static class InvalidInputException extends Exception {

    }
}
