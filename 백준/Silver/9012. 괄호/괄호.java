import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		
	
		int number = 0;
		Scanner scanner = new Scanner(System.in);
		number = scanner.nextInt(); // 정수 입력받기
	 
//		System.out.println("숫자를 입력하시오.");
		
		// 배열 만들기
//		String [] array = new String[number]; // 배열
//		String [] result = new String[number]; // 스택에 대한 결과
		
		// 숫자 넣어주기
		for(int i =0; i< number; i++) {
			System.out.println(Check(scanner.next()));	//Check메소드에서 호출받음
		}
	}		
	public static String Check(String s) { // 문자열 s에 대해 괄호의 짝을 체크

			Stack<Character> stack = new Stack<>(); 
			// (에 대한 매칭을 저장, )를 만나면 스택에서 제거
			
			


			for (char a : s.toCharArray()) { // 문자배열로 변환, 배열의 문자열들을 순회함.
				if( a == '(') {
					stack.push(a);          // a가 (이라면 스택에 push로 (를 추가해줌
					
				} else if(stack.empty()) { // 스택이 비어있다면 NO를 반환
					return "NO";
				} else {
					stack.pop(); 
					// '('도 아니고 비어있지도 않다면 ')' 인거임.
					// 그렇다면 가장 최근에 추가된 '('를 제거
				}

			} 
			if (stack.empty()) {  // 만약 순회했는데도 스택이 비어있다면 모두 짝이 맞는거임. YES 반환
				return "YES";
			} else {
				return "NO"; // 스택을 여는 괄호가 남아있다면 짝이 안맞으니까 NO 반환
			}
			
		   }	
	
	}	