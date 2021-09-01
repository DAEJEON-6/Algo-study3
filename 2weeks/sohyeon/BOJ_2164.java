package algo.study.boj.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// BOJ 2164. 카드2
public class BOJ_2164 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> q = new LinkedList<>();
		int N = sc.nextInt();
		int num=0;
		// queue에 카드 N까지 저장
		for(int i=1; i<=N; i++) q.add(i);
		
		while(!q.isEmpty() && q.size()>1) {
			if(num==0) {  // 카드를 버린다
				q.poll();
				num++;
			}else if(num==1) {  // 카드를 뒤로 보낸다
				q.add(q.poll());
				num--;
			}
		}
		System.out.println(q.peek());
		sc.close();
	}

}