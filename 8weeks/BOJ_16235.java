import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16235 {

	private static class Tree{
		int age;
		public Tree(int age) {
			super();
			this.age = age;
		}
	}
	private static class Point{
		int r;
		int c;
		int numTree; //나무의 개수
		int nutrientAdded; //겨울에 추가되는 양분의 양
		int curNutrient; //현재 양분의 양 (초기값: 5)
		int deadTreeAge; //죽은 나무의 나이 합
		ArrayList<Tree>list; //나무 리스트
		public Point(int r, int c, int numTree, int nutrientAdded, int curNutrient, int deadTreeAge, ArrayList<Tree> list) {
			super();
			this.r = r;
			this.c = c;
			this.numTree = numTree;
			this.nutrientAdded = nutrientAdded;
			this.curNutrient = curNutrient;
			this.deadTreeAge = deadTreeAge;
			this.list = list;
		}
	}
	private static int N, M, K, totalTree;
	private static Point[][]map;
	private static int[][]delta = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //NxN행열
		M = Integer.parseInt(st.nextToken()); //처음에 심은 나무 개수
		K = Integer.parseInt(st.nextToken()); //연도
		map = new Point[N+1][N+1]; //각 칸마다 Point객체 저장 (1인덱스부터 시작)

		for(int i=1; i<=N; i++) { //각 칸마다 겨울에 추가되는 양분의 양 저장
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				ArrayList<Tree>list = new ArrayList<>();
				map[i][j] = new Point(i, j, 0, Integer.parseInt(st.nextToken()), 5, 0, list);
			}
		}

		for(int i=0; i<M; i++) { //처음 심은 나무 정보 저장
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			map[r][c].list.add(new Tree(age));
			map[r][c].numTree++;
			totalTree++;
		}

		treeZTech();
		int result = countTree();

		System.out.println(result);
	}
	private static int countTree() {
		int numTree = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				numTree += map[i][j].numTree;
			}
		}
		return numTree;
	}
	private static void treeZTech() {
		for(int i=0; i<K; i++) { //K연도 만큼
	
			int treeCnt = 0;
			boolean search = true;
			
			//봄
			for(int j=1; j<=N; j++) {
				for(int k=1; k<=N; k++) {
					if(treeCnt==totalTree) {
						search = false;
						break;
					}
					for(int l=0; l<map[j][k].list.size(); l++) {
						Tree tree = map[j][k].list.get(l);
						if(tree.age == 0) { //죽은 나무는 스킵
							continue;
						}
						if(map[j][k].curNutrient >= tree.age) { //각 칸에있는 나무들을 순회하며 나무들의 나이만큼 각 칸에 해당되는 양분을 빼줌
							map[j][k].curNutrient -= tree.age;
							tree.age++; //나이 증가
							treeCnt++;
						}else {
							map[j][k].deadTreeAge += tree.age;
							map[j][k].numTree--; //나무 개수 빼주기
							tree.age = 0;
							treeCnt++;
							//tree = null; 왜 안되는건가...
						}
					}
				}
				if(!search) {
					break;
				}
			}

			//여름
			for(int j=1; j<=N; j++) {
				for(int k=1; k<=N; k++) {
					if(map[j][k].deadTreeAge!=0) {
						if(map[j][k].deadTreeAge%2 == 0) { //죽은 나무의 나이 총합이 짝수이면, 2로 나누고 1을 빼준만큼을 양분에 추가
							map[j][k].curNutrient += (map[j][k].deadTreeAge/2)-1; 
						}else { //죽은 나무의 나이 총합이 홀수이면, 2로 나눈 만큼을 양분에 추가
							map[j][k].curNutrient += (map[j][k].deadTreeAge/2); 
						}
					}
				}
			}
					
			//가을
			ArrayList<int[]>temp = new ArrayList<>(); //추가할 나무 리스트 (위치 저장)
			for(int j=1; j<=N; j++) {
				for(int k=1; k<=N; k++) {
					for(int l=0; l<map[j][k].list.size(); l++) {
						Tree tree = map[j][k].list.get(l);
						if(tree.age>0 && tree.age%5 == 0) { //나무가 죽지 않았고 나이가 5의 배수이면
							for(int m=0; m<8; m++) { //범위 안에 있는 8방에 나이가 1인 나무를 심음
								int nr = j+delta[m][0];
								int nc = k+delta[m][1];
								if(nr>=1 && nr<=N && nc>=1 && nc<=N) {
									temp.add(new int[] {nr,nc});
									totalTree++;
								}
							}
						}
					}
				}
			}

			for(int[] newTree: temp) { //새로운 나무를 해당 좌표 나무 리스트 가장 앞에 추가 (나이 순서대로 양분을 섭취하기때문)
				map[newTree[0]][newTree[1]].list.add(0, new Tree(1));
				map[newTree[0]][newTree[1]].numTree++;
			}
			
			//겨울
			for(int j=1; j<=N; j++) {
				for(int k=1; k<=N; k++) {
					map[j][k].curNutrient += map[j][k].nutrientAdded; //입력으로 주어진 양분만큼 추가
				}
			}
			
			for(int j=1; j<=N; j++) {
				for(int k=1; k<=N; k++) {
					map[j][k].deadTreeAge = 0; //죽은 나무의 나이 초기화
				}
			}

		}
	}

}
