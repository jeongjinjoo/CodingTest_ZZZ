import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//      버튼을 빨리 누를수록 대기목록에 먼저 들어감.
//      이미 대기열인 상태에서 다시 버튼을 누르면 대기목록 맨 뒤로 밀려남
//      수강신청 버튼이 비활성화되면, 대기목록에서 가장 앞에 있는 학생부터 수강신청 완료
//       - 수강 가능 인원이 꽉 차면 나머지 대기목록 무시 후 수강신청 종료

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader를 사용해 입력을 받음.

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫번째 줄 읽어오기
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 과목의 수강 가능 인원

        int L = Integer.parseInt(st.nextToken());
        // 학생들이 버튼을 클릭한 순서를 기록한 대기목록의 길이



//        HashMap 사용
//        HashMap이란? 키-값 쌍 저장/ 키와 대응하는 값을 하나의 쌍으로 저장
//        HashMap<String, Integer> map = new HashMap<>();
//       키는 String으로 학생 ID 저장, 값이 Integer형으로 대기 목록에 있는 순서 저장 해시맵 만들기
//       대기목록을 입력받을 때 학생들을 순서대로 해시맵에 넣어줌.

        LinkedHashSet<String> set = new LinkedHashSet<>();
//        대기목록을 순회하면서 학번과 대기순서를 해시맵에 저장
        for (int i = 0; i < L; i++) {
            String number = br.readLine(); // 학번은 8자리
            // 만약에 똑같은 학번이 또 있다면 삭제,
            if (set.contains(number)) {
                set.remove(number);
                set.add(number);
            } else {
                set.add(number);
            }
        }

        Object[] key = set.toArray();
        if(key.length < K){
            K = key.length;
        }
        for (int i = 0; i < K; i++) {
            bw.write(key[i] + "\n");
        }

        bw.flush();
        bw.close();

    }
}
