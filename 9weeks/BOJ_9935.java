import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine(); //전체 문자열
		String target = br.readLine(); //타겟 문자열
		char last = target.charAt(target.length()-1); //타겟 문자열의 마지막 문자
		StringBuilder sb = new StringBuilder();

		if(input.length() < target.length()) { //타겟 문자열의 크기가 전체 문자열보다 더 큰 경우
			System.out.println(input);
		}else {
			for(int i=0; i<input.length(); i++) {
				char cur = input.charAt(i);
				sb.append(cur); //일단 현재 문자열을 스트링빌더에 저장
				if(cur == last) { //타겟 문자열의 마지막 글자가 입력된 경우
					boolean flag = true;

					if(sb.length() < target.length()) { //타겟 문자열의 길이 현재 스트링빌더의 길이보다 큰 경우, 타겟 문자열 포함여부를 확인하지 않음
						continue;
					}

					for(int j=0; j<target.length(); j++) { //타겟 문자열을 모두 포함하는지 확인
						if(sb.charAt(sb.length()-target.length()+j)!=target.charAt(j)) {
							flag = false;
							break;
						}
					}
					if(flag) { //타겟 문자열을 모두 포함하면 타겟 문자열의 길이만큼 빼주기
						sb.setLength(sb.length()-target.length());
					}
				}
			}

			if(sb.length()==0) { //출력
				System.out.println("FRULA");
			}else {
				System.out.println(sb);
			}
		}
	}
}