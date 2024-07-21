import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader를 사용해 입력을 받음.
		

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); //상근이가 가져가야 하는 킬로그램
	
		
		
		int count = 0; // 가져가야하는 봉지 개수

		while(true) { // 3킬로그램부터 시작이라서 2보다 크다면 반복
			if(n % 5 == 0) { // n을 5로 나눈 몫이 0이라면 (5배수)
				count += n/5;
				bw.write(String.valueOf(count));
				break;
			} 
			n -= 3;
			count++;
			
			if(n < 0) {
				bw.write(String.valueOf(-1));
				break;
			}
		}
		bw.flush();
		bw.close();
		
	}

}
