package yandex.java.nearest_number;

/*
Напишите программу, которая находит в массиве элемент, самый близкий по величине к данному числу.

Формат ввода:
В первой строке задается одно натуральное число N, не превосходящее 1000 — размер массива. Во второй строке содержатся
N чисел — элементы массива, целые числа, не превосходящие по модулю 1000. В третьей строке вводится одно целое число
x, не превосходящее по модулю 1000.

Формат вывода:
Вывести значение элемента массива, ближайшее к x. Если таких чисел несколько, выведите любое из них.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] arr = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int x = Integer.parseInt(reader.readLine());
        reader.close();

        int result = arr[0];
        int minDiff = Math.abs(x - arr[0]);

        for (int i = 1; i < n; i++) {
            int currDiff = Math.abs(x - arr[i]);
            if (currDiff < minDiff) {
                minDiff = currDiff;
                result = arr[i];
            }
        }

        System.out.println(result);
    }
}
