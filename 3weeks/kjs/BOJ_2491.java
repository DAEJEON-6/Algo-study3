import java.util.Scanner;

public class BOJ_2491 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[]map = new int[N];
		for(int i=0; i<N; i++) {
			map[i] = sc.nextInt();
		}
		
		int countInc = 0; //연속해서 커지는 수열의 길이
		int countDec = 0; //연속해서 작아지는 수열의 길이
		
		for(int i=0; i<N; i++) {
			int tempInc = 1; //자기 자신을 포함하기에 1로 초기화
			for(int j=i; j<N-1; j++){
				if(map[j]<=map[j+1]) { //다음 원소가 자신보다 크거나 같은 경우, 카운트 증가
					tempInc++;
				}else {
					break;
				}	
			}
			countInc = Math.max(countInc, tempInc); //처음 시작원소를 바꾸기 전 연속해서 커지는 수열의 길이 갱신
		}
		
		
		for(int i=0; i<N; i++) {
			int tempDec = 1; //자기 자신을 포함하기에 1로 초기화
			for(int j=i; j<N-1; j++){
				if(map[j]>=map[j+1]) { //다음 원소가 자신보다 크거나 같은 경우, 카운트 증가
					tempDec++;
				}else {
					break;
				}	
			}
			countDec = Math.max(countDec, tempDec); //처음 시작원소를 바꾸기 전 연속해서 작아지는 수열의 길이 갱신
		}
		
		System.out.println(Math.max(countInc, countDec)); //연속해서 커지거나 작아지는 수 중에서 큰 길이를 출력
	}

}
