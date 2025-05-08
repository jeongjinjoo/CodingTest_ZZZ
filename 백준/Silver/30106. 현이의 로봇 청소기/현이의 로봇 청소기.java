import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

    static int n; // 선언
    static int m;
    static int k;
    static int[][] map;
    static int[][] result;

    // 위, 아래, 오른쪽, 왼쪽
    static int[] dx = {1,-1,0,0};// 상하좌우로 이동 배열
    static int[] dy = {0,0,1,-1};

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 문제
//        현아의 방 N x M 크기의 직사각형
//        로봇 청소기는 영역 청소 후 상,하,좌,우로 인접한 영역 중 하나로 이동
//        로봇 청소기는 높이 차이가 K 초과인 두 영역 사이를 이동하면 고장이 날 수 있어 K 이하 영역만 가능
//        현이가 로봇 청소기를 최소 몇 번 작동시켜야 방의 모든 영역을 청소할 수 있을지 구하자

        // BufferedReader를 사용해 입력을 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력값을 잘라옴.
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 가로(정점의 개수)
        m = Integer.parseInt(st.nextToken()); // 세로(간선의 개수)
        k = Integer.parseInt(st.nextToken()); // 높이(시작할 정점번호)

        result = new int[n][m]; // 배열 선언
        map = new int[n][m];

//        두 번째 줄부터 N+1번쨰 줄까지 각 영역 높이를 나타내는 정수 M개가 공백으로 구분되어 주어진다.
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()); // 입력받은거 공백을 기준으로 구분하기
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); // 입력값 넣기
            }
        }
        //입력 끝

        int counts = 0; // 작동한 횟수
        for(int i =0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(result[i][j] == 0){
                    // 방문하지 않았다면
                    counts++;
                    bfs(i,j,counts);
                }
            }
        }

        System.out.println(counts);

    }

    private static void bfs(int u, int v, int counts) {
        Queue<Point> q = new ArrayDeque<>(); // 큐 생성
        q.offer(new Point(u, v)); // 시작 좌표를 q에 넣음
        result[u][v] = counts; // 작동 횟수로 청소된 위치 표시

        while(!q.isEmpty()) { // 비어있을 때까지 반복
            Point p = q.poll(); // poll로 하나씩 꺼내기
            int height = map[p.x][p.y]; // 현재 위치 높이 값 가져오기

            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i]; // 현재 좌표에서 dx[i]만큼 이동
                int ny = p.y + dy[i]; // 현재 좌표에서 dy[i]만큼 이동

                if(nx>=0 && nx<n && ny>=0 && ny<m && result[nx][ny] == 0 && Math.abs(height - map[nx][ny]) <= k) { // abs는 높이 차이가 K 이하인지 확인하기 위해
                    result[nx][ny] = counts;
                    q.offer(new Point(nx, ny)); // 다음 위치를 이어서 탐색할 수 있게 offer를 이용해 큐에 값을 넣음

                }
            }
        }
    }
}