// 영서님 코드 참고했습니다.

public class 모음사전 {
	static char[]map = {'A','E','I','O','U'};
	static String word = "AAAAE";
	static int count;
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		permutation(sb);
		System.out.println(count);
	}

	private static boolean permutation(StringBuilder sb) {

		if(sb.toString().equals(word.toString())) { //원하는 문자열 찾음
			return true;
		}
		
		if(sb.length()==5) { //문자열의 크기는 5이상이 될 수 없음
			return false;
		}
		
		for(int i=0; i<5; i++) {
			count++;
			if(!permutation(sb.append(map[i]))) { //문자열 못 찾으면 크기 줄이기
				sb.setLength(sb.length()-1);
			}else { //원하는 문자열 찾으면 탐색 멈추기
				return true;
			}
		}
		
		return false;
	}
}