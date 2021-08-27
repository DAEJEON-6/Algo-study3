import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_6603 {
	static int K; //로또에서 몇 개 번호를 고를지
	static int[] S; //로또에서 사용할 수 있는 수의 집합
	static int[] numbers = new int[6]; //각 조합된 로또번호
	static int[] temp = new int[6];
	static ArrayList<int[]>list = new ArrayList<int[]>(); //조합된 로또번호의 총 합

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		while(true) {

			K = sc.nextInt();
			if(K==0) { //입력으로 0을 받으면 종료
				break;
			}

			S = new int[K];
			for(int i=0; i<K; i++) { //사용할 번호 저장
				S[i] = sc.nextInt();
			}

			combination(0,0);

			for(int i=0; i<list.size(); i++) {
				for(int j: list.get(i)) {
					System.out.print(j+ " ");
				}
				System.out.println();
			}

			System.out.println();
			list.clear(); //테케마다 초기화
		}
		
	}

	private static void combination(int cnt, int start) { //로또번호 조합 구하기

		if(cnt == 6) {
			//list.add(numbers); //ref타입이라 이렇게 하면 안된다. 이렇게 하면 numbers가 최종 조합에 나오는 7777777을 참조하게 된다.
			temp = Arrays.copyOf(numbers, 6);
			list.add(temp); //조합된 로또번호 리스트에 저장
			return;
		}

		for(int i=start; i<K; i++) {
			numbers[cnt] = S[i];
			combination(cnt+1, i+1);
		}

	}
}