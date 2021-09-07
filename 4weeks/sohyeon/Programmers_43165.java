package programmers.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Programmers 43165. 타겟넘버
public class Programmers_43165 {

	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());  // 배열 크기
		int[] numbers = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		int target = Integer.parseInt(br.readLine());  // 타겟 넘버
		System.out.println(solution(numbers, target));
	}
	
	public static int solution(int[] numbers, int target) {
		answer=0;
		
        dfs(numbers,target,0,0);
        
		return answer;
	}
	
    public static void dfs(int[] numbers, int target, int idx, int sum){
        // 탐색 끝
        if(idx == numbers.length){   
            // 누적 합이 target과 동일
            if(sum == target) answer++;
            return;
        }
        
        // 현재 인덱스의 정수 포함
        sum+=numbers[idx];
        // 다음 인덱스 dfs 수행
        dfs(numbers,target,idx+1,sum);
        // 현재 인덱스 정수 뺀 경우
        sum-=numbers[idx];
        // 현재 인덱스의 정수를 -
        sum+=(-1 * numbers[idx]);
        // 다음 인덱스 dfs 수행
        dfs(numbers,target,idx+1,sum);
        
    }
}
