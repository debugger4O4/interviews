package yandex.java.polyglots;

/*
 * Каждый из N школьников некоторой школы знает M_i языков.
 * Определите, какие языки знают все школьники и языки,
 * которые знает хотя бы один из школьников.
 *
 * Формат ввода:
 * Первая строка входных данных содержит количество школьников N.
 * Далее идет N чисел M_i, после каждого из чисел идет M_i строк,
 * содержащих названия языков, которые знает i-й школьник.
 * Длина названий языков не превышает 1000 символов,
 * количество различных языков не более 1000.
 * 1 <= N <= 1000, 1 <= M_i <= 500.
 *
 * Формат вывода:
 * В первой строке выведите количество языков, которые знают все школьники.
 * Начиная со второй строки - список таких языков.
 * Затем - количество языков, которые знает хотя бы один школьник,
 * на следующих строках - список таких языков.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        Set<String> commonLanguages = new HashSet<>();
        Set<String> totalLanguages = new HashSet<>();
        boolean first = true;
        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(reader.readLine());
            Set<String> current = new HashSet<>();
            for (int j = 0; j < M; j++) {
                String language = reader.readLine();
                current.add(language);
                totalLanguages.add(language);
            }

            if (first) {
                commonLanguages.addAll(current);
                first = false;
            } else {
                commonLanguages.retainAll(current);
            }
        }
        reader.close();

        System.out.println(commonLanguages.size());
        commonLanguages.forEach(System.out::println);

        System.out.println(totalLanguages.size());
        totalLanguages.forEach(System.out::println);

    }
}
