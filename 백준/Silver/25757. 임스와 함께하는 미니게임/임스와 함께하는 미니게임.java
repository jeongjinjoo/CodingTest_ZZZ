import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    /*
    임스와 한 번 같이 게임한 사람은 더이상 같이 게임할 수 없다.
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 임스와 같이 플레이하기를 신청한 횟수
        String game = st.nextToken();
        // 플레이할 게임의 종류
//        Y = 2, F = 3, O = 4이므로 임스를 꼭 껴야한다는 가정하에 1,2,3명이 추가로 필요함.

//        HashMap이랑 HashSet의 차이점?
//        HashMap : Key-Value 쌍으로 데이터를 저장, Key는 고유하지만, Value은 중복 가능
//        HashSet : 오직 고유한 값만 저장, 중복 불가

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        int player = 0;

        switch (game) {
            case "Y" :
                player = 1;
                break;
            case "F" :
                player = 2;
                break;
            case "O":
                player = 3;
                break;
            default:
                break;
        }


        System.out.println(set.size() / player);



    }
}