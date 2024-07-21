import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader를 사용해 입력을 받음.
		

		

		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

		
		
		// 테스트 케이스 수 입력받기
		for (int i = 0; i < T; i++) { // 테스트 케이스 수만큼 반복
			StringTokenizer st = new StringTokenizer(br.readLine());

			
			
			int n = Integer.parseInt(st.nextToken()); // 문서의 개수
		
			int m = Integer.parseInt(st.nextToken()); // 몇 번째로 인쇄되었는지 궁금한 문서
			
			st = new StringTokenizer(br.readLine());
			
			// 문서 중요도 저장
			LinkedList<int[]> q = new LinkedList<>(); // 테스트케이스만큼 큐에 담기

			// 엔터 입력후 중요도(배열의 값) 입력받기
			for (int j = 0; j < n; j++) { // 문서의 개수(n)만큼 입력받기
				q.add(new int[] {j, Integer.parseInt(st.nextToken())});	
			}
			
		
			
			//해당 m번째 문서가 몇번째로 인쇄되는지 구하는 메소드(매개변수 m)
			int count = 0; // m이 몇번째로 인쇄되었는지 저장하는 변수
			
	
		
		
		
		while(!q.isEmpty()) { // q 사이즈가 0일때까지 반복
			
			int[] first = q.pop(); // 큐 맨 앞 요소 빼기
			boolean max = true; // 제일 큰 요소의 유효성 검사
			
			// 큐에 남아있는 요소들만큼 반복문을 돌려서 중요도를 비교한다
			for(int k = 0; k< q.size(); k++) {
				
				// 자기보다 큰 값이 있다면 뒤로 넘겨라
				if(first[1] < q.get(k)[1]) {
					
					// 지금 뽑은 요소보다 큰 요소가 있을 경우
					q.add(first); // 젤 처음으로 뽑은걸 맨 뒤에 넣음
					
					// 반복하면서 뽑은 first보다 크지 않은 요소들도 맨 뒤에 넣음
					for (int j = 0; j < k; j++) {
						//q의 k번째에 first보다 큰게 있다는 것이므로 k까지만 반복
						
						q.add(q.pop());
					}
					
					max = false; // first보다 큰 요소가 있으므로 false를 함.
					break; // 반복문을 빠져나옴
				}
				//if 문을 빠져나왔음.
				
			}
			
			// 만약에 first가 가장 큰 값이 아니라면 다시 반복해라
			if (max == false) {
				continue;
			}
			
			// 만약 최고값이라면 pop했으니 count를 세줘야 함.
			count++; 
			
			// 만약 그 값이 우리가 원하는 답이라면 이만 멈추고 저장해야함.
			if (first[0] == m) { // 찾는게 맞을경우 반복문을 빠져나감.
				break;
			}
			
		}
		sb.append(count).append("\n");
		
	}
		// 큰 요소를 누적해서 더하기 한 걸 반환
		System.out.println(sb);
	}
}