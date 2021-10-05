import java.util.Arrays;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int N = answers.length;
        //각 사람들의 정답 패턴
        int p1[] = {1,2,3,4,5};
        int p2[] = {2,1,2,3,2,4,2,5};
        int p3[] = {3,3,1,1,2,2,4,4,5,5};
        
        int person[] = {0,0,0};
        //비교
        for(int i=0; i<N; i++){
            if(answers[i] == p1[i%5]) person[0]++;
            if(answers[i] == p2[i%8]) person[1]++;
            if(answers[i] == p3[i%10]) person[2]++;
        }
      //가장 큰 정답수
        int maxi = 0;
        for(int i=0; i<3; i++)
            maxi = Math.max(person[i], maxi);
        //몇명??
        int count=0;
        for(int i=0; i<3; i++)
            if(person[i]==maxi) count++;
        
        answer = new int[count];
        int n =0;
        for(int i=0; i<3; i++)
            if(person[i]==maxi) answer[n++] = i+1;
        //저장후 정렬
        Arrays.sort(answer);
        
        return answer;
    }
}
