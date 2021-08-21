import java.util.Scanner;

public class JO_1329 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if(N>100 || N%2==0) {
			System.out.print("INPUT ERROR!");
			System.exit(0);
		}else {
			
			int numStar = 1;
			int numSpace = 0;
			boolean upward = true;
			
			for(int i=0; i<N; i++) {
				
				for(int j=0; j<numSpace; j++) { //공백 출력
					System.out.print(" ");
				}
				
				for(int j=0; j<numStar; j++) { //별 출력
					System.out.print("*");
				}						
				
				if(i==N/2) {
					upward = false;
				}
				
				if(upward) { //별, 공백 갯수 모두 증가
					numStar = numStar + 2;
					numSpace++;
				}else { //별, 공백 갯수 모두 감소
					numStar = numStar - 2;
					numSpace--;
				}
				
				System.out.println(); //줄 바꿈
				
			}
		
		}
		
	}

}
