import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2991 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		int[]delivery = new int[3];
		int[]count = new int[3];
		int index = 0;

		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()); //개1의 공격 시간
		int B = Integer.parseInt(st.nextToken()); //개1의 쉬는 시간
		int C = Integer.parseInt(st.nextToken()); //개2의 공격 시간
		int D = Integer.parseInt(st.nextToken()); //개2의 쉬는 시간

		int intervalDog1 = A+B;
		int intervalDog2 = C+D;

		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) { //우체부, 우유배달원, 신문배달원의 도착 시간 저장
			delivery[index] = Integer.parseInt(st.nextToken());
			index++;
		}

		for(int i=0; i<delivery.length; i++) {
			//개1의 공격시간 내 배달원이 방문한 경우 카운트 증가
			if(delivery[i]%intervalDog1 <= A && delivery[i]%intervalDog1 > 0) {
				count[i]++;
			}
			
			//개2의 공격시간 내 배달원이 방문한 경우 카운트 증가
			if(delivery[i]%intervalDog2 <= C && delivery[i]%intervalDog2 > 0) {
				count[i]++;
			}
		}

		for(int c: count) {
			System.out.println(c);
		}
	}

}
