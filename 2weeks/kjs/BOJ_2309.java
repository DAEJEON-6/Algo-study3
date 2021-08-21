import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309 {

	static int[]heights; //아홉 난쟁이들의 키
	static int[]numbers; //조합된 일곱 난쟁이들의 키
	static int[]answers; //최종 일곱 난쟁이들의 키
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		heights = new int[9];
		numbers = new int[7];
		
		for(int i=0; i<9; i++) {
			heights[i] = sc.nextInt();
		}
		
		combination(0,0);
		
		Arrays.sort(answers); //오름차순으로 키 정렬
		
		for(int i=0; i<7; i++) {
			System.out.println(answers[i]);
		}
	}

	private static boolean combination(int cnt, int start) {
		
		if(cnt == 7) {
			int sum = 0;
			for(int i=0; i<7; i++) {
				sum += numbers[i];
			}
			if(sum == 100) { //일곱명의 난쟁이의 키가 100인 경우
				answers = Arrays.copyOf(numbers, numbers.length);
				return true;
			}
			return false;
		}
		
		for(int i=start; i<heights.length; i++) {
			numbers[cnt] = heights[i];
			if(combination(cnt+1, i+1)) {
				return true;
			}
		}
		return false;
	}

}
