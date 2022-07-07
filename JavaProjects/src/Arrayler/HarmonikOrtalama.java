package Arrayler;

import java.util.Arrays;

public class HarmonikOrtalama {

    public double harmonicMean(int[] numbers) {
        int length = numbers.length;
        return (double)length / harmonicProgression(numbers);
    }

    public double harmonicProgression(int[] numbers) {
        double sum=0.0;
        for(var temp : numbers) {
            sum += (1.0/temp);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        HarmonikOrtalama h = new HarmonikOrtalama();

        double result = h.harmonicMean(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println("harmonic mead: " + result);
    }
}
