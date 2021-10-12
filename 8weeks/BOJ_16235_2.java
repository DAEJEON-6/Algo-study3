import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList; //속도면에서 ArrayList보다 LinkedList가 훨씬 빠르다!!
import java.util.StringTokenizer;

public class BOJ_16235_2 {
	private static int N, M, K, Cnt;
	private static int[][]S2D2;
	private static int[][]nutrient;
	private static LinkedList<Tree>treeList = new LinkedList<Tree>();
	private static LinkedList<Tree>deadTreeList = new LinkedList<Tree>();
	private static int[][]delta = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	private static class Tree{
		int r;
		int c;
		int age;
		public Tree(int r, int c, int age) {
			super();
			this.r = r;
			this.c = c;
			this.age = age;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 땅 사이즈
		M = Integer.parseInt(st.nextToken()); //초기 나무 수
		K = Integer.parseInt(st.nextToken()); //연도
		S2D2 = new int[N+1][N+1]; //각 땅에 매년 추가되는 양분의 양
		nutrient = new int[N+1][N+1]; //각 땅의 존재하는 양분의 양

		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				S2D2[i][j] = Integer.parseInt(st.nextToken()); //각 땅마다 매년 추가되는 양분의 양 저장하기
				nutrient[i][j] = 5; //각 땅마다 초기 양분 5로 저장
			}
		}

		for(int i=0; i<M; i++) { //처음 심어준 나무 정보 저장
			st = new StringTokenizer(br.readLine()); 
			int r = Integer.parseInt(st.nextToken()); //위치
			int c = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken()); //나이
			treeList.add(new Tree(r,c,age));
		}

		treeZTech();
		calcNumTree();
		System.out.println(Cnt);
	}

	private static void calcNumTree() {
		for(Tree t: treeList) {
			if(t.age > 0) { //살아있는 나무의 숫자 세기
				Cnt++;
			}
		}
	}

	private static void treeZTech() {

		for(int i=0; i<K; i++) { //K년 만큼
			//봄
			Iterator<Tree>iterator = treeList.iterator();
			while(iterator.hasNext()) {
				Tree t = iterator.next();
				int r = t.r;
				int c = t.c;
				int age = t.age;
				if(nutrient[r][c] >= age) {
					nutrient[r][c] -= age;
					t.age++; //나무는 자신의 나이만큼의 양분을 현재 위치로부터 섭취하고, 나이가 증가한다
				}else {
					deadTreeList.add(t);
					iterator.remove(); //그렇지 못하면, 나무는 죽는다
				}
			}
			
			//리스트에 있는 요소를 지울 땐 iterator를 사용하자. 아래와 같이 for each 구문 사용하면 에러남
			
			/*for(Tree t: treeList) { 
				if(nutrient[t.r][t.c] >= t.age) {
					nutrient[t.r][t.c] -= t.age;
					t.age++;
				}else { 
					deadTreeList.add(t);
					treeList.remove(t);
				}
			}*/

			//여름
			for(Tree t: deadTreeList) { //봄에 죽은 나무마다 나이를 2로 나눈 값이 원래 자신의 칸 양분에 추가된다
				int added = t.age/2;
				nutrient[t.r][t.c] += added;
			}
			deadTreeList.clear();
			
		

			//가을
			LinkedList<Tree>temp = new LinkedList<>(); //번식된 나무를 임시적으로 저장
			for(Tree t: treeList) {
				if(t.age%5 == 0) { //나무의 나이가 5의 배수이면
					for(int j=0; j<8; j++) { //인접한 곳에 나이가 1인 나무 추가해주기
						int nr = t.r+delta[j][0];
						int nc = t.c+delta[j][1];
						if(nr>0 && nr<=N && nc>0 && nc<=N) {
							temp.add(new Tree(nr, nc, 1));
						}
					}
				}
			}
			if(temp!=null) {
				treeList.addAll(0, temp); //번식된 나무들을 가장 앞쪽에 저장 (나이순으로 양분을 섭취하기때문)
			}

			//겨울
			for(int j=1; j<=N; j++) { //로봇이 각 땅의 양분을 주어진 양만큼 보충해줌
				for(int k=1; k<=N; k++) {
					nutrient[j][k] += S2D2[j][k];
				}
			}
		}
	}

}
