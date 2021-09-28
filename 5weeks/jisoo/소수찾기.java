import java.util.HashSet;

public class 소수찾기 {

	static int count;
	static String numbers;
	static boolean isSelected[];
	static HashSet<Integer> set = new HashSet<>();
	
	public static void main(String[] args) {
		numbers = "011";
		StringBuilder sb = new StringBuilder();
		isSelected = new boolean[numbers.length()];
		for(int i=1; i<=numbers.length(); i++) { //길이가 1~num까지의 모든 부분집합 구하기
			generateSubset(i,sb);
		}
		System.out.println(count);
	}

	private static void generateSubset(int num, StringBuilder sb) {

		if(sb.length() == num) {
			int number = Integer.parseInt(sb.toString()); //num만큼의 길이를 가진 부분집합 완성
			if(checkPrime(number) && checkSet(number)) { //해당 부분집합이 소수이고, 중복되지 않았는지 확인
				count++;
			}
			return;
		}

		for(int i=0; i<numbers.length(); i++) {
			if(isSelected[i]) {
				continue;
			}else {
				isSelected[i] = true;
				generateSubset(num, sb.append(numbers.charAt(i)));
				sb.setLength(sb.length()-1);
				isSelected[i] = false;
			}
		}
	}


	private static boolean checkSet(int number) { //기존에 이미 있던 수인지 확인
		if(set.add(number)) {
			return true;
		}
		return false;
	}

	private static boolean checkPrime(int number) { //소수인지 확인
		if((number != 2 && number % 2 == 0)||(number <= 1)) {
			return false;
		}
		
		for(int i=3; i<number; i+=2) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}
}