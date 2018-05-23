package com.vaiss.edl.task1;
/*
1.	Создать программу, которая будет сообщать, является ли целое число, введенное пользователем, чётным или нечётным,
простым или составным.  Если пользователь введёт не целое число, то сообщать ему об ошибке.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class SolutionBigInteger {

    public static void main(String[] args)  {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        boolean isInputValid;
        String primeProp = "";
        String evenProp = "";
        BigInteger input = null;

        do {
            System.out.println("Введите целое число: ");

             isInputValid = true;

            try {
                 input = new BigInteger(consoleReader.readLine());

            } catch (NumberFormatException e) {

                System.out.println(String.format("Ошибка! Число должно быть ЦЕЛЫМ!",
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
        if (input.compareTo(BigInteger.valueOf(1)) == 1) {
            primeProp = isPrime(input) ? "простое" : "составное";
        } else {
            primeProp = (input.compareTo(BigInteger.ZERO) == -1) ? "отрицательное" : "не является ни простым, ни составным";
        }

        evenProp = isEven(input) ? "четное" : "нечетное";

        System.out.println(String.format("Число %,d - %s и %s", input, evenProp, primeProp));
    }



    public static boolean isPrime(BigInteger val) {
        BigInteger sqrtVal = sqrt(val);
        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(sqrtVal) == -1; i = i.add(BigInteger.ONE)) {
            if (val.remainder(i) == BigInteger.ZERO) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEven(BigInteger val) {
        return val.remainder(BigInteger.valueOf(2)) == BigInteger.ZERO;
    }


    public static BigInteger sqrt(BigInteger N)// see https://ru.stackoverflow.com/questions/82135/%D0%9F%D0%BE%D0%BB%D1%83%D1%87%D0%B5%D0%BD%D0%B8%D0%B5-%D0%BA%D0%BE%D1%80%D0%BD%D1%8F-%D0%B8%D0%B7-biginteger-%D0%B1%D0%BE%D0%BB%D1%8C%D1%88%D0%B8%D1%85-%D1%87%D0%B8%D1%81%D0%B5%D0%BB
    {
        final BigInteger TWO = BigInteger.valueOf(2);

        BigInteger result = N.divide(TWO);
        while(result.multiply(result).subtract(N).compareTo(BigInteger.ONE.divide(new BigInteger("100000000")))==1) {
            result = result.add(N.divide(result)).divide(TWO);
        }
        return result;
    }
}
