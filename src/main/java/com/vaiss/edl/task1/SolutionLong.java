package com.vaiss.edl.task1;
/*
1.	Создать программу, которая будет сообщать, является ли целое число, введенное пользователем, чётным или нечётным,
простым или составным.  Если пользователь введёт не целое число, то сообщать ему об ошибке.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SolutionLong {

    public static void main(String[] args)  {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        boolean isInputValid;
        String primeProp = "";
        String evenProp = "";
        long input = 0;

        do {
            System.out.println("Введите целое число: ");

             isInputValid = true;

            try {
                //restricted input to Long values to keep isPrime() function less complicated (by using Math.sqrt()
                // instead of custom sqrt func) and avoid clients machine hang if input is too big

                //for solution using BigInteger refer to com.vaiss.edl.task1.SolutionBigInteger
                // (be careful it can hang your machine if input is too big)
                 input = Long.parseLong(consoleReader.readLine());

            } catch (NumberFormatException e) {
                //to ensure correct formatting of long value into scientific
                // notation has to multiply long by 1.0
                System.out.println(String.format("Ошибка! Число должно быть ЦЕЛЫМ и в пределах от %6.3e до %6.3e!",
                        Long.MIN_VALUE * 1.0, Long.MAX_VALUE * 1.0));

                isInputValid = false;
            } catch (IOException e) {
                System.out.println("УПС! Непредвиденная ошибка! Попробуйте запустить программу еще раз!");
            }

        } while (!isInputValid);

        //numbers less then 1 are neither prime nor composite
        // see https://ru.wikipedia.org/wiki/%D0%9F%D1%80%D0%BE%D1%81%D1%82%D0%BE%D0%B5_%D1%87%D0%B8%D1%81%D0%BB%D0%BE
        // or https://en.wikipedia.org/wiki/Prime_number
        // also https://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D1%81%D1%82%D0%B0%D0%B2%D0%BD%D0%BE%D0%B5_%D1%87%D0%B8%D1%81%D0%BB%D0%BE
        // or https://en.wikipedia.org/wiki/Prime_number
        if (input > 1) {
            primeProp = isPrime(input) ? "простое" : "составное";
        } else {
            primeProp = (input < 0) ? "отрицательное" : "не является ни простым, ни составным";
        }

        evenProp = isEven(input) ? "четное" : "нечетное";

        System.out.println(String.format("Число %,d - %s и %s", input, evenProp, primeProp));
    }

    public static boolean isPrime(long val) {
        for (int i = 2; i < Math.sqrt(val); i++) {
            if (val % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEven(long val) {
        return val % 2 == 0;
    }
}
