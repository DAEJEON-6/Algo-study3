package algo.study.boj.bronze;

import java.util.Scanner;

// BOJ 2991. 사나운개
public class BOJ_2991 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int aattack = sc.nextInt();
		int arest = sc.nextInt();
		int battack = sc.nextInt();
		int brest = sc.nextInt();
		int time[] = new int[3];
		int dogcnt[] = new int[3];
		int dogA = aattack + arest;
		int dogB = battack + brest;

		for (int i = 0; i < 3; i++) {
			time[i] = sc.nextInt();
			dogcnt[i] = 0;
		}

		for (int i = 0; i < 3; i++) {
			if (time[i] % dogA >= 1 && time[i] % dogA <= aattack) {
				dogcnt[i]++;
			}
			if (time[i] % dogB >= 1 && time[i] % dogB <= battack) {
				dogcnt[i]++;
			}
			System.out.println(dogcnt[i]);
		}
		sc.close();
	}

}
