import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
//        문제
//        약수 구하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] divisors = new int[cnt];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < cnt; i++) {
            divisors[i] = Integer.parseInt(st.nextToken());

            // 최소, 최대 찾기
            if (divisors[i] < min) {
                min = divisors[i];
            }
            if (divisors[i] > max) {
                max = divisors[i];
            }
        }

        System.out.println(min * max); // 최소 × 최대 = N
    }
}
