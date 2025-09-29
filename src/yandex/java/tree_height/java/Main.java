package yandex.java.tree_height.java;

/*
Реализуйте бинарное дерево поиска для целых чисел.

Элементы добавляются в дерево последовательно, балансировки не происходит
(первый элемент последовательности будет являться корнем дерева).

Найдите высоту получившегося дерева.

Формат ввода:
На вход программа получает последовательность натуральных чисел.
Последовательность завершается числом 0, которое означает конец ввода.
Добавлять его в дерево не надо.

Формат вывода:
Выведите высоту получившегося дерева.

Примечание:
Бинарное дерево поиска — дерево, обладающее следующим свойствами:
- У каждой вершины не более двух детей.
- Все вершины обладают ключами, на которых определена операция сравнения
(в данной задаче ключами являются целые числа).
- У всех вершин левого поддерева вершины v ключи не больше, чем ключ v.
- У всех вершин правого поддерева вершины v ключи больше, чем ключ v.
- Оба поддерева — левое и правое — являются двоичными деревьями поиска.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(
                        Arrays.stream(reader.readLine()
                                        .split(" ")
                                )
                                .mapToInt(Integer::parseInt)
                                .toArray()
                )
                .filter(f -> f > 0)
                .toArray();
        reader.close();

        TreeNode tree = fillTree(arr);
        int result = getResult(tree);
        System.out.println(result);
    }

    private static TreeNode fillTree(int[] arr) {
        TreeNode root = new TreeNode(arr[0]);
        for (int j : arr) {
            put(root, j);
        }
        return root;
    }

    private static TreeNode put(TreeNode parentNode, int newValue) {
        if (parentNode == null) {
            return new TreeNode(newValue);
        }

        if (newValue < parentNode.val) {
            parentNode.left = put(parentNode.left, newValue);
        } else if (newValue > parentNode.val) {
            parentNode.right = put(parentNode.right, newValue);
        }
        return parentNode;
    }

    private static int getResult(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        int maxLeft = getResult(tree.left);
        int maxRight = getResult(tree.right);
        return Math.max(maxLeft, maxRight) + 1;
    }

    static class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
