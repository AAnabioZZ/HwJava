package dz2;

import java.util.Arrays;

public class start {
    /**
    *
     */

    public static void main(String[] args) {
        int[] arr = new int[] { 19, 56, 43, 2, 7, 954, 9, 2, 347, 4 };
        mergeSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        System.out.println(Arrays.toString(a));
        int half = n / 2;
        int[] leftArr = new int[half];
        int[] rightArr = new int[n - half];

        for (int i = 0; i < half; i++) {
            leftArr[i] = a[i];
        }
        for (int i = half; i < a.length; i++) {
            rightArr[i - half] = a[i];
        }

        mergeSort(leftArr, half);
        mergeSort(rightArr, n - half);
        merge(a, leftArr, rightArr,half,n - half);

        // return merge(a, leftArr ,rightArr , rightArr.length, rightArr.length);
    }

    private static void merge(int[] a, int[] leftAr, int[] rightAr, int left, int right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left && j < right) {
            if (leftAr[i] <= rightAr[j]) {
                a[k++] = leftAr[i++];
            } else {
                a[k++] = rightAr[j++];
            }
        };
        while (i < left) {
            a[k++] = leftAr[i++];
        };
        while (j < right) {
            a[k++] = rightAr[j++];
        };
        return;
    }

}
