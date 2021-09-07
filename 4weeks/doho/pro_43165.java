package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class pro_43165 {
    private int answer = 0;

    private void DFS(final int index, final int sum, int[] numbers, final int target) {
        if(index >= numbers.length) {
            if(target == sum)
                answer++;
            return;
        }
        DFS(index+1,sum + numbers[index],numbers,target);
        DFS(index+1,sum - numbers[index],numbers,target);
    }

    public int solution(int[] numbers, int target) {

        DFS(0,0,numbers,target);
        return answer;
    }

    @Test
    void test1() {
        assertEquals(solution(new int[] {1,1,1,1,1},3),5);
    }
}
