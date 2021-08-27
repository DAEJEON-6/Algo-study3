package boj;

import java.util.LinkedList;
import java.util.Scanner;

public class boj_2635 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int answer = 0;
        LinkedList<Integer> answerList = null;
        for(int i=N/2+1;i<=N;i++) {
            LinkedList<Integer> list = new LinkedList<>();
            list.add(N);
            list.add(i);
            int index = 1;
            while(true) {
                int result = list.get(index-1) - list.get(index);
                if(result < 0)
                    break;
                list.add(result);
                index++;
            }
            if(answer < list.size()) {
                answer = list.size();
                answerList = list;
            }
        }
        System.out.println(answer);
        for(Integer i : answerList)
            System.out.print(i+" ");
    }
}
