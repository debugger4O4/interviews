package yandex.java.sum_of_the_numbers;

/*
Вася очень любит везде искать своё счастливое число K.
Каждый день он ходит в школу по улице, вдоль которой припарковано N машин.
Он заинтересовался вопросом, сколько существует отрезков из подряд идущих машин таких,
что сумма их номеров равна K. Помогите Васе узнать ответ на его вопрос.

Формат ввода:
В первой строке входных данных задаются числа N и K (1 ≤ N ≤ 100000, 1 ≤ K ≤ 10^9).
Во второй строке содержится N чисел, задающих номера машин. Номера машин могут принимать значения от 0 до 100000 включительно.

Формат вывода:
Необходимо вывести одно число — количество отрезков.

Примечание:
В первом примере существуют четыре подходящих отрезка машин:
1. Только первая машина — 17,
2. Машины 2 и 3 — 7, 10,
3. Машины 3 и 4 — 10, 7,
4. Машины 4 и 5 — 7, 10.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int K = input[1];
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        reader.close();

        int result = 0;
        Set<Integer> prefixes = new HashSet<>(N);
        int sum = 0;
        prefixes.add(sum);
        for (int j : arr) {
            sum += j;
            if (prefixes.contains(sum - K)) {
                ++result;
            }
            prefixes.add(sum);
        }

        System.out.println(result);
    }
}
