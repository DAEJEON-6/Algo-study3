import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
  //BFS 위한 노드, 현재까지의 name, 위치, 이동거리를 저장한다.
    public static class Node{
		char[] cname ;
		int curr;
		int move = 0 ;
		Node(char[] cname, int curr, int move){
			this.cname = Arrays.copyOf(cname, cname.length);
			this.curr = curr;
			this.move = move;
		}
		
	}
    
    public int solution(String name) {
      
        int answer = 0;
        
        char[] names = name.toCharArray();
        int len = names.length;
        char[] init = new char[len];
        
        Arrays.fill(init,'A');
        
        Queue<Node> queue = new LinkedList<Node>();
        
        queue.add(new Node(init, 0, 0));
        
        
        //BFS를 이용하면 간단히 풀 수 있다.
        while(!queue.isEmpty()) {
        	Node curr = queue.poll();
        	
        	init = curr.cname;
        	int pos = curr.curr;
        	int move = curr.move;
        	
        	int updown = names[pos]-init[pos];
        	if(updown<=13) {
        		move+=updown;
        		init[pos] = names[pos];
        	}else {
        		move+= (26-updown);
        		init[pos] = names[pos];
        	}
        	//원하는 결과로 옮겨졌으면 answer 저장 후 탈출
        	if(Arrays.equals(names, init)) {
        		answer = move;
        		break;
        	}
            queue.add(new Node(init,(pos-1>=0)?pos-1:len-1,move+1));
    		queue.add(new Node(init,(pos+1<len)?pos+1:0,move+1));
        }
        
        return answer;
    }
}
