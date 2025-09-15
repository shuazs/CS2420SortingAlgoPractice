package algoPractice;

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
}
