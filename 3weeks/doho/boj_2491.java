package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class boj_2491 {
    private static int N;

    private static int increasePattern(final int[] array) {
        int maxCount = 1;
        int count = 1; int index = 1;
        while(index < N) {
            if(array[index-1] <= array[index]) {
                count++;
                if(maxCount < count)
                    maxCount = count;
            }
            else {
                count = 1;
            }
            index++;
        }

        return maxCount;
    }

    private static int decreasePattern(final int[] array) {
        int maxCount = 1;
        int count = 1;
        int index = 1;

        while(index < N) {
            if (array[index - 1] >= array[index]) {
                count++;
                if (maxCount < count)
                    maxCount = count;
            } else {
                count = 1;
            }
            index++;
        }
        return maxCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxCount = increasePattern(inputs);
        int minCount = decreasePattern(inputs);

        System.out.println((maxCount < minCount) ? minCount : maxCount);

    }
}
