import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader를 사용해 입력을 받음.
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int number;
		number = Integer.parseInt(br.readLine()); // reader로 정수를 읽어옴. 정수를 읽을땐 parseInt 사용
		Stack<Integer> list = new Stack<>(); // 스택 만들땐 이렇게
		
		for(int i = 0; i < number; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String sp = st.nextToken();
			
			// StringTokenizer나 String의 split 메서드를 통해 공백을 기준으로 입력을 분리함.
			
			if(sp.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				list.push(num);
			// pop 만들기
			}else if(sp.equals("pop")) { // pop이면 sp에 담김과 동시에 if문을 타고 들어옴.
				if(list.size() == 0) { // 스택의 사이즈가 0이라면 if문을 타고 들어옴.
					bw.write("-1\n"); // pop이고 스택 사이즈가 0이면 -1을 출력함
				} else {
					bw.write(String.valueOf(list.pop()) + "\n");
				}
				 // pop인데 사이즈가 0이 아니라면 pop을 해줌.
			} else if(sp.equals("size")) {
				bw.write(String.valueOf(list.size()) + "\n"); // size라면 스택의 사이즈 출력
			} else if (sp.equals("empty")) {// empty면 스택이 비었는지 알려줌
				if(list.size() == 0) {
					bw.write("1\n");	
				} else
					bw.write("0\n");
				
			} else if (sp.equals("top")) { // 스택의 가장 위에 있는 정수를 출력
				if(list.size() == 0) {
					
					bw.write("-1\n");
				} else {
					bw.write(String.valueOf(list.peek()) + "\n");
				}
			}
			

		}
		bw.flush(); // 한번 비워줘야됨.
		bw.close(); // bw를 열어줬으니 닫아주는 것임.
		br.close(); // br을 열어줬으니 닫아주는 것임.
		
	}

}
