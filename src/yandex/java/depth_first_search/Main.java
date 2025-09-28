package yandex.java.depth_first_search;

/*
Дан неориентированный граф, возможно с петлями и кратными ребрами.
Необходимо найти компоненту связности, содержащую вершину с номером 1.

Формат ввода:
В первой строке записаны два целых числа N и M (1 <= N <= 10^3, 0 <= M <= 5 * 10^5)
— количество вершин и рёбер в графе соответственно.

В последующих M строках перечислены рёбра — пары чисел, определяющие номера вершин,
которые соединяют рёбра. Вершины нумеруются с единицы.

Формат вывода:
В первой строке выведите число K — количество вершин в компоненте связности.

Во второй строке выведите K целых чисел — вершины компоненты связности,
перечисленные в порядке возрастания номеров.

Примечание:
Петля в графе — это ребро, которое соединяет вершину с самой собой.
Кратные рёбра в графе — это рёбра, которые соединяют одну и ту же пару вершин.
Компонента связности в неориентированном графе — это подмножество вершин таких,
что все вершины достижимы друг из друга.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] data = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = data[0];
        int M = data[1];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int[] edge = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int u = edge[0], v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        reader.close();

        boolean[] visited = new boolean[N + 1];
        List<Integer> component = new ArrayList<>();
        dfs(adjList, visited, component, 1);
        component.sort(Integer::compareTo);
        System.out.println(component.size());
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer vertex : component) {
            stringBuilder.append(vertex).append(" ");
        }
        System.out.println(stringBuilder.toString().trim());
    }

    private static void dfs(List<List<Integer>> adjList, boolean[] visited, List<Integer> component, int currentVertex) {
        visited[currentVertex] = true;
        component.add(currentVertex);

        for (int nextVertex : adjList.get(currentVertex)) {
            if (!visited[nextVertex]) {
                dfs(adjList, visited, component, nextVertex);
            }
        }
    }
}
