package SWEA;

import java.util.Scanner;

public class swea_7272 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        String zero = "CEFGHIJKLMNSTUVWXYZ";
        String one = "ADOPQR";
        String two = "B";
        for(int test_case = 1; test_case <= T; test_case++)
        {
            System.out.print("#"+test_case+" ");
            String a = sc.next();
            String b = sc.next();
            boolean isDiff = false;

            if(a.length() != b.length()) {
                System.out.println("DIFF");
                continue;
            }
            for(int i=0;i<a.length();i++) {
                if(zero.contains(String.valueOf(a.charAt(i)))) {
                    if(!zero.contains(String.valueOf(b.charAt(i)))) {
                        isDiff = true;
                        break;
                    }
                } else if (one.contains(String.valueOf(a.charAt(i)))) {
                    if(!one.contains(String.valueOf(b.charAt(i)))) {
                        isDiff = true;
                        break;
                    }
                } else {
                    if(!two.contains(String.valueOf(b.charAt(i)))) {
                        isDiff = true;
                        break;
                    }
                }
            }
            if(isDiff)
                System.out.println("DIFF");
            else
                System.out.println("SAME");
        }
    }
}
