import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
//        햄버거를 먹을 수 있는 최대 사람의 수 구하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader를 사용해 입력을 받음.

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫번째 줄 읽어오기
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 식탁의 길이

        int K = Integer.parseInt(st.nextToken()); // 햄버거를 선택할 수 있는 거리
// 자신의 위치에서 거리가 K이하인 햄버거를 먹을 수 있다.
// 햄버거를 먹으려면 멀리 있는 사람부터 찾아야한다.
//        ex) HHPP, k=2이면 거리가 2, 그럼 최대한 멀리있는 것부터 찾아야 2명 다 먹을 수 있음.

//        햄버거를 발견했는지의 여부를 저장하는 배열
        char[] result = br.readLine().toCharArray();

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if (result[i] =='P') {
                // 가장 먼저 발견한 햄버거 탐색
                for(int j = i - K; j <= i + K; j++) {
                    if(j < 0 || j >= N){
                        continue;
                    }
                   if (result[j] == 'H') {
                       cnt++;
                       result[j] = 'X';
                       break;
                   }
                }
            }
        }
        System.out.println(cnt);
    }
}
