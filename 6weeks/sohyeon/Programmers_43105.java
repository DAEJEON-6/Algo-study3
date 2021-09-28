package programmers.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Programmers 43105. 정수 삼각형
public class Programmers_43105 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] triangle = new int[n][];
		for(int i=0; i<n; i++) {
			triangle[i] = new int[i+1];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<i+1; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(solution(triangle));
	}

	public static int solution(int[][] triangle) {
		int answer = 0;
        int sum[][]=new int[triangle.length][triangle.length]; // 합을 저장 
        sum[0][0]=triangle[0][0]; 
        // 가장 왼쪽과 오른쪽 줄 sum값 계산 후 저장
        for(int i=1;i<triangle.length;i++){
            sum[i][0]=sum[i-1][0]+triangle[i][0];
            sum[i][i]=sum[i-1][i-1]+triangle[i][i];
        }
        // 현재 위치로 올 수 있는 이전 줄 대각선 왼쪽 오른쪽 중 최댓값을 선택 + 현재 위치 값 
        for(int i=2;i<triangle.length;i++){
            for(int j=1;j<i;j++){
                sum[i][j]=Math.max(sum[i-1][j-1],sum[i-1][j])+triangle[i][j];
            }
        }
        // -> sum 배열 완성
        int max=sum[sum.length-1][0];
        for(int j=1;j<sum.length;j++){  //마지막 행에서 최댓값을 선택
            max=Math.max(max, sum[sum.length-1][j]);
        }
        answer=max;
        return answer;
    }
}
