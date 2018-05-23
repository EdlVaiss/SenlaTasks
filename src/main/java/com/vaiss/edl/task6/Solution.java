package com.vaiss.edl.task6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;

/*
6.	Написать программу, которая проверяет три отрезка на возможность создать прямоугольный треугольник.
Длина отрезков вводится вручную.
 */
public class Solution {
    public static void main(String[] args) {

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        boolean isInputValid;

        BigDecimal side1 = null;
        BigDecimal side2 = null;
        BigDecimal side3 = null;

        do {

            isInputValid = true;

            try {
                System.out.println("Введите длину первой стороны:");
                side1 = new BigDecimal(consoleReader.readLine());

                if (side1.compareTo(BigDecimal.ZERO) <= 0) {
                    throw new InvalidInputException();
                }

                System.out.println("Введите длину второй стороны:");
                side2 = new BigDecimal(consoleReader.readLine());

                if (side2.compareTo(BigDecimal.ZERO) <= 0) {
                    throw new InvalidInputException();
                }

                System.out.println("Введите длину третьей стороны:");
                side3 = new BigDecimal(consoleReader.readLine());

                if (side3.compareTo(BigDecimal.ZERO) <= 0) {
                    throw new InvalidInputException();
                }

            } catch (NumberFormatException | InvalidInputException e) {

                System.out.println("Ошибка! Все введенные данные должны быть положительными числами!");

                isInputValid = false;
            } catch (IOException e) {
                System.out.println("УПС! Непредвиденная ошибка! Попробуйте запустить программу еще раз!");
            }

        } while (!isInputValid);


        BigDecimal[] sidesArr = {side1, side2, side3};

        Arrays.sort(sidesArr);
        //hypotenuse can't be less then each of the other sides, so in the sorted sidesArr hypotenuse is sidesArr[2]

        if (sidesArr[0].pow(2).add(sidesArr[1].pow(2)).equals(sidesArr[2].pow(2))) {//a^2 + b^2 = c^2
            System.out.println("Из введенных отрезков можно составить прямоугольный треугольник.");
        } else {
            System.out.println("Из введенных отрезков невозможно составить прямоугольный треугольник.");
        }

    }


    static class InvalidInputException extends Exception {

    }
}
