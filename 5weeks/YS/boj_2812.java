import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-12
 * Description : 백준 2812
 */

public class Main{
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        String str = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<N; i++) {
          //현재 자리의 숫자
        	int curr = str.charAt(i)-'0';
        	//sb비었으면 추가 후 컨티뉴
        	if(sb.length()==0) {
        		sb.append(curr);
        		continue;
        	}
        	//이전 숫자가 더 작으면 지워준다 . 우리는 큰 숫자를 만들어야하기때문에
        	while(K>0 && sb.length()!=0 && (sb.charAt(sb.length()-1)-'0')<curr) {
        		sb.setLength(sb.length()-1);
        		K--;
        	}
        	//조건인 K가 0이 된다면 현재까지의 sb를 추가하고 뒤의 숫자를 모두 출력해준다
        	if(K==0) {
        		bw.write(sb.toString()+str.substring(i));
        		break;
        	}
        	//sb에 추가
        	sb.append(curr);
        }
        //만약 끝까지 돌았는데 끝나지 않았다면 K만큼 가장 작은자릿수를 제거해준다.
        if(K!=0) {
        	bw.write(sb.substring(0, sb.length()-K));
        }
        
        bw.flush();
        bw.close();
        br.close();
	}
}
