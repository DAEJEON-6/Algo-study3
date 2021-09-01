package algo.study.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA D2 1859. 백만 장자 프로젝트
public class SWEA_1859 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());  // 테스트 케이스
		for(int test_case=1; test_case<=T; test_case++) {
			int N = Integer.parseInt(br.readLine());  // 매매가 개수
			int[] price = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			int max = price[N-1];
			long profit=0;
			for(int i=N-2; i>=0; i--) {
				if(max>price[i]) {
					profit +=max-price[i];
				}else {
					max=price[i];
				}
			}
			System.out.printf("#%d %d%n", test_case, profit);
		}
	}

}
