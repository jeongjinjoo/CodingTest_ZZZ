import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static int[][] temp;
    static boolean[] arr;
    static int max = 0;

//    좌, 우, 하, 상
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        // 문제
//        연구소 크기는 NxM이고, 0은 빈칸, 1은 벽, 2는 바이러스
//        벽을 세우지 않으면 바이러스가 빈칸으로 퍼져감
//        나중에 바이러스 2가 0을 2로 바꾸면서 가다가 1을 만나면 멈춤

        // BufferedReader를 사용해 입력을 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력값을 잘라옴.
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 가로
        M = Integer.parseInt(st.nextToken()); // 세로

        map = new int[N][M];
        temp = new int[N][M];

//        행렬로 담기
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0); // 벽 3개 세우기, 문제에서 벽 3개를 세워야 바이러스가 빠져나가지 않음
        System.out.println(max); // 최댓값 출력

    }


//dfs 만들기
//    벽을 세워야하니까
    static void dfs(int i) {
        if(i == 3) {
//            벽은 3개니까 i가 3개라면 바이러스를 퍼뜨려도 됨
            virus();
            return;
        }

        for(int j = 0; j < N; j++) {
            for(int k=0; k <M; k++) {
                if(map[j][k] == 0){
                    map[j][k] = 1;
                    dfs(i+1);
                    map[j][k] = 0;//백트래킹

                }
            }
        }
    }

//    바이러스를 퍼뜨리려면 bfs 사용
    static void virus() {
        temp = new int[N][M];
        for (int i = 0; i < N; i++)
            temp[i] = map[i].clone(); // 맵 복사

        Queue<int[]> q = new LinkedList<>();


        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(temp[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
            }
        }
        while(!q.isEmpty()) {
            int[] arr = q.poll();
            int x = arr[0];
            int y = arr[1];

            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if(temp[nx][ny] == 0) {
                        temp[nx][ny] = 2; // 0이라면 2로 바꿔줘라, 그래야 바이러스지
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        count();
    }

//    안전 구역 계산
    static void count() {
        int safe = 0;
        for(int i = 0; i < N; i++) {
            for(int j =0; j < M; j++){
                if(temp[i][j] == 0){
                    safe++;
                }
            }
        }
        max = Math.max(max, safe);
    }
}