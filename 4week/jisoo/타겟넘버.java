public class 타겟넘버 {

	static int answer = 0;

	static public int solution(int[] numbers, int target) {

		dfs(numbers, numbers[0], 0, target);
		dfs(numbers, -numbers[0], 0, target);

		return answer;
	}

	static public void dfs(int[] numbers, int val, int depth, int target){

		if(depth == numbers.length-1){
			if(val == target){
				answer++; 
			}
			return;
		}

		dfs(numbers, val+numbers[depth+1], depth+1, target);
		dfs(numbers, val-numbers[depth+1], depth+1, target);
	}

	public static void main(String[] args) {
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}
}