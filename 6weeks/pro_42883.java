import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution {
    public String solution(String number, int k) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<number.length(); i++) {
        	int curr = number.charAt(i)-'0';
        	
        	if(sb.length()==0) {
        		sb.append(curr);
        		continue;
        	}
        	
        	while(k>0 && sb.length()!=0 && (sb.charAt(sb.length()-1)-'0')<curr) {
        		sb.setLength(sb.length()-1);
        		k--;
        	}
        	
        	if(k==0) {
        		answer = sb.toString()+number.substring(i);
        		break;
        	}
        	
        	sb.append(curr);
        }
        
        if(k!=0) {
        	answer=sb.substring(0, sb.length()-k);
        }
        
        return answer;

	}
}
