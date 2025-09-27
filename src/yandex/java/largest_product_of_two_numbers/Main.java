package yandex.java.largest_product_of_two_numbers;

/*
 * Дан список, заполненный произвольными целыми числами. Найдите в этом списке два числа,
 * произведение которых максимально.
 *
 * Формат ввода:
 * В единственной строке через пробел вводятся целые числа — элементы списка. Список содержит
 * не менее двух и не более 100 000 чисел. Сами элементы по модулю не превышают 1 000 000.
 *
 * Формат вывода:
 * Выведите эти два числа в порядке неубывания.
 *
 * Примечание:
 * Решение должно иметь сложность O(n), где n — размер списка.
 *
 * Гарантируется, что во всех тестах ответ однозначен.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long[] arr = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        Arrays.sort(arr);

        reader.close();

        long mins = arr[0] * arr[1];
        long maxs = arr[arr.length - 2] * arr[arr.length - 1];
        if (mins >= maxs) {
            System.out.print(arr[0] + " " + arr[1]);
        } else {
            System.out.print(arr[arr.length - 2] + " " + arr[arr.length - 1]);
        }
    }
}
