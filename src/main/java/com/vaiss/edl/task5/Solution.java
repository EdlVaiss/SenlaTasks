package com.vaiss.edl.task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
5.	Создать программу, которая подсчитывает сколько раз употребляется слово в тексте (без учета регистра) .
Текст и слово вводится вручную.
 */
public class Solution {
    public static void main(String[] args) {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        String wordToSearch = "";

        try {
            System.out.println("Введите текст: ");
            input = consoleReader.readLine();
            System.out.println("Введите слово для поиска: ");
            wordToSearch = consoleReader.readLine();

        } catch (IOException e) {
            System.out.println("УПС! Непредвиденная ошибка! Попробуйте запустить программу еще раз!");
        }

        //match (case insensitive) only separate words,
        // i.e. if word to search is "port" and text to search in is "comments are imPORTant" there won't be any match

        int counter = 0;

        Pattern pattern = Pattern.compile("\\b" + wordToSearch.toLowerCase() + "\\b");
        Matcher matcher = pattern.matcher(input.toLowerCase());
        while (matcher.find()) {
            counter++;
        }

        System.out.printf("В исходном тексте слово %s встречается %d раз(а) ",wordToSearch, counter);
    }
}
