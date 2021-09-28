public class 네트워크 {
	
	static int[]parents;
	static int count;
	
	private static void make(int n) {
		for(int i=0; i<n; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(a == parents[a]) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) {
			return false;
		}
		parents[bRoot] = aRoot;
		count++;
		return true;
	}
	
	public static void main(String[] args) {
		int[][]computers = {{1,1,0},{1,1,1},{0,1,1}};
		parents = new int[computers.length];
		make(computers.length);
		for(int i=0; i<computers.length; i++) {
			for(int j=0; j<computers[i].length; j++) {
				if(i!=j && computers[i][j]==1) {
					union(i,j);
				}
			}
		}
		System.out.println(computers.length-count);
	}

}
