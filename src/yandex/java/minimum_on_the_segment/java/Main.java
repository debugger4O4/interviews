package yandex.java.minimum_on_the_segment.java;

/*
Рассмотрим последовательность целых чисел длины n.

По ней двигается «окно» длины k: сначала в «окне» находятся первые k чисел,
на следующем шаге в «окне» уже будут находиться k чисел, начиная со второго,
и так далее до конца последовательности.

Требуется для каждого положения «окна» определить минимум в нём.

Формат ввода:
В первой строке входных данных содержатся два натуральных числа n и k
(n <= 150000, k <= 10000, k <= n) — длины последовательности и «окна», соответственно.

На следующей строке находятся n целых чисел — сама последовательность.

Формат вывода:
Выведите n − k + 1 строк. В каждой строке должно быть одно число —
минимум для соответствующего положения «окна».
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] data = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = data[0];
        int k = data[1];
        int[] sequence = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        reader.close();

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && sequence[deque.peekLast()] >= sequence[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        for (int i = k; i <= n; i++) {
            System.out.println(sequence[deque.peekFirst()]);
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }
            if (i < n) {
                while (!deque.isEmpty() && sequence[deque.peekLast()] >= sequence[i]) {
                    deque.removeLast();
                }
                deque.addLast(i);
            }
        }
    }
}
