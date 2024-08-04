import java.io.*;

public class Main {
    /*
    DP(다이나믹 프로그램)
    : 모든 연산을 수행하면 똑같은 연산을 중복되게 수행하는데 다이나믹 프로그램은
    연산한 내용을 따로 저장하여 효율적으로 작성한 프로그램.
    정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader를 사용해 입력을 받음.

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫번째 줄 읽어오기
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수 T

        // 테스트 케이스 개수만큼 정수 N이 주어짐.

        long[] dp = new long[1000001]; // n은 1000000보다 작거나 같음.

        for (int i = 0; i < T; i++) {
            int number = Integer.parseInt(br.readLine()); // n 입력받기

            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            // j가 4부터 시작하는 이유는? 앞에 1,2,3 선언 후 숫자는 4부터 시작
            for(int j = 4; j <= number; j++){
                dp[j] = (dp[j-1] + dp[j-2] + dp[j-3])% 1000000009;
            }
            bw.write(dp[number] + "\n");
        }

        bw.flush();
        bw.close();

    }
}