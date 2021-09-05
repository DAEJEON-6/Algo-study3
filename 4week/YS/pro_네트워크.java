class Solution {
    
    static int[] parent;
	
	
	//자기 자신을 부모로 하는 배열 생성
	public static void make(int n) {
		parent = new int[n];
		
		for(int i=0; i<n; i++) {
			parent[i] = i;
		}
		
	}
	//부모를 찾는 함수
	public static int find(int n) {
		if(parent[n]==n) return n;
		
		return parent[n] = find(parent[n]);
		
	}
	
	//두개를 연결시켜주는 함수
	//부모가 다르면 연결 부모가 같으면 아무동작 x
	public static void link(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa==pb) return;
		
		parent[pb] = pa; 
	}
    
  
  
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        make(n);
		//연결시키기
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i==j) continue;
				
				if(computers[i][j] == 1) link(i,j); 
			}
		}
		//부모 통일
		for(int i=0; i<n; i++) {
			find(i);
		}
    boolean[] check = new boolean[n];
    //부모 갯수 세기    
		for(int i=0; i<n; i++) {
			check[find(i)] = true;
		}
		
		for(int i=0; i<n; i++) {
			if(check[i]) answer ++;
		}
        
        return answer;
    }
}
