import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


class Solution {
    
    static int n;
    static int[] number;
    static boolean[] prime;
    static HashSet<Integer> set;
    static boolean used[];
    
    public int solution(String numbers) {
        int answer = 0;
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        n = (int)Math.sqrt(9999999)+1;
        
        prime = new boolean[10000000];
        prime[0]=true;
        prime[1]=true;
        //에라토스테네스의 체 사용하여 소수 먼저구함    
        for(int i=2; i<=n; i++) {
        	if(prime[i]) continue;
        	
        	int temp = i+i;
        	while(temp<=9999999) {
        		prime[temp] = true;
        		temp += i;
        	}
        }
        n = numbers.length();
        
        number = new int[n];
        for(int i=0; i<n; i++) {
        	number[i] = numbers.charAt(i)-'0';
        }
        
        StringBuilder sb = new StringBuilder();
        set = new HashSet<Integer>();
        used = new boolean[n];

        //순열을 사용하여 가능한 모든 조합이 소수인지 확인 이때 중복을 방지하기 위해 hashset을 이용.
        permu(sb);

        answer = set.size();
        
        
        
        return answer;
    }
    
    	static public void permu(StringBuilder sb) {
		if(sb.length() == n) {
			return;
		}
		for(int i=0; i<n; i++) {
			if(used[i]) continue;
			sb.append(number[i]);
			used[i] = true;
			check(sb);
			permu(sb);
			used[i] = false;
			sb.setLength(sb.length()-1);
		}
	}
	
	static public void check(StringBuilder sb) {
		int number = Integer.parseInt(sb.toString());
		
		if(!prime[number]) set.add(number); 
	}
}
