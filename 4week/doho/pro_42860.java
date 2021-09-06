package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class pro_42860 {

    private int getCost(char c) {
        int up = c - 'A';
        int down = 'Z' + 1 - c;
        return Math.min(up,down);
    }

    public int[] getDistance(boolean[] isChecked, final int startIndex) {
        int left = -1, right = -1;
        int leftIndex = -1, rightIndex = -1;
        int N = isChecked.length;
        for(int i=0;i<N;i++) {
            if(!isChecked[(startIndex+i)%N]) {
                left = i;
                leftIndex = (startIndex+i) % N;
                break;
            }
        }

        for(int i=0;i<N;i++) {
            int index = startIndex - i;
            if(index < 0)
                index += N;

            if(!isChecked[index]) {
                right = i;
                rightIndex = index;
                break;
            }
        }

        if(left <= right) {
            return new int[] {left, leftIndex};
        } else
            return new int[] {right, rightIndex};
    }

    public int solution(String name) {
        char[] str = name.toCharArray();
        boolean[] isChecked = new boolean[str.length];
        for(int i=0;i<str.length;i++) {
            if(str[i] == 'A')
                isChecked[i] = true;
        }

        int answer = getCost(str[0]);
        isChecked[0] = true;

        int index = 0;
        while(true) {
            int[] next = getDistance(isChecked,index);
            if(next[0] == -1)
                break;
            index = next[1];
            answer += (next[0] + getCost(str[index]));
            isChecked[index] = true;
        }

        return answer;
    }

    @Test
    void test1() {
        Assertions.assertEquals(solution("JAZ"),11);
    }

    @Test
    void test2() {
        Assertions.assertEquals(solution("JEROEN"),56);
    }

    @Test
    void test3() {
        Assertions.assertEquals(solution("JAN"),23);
    }

    @Test
    void test4() {
        Assertions.assertEquals(solution("ABABAAAAAAABA"),11);
    }
}
