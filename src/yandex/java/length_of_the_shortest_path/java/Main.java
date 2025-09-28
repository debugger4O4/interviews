package yandex.java.length_of_the_shortest_path.java;

/* 
Дан неориентированный граф. Найдите длину минимального пути между двумя вершинами.

Формат ввода:
В первой строке записано целое число N (1 <= N <= 100) — количество вершин в графе.
Далее записывается матрица смежности — N строк, в каждой из которых содержится N чисел 0 или 1,
разделённых пробелом. Число 0 означает отсутствие ребра, а 1 — наличие ребра.
В последней строке задаются номера двух вершин — начальной и конечной.
Вершины нумеруются с единицы.

Формат вывода:
Выведите длину кратчайшего пути — минимальное количество рёбер, которые нужно пройти.
Если пути нет, нужно вывести -1.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[][] matrix = new int[N][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[] data = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start = data[0] - 1;
        int end = data[1] - 1;
        reader.close();

        int[] result = bfs(matrix, start, N);

        if (result[end] != Integer.MAX_VALUE) {
            System.out.println(result[end]);
        } else {
            System.out.println(-1);
        }

    }

    private static int[] bfs(int[][] graph, int start, int n) {
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[start] = 0;
        visited[start] = true;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            for (int i = 0; i < n; i++) {
                if (graph[currNode][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    result[i] = result[currNode] + 1;
                    queue.offer(i);
                }
            }
        }
        return result;
    }
}
