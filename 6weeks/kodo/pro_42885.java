package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class pro_42885 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int left = 0, right = people.length-1;
        while(true) {
            if(left > right)
                break;
            answer++;
            if(left==right) {
                break;
            }
            if(people[left]+people[right] <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
        }
        return answer;
    }

    @Test
    void t1() {
        int result = solution(new int[]{70,50,80,50},100);
        Assertions.assertEquals(result,3);
    }

    @Test
    void t2() {
        int result = solution(new int[]{70,50,80},100);
        Assertions.assertEquals(result,3);
    }
}
