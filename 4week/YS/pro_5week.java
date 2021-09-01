class Solution {
    //전역변수화
    static char[] alpha;
    static String word;
    static int num;
    static int result;
    
    public int solution(String word) {
        //순서대로 접근할 알파벳
        alpha = new char[] {'A','E','I','O','U'};
        //입력값
        this.word = word;
        num = 0;
        result = 0;
        
        StringBuilder sb = new StringBuilder();
        permutation(sb);    
        //출력
        return result;
    }
    
    //순열로 풀이하였다.
    public static void permutation(StringBuilder sb){
        //정답 찾으면 갱신하고 종료
      	if(sb.toString().equals(word)){
      		result = num;
      		return;
      	}
        //길이가 5면 더 넘어가면 안됨
        if(sb.length()==5){
      	return;
       }
        //a e i o u 순서대로 조합
       for(int i=0; i<5; i++){
           sb.append(alpha[i]);
         //문자 순서 
           num++;
           permutation(sb);
         //이미 답 찾았으면 더 돌지 않고 종료 .
           if(result!=0) return;
           sb.setLength(sb.length()-1);
       }
        
       return;
        
    }
}
