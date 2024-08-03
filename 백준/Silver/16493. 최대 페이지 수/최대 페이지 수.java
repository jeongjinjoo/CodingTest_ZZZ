import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        남은 기간 N일과 책의 각 챕터 당 그 챕터를 전부 읽는데 소요되는 일 수와 페이지 수가 주어질때
        N일간 읽을 수 있는 초치대 페이지 수를 구하는 프로그램을 작성하라.
        : 읽을 수 있는 최대 페이지 수 출력
         */
        /*
        DP란 Dynamic Programming이다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader를 사용해 입력을 받음.

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫번째 줄 읽어오기
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 남은 기간 N일

        int M = Integer.parseInt(st.nextToken()); // 챕터의 수

        // 둘째줄부터 입력받는 일 수와 페이지 수를 고려해 페이지 수가 제일 큰 것 부터 계산한다.
        // 페이지수가 같을 경우에는 일 수가 적은 것부터 고려해 계산한다.

        // 각 챕터의 소요일수와 페이지 수를 저장할 배열을 선언
        int[] days = new int[M]; // 챕터의 수만큼 배열이 필요한 이유는?
        int[] pages = new int[M]; // 챕터는 일수, 페이지 수 두가지 정보를 가진다.
        // 저장할 배열 만들기
        // 0부터 N까지 읽을 수 있는 최대 페이지 수를 저장하기 때문에 N+1
        int[] dp = new int[N + 1];

        // 챕터의 수 M만큼 반복한다.
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            days[i] = Integer.parseInt(st.nextToken()); // 일 수

            pages[i] = Integer.parseInt(st.nextToken()); // 페이지 수

        }
        // 각 챕터에 대해 DP 배열을 업데이트한다.
        for(int i = 0; i < M; i++) {
            // 주어진 날짜 수가 i번째 챕터의 일수보다 클 경우에만 고려한다.
            for(int j = N; j >= days[i]; j--) {
                // n일째 읽을 수 있는 최대 페이지 수와
                // n일에서 현재 페이지를 빠진 날짜
                // i번째 책의 페이지 수 계산
                // dp[j] : 현재 상태에서의 최대 페이지 수
                // dp[j-days[i]] : 현재 상태에서
                // j-days[i]일에서의 최대 페이지 수 + 현재 챕터의 페이지 수 중 최대값
                dp[j] = Math.max(dp[j], dp[j-days[i]] + pages[i]);
            }
        }
        System.out.println(dp[N]);


    }
}