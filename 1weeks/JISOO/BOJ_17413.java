import java.util.Scanner;
import java.util.Stack;

public class BOJ_17413 {

	static Stack<Character>stack;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		stack = new Stack<>();
		String input = sc.nextLine();
		sb = new StringBuilder(); //최종 출력할 문자열
		StringBuilder withinTag = new StringBuilder(); //태그 포함, 태그 안에 저장될 문자열 (변하지 않음)

		for(int i=0; i<input.length(); i++) {			
			
			if(input.charAt(i)=='<') { //현재 문자열이 '<'인 경우				
				printStack();
				
				withinTag.append('<'); //시작 태그 붙여준다
				i++; //시작 태그 바로 뒤부터 확인
				while(true) {
					if(input.charAt(i) == '>') {
						break;
					}
					withinTag.append(input.charAt(i)); //태그 안에 있는 문자열들을 전부 더한다
					i++;
				}
				withinTag.append('>'); //종료 태그를 붙여준다
				sb.append(withinTag); //태그 포함, 태그 안에 있던 문자열을 최종 문자열에 추가
				withinTag.setLength(0); //withinTag 초기화
				
			}else if(input.charAt(i) == ' ') { //현재 문자열이 공백인 경우
				printStack();
				sb.append(' ');	 //공백 문자 추가
				
			}else{ //실질적인 문자열이 입력된 경우 (공백이나 태그가 아닌)
				stack.push(input.charAt(i));
			}
		}
		
		printStack(); //마지막 문자열 덩어리가 출력 안된 경우
		
		System.out.println(sb);
	}

	private static void printStack() { //현재 읽은 문자열이 공백, 시작 태그, 마지막 인덱스인 경우 스택에 남아있는 모든 문자열을 최종 문자열에 추가
		while(!stack.isEmpty()) { 
			sb.append(stack.pop());
		}			
	}
}
