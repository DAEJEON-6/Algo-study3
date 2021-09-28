package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class pro_42839 {
    private static Set<String> set;
    private static StringBuilder sb;

    private static boolean isPrime(Integer number) {
        if (number < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    private static void permutation(final char[] list, int flag, final int level) {
        set.add(sb.toString());
        if (level >= list.length)
            return;

        for (int i = 0; i < list.length; i++) {
            if ((flag & (1 << i)) != 0) continue;
            sb.append(list[i]);
            permutation(list, flag |= 1 << i, level + 1);
            flag -= 1 << i;
            sb.delete(sb.length() - 1, sb.length());

        }

    }

    public int solution(String numbers) {
        set = new HashSet<>();
        sb = new StringBuilder();
        char[] list = numbers.toCharArray();

        // 순열
        for (int i = 0; i < list.length; i++) {
            sb.append(list[i]);
            permutation(list, 1 << i, 1);
            sb.delete(sb.length() - 1, sb.length());
        }

        Set<Integer> numberList = set.stream().mapToInt(Integer::parseInt).collect(HashSet::new, HashSet::add, HashSet::addAll);

        int answer = 0;
        for (Integer i : numberList) {
            System.out.println("i = " + i);
            if (isPrime(i))
                answer++;
        }
        return answer;

    }

    @Test
    @DisplayName("17")
    void test1() {
        Assertions.assertEquals(solution("17"), 3);
    }

    @Test
    @DisplayName("011")
    void test2() {
        Assertions.assertEquals(solution("011"), 2);
    }

    @Test
    @DisplayName("002")
    void test3() {
        Assertions.assertEquals(solution("002"), 1);
    }

    @Test
    @DisplayName("004")
    void test4() {
        Assertions.assertEquals(solution("004"), 0);
    }
}
