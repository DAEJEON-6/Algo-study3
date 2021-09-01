package algo.study.swea.d3;

import java.util.Arrays;
import java.util.Scanner;

// SWEA D3 6730. 장애물 경주 난이도
public class SWEA_6730 {

	public static void main(String[] args) throws Exception{	
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();  // 테스트 케이스 수
		for(int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();  // N개의 정수
			int[] arr = new int[N];
			int[] up = new int[N];  // 음수
			int[] down = new int[N];  // 양수
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			for(int i=0; i<N-1; i++) {
				if(arr[i] - arr[i+1] <0) {
					up[i] = Math.abs(arr[i] - arr[i+1]);
				}else if(arr[i] - arr[i+1]>0) {
					down[i] = arr[i] - arr[i+1];
				}else {
					up[i] = 0;
					down[i] = 0;
				}
			}
			Arrays.sort(up);
			Arrays.sort(down);
			
			System.out.printf("#%d %d %d%n", test_case, up[up.length-1], down[down.length-1]);
			sc.close();
		}
	}

}
