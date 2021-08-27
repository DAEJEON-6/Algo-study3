import java.util.Scanner;

public class BOJ_2564 {

	static int N;
	static int M;
	static int[]map;
	static int guardInd; //경비원의 위치
	static int shortestDis; //경비윈의 위치와 각 상점 사이 최단거리의 총합

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		int store = sc.nextInt();
		map = new int[2*(N+M)]; //경비원과 상점들의 위치를 저장하기 위한 1차원배열

		for(int i=0; i<store; i++) {
			int dir = sc.nextInt();
			int dis = sc.nextInt();
			map[mapToArray(dir, dis)] = 1; //상점들의 위치를 1로 저장
		}
		
		int gDir = sc.nextInt();
		int gDis = sc.nextInt();
		guardInd = mapToArray(gDir, gDis);

		for(int i=0; i<map.length; i++) {
			if(map[i] == 1) { //경비원의 위치와 각 상점 사이 최단 거리 구하기
				shortestDis += sumDistance(i);
			}
		}
		System.out.println(shortestDis);
	}

	private static int mapToArray(int dir, int dis) {
		int index = 0;
		switch (dir) {
		case 1: //왼쪽 위 모서리에서 더해준다
			index = dis;
			break;
		case 2: //왼쪽 아래 모서리에서 빼준다
			index = N+N+M-dis;
			break;
		case 3: //왼쪽 위 모서리에서 빼준다
			index = 2*(N+M)-dis;
			break;
		case 4: //오른쪽 위 모서리에서 더해준다
			index = N+dis;
			break;
		}
		return index;
	}

	private static int sumDistance(int ind) { //각 상점마다 경비원으로부터 최단 거리를 구함
		int a = Math.abs(guardInd-ind); //경비원에서 상점까지 거리를 직접빼준 거리
		int b = map.length - a; //전체거리에서 위 거리를 빼준 거리
		return Math.min(a, b);
	}
}