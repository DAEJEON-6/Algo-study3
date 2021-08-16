package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_6603 {
    private static void permutation(final int[] numbers, int index, int level, int[] result) {
        if(level == 6) {
            for(int i : result)
                System.out.print(i + " ");
            System.out.println();
            return;
        }

        for(int i=index;i<numbers.length;i++) {
            result[level] = numbers[i];
            permutation(numbers,i+1,level+1,result);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            if(N == 0)
                break;
            int[] numbers = new int[N];
            for(int i=0;i<N;i++)
                numbers[i] = Integer.parseInt(st.nextToken());

            // Permutation 구하라는 것 같아용
            permutation(numbers,0,0,new int[6]);
            System.out.println();
        }
    }
}
