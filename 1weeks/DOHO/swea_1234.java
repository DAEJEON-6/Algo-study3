package SWEA;

import java.util.Scanner;

public class swea_1234 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int T;
            T=sc.nextInt();
            String input = sc.next();
            int count = 0;
            while(count<input.length()-1) {
                if(input.charAt(count) == input.charAt(count+1)) {
                    input=input.replace((Character.toString(input.charAt(count))).repeat(2),"");
                    count--;
                    continue;
                }
                count++;
            }
            System.out.println("#"+test_case+" "+input);
        }
    }
}
