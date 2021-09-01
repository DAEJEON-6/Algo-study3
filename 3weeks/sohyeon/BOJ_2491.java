package algo.study.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

// BOJ 2491. 수열
public class BOJ_2491 {

	static int N;
	static int[] arr;
	static int incnt=1,decnt=1;
	static LinkedList<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());  // 수열 길이
		arr = new int[N];
		list = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		increase();
		decrease();
		System.out.println(getMax());
	}
	// 증가하는 수열 길이 계산
	public static void increase() {
		for(int i=0; i<N-1; i++) {
			if(arr[i]<=arr[i+1]) { 
				incnt++;
			}
			else {
				list.add(incnt);
				incnt=1;
			}
		}
		list.add(decnt);  // 마지막 원소 cnt 추가
	}
	// 감소하는 수열 길이 계산
	public static void decrease() {
		for(int i=0; i<N-1; i++) {
			if(arr[i]>=arr[i+1]) {
				decnt++;
			}
			else {
				list.add(decnt);
				decnt=1;
			}
		}
		list.add(decnt);  // 마지막 원소 cnt 추가
	}
	// 증감 수열 길이 list 최대값 계산
	public static Integer getMax() {
		Collections.sort(list);
		return list.get(list.size()-1);
	}
}
