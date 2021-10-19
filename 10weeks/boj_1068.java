import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
백준 1068 트리 문제 

부모 노드 기준으로 child를 저장해주어서 

DFS로 child가 없는 노드를 찾아주었습니다.

*/

public class Main {
	//child를 저장할 객체
	public static class Node{
		ArrayList<Integer> child = new ArrayList<Integer>();

		public Node(int num) {
			super();
			child.add(num);
		}
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //노드의 개수
		int N = Integer.parseInt(br.readLine());
		//노드 선언
		Node[] tree = new Node[N];
    //초기화
		for(int i=0; i<N; i++) {
			tree[i] = null;
		}
    
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = 0;
    //입력받아서 자식으로 넣어준다
		for (int i = 0; i < N; i++) {
			int parent = Integer.parseInt(st.nextToken());
      //-1은 시작값(루트)
			if (parent == -1) {
				start = i;
				continue;
			}
			//null이면 객체 만들어서 넣어주고 아니면 뒤에 추가해준다.
			if(tree[parent]!=null) {
				tree[parent].child.add(i);
			}else {
				tree[parent] = new Node(i);
			}
		}
		//제거할 노드 : 가지않을거다
		int remove = Integer.parseInt(br.readLine()); 
		
		System.out.println(dfs(tree, start, remove));
		
		
	}
  //객체 리스트, 현재 노드 넘버, remove된 넘버
	private static int dfs(Node[] tree, int number, int pass) {
  //삭제된 노드에 들어왔다는것이므로 0을 리턴
		if(number == pass) return 0;
		// 자식이 없으므로 말단 노드 이다. 1을 리턴해준다.
		if(tree[number] == null) {
			return 1;
		}
		//노드의 자식이 1개였는데 삭제되었으므로 1을 리턴
		if(tree[number].child.size()==1) {
			if(tree[number].child.get(0)==pass) {
				return 1;
			}
		}
		//리턴 할 변수
		int result = 0;
		//각각의 노드에 접근
		for(int next : tree[number].child) {
			result += dfs(tree, next, pass);
		}
		
		return result;
		
	}
}
