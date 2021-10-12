import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 슬라이딩 윈도우
 */
public class BOJ_15961 {
	private static int N, D, K, C, SushiType, Cnt;
	private static int[]map;
	private static int[]count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //벨트 위 접시 수
		D = Integer.parseInt(st.nextToken()); //초밥의 가짓수
		K = Integer.parseInt(st.nextToken()); //연속 접시 수
		C = Integer.parseInt(st.nextToken()); //쿠폰 번호

		map = new int[N]; //현재 벨트 위 회전초밥의 상태
		count = new int[D+1]; //각 초밥별 등장 횟수

		for(int i=0; i<N; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}

		add(C); //쿠폰에 해당하는 초밥 넣어주기

		for(int i=0; i<K; i++) { //가장 첫 번째 K개의 초밥상태 저장
			add(map[i]);
		}

		for(int i=1; i<N; i++) { //K개의 초밥을 고르는 시작 위치
			delete(map[(i-1)%N]); //기존 초밥 주 첫번째 초밥 제거
			add(map[(i+K-1)%N]); //새로운 초밥 한 개 추가
		}

		System.out.println(Cnt);

	}
	private static void delete(int sushi) {
		count[sushi]--;
		if(count[sushi]==0) { //해당 초밥의 개수가 0이되면, 초밥의 종류 감소
			SushiType--;
		}
	}
	private static void add(int sushi) {
		if(count[sushi]==0) { //해당 초밥이 처음 들어간 경우, 초밥의 종류 증가
			SushiType++;
		}
		count[sushi]++;
		if(SushiType > Cnt) { //현재 K개의 초밥상태가 종류가 가장 많은 경우, Cnt 갱신
			Cnt = SushiType;
		}
	}

}
