import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            세준이의 체력은 100, 기쁨은 0
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader를 사용해 입력을 받음.

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫번째 줄 읽어오기
        int N = Integer.parseInt(br.readLine()); // 사람의 수

        //배열은 0부터 시작하니까 N+1크기로 만듬.
        int[] happy = new int[N + 1];
        int[] sad = new int[N + 1];
        int[][] dp = new int[N + 1][100];

        StringTokenizer st = new StringTokenizer(br.readLine()); // 두번째줄 받기
        StringTokenizer st2 = new StringTokenizer(br.readLine()); // 세번째줄 받기

        for(int i = 1; i <= N; i++) {

            happy[i] = Integer.parseInt(st.nextToken()); // 두번째줄 값 배열로 넣기
            sad[i] = Integer.parseInt(st2.nextToken()); // 세번째줄 값 배열로 넣기
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j < 100; j++) { // 체력이 0이 되면 안됨!
                if(happy[i] <= j) { // 기쁨 100보다 작다면
                    // 체력에 기쁨 빼고 잃는 체력을 뺀다.
                    // i번까지(인원수 N) 고려했을때 체력 j를 가질 떄 최대 체력 저장
                    dp[i][j] = Math.max(dp[i-1][j-happy[i]] + sad[i], dp[i-1][j]);
                } else{
                    // 기쁨이 j보다 크다면 i 사용 불가로 체력을 변경하지 않고 이전 상태로 그대로 유지
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.print(dp[N][99]); // 체력은 100을 넘으면 안됨.
    }
}
