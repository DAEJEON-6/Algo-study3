package algo.study.boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// BOJ 2999. 비밀 이메일
public class BOJ_2999 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] rc = findRC(str.length());	
		char[][] arr = new char[rc[0]][rc[1]];

		int k=0;
		for(int i=0; i<rc[1]; i++) {  // 0 1 2
			for(int j=0; j<rc[0]; j++) {  // 0 1
				arr[j][i] = str.charAt(k++);
			}
		}
		for(int i=0; i<rc[0]; i++) {  // 0 1
			for(int j=0; j<rc[1]; j++) {  // 0 1 2
				System.out.print(arr[i][j]);
			}
		}
		
	}
	public static int[] findRC(int length) {
		ArrayList<Integer> raw = new ArrayList<Integer>();
		ArrayList<Integer> cal = new ArrayList<Integer>();
		int[] rc = new int[2];
		
		for(int i=1; i<=length; i++) {
			if(length%i==0) {
				raw.add(i);  // 약수 구하기 
				cal.add(length/i);
			}		
		}
		for(int i=0; i<raw.size(); i++) {
			if(raw.get(i)<=cal.get(i)) {
				rc[0] = raw.get(i);
				rc[1] = cal.get(i);
			}
		}
		return rc;
	}
	
}
