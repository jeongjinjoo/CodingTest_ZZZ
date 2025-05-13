import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int K;
    static int X;
    static boolean[] arr;
    static int[] result;
    static int cnt = 1;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 문제

//        특정 도시 X로부터 최단거리가 정확히 K인 모든 도시들의 번호를 출력해라

        // BufferedReader를 사용해 입력을 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력값을 잘라옴.
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시의 개수
        M = Integer.parseInt(st.nextToken()); // 도로의 개수
        K = Integer.parseInt(st.nextToken()); // 거리 정보
        X = Integer.parseInt(st.nextToken()); // 출발 도시 번호

        arr = new boolean[N + 1];
        int[] distance = new int[N + 1]; // 방문순서가 아니라 거리를 저장
        Arrays.fill(distance, -1);
        distance[X] = 0;

        for (int j = 0; j <= N; j++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < M ; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            // 정점 a,b를 공백에 따라 담음.
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            graph.get(a).add(b); // 단방향 그래프만 처리
        }
//        입력 끝

//        bfs 탐색 시작
        bfs(X);

    }


    //        LinkedList는 이중 연결 리스트로 각 요소가 이전/다음 노드를 참조
//        ArrayDeque는 배열 기반으로 크기가 가변적인 원형 배열로 구현
//bfs 만들기
    private static void bfs(int start) throws IOException {
        Queue<Integer> q = new LinkedList<Integer>(); // 사용 큐
        q.add(start); // 시작 정점을 큐에 저장

        int[] distance = new int[N + 1]; // 방문순서가 아니라 거리를 저장
        Arrays.fill(distance, -1);
        distance[start] = 0;

        while (q.size() != 0) {
            int a = q.poll();
            // 인접 정점 탐색
            for (int next : graph.get(a)) {
                if (distance[next] == -1) { // 방문하지 않았다면
                    distance[next] = distance[a] + 1;
                    q.add(next);
                }
            }
        }

        boolean found = false;
        for(int i =1; i <= N; i++) {
            if (distance[i] == K) { // 거리가 K가 아니라면
                bw.write(i + "\n");
                found = true;
            }
        }
        if (!found) {
            bw.write("-1\n");
        }
        bw.flush();
    }
}