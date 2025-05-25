import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 문제
//        N은 첫재줄에서 나란히 나오는 숫자의 정수를 나타냄
//        그 다음은 N이하의 정수들이 한 줄에 하나씩 입력된다.
//        각 숫자의 밑에 N이하의 숫자들이 있는 두번째 줄과 첫째줄의 숫자 크기가 같아야한다.
//        집합의 크기가 가장 큰, 숫자 크기가 같은 여러가지 경우의 수 중 최대 개수를 출력한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        visited = new boolean[N + 1];
        finished = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i, i);
        }

        Collections.sort(result);
        
        System.out.println(result.size());
        
        for (int num : result) {
            System.out.println(num);
        }
    }
    
//  dfs 함수 만들기
    static void dfs(int start, int current) {
        if (!visited[current]) {
            visited[current] = true;
            dfs(start, arr[current]);
        } else {
            if (start == current) {
                result.add(start);
            }
        }
    }
}
