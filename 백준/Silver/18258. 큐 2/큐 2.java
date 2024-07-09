
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader를 사용해 입력을 받음.

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 사람의 수 입력받기
		int n = Integer.parseInt(st.nextToken()); // 정수 입력받기 , 공백으로 분리 (7)
		// 건너뛸 간격 입력받기
//			int k = Integer.parseInt(st.nextToken()); // 정수로 변환 (3)

		// 큐 이용해 사람들 저장
		Deque<Integer> q= new ArrayDeque<>(); // n명의 사람을 큐에 넣음.



		int k = 0;
		
		int kbs = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			switch (s) {
			case "push":
				kbs = Integer.parseInt(st.nextToken());
//				k = kbs;
				q.add(kbs);

				break;
			case "pop":
				if (q.size() != 0) {
					bw.write(String.valueOf(q.poll()) + "\n");
				} else {
					bw.write("-1\n"); 
				}
				break;
			case "size":
				bw.write(String.valueOf(q.size()) + "\n");
				break;
			case "empty":
				if (q.size() == 0) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
				break;
			case "front":
				if (q.size() != 0) {
					bw.write(String.valueOf(q.peek()) + "\n");
				} else {
					bw.write("-1\n");
				}
				break;
			case "back":
				if (q.size() != 0) {
					bw.write(q.getLast() + "\n");
				} else {
					bw.write("-1\n");
				}
				break;
			}
		}

		bw.flush(); // 한번 비워줘야됨. (버퍼 비우기)
		bw.close(); // bw를 열어줬으니 닫아주는 것임.
		br.close(); // br을 열어줬으니 닫아주는 것임.
		
	}

}
