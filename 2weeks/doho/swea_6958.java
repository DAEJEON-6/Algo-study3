import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            int maxCount = 0;
            int answer = 0;
            
            for(int i=0;i<N;i++) {
                String[] temp = br.readLine().split(" ");
                int count = 0;
                for(int j=0;j<M;j++) {
                 	if(Integer.parseInt(temp[j]) == 1) count++;   
                }
                
                if(count > maxCount) {
                    maxCount = count;
                    answer = 1;
                } else if (count == maxCount) {
                    answer++;
                }
            }
            System.out.println("#"+test_case+" "+answer+" "+maxCount);
		}
	}
}