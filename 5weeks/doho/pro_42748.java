package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class pro_42748 {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> arr = Arrays.stream(array).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        ArrayList<Integer> answer = new ArrayList<>(50);

        for (int[] command : commands) {
            List<Integer> sub = new LinkedList<>(arr.subList(command[0]-1, command[1]));
            Collections.sort(sub);
            answer.add(sub.get(command[2]-1));
        }
        return answer.stream().mapToInt(a->a).toArray();
    }

    @Test
    void t1() {
        Assertions.assertArrayEquals(solution(new int[]{1,5,2,6,3,7,4}, new int[][]{{2,5,3},{4,4,1},{1,7,3}}),new int[]{5,6,3});
        //Assertions.assertEquals(solution(new int[]{1,5,2,6,3,7,4}, new int[][]{{2,5,3},{4,4,1},{1,7,3}}),new int[]{5,6,3});
    }
}
