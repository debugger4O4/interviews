package yandex.java.correct_parenthesis_sequence;

/*
 * Рассмотрим последовательность, состоящую из круглых, квадратных и фигурных скобок.
 * Программа должна определить, является ли данная скобочная последовательность правильной.
 *
 * Пустая последовательность является правильной.
 * Если A — правильная последовательность, то последовательности (A), [A], {A} — правильные.
 * Если A и B — правильные последовательности, то последовательность AB — правильная.
 *
 * Формат ввода:
 * В единственной строке записана скобочная последовательность, содержащая не более 100000 скобок.
 *
 * Формат вывода:
 * Если данная последовательность правильная, то программа должна вывести строку "yes",
 * иначе строку "no".
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sequence = reader.readLine();
        reader.close();
        if (isValidParenthesesSequence(sequence)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }

    public static boolean isValidParenthesesSequence(String sequence) {
        Stack<Character> stack = new Stack<>();

        for (char ch : sequence.toCharArray()) {
            switch (ch) {
                case '(', '[', '{' -> stack.push(ch);
                case ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                }
                case '}' -> {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
