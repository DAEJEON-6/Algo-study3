package algo.study.boj.silver;

import java.util.Scanner;

public class BOJ_11399 {
	static int MinTime = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 사람 수
		int time[] = new int[N];
		for (int i = 0; i < N; i++) {
			time[i] = sc.nextInt();
		}
		per1(time, 0, 5, 5);
		System.out.println(MinTime);
	}

	// 1. Swap 함수를 이용해 구현 - 순서 없이 n 개중에서 r 개를 뽑는 경우
	static void per1(int[] arr, int depth, int n, int r) {
		int sum = 0;
		if (depth == r) {
			// print(arr, r);
			for (int i = 0; i < arr.length; i++) {
				for (int j = i; j >= 0; j--) {
					sum += arr[j];
				}
			}
			MinTime = Math.min(MinTime, sum);
			return;
		}

		for (int i = depth; i < n; i++) {
			swap(arr, depth, i);
			per1(arr, depth + 1, n, r);
			swap(arr, depth, i);
		}
	}

	static void swap(int[] arr, int depth, int i) { // 두 배열의 값을 바꾸는 Swap 함수
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}

	// 배열 출력
	static void print(int[] arr, int r) {
		for (int i = 0; i < r; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
