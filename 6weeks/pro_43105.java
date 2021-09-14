class Solution {
    public int solution(int[][] triangle) {

        int N = triangle.length;
        
        if(N==1) return triangle[0][0];
        
        for(int i=N-2; i>=0; i--){
            for(int j=0; j<i+1; j++){
                triangle[i][j] += Math.max(triangle[i+1][j],triangle[i+1][j+1]);
            }
        }
        
        return triangle[0][0];   
    }
}
