package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        if(K > R*C) {
            System.out.println(0);
            return;
        }

        int yRange = R;
        int flag = -1;
        int yIndex = R, xIndex = 0;
        int number = 0;
        while(number < K) {
            for(int i=0;i<R;i++) {
                yIndex += flag;
                ++number;
                if(number==K)
                    break;
            }
            R--;
            flag *= -1;

            if(number==K)
                break;

            for(int i=1;i<C;i++) {
                xIndex += flag;
                ++number;
                if(number==K)
                    break;
            }
            C--;

        }
        System.out.println((xIndex+1)+ " " + (yRange-yIndex));
    }
}
