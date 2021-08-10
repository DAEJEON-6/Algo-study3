package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");// 우편 우유 신문
        for(int i=0;i<3;i++) {
            int time = Integer.parseInt(st.nextToken());
            int count = 0;

            int retval = time%(A+B);
            if(retval <= A  && retval > 0)
                count++;
            retval =time % (C+D);
            if( retval <= C && retval > 0)
                count++;
            System.out.println(count);
        }



    }
}
