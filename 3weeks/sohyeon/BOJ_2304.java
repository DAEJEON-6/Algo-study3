package algo.study.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// BOJ 2304. 창고 다각형
public class BOJ_2304 {

	static class Top implements Comparable<Top>{
		int x;
		int y;
		
		public Top(int x, int y) {
			super();
			this.x=x;
			this.y=y;
		}

		@Override
		public int compareTo(Top o) {
			return this.x-o.x;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());  // 기둥의 개수 N개
		ArrayList<Top> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int L = Integer.parseInt(st.nextToken());  // 각 줄에 각 기둥의 왼쪽면 위치 L
			int H = Integer.parseInt(st.nextToken());  // 각 줄에 각 기둥의 왼쪽면 위치 높이 H
			list.add(new Top(L,H));
		}
		Collections.sort(list);
		
		int maxX=0, area=0;
		
		// 왼쪽 -> 오른쪽
		Top currenttop = list.get(0);
		for(int i=1; i<N; i++) {
			if(currenttop.y<=list.get(i).y) {
				area+=(list.get(i).x-currenttop.x)*currenttop.y;
				currenttop = list.get(i);
				maxX=i;
			}
		}
		// 왼쪽 <- 오른쪽
		currenttop = list.get(N-1);
		for(int i=0; i<N-maxX; i++) {
			if(currenttop.y<=list.get(N-i-1).y) {
				area+=(currenttop.x-list.get(N-i-1).x)*currenttop.y;
				currenttop = list.get(N-i-1);
			}
		}
		area += currenttop.y;
		System.out.println(area);
	}

}
