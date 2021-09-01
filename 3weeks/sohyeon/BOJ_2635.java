package algo.study.boj.silver;

import java.util.LinkedList;
import java.util.Scanner;

// BOJ 2635. 수 이어가기
public class BOJ_2635 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt(); // 첫번째 수
		int cnt = 0;
		LinkedList<Integer> result = new LinkedList<>();
		int first = num1;
		for (int i = num1; i >= first / 2; i--) {
			LinkedList<Integer> list = new LinkedList<>();
			list.add(first); // 첫번째 수
			int num2 = i;
			list.add(num2); // 두번째 수
			num1 = first;
			while (num1 - num2 >= 0) {
				int num3 = num1 - num2;
				list.add(num3);  // 앞의 두 수 차
				num1 = num2;
				num2 = num3;
			}
			// 문제 규칙으로 만들어지는 최대 개수의 수
			if (cnt < list.size()) {
				cnt = list.size();
				result = list;
			}
		}
		System.out.println(cnt);
		print(result);
		sc.close();
	}

	public static void print(LinkedList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}

}
