public class 조이스틱 {
	static String str = "NNAAAAANNN";
	public static void main(String[] args) {
		System.out.println(findAlphaMove());
		System.out.println(findMinOrder());		
		System.out.println(findAlphaMove()+findMinOrder());
	}
	
	private static int findAlphaMove() { //각 알파벳에서 A까지의 최소 이동횟수 구하기
		int alphaMove = 0;

		for(int i=0; i<str.length(); i++) {
			int count = 26;
			int num = str.charAt(i);
			if(num <= 78) { //알파벳 A~N까지는 해당 알파벳에서 A까지의 거리를 빼준다
				count = num-65;
			}else { //알파벳 O~Z까지는 Z에서 해당 알파벳을 빼주고 1더해준다 (Z->A로 이동하기에)
				count = 90-num+1;
			}
			alphaMove += count;
		}
		return alphaMove;
	}

	private static int findMinOrder() { //원하는 이름을 만들기 위해 필요한 최소한의 위치 이동횟수 구하기

		int lowerNotA = 0, upperNotA = 0; //가장 왼쪽, 오른쪽에 있는 A가 아닌 문자의 위치
		for(int i=1; i<str.length(); i++) {
			if(str.charAt(i)!='A') {
				lowerNotA = i;
				break;
			}
		}
		
		for(int i=str.length()-1; i>0; i--) {
			if(str.charAt(i)!='A') {
				upperNotA = i;
				break;
			}
		}
		
		//첫번째 경우
		int forward = upperNotA; //인덱스1~가장 끝에 있는 A가 아닌 문자까지의 거리 
		
		
		//두번째 경우
		int backward = str.length()-lowerNotA; //끝~인덱스1 가장 처음에 있는 A가 아닌 문자까지의 거리		
		
		
		//세번째 경우
		int mixed = 1; //시작부터 끝으로 가다가 중간에 시작으로 이동해 거꾸로 이동하는 경우
		int index = 1; //1인덱스부터 시작 (0부터 시작하면 바로 끝에서부터 시작으로 이동할 수 있음)
		int temp = 0; //A의 반복 횟수
		
		while(true) {
			if(str.charAt(index)!='A') { //방향 전환
				mixed *= 2;
				for(int i=str.length()-1; i>index; i--) { //끝에서부터 index뒤에까지 확인
					if(str.charAt(i)!='A') { //문자가 A가 아니면 기존 저장된 A가 아닌 문자의 횟수와 A의 횟수를 추가해준다
						mixed++;
						mixed += temp;
						temp = 0; //A의 반복횟수 초기화
					}else { //문자가 A인 경우, A의 반복횟수 누적
						temp++;
					}
				}
				break;
			}
			index++;
			mixed++;
		}

		int min = 0; //세 가지 경우 중 최솟값 구하기
		if(forward > backward) {
			min = Math.min(backward, mixed);
		}else {
			min = Math.min(forward, mixed);
		}
		
		return min;
	}
}