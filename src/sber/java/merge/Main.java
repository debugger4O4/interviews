package sber.java.merge;

import java.util.*;

public class Main {

    /**
     * Input: nums1 = [1, 2, 7, 0, 0, 0], m = 3, nums2 = [2, 5, 6], n = 3
     * Output: [1, 2, 2, 5, 6, 7]
     * <br>
     * Input: nums1 = [1], m = 1, nums2 = [], n = 0
     * Output: [1]
     * <br>
     * * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
     * Output: [1]
     */

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 7, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

        int[] nums3 = new int[]{1};
        int[] nums4 = new int[]{2, 5, 6};
        merge(nums3, 1, nums4, 0);
        System.out.println(Arrays.toString(nums1));

        int[] nums5 = new int[]{0};
        int[] nums6 = new int[]{1};
        merge(nums5, 0, nums6, 1);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = nums1.clone();
        int l = 0, r = 0;

        while (l < m && r < n) {
            if (arr[l] < nums2[r]) {
                nums1[l + r] = arr[l++];
            } else {
                nums1[l + r] = nums2[r++];
            }
        }

        while (l < m) {
            nums1[l + r] = arr[l++];
        }

        while (r < n) {
            nums1[l + r] = arr[r++];
        }
    }
}
