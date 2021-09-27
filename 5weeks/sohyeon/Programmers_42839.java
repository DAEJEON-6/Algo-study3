package programmers.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Stream;

// Programmers 42839. 소수 찾기
public class Programmers_42839 {

	static int answer = 0;
	static ArrayList<Integer> primelist = new ArrayList<>();  // 만들어진 소수 저장하는 리스트
	
	public static void main(String[] args) throws IOException {
		// 부분 집합 문제
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String numbers = br.readLine();
		int result = solution(numbers);

		System.out.println("소수 개수 : " + result);
	}

	public static int solution(String numbers) {
		// String을 int형 배열로 변환
		int[] parsetoary = Stream.of(numbers.split("")).mapToInt(Integer::parseInt).toArray();
		boolean[] isVisited = new boolean[numbers.length()];
		getSubSet(isVisited, parsetoary, 0);
		return answer;
	}

	// 부분집합 함수
	public static void getSubSet(boolean[] isVisited, int[] set, int idx) {
		if (idx == set.length) {
			// 부분집합이 다 만들어짐
			int[] subset = new int[set.length];
			int cnt = 0;
			for (int i = 0; i < set.length; i++) {
				if (isVisited[i]) {
					subset[i] = set[i];
					cnt++;
				}
			}
			if (cnt != 0) {  // 부분집합의 개수가 0이 아닌 경우
				int[] result = new int[cnt];
				for (int i = 0, j = 0; i < set.length; i++) {
					if (isVisited[i] == true) {
						result[j++] = set[i];
					}
				}
				int[] permuary = new int[cnt];
				permutation(0, result, permuary, 0);
				
			}
			return;
		}
		isVisited[idx] = false;
		getSubSet(isVisited, set, idx + 1);

		isVisited[idx] = true;
		getSubSet(isVisited, set, idx + 1);
	}
	// 만들어진 부분집합(subset)을 순열로 모든 경우
	// result =  부분집합을 순열로 만든 것
	private static void permutation(int cnt, int[] subset,int[] result, int flag) {
		if(cnt == subset.length) {
			// result를 int로 만든다.
			String num = "";
			for(int i=0; i<result.length; i++) {
				num += result[i];
			}
			
			int i,number = Integer.parseInt(num);  // number = 123;
			
			for(i=0; i<primelist.size(); i++) {
				if(primelist.get(i).equals(number)) {
					break;
				}
			}
			// 리스트에 같은 원소가 없다.
			if(i==primelist.size()) {
				primelist.add(number);  // 순열로 만들어진 중복안되는 값 넣어주기.
				if (checkPrime(number)) {
					answer++;
				}
			}
			return;
		}
		// 가능한 모든 수들이 들어있는 배열 모든 원소에 대해 시도
		for(int i=0; i<subset.length; i++) {
			// flag : 현재 상태
			if((flag & 1<<i) != 0) continue;
			result[cnt] = subset[i];
			
			// 다음 자리 순열 뽑으로 gogo
			permutation(cnt+1, subset, result, flag | 1<<i);
			
		}
	}
	// 소수인지 확인하는 함수
	public static boolean checkPrime(int subset) {  // 7
		for (int i = 2; i < subset; i++) {
			// 나눠지는 값이 있으면 소수가 아니다.
			if (subset % i == 0) return false;
		}
		if(subset==0 || subset==1) return false;
		// 여기까지 왔다는 건 소수라는 것.
		return true;
	}
}
/*
 * input 17 output 3
 * 
 * input 011 output 2
 */
