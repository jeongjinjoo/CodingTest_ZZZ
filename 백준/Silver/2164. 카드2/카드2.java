import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader를 사용해 입력을 받음.

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 사람의 수 입력받기
		int n = Integer.parseInt(st.nextToken()); // 정수 입력받기 , 공백으로 분리 (7)
		// 건너뛸 간격 입력받기
//			int k = Integer.parseInt(st.nextToken()); // 정수로 변환 (3)

		// 큐 이용해 사람들 저장
		Deque<Integer> q= new ArrayDeque<>(); // n명의 사람을 큐에 넣음.

		for(int i = 1; i <= n; i++) {
				q.add(i);
				
				
			
		}
		
		while(q.size()!= 1) {
			q.removeFirst(); // 첫번째 수 제거
			q.addLast(q.removeFirst()); // 마지막으로 뺀 수를 마지막에 더해
			
		}
		
		System.out.println(q.peekFirst());
		

	}

}