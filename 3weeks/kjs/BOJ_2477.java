import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2477 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		ArrayList<Integer>list = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine()); //1m^2에 자라는 참외의 개수

		int outerLength = 0; //가장 긴 변의 길이 (큰 직사각형의 한 변의 길이)
		int outerLengthIndex = 0;
		StringTokenizer st;
		
		for(int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken(); //방향은 사용하지 않음
			int length = Integer.parseInt(st.nextToken()); //육각형 각 변의 길이
			
			list.add(length); //변의 길이 저장
			if(length > outerLength) {
				outerLength = length; //큰 직사각형의 가장 긴 변 갱신
				outerLengthIndex = i;
			}
		}
				
		//큰 직사각형의 다른 한 변의 길이를 구하기 위해 가장 긴 변의 길이 양쪽을 살펴서 그 중 긴 변을 다른 한 변으로 선택
		//어떤 수를 음수로 나눈 나머지를 구할 때, 그 값이 양수가 되게하려면 Math.floorMod를 사용. ex) -1%6= -1이지만, Math.floorMod 사용 시 값이 5
		//%사용시, list(get(-1))이 나올 수 있어서 예외발생함
		int a = list.get(Math.floorMod(outerLengthIndex+1, 6));
		int b = list.get(Math.floorMod(outerLengthIndex-1, 6));
		
		int outerWidth = Math.max(a,b); //두 번째로 긴 변의 길이 (큰 직사각형 다른 한 변의 길이)
		int innerLength = Math.abs(a-b); //작은 직사각형 한 변의 길이
		
		int outerWidthIndex = list.indexOf(outerWidth);
		
		int c = list.get(Math.floorMod(outerWidthIndex+1, 6));
		int d = list.get(Math.floorMod(outerWidthIndex-1, 6));
		
		int innerWidth = Math.abs(c-d); //작은 직사각형 다른 한 변의 길이
						
		System.out.println(K*(outerLength*outerWidth - innerLength*innerWidth));
		
	}

}
