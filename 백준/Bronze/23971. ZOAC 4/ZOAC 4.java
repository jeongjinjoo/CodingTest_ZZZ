import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken()); // 행 개수
        int W = Integer.parseInt(st.nextToken()); // 열 개수
        int N = Integer.parseInt(st.nextToken()); // 세로로 N칸
        int M = Integer.parseInt(st.nextToken()); // 가로로 M칸

//        처음에 앉는 한 사람이 있기 때문에 행 개수에서 앉아있는 한사람 몫을 빼줌.
//        세로로 띄워지는 N칸을 띄우고 사람을 앉히기 때문에 1을 더해줘야 함.
//        N이 1이면 2칸을 이동해야함.
//        마지막에 1을 더하는 이유는 처음에 앉아있던 한 사람을 더해주는 것임.
//        But, 왜 나눠서 최대 인원을 구하는지 이해가 안감.
        int height = (H - 1)/(N + 1) + 1;
        int width = (W - 1)/(M + 1) + 1;
        
        System.out.println( height*width );
    }
}