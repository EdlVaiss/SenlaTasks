package com.vaiss.edl.task10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/*
10.	Написать программу, составляющую всевозможные комбинации 3-х значных чисел из 3-х введенных пользователем цифр.
Цифры вводятся вручную.
 */
public class Solution {
    private static HashSet<String> set = new HashSet<>();//set to store all unique combinations

    public static void main(String[] args) {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        boolean isInputValid;

        Integer num1 = 0;
        Integer num2 = 0;
        Integer num3 = 0;

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



        String[] numsArr = {num1.toString(), num2.toString(), num3.toString()};

        permutations(numsArr,0);

        System.out.println(String.format("Из введенных цифр можно составить %d трехзначных числа (чисел)", set.size()));

        int counter = 0;

        for (String str : set) {
            System.out.printf("%s | ",str);

            counter++;
            if (counter % 3 == 0) {
                System.out.println();
            }

        }
    }


    private static void permutations(String[] arr, int pos) {

        if (pos == arr.length - 1) {

            String s = String.join("", arr);
            if (!arr[0].equals("0")) {//don't add numbers with leading zero, they are not valid 3-digit numbers
                set.add(s);
            }
        } else {
            for (int j = pos; j < arr.length; j++) {
                swap(arr, pos, j);
                permutations(arr, pos + 1);
                swap(arr, pos, j);
            }
        }
    }

    private static void swap(String[] arr, int pos1, int pos2) {
        String buff = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = buff;
    }


    static class InvalidInputException extends Exception {

    }
}
