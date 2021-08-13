import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            int nowHeight = sc.nextInt();
            int[] answer = {0,0};	// 오름, 내림
            for(int i=0;i<N-1;i++) {
                int nextHeight = sc.nextInt();
                int result = nextHeight - nowHeight;
                if(result < 0 ) {
               		answer[1] = Math.min(answer[1],result);
                } else if (result > 0) {
                 	answer[0] = Math.max(answer[0],result);
                }
                nowHeight = nextHeight;
            }
            System.out.println("#"+test_case+" "+answer[0]+" "+answer[1]*-1);
		}
	}
}