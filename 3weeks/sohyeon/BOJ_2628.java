package algo.study.boj.silver;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

// BOJ 2628. 종이자르기
public class BOJ_2628 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> rowList = new LinkedList<>();
		LinkedList<Integer> colList = new LinkedList<>();
		int col = sc.nextInt(); // 가로
		colList.add(col);
		int row = sc.nextInt(); // 세로
		rowList.add(row);
		int n = sc.nextInt(); // 자르는 횟수
		for (int i = 0; i < n; i++) {
			int dir = sc.nextInt(); // 자르는 방향
			int index = sc.nextInt(); // 자르는 위치
			if (dir == 0) {
				cutPaper(rowList, index);
			} else if (dir == 1) {
				cutPaper(colList, index);
			}
		}
		// 잘린 종이 중 가장 큰 가로, 세로 찾기 위한 정렬
		Collections.sort(rowList);
		Collections.sort(colList);
		System.out.println((rowList.get(rowList.size() - 1)) * (colList.get(colList.size() - 1)));
		sc.close();
	}
	public static void cutPaper(LinkedList<Integer> list, int index) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
			if (sum >= index) {
				if (i == 0) {
					list.remove();
					list.addFirst(index);
					list.add(1, sum-index);
				} else {
					// remove, add 할 때 i변화 유의 코딩
					int result=list.remove(i);
					int front=index-(sum-result);
					list.add(i,front);
					int back=sum-index;
					list.add(i+1,back);
				}
				break;
			}
		}
	}
}

