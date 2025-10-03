package sber.java.find_index;

public class Main {
    public static void main(String[] args) {
        System.out.println(min(new int[]{1, 2, 3, 4}));
    }

    public static int min(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return -1;
        }
        int leftSum = 0;
        int rightSum = 0;
        for (int num : arr) {
            rightSum += num;
        }
        int minDiff = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            leftSum += arr[i];
            rightSum -= arr[i];
            int diff = Math.abs(leftSum - rightSum);
            if (diff < minDiff) {
                minDiff = diff;
                index = i + 1;
            }
        }
        return index;
    }
}
