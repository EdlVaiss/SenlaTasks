package com.vaiss.edl.task9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
9.	Написать программу выводящую на экран все четные числа и их сумму из последовательности от 0 до N.
N вводится вручную.
 */
public class Solution {
    public static void main(String[] args) {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        boolean isInputValid;
        final BigInteger TWO = BigInteger.valueOf(2);
        final BigInteger ZERO = BigInteger.ZERO;

    //max N is not restricted, use BigInteger
        BigInteger input = null;

        do {
            System.out.println("Введите целое положительное число:");
            isInputValid = true;

            try {

                input = new BigInteger(consoleReader.readLine());

                if (input.compareTo(ZERO) <= 0) {
                    throw new InvalidInputException();
                }

            } catch (NumberFormatException | InvalidInputException e) {

                System.out.println("Ошибка! Введенное число должно быть натуральным числом!");

                isInputValid = false;

            } catch (IOException e) {
                System.out.println("УПС! Непредвиденная ошибка! Попробуйте запустить программу еще раз!");
            }

        } while (!isInputValid);


        BigInteger sum = ZERO;

        int counter = 0;

        for (BigInteger i = ZERO; i.compareTo(input) <= 0; i = i.add(BigInteger.ONE)) {
            if (i.remainder(TWO) == ZERO) {
                System.out.printf("%,d | ",i);

                counter++;
                if (counter % 30 == 0) {//output no more then 30 numbers per row
                    System.out.println();
                    counter = 0;
                }

                sum = sum.add(i);
            }
        }
        System.out.println();
        System.out.printf("Сумма всех четных чисел в последовательности от 0 до %,d равна %,d", input, sum);
    }

    static class InvalidInputException extends Exception {

    }
}
