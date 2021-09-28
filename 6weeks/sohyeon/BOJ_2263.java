package algo.study.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 1263. 트리의 순회
public class BOJ_2263 {

	static int[] inOrder, postOrder, inOrderIdx;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		inOrder = new int[n+1];
		postOrder = new int[n+1];
		inOrderIdx = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			inOrder[i] = Integer.parseInt(st.nextToken());
			inOrderIdx[inOrder[i]]=i;
		}
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<n; i++) postOrder[i] = Integer.parseInt(st.nextToken());
		preOrder(0,n-1,0,n-1);
	}
	// 중위 순회(인오더)를 통해 왼쪽 자식의 트리와 오른쪽 자식의 트리를 알 수 있다. 
	// 후위 순회(포스트오더)를 통해 트리의 루트를 알 수 있다
	public static void preOrder(int in_start, int in_end, int post_start, int post_end) {
		if(in_start > in_end || post_start > post_end) return;
		// 루트 찾기(postOrder의 마지막 인덱스 post_end = 루트의 인덱스!
		int root = postOrder[post_end-1];
		// inorder에서 루트 인덱스 구하기
		int rootIdx = inOrderIdx[root];
		// inorder에서 루트 기준 왼쪽 노드 개수 계산
		int left = rootIdx - in_start;
		System.out.print(root+" ");
		// 왼쪽 자식 노드
		preOrder(in_start, rootIdx-1, post_start, post_start+left-1);
		// 오른쪽 자식 노드
		preOrder(rootIdx+1, in_end, post_start+left, post_end-1);
	}

}
