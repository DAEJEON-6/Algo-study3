package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int count = 0;
        for (int i = 0; i < input.length;) {
            count++;
            if(i+1 >= input.length)
                break;
            // i+1 == =
            if(input[i]=='s' || input[i]=='z') {
                if(input[i+1]=='=')
                    i+=2;
                else
                    i++;
            } else if(input[i] == 'c') {
                if(input[i+1] == '=' || input[i+1] == '-')
                    i+=2;
                else
                    i++;
            } else if(input[i] == 'l' && input[i+1] == 'j')
                i+=2;
            else if(input[i] == 'n' && input[i+1]=='j')
                i+=2;
            else if(input[i]=='d') {
                if(input[i+1] == '-')
                    i+=2;
                else if(i+2 < input.length && input[i+1]=='z' && input[i+2]=='=')
                    i+=3;
                else
                    i++;
            } else
                i++;
        }
        System.out.println(count);
    }
}
