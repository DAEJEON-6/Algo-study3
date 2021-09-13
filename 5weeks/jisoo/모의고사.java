import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
        int[] answer = {};
        int[] count = new int[3]; //각 학생의 맞춘 문제 수 계산하는 배열
        int student1 [] = {1,2,3,4,5};
        int student2 [] = {2,1,2,3,2,4,2,5};
        int student3 [] = {3,3,1,1,2,2,4,4,5,5};
        int answer1=0, answer2=0, answer3=0;
        
        for(int i=0; i<answers.length; i++){ //각 문제마마다 각 학생의 정답유무 확인
            if(answers[i] == student1[i%5]){
                answer1++;
            }
            if(answers[i] == student2[i%8]){
                answer2++;
            }
            if(answers[i] == student3[i%10]){
                answer3++;
            }
        }
        
        int max = Math.max(Math.max(answer1, answer2),answer3); // 가장 높은 점수받은 학생 구하기
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(max==answer1) list.add(1); //가장 높은 점수받은 학생이면 리스트에 추가
        if(max==answer2) list.add(2);
        if(max==answer3) list.add(3);
        
        answer = new int[list.size()];
        
        for(int i =0; i<answer.length; i++) { //리스트를 배열로 저장
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
}