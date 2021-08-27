import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_2628 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int col = sc.nextInt(); //열
		int row = sc.nextInt(); //행
		int max = 0; //최대 넓이

		ArrayList<Integer>cutRow = new ArrayList<>(); //가로로 자를 때 위치
		ArrayList<Integer>cutCol = new ArrayList<>(); //세로로 자를 때 위치

		int N = sc.nextInt(); //자른 횟수
		for(int i=0; i<N; i++) {
			int dir = sc.nextInt();
			if(dir == 0) {
				cutRow.add(sc.nextInt());
			}else {
				cutCol.add(sc.nextInt());
			}
		}

		Collections.sort(cutRow); //자른 위치를 오름차순으로 정렬
		Collections.sort(cutCol);

		int[]rowElem = new int[cutRow.size()+1]; //가로로 잘랐을 때 만들어지는 모든 가로의 길이
		int[]colElem = new int[cutCol.size()+1]; //세로로 잘랐을 때 만들어지는 모든 세로의 길이

		if(cutRow.size()>0 && cutCol.size()>0) { //가로, 세로 각각 최소 한 번은 자른 경우

			rowElem[0] = cutRow.get(0); //가장 위쪽을 잘랐을 때 생기는 길이
			for(int i=1; i<rowElem.length-1; i++) { //사각형이 중간에 생기는 경우
				rowElem[i] = cutRow.get(i)-cutRow.get(i-1);
			}
			rowElem[rowElem.length-1] = row - cutRow.get(cutRow.size()-1); //마지막 남은 부분의 길이

			colElem[0]= cutCol.get(0); //가장 왼쪽을 잘랐을 때 생기는 길이
			for(int i=1; i<colElem.length-1; i++) { //사각형이 중간에 생기는 경우
				colElem[i] = cutCol.get(i)-cutCol.get(i-1);
			}
			colElem[colElem.length-1] = col - cutCol.get(cutCol.size()-1); //마지막 남은 부분의 길이

			for(int i=0; i<rowElem.length; i++) { //가장 큰 넓이 조합 구하기
				for(int j=0; j<colElem.length; j++) {
					if(rowElem[i]*colElem[j] > max) {
						max = rowElem[i]*colElem[j];
					}
				}
			}
		}else if(cutRow.size() == 0) { //세로로만 자른 경우
			
			colElem[0]= cutCol.get(0); //가장 왼쪽을 잘랐을 때 생기는 길이
			for(int i=1; i<colElem.length-1; i++) { //사각형이 중간에 생기는 경우
				colElem[i] = cutCol.get(i)-cutCol.get(i-1);
			}
			colElem[colElem.length-1] = col - cutCol.get(cutCol.size()-1); //마지막 남은 부분의 길이

			int maxIndex = 0;
			for(int i=0; i<colElem.length-1; i++) { //가장 큰 넓이 조합 구하기
				if(colElem[i] < colElem[i+1]) {
					maxIndex = i+1; 
				}
			}
			max = colElem[maxIndex]*row;

		}else if(cutCol.size() == 0) { //가로로만 자른 경우
			
			rowElem[0] = cutRow.get(0); //가장 위쪽을 잘랐을 때 생기는 길이
			for(int i=1; i<rowElem.length-1; i++) { //사각형이 중간에 생기는 경우
				rowElem[i] = cutRow.get(i)-cutRow.get(i-1);
			}
			rowElem[rowElem.length-1] = row - cutRow.get(cutRow.size()-1); //마지막 남은 부분의 길이
			
			int maxIndex = 0;
			for(int i=0; i<rowElem.length-1; i++) { //가장 큰 넓이 조합 구하기
				if(rowElem[i] < rowElem[i+1]) {
					maxIndex = i+1; 
				}
			}
			max = rowElem[maxIndex]*col;

		}
		System.out.println(max);
	}

}
