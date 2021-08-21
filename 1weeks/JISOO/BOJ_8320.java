import java.util.Scanner;

public class BOJ_8320 {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int count = 0;
		
		for(int i=1; i<=N; i++) {
			for(int j=i; j*i<=N; j++) { //가로*세로가 주어진 정사각형의 넓이보다 작을때만 count증가
				count++;
			}
		}
		
		System.out.println(count);
		
	}

}
