import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-30
 * Description : 백준 1918
 */

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//입력받은 문자열
		String str = br.readLine();
    		
		List<Character> lst = new ArrayList<Character>();          //결과를 출력할 리스트
		List<Character> lst_temp = new ArrayList<Character>();     //우선순위가 높은 연산들(스택용)
		//현재 괄호의 갯수
		int count = 0;
    
    		//첫번째부터 문자열 하나씩 접근
		for(int i=0; i<str.length(); i++) {
			//숫자면 결과리스트에 추가
			if(str.charAt(i)>=65) {
				lst.add(str.charAt(i));
			}else { //연산자일 경우
				//우선순위가 낮은경우, )를 만났을때
				if((str.charAt(i)=='+' || str.charAt(i)=='-' || str.charAt(i)==')')) {
					//숫자가 아니고 * - )일때 (를 만날때까지 lst_temp에서 결과리스트로 뱉어낸다.
					while(!lst_temp.isEmpty() && (lst_temp.get(lst_temp.size()-1)!='(')) {
						lst.add(lst_temp.get(lst_temp.size()-1));
						lst_temp.remove(lst_temp.size()-1);
					}
					//다 뽑아냇는데 비어있지 않다는것은 (를 만났다는 것
					if(!lst_temp.isEmpty() && str.charAt(i)==')') {
						//따라서 )를 없애고 count--해준다.
						if(lst_temp.get(lst_temp.size()-1)=='(') {
							lst_temp.remove(lst_temp.size()-1);
							count--;
							//카운트가 0이 되었다는것은 괄호 연산을 다 한것이므로 앞에 입력받았던 우선순위가 낮은 문자들을 전부 넣어준다.
							if(count==0) {
								while(!lst_temp.isEmpty()&& (lst_temp.get(lst_temp.size()-1)=='+' && lst_temp.get(lst_temp.size()-1) == '-')) {
									lst.add(lst_temp.get(lst_temp.size()-1));
									lst_temp.remove(lst_temp.size()-1);
								}
							}
						}
					}
					
					//현재 문자열추가
					lst_temp.add(str.charAt(i));
					//)면 이미 리스트를 옮기는데 사용했으므로 다시 제거해준다.
					if(lst_temp.get(lst_temp.size()-1)==')') lst_temp.remove(lst_temp.size()-1);
				
				}else{//우선순위가 높을 경우 list_temp에 누적시킨다.(스택역할)
					lst_temp.add(str.charAt(i));
					//쌓인 괄호의 갯수 count해준다.
					if(lst_temp.get(lst_temp.size()-1)=='(') count++;
					//*와 /중 먼저 들어온게 먼저 출력되게 넣어준다.
					if(lst_temp.size()>=2 && (lst_temp.get(lst_temp.size()-2)=='*' || lst_temp.get(lst_temp.size()-2)=='/')){
						if(lst_temp.get(lst_temp.size()-1)=='*' || lst_temp.get(lst_temp.size()-1)=='/'){
							lst.add(lst_temp.get(lst_temp.size()-2));
							lst_temp.remove(lst_temp.size()-2);
						}
					}
				}
			}
		}
		//잔여 리스트 출력으로 옮겨준다
		while(!lst_temp.isEmpty()) {
			lst.add(lst_temp.get(lst_temp.size()-1));
			lst_temp.remove(lst_temp.size()-1);
		}
		//출력
		for(char c : lst) {
			System.out.print(c);
		}
		
	}
}
