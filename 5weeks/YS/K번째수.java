import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int tc=0; tc<commands.length; tc++){
            int len = commands[tc][1]-commands[tc][0]+1;
            int[] temp = new int[len];
            
            //copy
            for(int i=0; i<len; i++){
                temp[i] = array[commands[tc][0]-1+i];
            }
            //정렬
            Arrays.sort(temp);
            //저장
            answer[tc] = temp[commands[tc][2]-1];   
        }
        return answer;
    }
}
