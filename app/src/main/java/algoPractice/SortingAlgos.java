package algoPractice;

import java.util.Arrays;

public class SortingAlgos {

    /**
     * find min from j-end
     * move to end of i-j
     * @param <T>
     * @param arr
     */
    public static <T extends Comparable<T>> void selectionSort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[min]) < 0) {
                    min = j;
                }
                swap(arr, i, min);
            }
        }
    }

    /**
     * the current element we are inserting is the key
     * 0-i-1 is considered relativly sorted
     * compare elements from i-1 - 0 against the key
     * shift elements that are larger than the key to the right
     * (arr[j+1] = arr[j])
     * The while loop either stops at -1 or at the first value smaller than key
     * either can key goes one to the left of where j stops
     * (arr[j+1] = arr[j])
     * @param <T>
     * @param arr
     */
    public static <T extends Comparable<T>> void insertionSort(T[] arr){
        for (int i = 1; i < arr.length; i++){
            T key = arr[i];
            int j = i -1;
            
            while (j >= 0 && arr[j].compareTo(key) > 0){
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = key;
        }
    }

    /*
     * Breaks array into halves
     * sorts each halve recursivly:
     *     keep breaking into halves until just one element remaining
     * merge back together by comparing pointer:
     * 
     * 1  3   5    2   4  6       
     * a1    b1    a2      b2
     * 
     */
    public static <T extends Comparable<T>> void mergeSort(T[] arr) {
        // Base case: if length <= 1, return
        if(arr.length <= 1){
            return;
        }

        // Find midpoint
        int midpoint = arr.length/2;

        // Split array into two halves
        T[] arrLeft = Arrays.copyOfRange(arr, 0, midpoint);
        T[] arrRight = Arrays.copyOfRange(arr, midpoint, arr.length);


        // Recursively sort left half
        mergeSort(arrLeft);
        // Recursively sort right half
        mergeSort(arrRight);
        // Merge the two sorted halves
        merge(arrLeft, arrRight, arr);
    }

    /**
     * kinda j swaps the things
     * @param <T>
     * @param arr
     * @param i
     * @param j
     */
    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static <T extends Comparable<T>> void merge(T[] left, T[] right, T[] result) {
        // Use three indices: i (left), j (right), k (result)
        int i = 0;
        int j = 0;
        int k = 0;
        // While both halves have elements, compare and copy smaller
        while(i < left.length && j < right.length){
            if(left[i].compareTo(right[j]) <= 0){
                result[k] = left[i];
                i++;
            }
            else{
                result[k] = right[j];
                j++;
            }
            k++;
        }
        // Copy any leftovers from left
        while(i < left.length){
            result[k++] = left[i++];
        }
        // Copy any leftovers from right
        while(j < right.length){
            result[k++] = right[j++];
        }
    }

}
