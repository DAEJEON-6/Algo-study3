import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people); //몸무게 작은순부터 큰순으로 정렬
        int minInd = 0;
        int maxInd = people.length-1;

        while(minInd < maxInd){
            if(people[minInd]+people[maxInd] <= limit){
                minInd++;
                maxInd--;
            }else{
                maxInd--;
            }
            answer++;
        }
        if(minInd == maxInd){
            answer++;
        }

        return answer;
    }
}