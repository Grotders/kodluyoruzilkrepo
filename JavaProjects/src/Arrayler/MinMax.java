package Arrayler;

import java.util.Arrays;

public class MinMax {
    public static void main(String[] args) {
        int[] list = {56, 34, 1, 8, 101, -2, -33};

        int min = list[0];
        int max = list[0];

        for (int i : list) {
            min= Math.min(i, min);

            max= Math.max(i, max);
        }
        System.out.println(Arrays.toString(list));
        System.out.println("Min= " + min + "   Max= " + max);
    }
}
