package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;


public class pro_43162 {

    private int[] parent;

    private int find(int number) {
        if(parent[number] == number)
            return number;
        return parent[number] = find(parent[number]);
    }

    public int solution(int n, int[][] computers) {
        parent = new int[n];
        for(int i=0;i<n;i++)
            parent[i] = i;

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i==j) continue;
                if(computers[i][j] == 1) {
                    int iFind = find(i);
                    int jFind = find(j);
                    if(iFind != jFind)
                        parent[jFind] = iFind;
                }
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++) {
            set.add(find(i));
        }
        return set.size();
    }

    @Test
    void test1() {
        Assertions.assertEquals(solution(3,new int[][] {{1,1,0},{1,1,0},{0,0,1}}),2);
    }

    @Test
    void test2() {
        Assertions.assertEquals(solution(3,new int[][] {{1,1,0},{1,1,1},{0,1,1}}),1);
    }
}
