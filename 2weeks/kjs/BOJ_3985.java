import java.util.Scanner;


public class BOJ_3985 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt(); //롤케이크 길이
		int N = sc.nextInt(); //방청객 수
		int[]cake = new int[L+1]; //롤케이크를 누가 얻었는지 표시
		int[]count = new int[N+1]; //방청객마다 얻은케이크 수를 저장
		int[]init = new int[N+1]; //처음 예측되는 롤케이크 개수 저장
		int maxExpected = 0; //가장 많은 케이크를 받을것으로 되었던 방청객 번호
		int maxCalculated = 0; //실제로 가장 많은 케이크를 받은 방청객 번호

		for(int i=1; i<=N; i++) {

			int P = sc.nextInt();
			int K = sc.nextInt();

			init[i] = K-P;

			if(K-P > init[maxExpected]) { //가장 많은 케이크를 받을것으로 되었던 방청객 번호 갱신
				maxExpected = i;
			}
			
			if(K-P > maxExpected) {
				maxExpected = i;
			}

			for(int j=P; j<=K; j++) {
				if(cake[j]!=0) { //이미 번호가 적혀있는 케이크는 넘어간다
					continue;
				}
				cake[j] = i; //롤케이크에 방청객의 번호 저장
				count[i]++; //방청객의 케이크 개수 갱신
			}
		}

		for(int i=1; i<=N; i++) { //가장 많은 케이크를 얻은 방청객 번호 구하기
			if(count[i]>count[maxCalculated]) {
				maxCalculated = i;
			}
		}

		System.out.print(maxExpected+"\n"+maxCalculated);
	}

}
