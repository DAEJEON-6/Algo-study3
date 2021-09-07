package boj;

import java.util.LinkedList;
import java.util.Scanner;

public class boj_1918 {

    private static int compare(char c) {
        if(c == '(') return 0;
        else if (c=='+' || c=='-') return 1;
        else if (c=='*' || c=='/') return 2;

        return -1;
    }

    private static String solution(final char[] input, int sourceIndex) {

        StringBuilder sb = new StringBuilder();
        LinkedList<Character> operatorStack = new LinkedList<Character>();

        for(char c : input) {
            if(Character.isAlphabetic(c)) {
                sb.append(c);
            } else if(c == '(') {
                operatorStack.add(c);
            } else if (c == ')') {
                while(operatorStack.getLast() != '(')
                    sb.append(operatorStack.pollLast());
                operatorStack.pollLast();
            } else {
                while(!operatorStack.isEmpty() && compare(operatorStack.getLast()) >= compare(c)) {
                    sb.append(operatorStack.pollLast());
                }
                operatorStack.add(c);
            }
        }

        while(!operatorStack.isEmpty()) {
            sb.append(operatorStack.pollLast());
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.nextLine().toCharArray();

        System.out.println(solution(input,0));
    }
}

/*
[Test]
A+B*C+D*E+G
: ABC*+DE*+G+
A*B+C+D+E*F*G+E
: AB*C+D+EF*G*+E+
A+B*C*((D-E)*G)
: ABC*DE-G**+
 */