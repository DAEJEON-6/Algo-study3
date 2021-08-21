import java.util.Scanner;

public class BOJ_2941 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		String str = sc.next();
		
		for(int i=0; i<str.length(); i++) {
			count++;
			switch (str.charAt(i)) {
			case 'c': //현재 문자열이 c이고 다음 문자열이 해당 조건을 만족하면 두 문자를 하나의 문자로 본다
				if(i+1<str.length()) {			
					if(str.charAt(i+1)=='=' || str.charAt(i+1)=='-') {
						i++;
					}
				}
				break;
			case 'd': 
				if(i+1<str.length()) { 
					if(str.charAt(i+1)=='-') { //현재 문자열이 d이고 다음 문자열이 -이면 두 문자열을 하나의 문자로 본다
						i++;
					}else if(str.charAt(i+1)=='z') { //현재 문자열이 d이고 다음 문자열이 z, 그리고 그 다음 문자열이 =이면 세 문자열을 하나의 문자로 본다
						if(i+2<str.length() && str.charAt(i+2)=='=') {
							i = i+2;
						}						
					}	
				}
				break;
			case 'l':
				if(i+1<str.length()) {
					if(str.charAt(i+1)=='j') {
						i++;
					}
				}
				break;
			case 'n':
				if(i+1<str.length()) {
					if(str.charAt(i+1)=='j') {
						i++;
					}
				}
				break;
			case 's':
				if(i+1<str.length()) {
					if(str.charAt(i+1)=='=') {
						i++;
					}
				}
				break;
			case 'z':
				if(i+1<str.length()) {
					if(str.charAt(i+1)=='=') {
						i++;
					}
				}
				break;
			}
		}
		System.out.println(count);
	}
}
