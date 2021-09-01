package algo.study.boj.bronze;

import java.util.LinkedList;
import java.util.Scanner;

// BOJ 2605. 줄 세우기
public class BOJ_2605 {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int N = sc.nextInt();  // 학생 수
		LinkedList<Integer> student = new LinkedList<>();
		student.add(-1);
		for(int i=0; i<N; i++) {
			int order = sc.nextInt();
			student.add(i-order,i+1);			
		}
		for(int i=0; i<N; i++) {
			System.out.print(student.get(i)+ " ");
		}
		sc.close();
	}

}
