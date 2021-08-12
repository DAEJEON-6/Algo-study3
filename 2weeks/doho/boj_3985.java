package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_3985 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        Node prediction = new Node();
        Node real = new Node();
        boolean[] cake = new boolean[L];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int P = Integer.parseInt(st.nextToken()) - 1;
            int K = Integer.parseInt(st.nextToken()) - 1;
            int count = 0;
            for (int j = P; j <= K; j++) {
                if (cake[j]) continue;
                cake[j] = true;
                count++;
            }
            if(K-P > prediction.counts) {
                prediction.counts = K-P;
                prediction.index = i;
            }
            if(count > real.counts) {
                real.counts = count;
                real.index = i;
            }
        }
        System.out.println(prediction.index);
        System.out.println(real.index);
    }

    static class Node {
        private int index;
        private int counts;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getCounts() {
            return counts;
        }

        public void setCounts(int counts) {
            this.counts = counts;
        }
    }
}
