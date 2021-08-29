import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2304 {

	static class Node implements Comparable<Node>{
		
		int row;
		int height;
		public Node(int row, int height) {
			super();
			this.row = row;
			this.height = height;
		}
		@Override
		public int compareTo(Node o) {
			return this.row-o.row; //위치 기준 오름차순으로 정렬
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<Node>list = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		int maxHeight = 0; //최대 기둥의 높이
		int maxIndex = 0; //최대 기둥의 높이가 위치한 인덱스 (중복 시, 가장 오른쪽 인덱스)
		int area = 0; //최소 넓이
		Stack<Node>left = new Stack<>();
		Stack<Node>right = new Stack<>();

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			list.add(new Node(row, height));
		}
		
		Collections.sort(list); //정렬을 수행한다고 명시해야함
		
		for(int i=0; i<N; i++) { //가장 높은 높이와 인덱스 구하기 (가장 높은 높이가 여러개인 경우, 가장 오른쪽에 위치한 인덱스)
			if(list.get(i).height >= maxHeight) {
				maxHeight = list.get(i).height;
				maxIndex = i;
			}
		}

		int leftTop = 0;
		for(int i=0; i<maxIndex; i++) { //왼쪽에서부터 높이가 증가하는 왼쪽 기둥을 스택에 추가
			if(list.get(i).height >= leftTop) {
				leftTop = list.get(i).height;
				left.push(list.get(i));
			}
		}
		
		int rightTop = 0;
		for(int i=N-1; i>maxIndex; i--) { //오른쪽에서부터 높이가 증가하는 오른쪽 기둥을 스택에 추가
			if(list.get(i).height >= rightTop) {
				rightTop = list.get(i).height;
				right.push(list.get(i));
			}
		}
		
		int nextRow = list.get(maxIndex).row; //가장 높은 기둥의 인덱스로 초기화
		while(!left.isEmpty()) { //가장 높은 기둥의 왼쪽 넓이
			Node node = left.pop();
			area += node.height*(nextRow-node.row);
			nextRow = node.row;
		}
		
		int prevRow = list.get(maxIndex).row; //가장 높은 기둥의 인덱스로 초기화
		while(!right.isEmpty()) { //가장 높은 기둥의 오른쪽 넓이
			Node node = right.pop();
			area += node.height*(node.row-prevRow);
			prevRow = node.row;
		}
		
		area += maxHeight; //가장 높은 기둥의 넓이 (높이*1)
		
		System.out.println(area);
	}
}
