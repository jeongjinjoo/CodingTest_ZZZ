import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader를 사용해 입력을 받음.
		
		

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken()); // 준규가 가지고 있는 동전 개수
	
		int k = Integer.parseInt(st.nextToken()); // 만들어야 하는 금액
		
		
		
		int[] coin = new int[n]; // 동전 가치 입력(N개의 동전)
		
//		동전 개수만큼 coin에 넣어줌.
		for(int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		
		int count = 0; // 최소한의 동전 구성 개수

		for(int i = n - 1; i >= 0; i--){
		// i는 동전의 개수보다 1개 적은것부터 0보다 클때까지 줄여가며
			
			// 현재 동전의 가치가 K보다 작거나 같아야지 구성가능하다.
			// K는 가치의 합. 만들어야하는 금액
			if(coin[i] <= k){
			// 현재 가치의 동전으로 구성할 수 있는 개수를 count에 더함
				count += (k / coin[i]); 
				// ex) 4200 / 1000 -> 4를 더함. 1000원이 4개 있어야 함.
				k = k % coin[i];
			}
		}
		System.out.println(count);
		
	}
}