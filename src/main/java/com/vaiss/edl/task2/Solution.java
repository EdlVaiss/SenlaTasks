package com.vaiss.edl.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
2.	Создать программу, которая будет вычислять и выводить на экран сумму, разность, НОК и НОД двух целых чисел,
введенных пользователем. Если пользователь некорректно введёт хотя бы одно из чисел, то сообщать об ошибке.
 */
public class Solution {

    public static void main(String[] args) {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        boolean isInputValid;

        BigInteger input1 = null;
        BigInteger input2 = null;

        do {

            isInputValid = true;

            try {
                System.out.println("Введите целое число (N1): ");
                input1 = new BigInteger(consoleReader.readLine());

                System.out.println("Введите целое число (N2): ");
                input2 = new BigInteger(consoleReader.readLine());

            } catch (NumberFormatException e) {
                //to ensure correct formatting of long value into scientific
                // notation has to multiply long by 1.0
                System.out.println("Ошибка! Оба числа должны быть ЦЕЛЫМИ!");

                isInputValid = false;
            } catch (IOException e) {
                System.out.println("УПС! Непредвиденная ошибка! Попробуйте запустить программу еще раз!");
            }

        } while (!isInputValid);

        BigInteger sum = input1.add(input2);
        BigInteger difference = input1.subtract(input2);
        BigInteger gcd = input1.gcd(input2); //greatest common divisor
        BigInteger lcm = input1.multiply(input2).divide(gcd);//least common multiple

        System.out.println(String.format("Сумма N1 + N2 равна %s", sum.toString()));
        System.out.println(String.format("Разность N1 - N2 равна %s", difference.toString()));
        System.out.println(String.format("НОД N1 и N2 равен %s", gcd.toString()));
        System.out.println(String.format("НОК N1 и N2 равно %s", lcm.toString()));

    }


}
