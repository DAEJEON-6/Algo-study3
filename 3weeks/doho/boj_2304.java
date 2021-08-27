package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Node> list = new ArrayList<>(N);
        int maxIndex = 0;
        int maxLength = 0;
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int index = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            if(maxLength < length) {
                maxIndex = index;
                maxLength = length;
            }
            list.add(new Node(index,length));
        }

        Collections.sort(list);
        int prevIndex = list.get(0).index;
        int prevLength = list.get(0).length;
        int answer = 0;
        for(int i=1;i<N;i++) {
            if(list.get(i).length < prevLength) continue;
            answer += (list.get(i).index - prevIndex) * prevLength;
            if(list.get(i).index >= maxIndex) break;
            prevLength = list.get(i).length;
            prevIndex = list.get(i).index;
        }

        prevIndex = list.get(N-1).index;
        prevLength = list.get(N-1).length;
        for(int i=N-2;i>0;i--) {
            if(list.get(i).length < prevLength) continue;
            answer += (prevIndex - list.get(i).index) * prevLength;
            if(list.get(i).index <= maxIndex) break;
            prevLength = list.get(i).length;
            prevIndex = list.get(i).index;
        }

        answer += maxLength;
        System.out.println(answer);
    }

    static class Node implements Comparable<Node> {
        private int index;
        private int length;

        public Node(int index, int length) {
            this.index = index;
            this.length = length;
        }

        @Override
        public int compareTo(Node o) {
            return this.index - o.index;
        }
    }
}

