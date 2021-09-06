package algo.study.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// BOJ 1918. 후위 표기식
public class BOJ_1918 {
    //연산자 우선순위
    public static int precedence(char c){
        if (c=='(') return 0;
        if (c=='+' || c=='-') return 1;
        else return 2;
    }

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c>='A' && c<='Z'){
                // 연산자가 아닌 경우엔 출력
                System.out.print(c);
            } else if (c==')'){
                // '('가 나올때까지 출력
                while (!stack.isEmpty()){
                    char tmp = stack.pop();
                    if (tmp=='(') break;
                    System.out.print(tmp);
                }
            } else if (c=='('){ // 피연산자가 아닐때
                // '('는 무조건 스텍에 집어넣음
                stack.push(c);
            } else {
                // 연산자 우선순위가 더 큰경우에만 Stack에 집어넣기
                // 우선순위가 같거나 낮은경우 우선 Stack에 있는 연산자 전부 출력 후 집어넣기
                while (!stack.isEmpty() && precedence(stack.peek())>=precedence(c)){
                    System.out.print(stack.pop());
                }
                stack.push(c);
            }
        }
        //스택에 남아있는 연산자 전부 출력
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}