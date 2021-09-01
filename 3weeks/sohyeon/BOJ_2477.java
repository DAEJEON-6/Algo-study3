package algo.study.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// BOJ 2477. 참외밭
public class BOJ_2477 {

	static int[][] length;
	static int maxrow, maxcol;  // 최대길이의 가로,세로길이의 방향 번호
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());  // 참외 개수 K
		length = new int[6][2];  // 변 방향, 밭 경계 길이 
		for(int i=0; i<6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			length[i][0] = Integer.parseInt(st.nextToken());
			length[i][1] = Integer.parseInt(st.nextToken());
		}
		System.out.println(K*(getAll()-getPart()));
	}

	// 밭이 ㅁ형태라고 가정한 넓이
	public static int getAll() {
		int row=Integer.MIN_VALUE,col=Integer.MIN_VALUE;
		for(int i=0; i<6; i++) {
			// 최대 가로 길이
			if(length[i][0]==1 || length[i][0]==2) {
				if(col<length[i][1]) {
					col=length[i][1];
					// 최대 가로 길이의 방향 번호 저장
					maxcol=length[i][0];
				}
			}
			// 최대 세로 길이
			if(length[i][0]==3 || length[i][0]==4) {
				if(row<length[i][1]) {
					row=length[i][1];
					// 최대 세로 길이의 방향 번호 저장
					maxrow=length[i][0];
				}
			}
		}
		return row*col;
	}
	// ㅁ형태에서 꺾인 부분 넓이
	public static int getPart() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=0; i<6; i++) {
			// 이전, 이후가 꺾인 부분 방향이라면
			if(length[i][0]!=maxrow && length[i][0]!=maxcol) {
				// 이전, 이후 접근할 때 원형으로 이어진 것 처럼 구현
				// 이전 : i==0일 때만 마지막 방 접근, 나머지는 -1방 접근
				// 이후 : (i+1)%6 하면 원형 구현 가능
				if(i==0) {
					if(length[5][0]!=maxrow && length[5][0]!=maxcol && length[(i+1)%6][0]!=maxrow && length[(i+1)%6][0]!=maxcol) list.add(length[i][1]);
				}
				else{
					if(length[i-1][0]!=maxrow && length[i-1][0]!=maxcol && length[(i+1)%6][0]!=maxrow && length[(i+1)%6][0]!=maxcol) list.add(length[i][1]);
				}
			}
		}
		return list.get(0) * list.get(1);
	}
}
