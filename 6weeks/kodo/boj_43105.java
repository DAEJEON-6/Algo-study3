package programmers;

import java.util.Arrays;

public class boj_43105 {
    public int solution(int[][] triangle) {
        int N = triangle.length;
        int[][] sum = new int[N][];
        for(int i=0;i<N;i++)
            sum[i] = Arrays.copyOf(triangle[i],triangle[i].length);

        for(int i=0;i<N-1;i++) {
            for (int j = 0; j < sum[i].length; j++) {
                sum[i+1][j] = Math.max(sum[i+1][j],sum[i][j]+triangle[i+1][j]);
                sum[i+1][j+1] = Math.max(sum[i+1][j+1],sum[i][j]+triangle[i+1][j+1]);
            }
        }

        int answer = 0;
        for(int i : sum[N-1])
            answer = Math.max(answer,i);
        return answer;
    }
}
