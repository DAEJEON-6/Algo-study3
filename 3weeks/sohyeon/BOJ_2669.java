package algo.study.boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 2669. 직사각형 네개의 합집합의 면적 구하기
public class BOJ_2669 {

	static int[][] area = new int[101][101];
	static int cnt=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int xstart = Integer.parseInt(st.nextToken());
			int ystart = Integer.parseInt(st.nextToken());
			int xend = Integer.parseInt(st.nextToken());
			int yend = Integer.parseInt(st.nextToken());
			paint(xstart, xend, ystart, yend);
		}
		System.out.println(cnt);
	}
	// 해당 면적 색칠 & 색칠 면적 count
	public static void paint(int xstart, int xend, int ystart, int yend) {
		for(int i=xstart; i<xend; i++) {
			for(int j=ystart; j<yend; j++) {
				if(area[i][j]==0) {
					area[i][j]=1;  // 색칠
					cnt++;
				}
			}
		}
	}
}
