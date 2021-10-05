package algo.study.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ 16235. 나무 재테크
public class BOJ_16235 {

	static int N;  // 땅 크기 N*N
	static int M;  // 처음 땅에 심은 나무 개수 M개
	static int K;  // K년 후
	static PriorityQueue<Tree> q;  // 나이순 정렬한 큐
	static int[][] nutrient;
	static int[][] S2D2;
	static Queue<Tree> live;
	static Queue<Tree> dead;
	static int[][] deltas = {{-1,0},{-1, 1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};  // 8방 탐색

	static class Tree implements Comparable<Tree>{
		int x,y;
		int age;

		public Tree(int x, int y, int age) {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}
	}
	// r과 c는 1부터 시작한다.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		// 겨울에 S2D2가 땅을 돌아다니면서 땅에 추가하는 양분 양 저장
		S2D2 = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1; j<=N; j++) {
				S2D2[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 심은 나무 초기 상태
		q = new PriorityQueue<Tree>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			q.add(new Tree(x,y,age));
		}
		// 양분 초기 상태
		nutrient = new int[N+1][N+1];	
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				nutrient[i][j]=5;  // 가장 처음에 양분은 모든 칸에 5만큼 들어있다.
			}
		}
		
		live = new LinkedList<Tree>();  // 살아있는 나무
        dead = new LinkedList<Tree>();  // 죽은 나무

		// K년이 지난다.
		for(int i=0; i<K; i++) year();
	    // K년이 지난 후 상도의 땅에 살아있는 나무의 개수
		System.out.println(q.size());
	}
	public static void year() {
		spring();
		summer();
		autumn();
		winder();
	}
	// 봄
	// 나무는 자신의 나이만큼 양분을 먹는다. 
	// 나이가 1 증가한다.
	// 하나의 칸에 여러 개의 나무가 있다면 어린 나무 부터 양분을 먹는다. 
	// 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
	public static void spring() {
		while(!q.isEmpty()) {
			Tree tree = q.poll();
			int x = tree.x;
			int y = tree.y;
			int age = tree.age;
			if(age <= nutrient[x][y]) {
				nutrient[x][y] -= age;  // 자신의 나이만큼 양분을 먹는다.
				age++;  // 나이 1 증가
				live.add(new Tree(x,y,age));  // 살아 있는 나무 정보 추가 업데이트
			}else {  // 땅에 양분이 부족하면 그 나무는 죽는다.
				dead.add(new Tree(x,y,age));
			}
		}
	}
	// 여름
	// 봄에 죽은 나무가 양분으로 변한다. 
	// 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다. (소수점 아래 버림)
	public static void summer() {
		while(!dead.isEmpty()) {
			Tree tree = dead.poll();
			int x = tree.x;
			int y = tree.y;
			int age = tree.age;
			nutrient[x][y] += age/2;
		}
	}
	// 가을
	// 나무가 번식한다.
	// 번식하는 나무는 나이가 5의 배수이어야 한다.
	// 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
	public static void autumn() {
		while(!live.isEmpty()) {
			Tree tree = live.poll();
			int x = tree.x;
			int y = tree.y;
			int age = tree.age;
			if(age % 5 == 0) {
				// 8방 탐색
				for(int dir=0; dir<8; dir++) {
					int dx = x + deltas[dir][0];
					int dy = y + deltas[dir][1];
					// 맵 범위 밖이면 continue;
					if(dx<1 || dx>N || dy<1 || dy>N) continue;
					q.add(new Tree(dx,dy,1));
				}
			}
			q.add(new Tree(x, y, age));
		}
	}
	
	// 겨울
	// S2D2가 땅을 돌아다니며 땅에 양분을 추가한다. 
	// 각 칸에 추가되는 양분의 양 A[r][c]이다.
	public static void winder() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				nutrient[i][j] += S2D2[i][j];
			}
		}
	}

}
