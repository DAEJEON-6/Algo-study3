/*
비트마스킹을 이용한 조합으로 풀었습니다.
*/


class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        for(int i=1; i<(1<<numbers.length); i++) {
			int result = 0;
			
			for(int j=0; j<numbers.length; j++) {
				if((i & (1<<j))!=0) {
					result += numbers[j];
				}else {
					result -= numbers[j];
				}
			}
			
			if(result == target) answer++;
		}
        
        return answer;
    }
}
