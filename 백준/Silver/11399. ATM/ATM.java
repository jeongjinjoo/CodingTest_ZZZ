import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader를 사용해 입력을 받음.
		

		
		int n = Integer.parseInt(br.readLine()); // 사람의 수
		
		//입력범위는 1 ~ 1000 -> 1001개의 index를 둔다.
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i =0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	
		
//		배열을 오름차순으로 정렬
		Arrays.sort(arr);
		// 이전까지의 대기시간 누적합
		int prev = 0;
		// 사람별 대기시간 총합
		int sum = 0;
		
		for(int i = 0; i < n; i++) {
			// 이전까지의 대기시간과 현재 사람이 걸리는 시간을 더해줌.
			sum += prev + arr[i];
			
			// 이전까지의 누적합에 현재 걸리는 시간을 더해줌.
			prev += arr[i];
		}
		System.out.println(sum);
	}

}