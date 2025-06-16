import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws IOException {
        //1번부터 N번까지 총 N개의 문제로 되어 있는 문제집 풀기
        // 1~N번 문제 순서로 난이도 출제
        // 먼저 푸는게 좋은 문제가 있음. ex) 1번 풀면 4번 쉽게 풀림
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        // 입력받기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
 
        int[] result = new int[N + 1];
        
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
 
        for (int i = 0; i <= N; i++) {
            a.add(new ArrayList<>());
        }
 
        for (int i = 0; i < M; i++) {
            
            st = new StringTokenizer(br.readLine());
            
            int first = Integer.parseInt(st.nextToken());
            
            int last = Integer.parseInt(st.nextToken());
 
            a.get(first).add(last);
           
            result[last]++; // 특정 문제의 번호보다 먼저 풀어야하는 문제의 개수
        }
 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
 
        for (int i = 1; i <= N; i++) {
            if (result[i] == 0) { // 먼저 풀어야하는 문제가 없는 경우
                pq.offer(i);
            }
        }
 
        StringBuilder sb = new StringBuilder();
        
        while (!pq.isEmpty()) {
            
            int now = pq.poll();
            
            sb.append(now + " ");
 
            // now와 연결된 문제가 있는지 확인.
            for (int next : a.get(now)) {
                // now에 해당하는 문제를 풀었기때문에
                // next보다 먼저 풀어야하는 문제의 개수가 1개 줄어듦.
                result[next]--;
 
                // 먼저 풀어야하는 문제가 없는 경우
                // 새롭게 큐에 데이터를 집어넣는다.
                if (result[next] == 0) {
                    pq.offer(next);
                }
            }
        }
 
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
