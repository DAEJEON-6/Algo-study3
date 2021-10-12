import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * [백준] 문자열 폭발
 *  출처 : https://www.acmicpc.net/problem/9935
 *  풀이 기법 : stack을 이용했습니다.
 */

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        String comp = br.readLine();
        int N = comp.length();
        //누적할 스택 ;
        Stack<Character> stack = new Stack<Character>();
        int cnt = 0;
        
        for(int i=0; i<str.length(); i++) {
        	stack.push(str.charAt(i));
        	if(stack.peek().compareTo(comp.charAt(cnt))==0) {
        		cnt++;
        		if(cnt==N) {
        			while(cnt-->0) {
        				stack.pop();
        			}
        			cnt=0;
        			
        			boolean check = true;
        			
    			out : while(check) {
	        			int start = (stack.size()-N-1>=0)?stack.size()-N-1:0;
	        			int end = stack.size();
	        			
	        			for(int j=start; j<end; j++) {
	        				if(stack.get(j).compareTo(comp.charAt(cnt))==0) {
	        					cnt++;
	        					if(cnt==N) {
	        						while(cnt-->0) {
	        							stack.pop();
	        						}
	        						cnt=0;
	        						continue out;
	        					}
	        				}else {
	        					cnt=0;
	        	        		if(stack.get(j).compareTo(comp.charAt(cnt))==0) 
	        	        			cnt++;
	        				}
	        			}
	        			check = false;
        			}
        			
        		}
        		
        	}else {
        		cnt = 0;
        		if(stack.peek().compareTo(comp.charAt(cnt))==0) {
        			cnt++;
        		}
        	}
        }
        
        
        StringBuilder sb = new StringBuilder();
        
        if(stack.isEmpty()) {
        	bw.write("FRULA");
        }else {
        	for(char c : stack) {
        		sb.append(c);
        	}
        	bw.write(sb.toString());
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}
