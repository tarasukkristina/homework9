package by.it.academy.homework9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Создать файл с текстом, прочитать, подсчитать в тексте количество
//знаков препинания и слов.
public class HW {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("resources/text.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                countOfWords(line);
                System.out.println("Количество знаков препинания: " + countOfPunctuationMark(line));
            }
        } catch (IOException e) {
            System.out.println("Exception with message " + e.getMessage() + " occurred");
        }
    }

    public static void countOfWords(String line) {

        String[] lineArray = line.split("\\s+");
        int countOfWordsArray = lineArray.length;
        System.out.println("Количество слов: " + countOfWordsArray);
    }

    public static int countOfPunctuationMark(String line) {
        String stringPattern = "\\p{Punct}";
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher matcher = pattern.matcher(line);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}

