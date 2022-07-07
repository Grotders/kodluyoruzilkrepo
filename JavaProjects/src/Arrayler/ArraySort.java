package Arrayler;

import java.util.Arrays;

public class ArraySort {

    public static void main(String[] args) {
        int[] list= {99, -2, -2121, 1, 0};

        quicksort(list, 0, list.length-1);

        System.out.println(Arrays.toString(list));
    }


    // pivot is selected as the last element
    static void quicksort(int[] arr, int low, int high){
        if(low < high){
            int p = partition(arr, low, high);
            quicksort(arr, low, p-1);
            quicksort(arr, p+1, high);
        }
    }
    static void swap(int[] arr, int low, int pivot){
        int tmp = arr[low];
        arr[low] = arr[pivot];
        arr[pivot] = tmp;
    }
    static int partition(int[] arr, int low, int high){
        int p = low, j;
        for(j=low+1; j <= high; j++)
            if(arr[j] < arr[low])
                swap(arr, ++p, j);

        swap(arr, low, p);
        return p;
    }

}
