import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	
	static int n; // 선언
	static int m; // 선언
	static int r; // 선언
	static int cnt = 1;
	static boolean[] arr;
	static int[] result; 
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	// 그래프용 리스트 배열
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
	
	public static void main(String[] args) throws IOException {
		
	
		// BufferedReader를 사용해 입력을 받음.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 첫째줄 정점개수, 간선개수, 정점번호를 저장.
		StringTokenizer st = new StringTokenizer(br.readLine());

		 n = Integer.parseInt(st.nextToken()); // 정점의 개수
		 m = Integer.parseInt(st.nextToken()); // 간선의 개수
		 r = Integer.parseInt(st.nextToken()); // 시작할 정점번호
		
		arr = new boolean[ n + 1];
		result = new int[ n + 1 ];
		
		for(int j = 0; j <= n; j++) {
			// 그래프에 내용을 저장할 리스트 만들기.
			graph.add(new ArrayList<>());
		}
		
		
		for (int i = 0; i < m; i++) {
			// 다음 m개의 줄에는 두 정점의 번호 입력받음
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			// 정점 a,b를 공백에 따라 담음.
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		// bfs 탐색 시작
		bfs(r);
	
	
		// 1부터 시작. 모든정점의 방문 순서를 출력
		for(int i = 1; i <= n; i++) {
			bw.write(result[i] + "\n");
		}
		
		
		bw.flush(); // 한번 비워줘야됨. (버퍼 비우기)
		bw.close(); // bw를 열어줬으니 닫아주는 것임.
		br.close(); // br을 열어줬으니 닫아주는 것임.
		
	}
	
	
	//bfs 만들기
	private static void bfs(int start) throws IOException {
		Queue<Integer> q = new LinkedList<Integer>(); // 사용 큐
		
		q.add(start); // 시작 정점을 큐에 저장
		arr[start] = true; // 시작 정점 방문했는지
		result[start] = cnt++; // 방문 순번을 배열에 저장 및 탐색(순번 저장)
		
		while(q.size() != 0) {
			int a = q.poll();
			// Collections로 리스트 정렬
			Collections.sort(graph.get(a)); // 오름차순
		
			// 인접 정점 탐색
			for(int newStart : graph.get(a)) {
				if(result[newStart] == 0){ // 방문하지 않았다면
					
					arr[newStart] = true;
					result[newStart] = cnt++;
					q.add(newStart);
				}
			}
		}
		return;
	}

}