package algo.study.boj.bronze;

import java.util.Arrays;
import java.util.Scanner;

// BOJ 2309. 일곱 난쟁이
public class BOJ_2309 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dwarf = new int[9];
		for (int i = 0; i < 9; i++) {
			dwarf[i] = sc.nextInt();
		}
		Arrays.sort(dwarf);
		int[] p = new int[9];
		int cnt = 0;
		while (++cnt <= 7)
			p[9 - cnt] = 1;
		int sum = 0;

		do {
			for (int i = 0; i < 9; i++) {
				if (p[i] == 1) {
					sum += dwarf[i];
				}
			}
			// 모자 수 합이 100인 경우 일곱 난쟁이 출력
			if (sum == 100) {
				for (int i = 0; i < 9; i++) {
					if (p[i] == 1) {
						System.out.println(dwarf[i]);
					}
				}
				break;
			}
			sum = 0;
		} while (nextpermutation(p));
		sc.close();
	}

	// 다음 큰 순열이 있으면 true, 없으면 false
	private static boolean nextpermutation(int[] numbers) {
		int N = numbers.length;

		// step1. 꼭대기(i)를 찾는다. 꼭대기를 통해 교환위치 찾기
		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i]) --i;

		if (i == 0)
			return false;

		// step2. (내리막이 있는 꼭대기를 찾은 경우) i-1 위치값과 교환할 큰 값 찾기
		int j = N - 1;
		while (numbers[i - 1] >= numbers[j]) --j;

		// step3. i-1위치값과 j위치값 교환
		swap(numbers, i - 1, j);

		// step4. 꼭대기(i)부터 맨 뒤까지 내림차순형태의 순열을 오름차순으로 처리
		int k = N - 1;
		while (i < k) {
			swap(numbers, i++, k--);
		}

		return true;
	}

	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
