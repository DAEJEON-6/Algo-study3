import java.util.Scanner;

public class BOJ_2798 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //카드의 갯수
		int M = sc.nextInt(); //딜러가 외친 숫자
		int[] cards = new int[N]; //카드를 저장할 배열
		int closestSum = 0; //합이 M보다 작고 M과 가장 가까운 수
		int tempSum = 0; //세 장의 카드 합을 저장할 임시 변수
		
		for(int i=0; i<N; i++) {
			cards[i] = sc.nextInt();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				for(int k=j+1; k<N; k++) {
					tempSum = cards[i]+cards[j]+cards[k]; //조합마다 세 장의 카드 합을 구함
					if(tempSum <= M && tempSum > closestSum) { //합이 M보다 작고  M과 가장 가까운 수보다 클 경우 M과 가장 가까운 수 갱신 
						closestSum = tempSum;
					}
					tempSum = 0;
				}
			}
		}
		System.out.println(closestSum);
	}

}
