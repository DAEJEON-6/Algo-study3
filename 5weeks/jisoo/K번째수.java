import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            int[] temp = new int[commands[i][1]-commands[i][0]+1]; //필요한 크기만큼 temp배열 생성
            
            int start = commands[i][0]; //temp배열이 어디서부터 시작하는지 구함
            for(int j=0; j<temp.length; j++){ //array배열의 i-j번째까지 원소를 temp배열에 추가
                temp[j] = array[start-1];
                start++;
            }
            
            Arrays.sort(temp); //temp배열 오름차순으로 정렬
            answer[i] = temp[commands[i][2]-1]; //temp배열에 k번째 있는 수 answer배열에 저장
        }

        return answer;
    }
}