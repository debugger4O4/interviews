package yandex.java.dictionary_of_synonyms;

/*
Вам дан словарь, состоящий из пар слов. Каждое слово является синонимом к парному ему слову. Все слова в словаре различны.
Для одного данного слова определите его синоним.

Формат ввода:
Программа получает на вход количество пар синонимов N. Далее следует N строк, каждая строка содержит ровно два
слова-синонима. После этого следует одно слово.

Формат вывода:
Программа должна вывести синоним к данному слову.

Примечание
Эту задачу можно решить и без словарей (сохранив все входные данные в списке), но решение со словарем будет более простым.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        List<String> strings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            strings.add(reader.readLine());
        }

        String word = reader.readLine();

        for (String string : strings) {
            String[] arr = string.split(" ");
            if (Objects.equals(arr[0], word)) {
                writer.write(arr[1]);
            }
            if (Objects.equals(arr[1], word)) {
                writer.write(arr[0]);
            }
        }

        writer.close();
    }
}