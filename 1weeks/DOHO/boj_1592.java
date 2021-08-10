package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N,M,L;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int[] recvCount = new int[N];

        recvCount[0]++;
        int receiverIndex = 0;
        int sendCount = 0;
        while(true) {
            if(recvCount[receiverIndex] == M)
                break;
            if(recvCount[receiverIndex]%2 == 0){
                receiverIndex -= L;
                while(receiverIndex < 0)
                    receiverIndex += N;
            } else
                receiverIndex = (receiverIndex+L) % N;


            recvCount[receiverIndex]++;
            sendCount++;
        }
        System.out.println(sendCount);
    }
}
