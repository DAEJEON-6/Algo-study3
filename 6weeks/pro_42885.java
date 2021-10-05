import java.util.Arrays;


/* 풀이 방법 
*  무게 순으로 정렬하고 무게가 큰사람과 가장 작은사람이 같이 탈수있으면 같이 보낸다.
*  같이 보낼수 없으면 무거운사람만 보낸다
*  무게가 가장 큰사람이 limit의 절반이 되면 무조건 같이 보낼수 있으므로 남은 사람들을 모두 두명씩 태울수있다.
*/


class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        int N = people.length;
        Arrays.sort(people);
        
        int front = 0;
        for(int rear=N-1; rear>=0; rear--){
            if(people[rear]<=limit/2){
                int save = (rear-front)+1;
                answer += (save%2==0)?save/2:save/2+1;
                break;
            }
            
            if(limit>=people[rear]+people[front]){
                answer++;
                front++;
            }else{
                answer++;
            }
        }

        
        return answer;
    }
}
