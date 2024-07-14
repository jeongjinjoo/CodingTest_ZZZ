import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	/*
	 * dfs문제인데 무방향 그래프이다./ 양방향 간선임.
	 * 정점 번호는 1 ~ N, 모든 간선의 가중치는 1
	 * 정점 시작은 R에서 시작
	 * 노드 방문 순서 출력
	 * 오름차순으로 방문한다.
	 */
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
			graph.add(new ArrayList<Integer>());
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
		
		// dfs 탐색 시작
		dfs(r);
	
	
		// 1부터 시작. 모든정점의 방문 순서를 출력
		for(int i = 1; i <= n; i++) {
			bw.write(result[i] + "\n");
		}
		
		
		bw.flush(); // 한번 비워줘야됨. (버퍼 비우기)
		bw.close(); // bw를 열어줬으니 닫아주는 것임.
		br.close(); // br을 열어줬으니 닫아주는 것임.
		
	}
	
	
	//dfs 만들기
	private static void dfs(int start) throws IOException {
		/*
		 * 노드 1과 연결된 2,4 중 제일 작은 2를 탐색
		 * 그 후 2에는 1,3,4가 연결되어있지만 1은 이미 탐색으로 3 탐색
		 * -> 탐색할때마다 순서 부여, 순서를 부여하는 배열을 따로 만들어준다.
		 * dfs는 노드를 탐색할때 가장 작은 노드를 우선으로 방문(오름차순인 이유)
		 */
		
		arr[start] = true; // 방문했는지 확인
		result[start] = cnt++; // 방문 순번을 배열에 저장 및 탐색(순번 저장)
		// Collections로 리스트 정렬
		Collections.sort(graph.get(start), Collections.reverseOrder()); // 인접 정점 오름차순
		
		// 인접 정점 탐색
		for(int newStart : graph.get(start)) {
			if(result[newStart] == 0){
				//재귀이용
				dfs(newStart);
			}
		}
		return;
	}

}
