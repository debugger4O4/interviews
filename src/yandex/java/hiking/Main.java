package yandex.java.hiking;

/*
 * Горная цепь состоит из отрезков, соединяющих точки на плоскости, каждая из которых находится правее предыдущей
 * (координата x строго возрастает).
 *
 * Трассой на горной цепи называется маршрут по отрезкам цепи из одной точки в другую. Трассы ориентированы —
 * то есть маршрут может быть как слева направо, так и справа налево.
 *
 * Подъёмом на трассе называется такой отрезок, на котором высота (координата y) возрастает, а высотой подъёма —
 * разность высот между начальной и конечной точками отрезка.
 *
 * Вам даны несколько трасс на одной горной цепи. Помогите для каждой трассы определить суммарную высоту подъёмов.
 *
 * Формат ввода:
 * В первой строке содержится число N (1 ≤ N ≤ 30000) — количество точек в цепи, задающей горную цепь.
 * Далее в N строках содержатся координаты точек — два целых числа xi и yi (1 ≤ xi, yi ≤ 30000, xi < xi+1).
 *
 * В следующей строке находится число M — количество трасс (1 ≤ M ≤ 30000).
 *
 * Далее в M строках содержатся описания трасс. Каждое описание представляет собой два целых числа si и fi (1 ≤ si, fi ≤ N) —
 * номера точек начала и конца трассы. Начало и конец трассы могут совпадать. Точки нумеруются с единицы.
 *
 * Формат вывода:
 * Для каждой трассы выведите одно число — суммарную высоту подъемов на данной трассе.
 */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] X = new long[N];
        long[] Y = new long[N];

        for (int i = 0; i < N; i++) {
            X[i] = scanner.nextLong();
            Y[i] = scanner.nextLong();
        }

        long[] resultUp = new long[N + 1];
        long[] resultDown = new long[N + 1];

        for (int i = 1; i < N; i++) {
            resultUp[i] = resultUp[i - 1] + Math.max(Y[i] - Y[i - 1], 0);
            resultDown[i] = resultDown[i - 1] + Math.max(Y[i - 1] - Y[i], 0);
        }

        int M = scanner.nextInt();

        for (int i = 0; i < M; i++) {
            int start = scanner.nextInt() - 1;
            int end = scanner.nextInt() - 1;
            if (start < end) {
                System.out.println(resultUp[end] - resultUp[start]);
            } else if (start > end) {
                System.out.println(resultDown[start] - resultDown[end]);
            } else {
                System.out.println(0);
            }
        }
        scanner.close();
    }
}
