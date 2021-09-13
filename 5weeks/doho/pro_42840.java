package programmers;

import java.util.ArrayList;

public class pro_42840 {
    public int[] solution(int[] answers) {
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};

        int[] count = new int[3];

        for(int i=0;i<answers.length;i++) {
            if ((answers[i] == one[(i % one.length)])) count[0]++;
            if ((answers[i] == two[(i % two.length)])) count[1]++;
            if ((answers[i] == three[(i % three.length)])) count[2]++;
        }

        int max = Math.max(count[0],Math.max(count[1],count[2]));
        ArrayList<Integer> answerList = new ArrayList();
        if(count[0] == max) answerList.add(1);
        if(count[1] == max) answerList.add(2);
        if(count[2] == max) answerList.add(3);

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
