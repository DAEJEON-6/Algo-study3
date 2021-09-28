import java.util.ArrayList;

public class 정수삼각형 {

	public static void main(String[] args) {
		int [][]input = {
				{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}
		};
		System.out.println(solution(input));
	}

	public static int solution(int[][] triangle) {
		int max = 0;
	
		ArrayList<Integer>[]list = new ArrayList[triangle.length];
		for(int i=0; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}

		list[0].add(triangle[0][0]);
		
		for(int i=1; i<triangle.length; i++) {
			for(int j=0; j<triangle[i].length; j++) {
				if(j==0) { //왼쪽 끝 값 처리
					list[i].add(list[i-1].get(0)+triangle[i][j]);
				}else if(j==i) { //오른쪽 끝 값 처리
					list[i].add(list[i-1].get(j-1)+triangle[i][j]);
				}else { //중간에 있는 값 처리
					int a = list[i-1].get(j-1)+triangle[i][j];
					int b = list[i-1].get(j)+triangle[i][j];
					list[i].add(Math.max(a, b));
				}
			}
		}
		
		for(int i=0; i<triangle.length; i++) { //마지막 행에서 최대값 구하기
			max = Math.max(max, list[triangle.length-1].get(i));
		}
		
		return max;
	}


}
