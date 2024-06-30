import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// N명의 사람이 원형으로 앉아있음. k번째 사람을 제거하는 과정, 마지막에 남는 사람들의 순서를 출력

	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader를 사용해 입력을 받음.

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 사람의 수 입력받기
		int n = Integer.parseInt(st.nextToken()); // 정수 입력받기 , 공백으로 분리  (7)
		// 건너뛸 간격 입력받기
		int k = Integer.parseInt(st.nextToken()); // 정수로 변환 (3)
		
		// 큐 이용해 사람들 저장
		Queue<Integer> q = new LinkedList<>(); // n명의 사람을 큐에 넣음. 
		
		// 1부터 n까지 숫자 큐에 추가
		for (int i = 1; i <= n; i++) { // n명까지 반복문 (1 ~ 7)
			q.offer(i); 
		}

		// 결과 저장할 sb 초기화
        StringBuilder sb = new StringBuilder("<"); // 문자열 효율적으로 변경
        // 초기 문자열은 <
        
      
        
        
        // 간격만큼 뛰어넘음.
        while (q.size() >  1) { // 큐 사이즈가 1보다 클 떄까지 반복, 큐 요소에 2개 이상 남아있을때까지
            for (int i = 0; i < k - 1; i++) { 
            	q.offer(q.poll()); // 큐 가장 앞에 있는 요소 제거하고 큐 맨 뒤에 추가,
    
            }
//              sb.append(q.poll()); // q.poll() : 큐에서 요소 꺼내기, 빌더에 요소 추가
   
                        // 큐에서 다음으로 제거할 사람 빼냄
                        sb.append(q.poll()).append(", ");
        }
        	// 마지막 남은 한 명 처리
            if(q.size()==0){ // 만약 1개 남았다면
                sb.append(q.poll()); // 큐에서 마지막 사람 빼내서 sb에 추가
            }else{
                sb.append(q.poll()).append(">"); 

            }
            bw.write(sb.toString());
        
        
        bw.flush();
//        
        br.close();
        bw.close();


    }
}
