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

//      사람 수 카운트
        int cnt = 0;

//        가장 왼쪽에 있는 것부터 먹어야 다음 사람이 먹을 확률이 높아짐.
//        i는 식탁의 길이만큼 반복
        for (int i = 0; i < N; i++) {
            if (result[i] =='P') { // 만약 P라면
                // 가장 먼저 발견한 햄버거 탐색
                for(int j = i - K; j <= i + K; j++) {
                    if(j < 0 || j >= N){
                        continue;
                    }
                   if (result[j] == 'H') { // 만약 햄버거를 찾는다면
                       cnt++; // 카운트 수 증가
                       result[j] = 'X'; // 그 위치 X로 변경해줌. 햄버거가 이미 없어져서 끝.
                       break;
                   }
                }
            }
        }
//        카운트한 수 출력
        System.out.println(cnt);
    }
}
